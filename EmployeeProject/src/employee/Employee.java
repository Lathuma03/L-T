package  employee;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

// Custom exceptions
class InvalidDepartment extends Exception {
    public InvalidDepartment(String message) {
        super(message);
    }
}

class InvalidDesignation extends Exception {
    public InvalidDesignation(String message) {
        super(message);
    }
}

class SalaryOutOfRange extends Exception {
    public SalaryOutOfRange(String message) {
        super(message);
    }
}

public class Employee {
    private String name;
    private String id;
    private String address;
    private String department;
    private String designation;
    private String emailId;
    private double salary;

    // Regex patterns
    private static final String ID_PATTERN = "E\\d{5}";
    private static final String NAME_PATTERN = "[A-Za-z ]{3,}";
    private static final String ADDRESS_PATTERN = "[A-Za-z0-9 #,]{15,}";
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9_]{3,}@gmail\\.com$";

    private static final String[] VALID_DEPARTMENTS = {"DEV", "MAINT", "TEST", "DEPLOY"};
    private static final String[] VALID_DESIGNATIONS = {"M", "TL", "SSE", "SE"};

    // Constructor
    public Employee(String name, String id, String address, String department,
                    String designation, String emailId, double salary) throws Exception {
        setName(name);
        setId(id);
        setAddress(address);
        setDepartment(department);
        setDesignation(designation);
        setEmailId(emailId);
        setSalary(salary);
    }

    // Setters with validation
    public void setName(String name) throws IllegalArgumentException {
        if (!Pattern.matches(NAME_PATTERN, name)) {
            throw new IllegalArgumentException("Invalid Employee Name");
        }
        this.name = name;
    }

    public void setId(String id) throws IllegalArgumentException {
        if (!Pattern.matches(ID_PATTERN, id)) {
            throw new IllegalArgumentException("Invalid Employee ID");
        }
        this.id = id;
    }

    public void setAddress(String address) throws IllegalArgumentException {
        if (!Pattern.matches(ADDRESS_PATTERN, address)) {
            throw new IllegalArgumentException("Invalid Employee Address");
        }
        this.address = address;
    }

    public void setDepartment(String department) throws InvalidDepartment {
        for (String validDept : VALID_DEPARTMENTS) {
            if (validDept.equals(department)) {
                this.department = department;
                return;
            }
        }
        throw new InvalidDepartment("Invalid Department");
    }

    public void setDesignation(String designation) throws InvalidDesignation {
        for (String validDesig : VALID_DESIGNATIONS) {
            if (validDesig.equals(designation)) {
                this.designation = designation;
                return;
            }
        }
        throw new InvalidDesignation("Invalid Designation");
    }

    public void setEmailId(String emailId) throws IllegalArgumentException {
        if (!Pattern.matches(EMAIL_PATTERN, emailId)) {
            throw new IllegalArgumentException("Invalid Email ID");
        }
        this.emailId = emailId;
    }

    public void setSalary(double salary) throws SalaryOutOfRange {
        if (salary < 20000 || salary > 200000) {
            throw new SalaryOutOfRange("Salary Out Of Range");
        }
        this.salary = salary;
    }

    // Calculate bonus
    public double calculateBonus() {
        switch (designation) {
            case "M":
                return salary * 0.10;
            case "TL":
                return salary * 0.15;
            case "SSE":
                return salary * 0.17;
            case "SE":
                return salary * 0.20;
            default:
                return 0;
        }
    }

    // Display employee details
    public void display() {
        System.out.println("Employee Details:");
        System.out.printf("Name: %s%n", name);
        System.out.printf("ID: %s%n", id);
        System.out.printf("Address: %s%n", address);
        System.out.printf("Department: %s%n", department);
        System.out.printf("Designation: %s%n", designation);
        System.out.printf("Email ID: %s%n", emailId);
        System.out.printf("Salary: %.1f%n", salary);
        System.out.printf("Bonus: %.1f%n", calculateBonus());
    }

    @Override
    public String toString() {
        return String.format("Name:%s\nID:%s\nAddress:%s\nDepartment:%s\nDesignation:%s\nEmail ID:%s\nSalary:%.1f\nBonus:%.1f",
                name, id, address, department, designation, emailId, salary, calculateBonus());
    }
}
