package com.inventorymanagement;

import java.io.*;
import java.util.ArrayList;

public class InventoryManager {
    private static final String FILE_NAME = "products.txt";
    ArrayList<Product> products = new ArrayList<>();

    // Constructor to load products from file
    public InventoryManager() {
        loadProductsFromFile();
    }

    // Add a product to the inventory
    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added successfully.");
        saveProductsToFile();
    }

    // View all products
    public void viewProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            for (Product product : products) {
                product.display();
            }
        }
    }

    // Search for a product by product number
    public Product searchProduct(int productNo) {
        for (Product product : products) {
            if (product.getProductNo() == productNo) {
                return product;
            }
        }
        return null;
    }

    // Update a product's details
    public void updateProduct(int productNo, double newPrice, int newQuantity) {
        Product product = searchProduct(productNo);
        if (product != null) {
            product.setPrice(newPrice);
            product.setQuantity(newQuantity);
            System.out.println("Product updated successfully.");
            saveProductsToFile();
        } else {
            System.out.println("Product not found.");
        }
    }

    // Delete a product
    public void deleteProduct(int productNo) {
        Product product = searchProduct(productNo);
        if (product != null) {
            products.remove(product);
            System.out.println("Product deleted successfully.");
            saveProductsToFile();
        } else {
            System.out.println("Product not found.");
        }
    }

    // Save products to file
    private void saveProductsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Product product : products) {
                writer.write(product.getProductNo() + "," + product.getName() + "," + product.getPrice() + ","
                        + product.getCategory() + "," + product.getQuantity());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving products to file: " + e.getMessage());
        }
    }

    // Load products from file
    private void loadProductsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int productNo = Integer.parseInt(data[0]);
                String name = data[1];
                double price = Double.parseDouble(data[2]);
                String category = data[3];
                int quantity = Integer.parseInt(data[4]);

                Product product = new Product(productNo, name, price, category, quantity);
                products.add(product);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No previous data found. Starting fresh.");
        } catch (IOException e) {
            System.out.println("Error loading products from file: " + e.getMessage());
        }
    }
}
