package com.isil.restaurant.model;

public class Category {

    String id_categoria;
    String nombre;
    String urlImagen;


    public Category(String id_categoria, String nombre, String urlImagen) {
        this.id_categoria = id_categoria;
        this.nombre = nombre;
        this.urlImagen = urlImagen;
    }

    public String getID() {
        return id_categoria;
    }
    public void setID(String id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getnombre() {
        return nombre;
    }
    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }
}
