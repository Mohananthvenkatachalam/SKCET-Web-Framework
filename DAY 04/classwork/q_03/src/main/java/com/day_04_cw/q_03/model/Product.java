package com.day_04_cw.q_03.model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;

@Entity
public class Product {
    @Id
    private int productId;
    private String productName;
    private double price;
    private String description;
    private int quality;

    public Product() {

    }

    public Product(int productId, String productName, double price, String discription, int quality) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.description = discription;
        this.quality = quality;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String discription) {
        this.description = discription;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }
}
