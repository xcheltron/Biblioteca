package com.library.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.library.SceneMannager;
import com.library.models.UserSesion;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HomeController implements Initializable{

    private static boolean isLibrosVisible = false;
    private static boolean isUsuariosVisible = false;
    private static boolean isPrestamosVisible = false;

    
    @FXML
    private Label lblBienvenida;

    @FXML
    private Button btnConsultarLibro;

    @FXML
    private Button btnLibros;

    @FXML
    private Button btnAgregarLibro;

    @FXML
    private Button btnUsuarios;
    
    @FXML
    private Button btnPrestamos;

    @FXML
    private Button btnConsultarUsuario;


    //LIBROS
    @FXML
    void btnActivarLibros(ActionEvent event) {
        isLibrosVisible = !isLibrosVisible;

        toggleButton(btnAgregarLibro, isLibrosVisible);
        toggleButton(btnConsultarLibro, isLibrosVisible);
    }

    @FXML
    void HandlerConsultarLibro(ActionEvent event) {

    }

    @FXML
    void HandlerAgregarLibro(ActionEvent event) {
        SceneMannager.StageSwitched("viewInsertBook.fxml");
    }

    //Usuarios
    @FXML 
    void btnActivarUsuarios(ActionEvent event) {
        isUsuariosVisible = !isUsuariosVisible;

        toggleButton(btnConsultarUsuario, isUsuariosVisible);
    }

    @FXML
    void HandlerConsultarUsuario (ActionEvent event){

    }

    private void toggleButton(Button btn, boolean show) {
        btn.setVisible(show);
        btn.setManaged(show);

        if(show){
            btn.setPrefHeight(30);
        } else{
            btn.prefHeight(0);
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        String name = UserSesion.getInstance().getName();

        lblBienvenida.setText(lblBienvenida.getText()+" "+name.toUpperCase());
    }

    
}