import java.util.Scanner;

public class Advanced_Screen {
    public static void AdvancedScreen() {
        System.out.println();
        System.out.println("Welcome to Arabic for Advanced Students");
        System.out.println("1. Arabic Listening Practice Test");
        System.out.println("2. Arabic Listening Practice Flashcards");
        System.out.println("4. Exit Arabic for Beginners");
        Scanner scanner = new Scanner(System.in);
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
