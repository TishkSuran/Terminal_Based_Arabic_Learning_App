import java.io.*;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login_System {
    private static final String CSV_FILE = "userInfo.csv";
    public static int experiencePoints;
    public static String email;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

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
                    registerUser(scanner);
                    break;
                case 2:
                    loginUser(scanner);
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

    private static void registerUser(Scanner scanner) throws IOException {
        String firstName = "";
        while (firstName.isEmpty()) {
            System.out.println("Enter your first name: ");
            firstName = scanner.nextLine();
            if (firstName.isEmpty()) {
                System.out.println("This field cannot be left blank.");
            } else if (!isValidFirstName(firstName)) {
                System.out.println("Invalid first name, first name can only contain letters.");
                firstName = ""; // Resetting the value to force re-entry
            }
        }

        String secondName = "";
        while (secondName.isEmpty()) {
            System.out.println("Enter your second name: ");
            secondName = scanner.nextLine();
            if (secondName.isEmpty()) {
                System.out.println("This field cannot be left blank.");
            } else if (!isValidSecondName(secondName)) {
                System.out.println("Invalid second name, second name can only contain letters.");
                secondName = "";
            }
        }

        String userName = "";
        while (userName.isEmpty()) {
            System.out.println("Enter your username: ");
            userName = scanner.nextLine();
            if (userName.isEmpty()) {
                System.out.println("This field cannot be left blank.");
            } else if (isUsernameAlreadyRegistered(userName)) {
                System.out.println("Username already exists, please enter a different one.");
                userName = "";
            }
        }

        String proficiency = "";
        while (proficiency.isEmpty()) {
            System.out.println("Enter your Arabic proficiency level (Beginner (B) | Intermediate (I) | Advanced (A)): ");
            proficiency = scanner.nextLine().toLowerCase(Locale.ROOT);
            switch (proficiency) {
                case "b":
                    proficiency = "Beginner";
                    break;
                case "i":
                    proficiency = "Intermediate";
                    break;
                case "a":
                    proficiency = "Advanced";
                    break;
                default:
                    System.out.println("Please enter either B, I, or A.");
                    proficiency = "";
            }
        }

        email = "";
        while (email.isEmpty() || !isValidEmail(email) || isEmailAlreadyRegistered(email)) {
            System.out.println("Enter your email address: ");
            email = scanner.nextLine();
            if (email.isEmpty()) {
                System.out.println("This field cannot be left blank.");
            } else if (!isValidEmail(email)) {
                System.out.println("Invalid email address. Please use a valid email address.");
            } else if (isEmailAlreadyRegistered(email)) {
                System.out.println("Email already exists. Please login or choose a different email address.");
            }
        }

        String password = "";
        while (password.isEmpty() || !isValidPassword(password)) {
            System.out.println("Please create a password: ");
            password = scanner.nextLine();
            if (password.isEmpty()) {
                System.out.println("This field cannot be left blank.");
            } else if (!isValidPassword(password)) {
                System.out.println("Invalid password. Password must be at least 8 characters long and contain at least one digit, one uppercase letter, and one lowercase letter.");
            }
        }

        int experiencePoints = 0;

        try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE, true))) {
            writer.println(email + "," + password + "," + firstName + "," + secondName + "," + proficiency + "," + userName + "," + experiencePoints);
            System.out.println("User registered successfully.");


            Login_System.email = email;
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void updateExperiencePoints(String email, int newXP) {
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE))) {
            String line;
            StringBuilder fileContent = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 7 && (parts[0].equals(email) || parts[5].equals(email))) {
                    int currentXP = Integer.parseInt(parts[6]); // Assuming XP is at index 6
                    currentXP += newXP;
                    parts[6] = String.valueOf(currentXP);
                    line = String.join(",", parts);
                }
                fileContent.append(line).append("\n");
            }

            try (FileWriter writer = new FileWriter(CSV_FILE)) {
                writer.write(fileContent.toString());
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception according to your application's logic
        }
    }


    private static void loginUser(Scanner scanner) throws FileNotFoundException {
        System.out.println("Enter your email or username: ");
        email = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 7 && (parts[0].equals(email) || parts[5].equals(email)) && parts[1].equals(password)) {
                    String firstName = parts[2];
                    String proficiency = parts[4];
                    int experiencePoints = Integer.parseInt(parts[6]);
                    System.out.println("Welcome, " + firstName + "! Your Arabic proficiency level is currently set to: " + proficiency + ", and your current XP is: " + experiencePoints + ".");

                    Login_System.experiencePoints = experiencePoints;

                    while (true) {
                        if (proficiency.equals("Beginner")) {
                            System.out.println();
                            System.out.println("Welcome to Arabic for Beginners");
                            System.out.println("1. Arabic Listening Practice Test");
                            System.out.println("2. Arabic Listening Practice Flashcards");
                            System.out.println("4. Exit Arabic for Beginners");
                            int userInput = scanner.nextInt();

                            if (userInput == 1) {
                                Arabic_Listening_Test_Beginner arabicListeningTestBeginner = new Arabic_Listening_Test_Beginner();
                                arabicListeningTestBeginner.startListeningPractice();
                            } else if (userInput == 2) {
                                Arabic_Flashcards_Beginner beginnerFlashcards = new Arabic_Flashcards_Beginner();
                                beginnerFlashcards.startFlashCardPractice();
                            } else if (userInput == 4) {
                                System.out.println("Exiting...");
                                System.exit(0);
                            }
                        }

                        else if (proficiency.equals("Intermediate")) {
                            System.out.println();
                            System.out.println("Welcome to Arabic for Intermediates");
                            System.out.println("1. Arabic Listening Practice Test");
                            System.out.println("2. Arabic Listening Practice Flashcards");
                            System.out.println("4. Exit Arabic for Beginners");
                            int userInput = scanner.nextInt();

                            if (userInput == 1) {

                                Arabic_Listening_Test_Intermediate arabicListeningTestIntermediate = new Arabic_Listening_Test_Intermediate();
                                arabicListeningTestIntermediate.startListeningPractice();
                            } else if (userInput == 2) {
                                Arabic_Flashcards_Intermediate arabicFlashcardsIntermediate = new Arabic_Flashcards_Intermediate();
                                arabicFlashcardsIntermediate.startFlashCardPractice();
                            } else if (userInput == 4) {
                                System.out.println("Exiting...");
                                System.exit(0);
                            }
                        } else if (proficiency.equals("Advanced")) {
                            System.out.println();
                            System.out.println("Welcome to Arabic for Advanced Students");
                            System.out.println("1. Arabic Listening Practice Test");
                            System.out.println("2. Arabic Listening Practice Flashcards");
                            System.out.println("4. Exit Arabic for Beginners");
                            int userInput = scanner.nextInt();

                            if (userInput == 1) {
                                Arabic_Listening_Test_Advanced arabicListeningTestAdvanced = new Arabic_Listening_Test_Advanced();
                                arabicListeningTestAdvanced.startListeningPractice();
                            } else if (userInput == 2) {
                                Arabic_Flashcards_Advanced arabicFlashcardsAdvanced = new Arabic_Flashcards_Advanced();
                                arabicFlashcardsAdvanced.startFlashCardPractice();
                            } else if (userInput == 4) {
                                System.out.println("Exiting...");
                                System.exit(0);
                            }
                        }
                    }
                    //return;
                }
            }
            System.out.println("Invalid email or password.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }



    public static final Pattern VALID_NAME_REGEX =
            Pattern.compile("^[a-zA-Z]*$", Pattern.CASE_INSENSITIVE);

    private static boolean isValidFirstName(String firstName) {
        Matcher matcher = VALID_NAME_REGEX.matcher(firstName);
        return matcher.matches();
    }

    private static boolean isValidSecondName(String secondName) {
        Matcher matcher = VALID_NAME_REGEX.matcher(secondName);
        return matcher.matches();
    }

    private static boolean isValidPassword(String password) {
        return password.length() >= 8 && password.matches(".*\\d.*") && password.matches(".*[A-Z].*") && password.matches(".*[a-z].*");
    }

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    private static boolean isValidEmail(String email) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.matches();
    }

    private static boolean isEmailAlreadyRegistered(String email) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 1 && parts[0].equals(email)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isUsernameAlreadyRegistered(String username) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 5 && parts[5].equals(username)) {
                    return true;
                }
            }
        }
        return false;
    }
}