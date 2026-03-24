package com.library.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HomeController {

    private static boolean isLibrosVisible = false;
    private static boolean isUsuariosVisible = false;
    private static boolean isPrestamosVisible = false;


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
}