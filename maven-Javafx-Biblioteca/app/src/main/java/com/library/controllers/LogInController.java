package com.library.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class LogInController {

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Label label1;

    @FXML
    private Button btnLogIn;

    @FXML
    void HandlerLogIn(ActionEvent event) {
        try {
            String email = txtEmail.getText();
            String password = txtPassword.getText();

            if (email.isEmpty() || password.isEmpty()) {
                label1.setText("Llena todos los campos");
                return;
            }

            URL url = new URL("http://localhost:3000/login");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String jsonInput = String.format(
                    "{ \"email\": \"%s\", \"password\": \"%s\" }",
                    email,
                    password);

            OutputStream os = conn.getOutputStream();
            os.write(jsonInput.getBytes());
            os.flush();
            os.close();

            int responseCode = conn.getResponseCode();

            Scanner scanner;
            if (responseCode >= 200 && responseCode < 300) {
                scanner = new Scanner(conn.getInputStream());
            } else {
                scanner = new Scanner(conn.getErrorStream());
            }

            StringBuilder response = new StringBuilder();
            while (scanner.hasNext()) {
                response.append(scanner.nextLine());
            }
            scanner.close();

            label1.setText(response.toString());

        } catch (Exception e) {
            label1.setText("Error: " + e.getMessage());
        }
    }
}