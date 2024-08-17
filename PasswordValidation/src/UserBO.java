
public class UserBO {
    public static void validate(User u) throws WeakPasswordException {
        String password = u.getPassword();

        if (password.length() < 8 || password.length() > 20 ||
                !password.matches(".*\\d.*") ||
                !password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*") ||
                !password.matches(".*[a-zA-Z].*")) {
            throw new WeakPasswordException("Your password is weak");
        }
    }
}
