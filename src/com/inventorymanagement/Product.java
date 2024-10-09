package com.inventorymanagement;

public class Product {
    private int productNo;
    private String name;
    private double price;
    private String category;
    private int quantity;

    public Product(int productNo, String name, double price, String category, int quantity) {
        this.productNo = productNo;
        this.name = name;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    // Getter and Setter methods
    public int getProductNo() {
        return productNo;
    }

    public void setProductNo(int productNo) {
        this.productNo = productNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void display() {
        System.out.println("Product No: " + productNo + ", Name: " + name + ", Price: " + price +
                ", Category: " + category + ", Quantity: " + quantity);
    }
}
