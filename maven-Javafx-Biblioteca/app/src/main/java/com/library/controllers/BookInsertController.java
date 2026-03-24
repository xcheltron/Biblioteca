package com.library.controllers;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.library.SceneMannager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

public class BookInsertController implements Initializable {

    @FXML
    private Button btnSalir;

    @FXML
    private TextField txtAutor;

    @FXML
    private Button btnAgregar;

    @FXML
    private Label lblError;

    @FXML
    private TextField txtAño;

    @FXML
    private TextField txtNombreLibro;

    @FXML
    private TextField txtSubtitulo;

    @FXML
    private Spinner<Integer> spinnerCantidad;

    @FXML
    void HandlerAgregar(ActionEvent event) {
        connection();
    }

    @FXML
    void HandlerSalir(ActionEvent event) {
        SceneMannager.StageSwitched("viewHome.fxml");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        SpinnerValueFactory<Integer> valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1);

        spinnerCantidad.setValueFactory(valueFactory);
        spinnerCantidad.setEditable(true);

        // 🔥 Bloquear letras en el spinner
        TextFormatter<Integer> formatter = new TextFormatter<>(change -> {
            if (change.getControlNewText().matches("\\d*")) {
                return change;
            }
            return null;
        });

        spinnerCantidad.getEditor().setTextFormatter(formatter);
    }

    public void connection() {
        try {
            // 🔹 Obtener valores
            String author = txtAutor.getText().trim();
            String Name_Book = txtNombreLibro.getText().trim();
            String subTitle = txtSubtitulo.getText().trim();
            String yearText = txtAño.getText().trim();

            // 🔹 Validar vacíos
            if (author.isEmpty() || Name_Book.isEmpty() || yearText.isEmpty()) {
                showAlert("Campos vacíos", "Autor, nombre y año son obligatorios");
                return;
            }

            int publication_date = Integer.parseInt(yearText);
            int quantity = spinnerCantidad.getValue();

            // 🔹 Construir JSON correctamente
            JsonObject json = new JsonObject();
            json.addProperty("author", author);
            json.addProperty("Name_Book", Name_Book);
            json.addProperty("Sub_Title", subTitle);
            json.addProperty("publication_date", publication_date);
            json.addProperty("quantity", quantity);

            String jsonInput = json.toString();

            // 🔹 Conexión HTTP
            URL url = new URL("http://localhost:3000/book");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // 🔹 Enviar JSON
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

            String responseStr = response.toString();
            System.out.println("Response: " + responseStr);

            // 🔹 Validar respuesta
            if (responseStr == null || responseStr.equals("null") || responseStr.isEmpty()) {
                throw new Exception("Respuesta vacía del servidor");
            }

            JsonObject gsonObj = JsonParser
                    .parseString(responseStr)
                    .getAsJsonObject();

            // 🔹 Mostrar mensaje del backend
            if (gsonObj.has("message")) {
                lblError.setText(gsonObj.get("message").getAsString());
                lblError.setVisible(true);
                limpiar();
            }

        } catch (NumberFormatException error) {
            showAlert("Error numérico", "El año debe ser un número válido");

        } catch (Exception e) {
            showAlert("Error", e.getMessage());
            System.err.println(e);
        }
    }

    // 🔥 Método reutilizable para alertas
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void limpiar(){
        txtAutor.setText("");
        txtAño.setText("");
        txtNombreLibro.setText("");
        txtSubtitulo.setText("");
    }
}