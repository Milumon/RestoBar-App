package com.isil.restaurant.model;

public class Recommendation {

    String id;
    String name;
    String rating;
    String time;
    String price;
    String imageURL;

    public Recommendation(String id, String name, String rating, String time, String price, String imageURL) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.time = time;
        this.price = price;
        this.imageURL = imageURL;
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

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
