package com.library.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.library.SceneMannager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;

public class BookInsertController implements Initializable{

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

    }

    @FXML
    void HandlerSalir(ActionEvent event) {
        SceneMannager.StageSwitched("viewHome.fxml");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        SpinnerValueFactory<Integer> valueFactory =
            new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1);

        spinnerCantidad.setValueFactory(valueFactory);
        spinnerCantidad.setEditable(true);
    }

}