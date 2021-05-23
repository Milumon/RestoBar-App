package com.isil.restaurant.model;

public class Store {

    String id;
    String name;
    String imageURL;
    String time;
    String capacidad;
    String direccion;

    public Store(String id ,String name, String direccion, String capacidad, String imageURL, String time)  {
        this.id = id;
        this.name = name;
        this.imageURL = imageURL;
        this.time = time;
        this.capacidad = capacidad;
        this.direccion = direccion;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
