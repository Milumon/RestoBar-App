package com.isil.restaurant.model;

public class Food {

    String name;
    String description;
    String rating;
    String time;
    String price;
    String category;
    String imageURL;

    public Food(String name, String description, String rating, String time, String price, String category, String imageURL) {
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.time = time;
        this.price = price;
        this.category = category;
        this.imageURL = imageURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
