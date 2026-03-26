package com.library.models;
import com.google.gson.annotations.SerializedName;

public class Book {
    @SerializedName("IdBook")
    private int id;

    @SerializedName("Author")
    private String autor;

    @SerializedName("Name_Book")
    private String titulo;

    @SerializedName("Sub_Title")
    private String subtitulo;

    @SerializedName("publication_date")
    private int year;

    @SerializedName("quantity")
    private int cantidad;

    //Constructor
    public Book(int id, String autor, String titulo, String subtitulo, int year, int cantidad) {
        this.id = id;
        this.autor = autor;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.year = year;
        this.cantidad = cantidad;
    }

    //Getters
    public int getId() {return id;}
    public String getAutor() {return autor;}
    public String getTitulo() {return titulo;}
    public String getSubtitulo() {return subtitulo;}
    public int getYear() {return year;}
    public int getCantidad() {return cantidad;}
}
