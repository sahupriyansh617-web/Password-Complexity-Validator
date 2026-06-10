import java.util.Scanner;

class UserAccount {
    private String username;
    private String password;

    public UserAccount(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

class SecurityValidator {

    public void validate(UserAccount user) {

        String password = user.getPassword();

        boolean hasDigit = false;
        boolean hasUppercase = false;

        for (int i = 0; i < password.length(); i++) {

            char ch = password.charAt(i);

            if (Character.isDigit(ch)) {
                hasDigit = true;
            }

            if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            }
        }

        boolean isValid =
                password.length() >= 8 &&
                hasDigit &&
                hasUppercase;

        if (isValid) {

            System.out.println("\nPassword is VALID");

        } else {

            System.out.println("\nPassword is INVALID");

            if (password.length() < 8) {
                System.out.println("- Password must contain at least 8 characters");
            }

            if (!hasUppercase) {
                System.out.println("- Password must contain at least 1 uppercase letter");
            }

            if (!hasDigit) {
                System.out.println("- Password must contain at least 1 digit");
            }
        }
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== PASSWORD COMPLEXITY VALIDATOR =====");

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        UserAccount user = new UserAccount(username, password);

        SecurityValidator validator = new SecurityValidator();

        validator.validate(user);

        sc.close();
    }
}