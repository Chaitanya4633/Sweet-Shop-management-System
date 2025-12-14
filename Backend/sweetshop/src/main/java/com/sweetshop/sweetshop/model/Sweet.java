package com.sweetshop.sweetshop.model;

import jakarta.persistence.*;

@Entity
public class Sweet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String category;
    private double price;
    private int quantity;

    protected Sweet() {}

    public Sweet(String name, String category, double price, int quantity) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() { return name; }
    public int getQuantity() { return quantity; }

    public void decreaseQuantity(int amount) {
    this.quantity -= amount;
    }

    public String getCategory() {
    return category;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
    this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



}
