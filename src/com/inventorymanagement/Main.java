package com.inventorymanagement;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventoryManager manager = new InventoryManager();
        boolean running = true;

        while (running) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Search Product");
            System.out.println("4. Update Product");
            System.out.println("5. Delete Product");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // Add Product
                    System.out.print("Enter product number: ");
                    int productNo = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();

                    System.out.print("Enter product category: ");
                    String category = scanner.next();

                    System.out.print("Enter product quantity: ");
                    int quantity = scanner.nextInt();

                    Product product = new Product(productNo, name, price, category, quantity);
                    manager.addProduct(product);
                    break;

                case 2: // View Products
                    manager.viewProducts();
                    break;

                case 3: // Search Product
                    System.out.print("Enter product number to search: ");
                    int searchProductNo = scanner.nextInt();
                    Product foundProduct = manager.searchProduct(searchProductNo);
                    if (foundProduct != null) {
                        foundProduct.display();
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 4: // Update Product
                    System.out.print("Enter product number to update: ");
                    int updateProductNo = scanner.nextInt();
                    System.out.print("Enter new price: ");
                    double newPrice = scanner.nextDouble();
                    System.out.print("Enter new quantity: ");
                    int newQuantity = scanner.nextInt();
                    manager.updateProduct(updateProductNo, newPrice, newQuantity);
                    break;

                case 5: // Delete Product
                    System.out.print("Enter product number to delete: ");
                    int deleteProductNo = scanner.nextInt();
                    manager.deleteProduct(deleteProductNo);
                    break;

                case 6: // Exit
                    running = false;
                    System.out.println("Exiting system.");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
