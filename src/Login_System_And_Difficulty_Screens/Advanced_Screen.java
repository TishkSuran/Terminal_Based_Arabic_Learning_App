package Login_System_And_Difficulty_Screens;

import Arabic_Flashcards.Arabic_Flashcards_Advanced;
import Arabic_Listening_Tests.Arabic_Listening_Test_Advanced;

import java.util.Scanner;

public class Advanced_Screen {
    public static void AdvancedScreen() {
        System.out.println();
        System.out.println("Welcome to Arabic for Advanced Students");
        System.out.println("1. Arabic Listening Practice Flashcards");
        System.out.println("2. Arabic Listening Practice Test");
        System.out.println("3. To View Login_System.Leaderboard");
        System.out.println("4. Exit Arabic for Beginners");
        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();

        if (userInput == 1) {
            Arabic_Flashcards_Advanced arabicFlashcardsAdvanced = new Arabic_Flashcards_Advanced();
            arabicFlashcardsAdvanced.startFlashCardPractice();
        } else if (userInput == 2) {
            Arabic_Listening_Test_Advanced arabicListeningTestAdvanced = new Arabic_Listening_Test_Advanced();
            arabicListeningTestAdvanced.startListeningPractice();
        } else if (userInput == 3) {
            Leaderboard leaderboard = new Leaderboard();
            leaderboard.Leaderboard();
        } else if (userInput == 4) {
            System.out.println("Exiting...");
            System.exit(0);
        }
    }
}
