import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the user details");
        String input = sc.nextLine();
        String[] details = input.split(",");

        User user = new User(details[0], details[1], details[2], details[3]);

        try {
            UserBO.validate(user);
            System.out.println(user);
        } catch (WeakPasswordException e) {
            System.out.println("WeakPasswordException: " + e.getMessage());
        }
    }
}
