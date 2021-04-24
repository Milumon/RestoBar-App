package com.isil.restaurant.model;

public class Store {

    String name;
    Integer imageURL;
    String time;

    public Store(String name, Integer imageURL, String time) {
        this.name = name;
        this.imageURL = imageURL;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getImageURL() {
        return imageURL;
    }

    public void setImageURL(Integer imageURL) {
        this.imageURL = imageURL;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
