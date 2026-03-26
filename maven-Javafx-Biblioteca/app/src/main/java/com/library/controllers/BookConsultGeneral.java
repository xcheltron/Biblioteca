package com.library.controllers;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.ResourceBundle;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.library.models.Book;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class BookConsultGeneral implements Initializable {

    private int currentPage = 1;
    private ObservableList<Book> bookList = FXCollections.observableArrayList();

    @FXML
    private Button btnRetroceder;

    @FXML
    private Button btnAvanzar;

    @FXML
    private Button btnSalir;

    @FXML
    private TableColumn<Book, String> columnSubtitulo;

    @FXML
    private TableColumn<Book, String> columnAutor;

    @FXML
    private TableView<Book> tableBook;

    @FXML
    private TableColumn<Book, Integer> columnId;

    @FXML
    private TableColumn<Book, Integer> columncantidad;

    @FXML
    private TableColumn<Book, Integer> columnage;

    @FXML
    private TableColumn<Book, String> columnTitulo;

    @FXML
    void handlerRetroceder(ActionEvent event) {
        if (currentPage > 1) {
            currentPage--;
            loadBooks(currentPage);
        }
    }

    @FXML
    void handlerAvanzar(ActionEvent event) {
        currentPage++;
        loadBooks(currentPage);
    }

    @FXML
    void HandlerSalir(ActionEvent event) {

    }

    public void loadBooks(int page) {
        try {
            bookList.clear();
            HttpClient client = HttpClient.newHttpClient();
            Gson gson = new Gson();
            // Aquí simulas o llamas tu backend
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:3000/book/consulta?page=" + page))
                    .GET()
                    .build();
            // (puedes usar HttpURLConnection o HttpClient)
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            Type listType = new TypeToken<List<Book>>() {
            }.getType();
            List<Book> books = gson.fromJson(response.body(), listType);

            bookList.clear();
            bookList.addAll(books);
            tableBook.setItems(bookList);;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnAutor.setCellValueFactory(new PropertyValueFactory<>("autor"));
        columnTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo")); 
        columnSubtitulo.setCellValueFactory(new PropertyValueFactory<>("subtitulo"));
        columnage.setCellValueFactory(new PropertyValueFactory<>("year"));
        columncantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));

        loadBooks(currentPage);
    }

}
