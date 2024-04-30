import java.io.IOException;
import java.util.Scanner;
import Login_System_And_Difficulty_Screens.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Login_System loginSystem = new Login_System();

        while (true) {
            System.out.println("╔═══════════════════════╗");
            System.out.println("║  Arabic Learning Hub  ║");
            System.out.println("╚═══════════════════════╝");
            System.out.println();
            System.out.println("Welcome to the Arabic Learning Hub. Please choose an option:");
            System.out.println();
            System.out.println("1. Register - Create a new account.");
            System.out.println("2. Login - Access your account.");
            System.out.println("3. Exit - Close the application.");
            System.out.println();
            System.out.print("Enter the number of your choice: ");
            System.out.println();

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    loginSystem.registerUser(scanner);
                    break;
                case 2:
                    loginSystem.loginUser(scanner);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
