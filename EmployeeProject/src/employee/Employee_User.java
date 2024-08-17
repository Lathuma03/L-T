package employee;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Employee_User {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueInput = true;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("employees.txt", true))) { // Append mode
            while (continueInput) {
                try {
                    System.out.println("Enter Employee Details:");

                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();

                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();

                    System.out.print("Enter department (DEV, MAINT, TEST, DEPLOY): ");
                    String department = scanner.nextLine();

                    System.out.print("Enter designation (M, TL, SSE, SE): ");
                    String designation = scanner.nextLine();

                    System.out.print("Enter email ID: ");
                    String emailId = scanner.nextLine();

                    System.out.print("Enter salary: ");
                    double salary = Double.parseDouble(scanner.nextLine());

                    // Create Employee object
                    Employee employee = new Employee(name, id, address, department, designation, emailId, salary);

                    // Display employee details
                    employee.display();

                    // Write to file
                    writer.write(employee.toString());
                    writer.newLine();

                    // Flush after writing
                    writer.flush();

                    System.out.print("Do you want to enter another employee? (yes/no): ");
                    String choice = scanner.nextLine();
                    if (!choice.equalsIgnoreCase("yes")) {
                        continueInput = false;
                    }

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        // Filtering and displaying matching records
        try {
            System.out.println("\nDo you want to filter employees by Salary or Bonus? (salary/bonus): ");
            String filterChoice = scanner.nextLine().toLowerCase();

            System.out.print("Enter the threshold value for " + filterChoice + ": ");
            double threshold = Double.parseDouble(scanner.nextLine());

            // Display matching records
            filterAndDisplayRecords(filterChoice, threshold);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void filterAndDisplayRecords(String filterChoice, double threshold) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("employees.txt"))) {
            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                String[] details = line.split("\\n");

                if (details.length < 8) {
                    System.out.println("Skipping malformed line: " + line);
                    continue;
                }

                // Assuming the employee data is stored in the correct format (as done by Employee.toString())
                String name = details[0].split(":")[1].trim();
                String id = details[1].split(":")[1].trim();
                String address = details[2].split(":")[1].trim();
                String department = details[3].split(":")[1].trim();
                String designation = details[4].split(":")[1].trim();
                String emailId = details[5].split(":")[1].trim();
                double salary = Double.parseDouble(details[6].split(":")[1].trim());
                double bonus = Double.parseDouble(details[7].split(":")[1].trim());

                // Apply filter
                if ((filterChoice.equals("salary") && salary >= threshold) ||
                        (filterChoice.equals("bonus") && bonus >= threshold)) {
                    found = true;
                    System.out.printf("Name: %s%nID: %s%nAddress: %s%nDepartment: %s%nDesignation: %s%nEmail ID: %s%nSalary: %.2f%nBonus: %.2f%n%n",
                            name, id, address, department, designation, emailId, salary, bonus);
                }
            }

            if (!found) {
                System.out.println("No matching records found.");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error processing record: " + e.getMessage());
        }
    }

}
