package com.isil.restaurant.model;

public class Cart {

    String name;
    String price;
    String imageURL;
    String quantity;

    public Cart(String name, String price, String imageURL, String quantity) {
        this.name = name;
        this.price = price;
        this.imageURL = imageURL;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }


}
