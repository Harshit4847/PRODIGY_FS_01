import java.util.Scanner;

public class AdminAuth {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin123";

    public static boolean login() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username: ");
        String user = sc.nextLine();
        System.out.print("Enter password: ");
        String pass = sc.nextLine();

        if (user.equals(USERNAME) && pass.equals(PASSWORD)) {
            System.out.println("Login successful.\n");
            return true;
        } else {
            System.out.println("Invalid credentials.");
            return false;
        }
    }
}

