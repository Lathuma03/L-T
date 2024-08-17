import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter the Item type details:");

            // Get name
            System.out.println("Enter the name:");
            String name = scanner.nextLine();

            // Get deposit
            System.out.println("Enter the deposit:");
            double deposit = Double.parseDouble(scanner.nextLine());

            // Get cost per day
            System.out.println("Enter the cost per day:");
            double costPerDay = Double.parseDouble(scanner.nextLine());

            // Create ItemType object
            ItemType item = new ItemType(name, deposit, costPerDay);

            // Display item details
            System.out.println("The details of the item type are:");
            System.out.println(item);

        } catch (NumberFormatException e) {
            System.out.println("java.lang.NumberFormatException: " + e.getMessage());
        }
    }
}
