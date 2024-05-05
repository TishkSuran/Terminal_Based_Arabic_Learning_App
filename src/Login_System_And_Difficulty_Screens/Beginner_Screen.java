package Login_System_And_Difficulty_Screens;

import Arabic_Flashcards.Arabic_Flashcards_Beginner;
import Arabic_Listening_Tests.Arabic_Listening_Test_Beginner;

import java.util.Scanner;

public class Beginner_Screen {
    public static void BeginnerScreen() {
        System.out.println();
        System.out.println("Welcome to Arabic for Beginners");
        System.out.println("1. Arabic Listening Practice Flashcards");
        System.out.println("2. Arabic Listening Practice Test");
        System.out.println("3. To View the Leaderboard");
        System.out.println("4. Exit Arabic for Beginners");

        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();

        if (userInput == 1) {
            Arabic_Flashcards_Beginner beginnerFlashcards = new Arabic_Flashcards_Beginner();
            beginnerFlashcards.startFlashCardPractice();
        } else if (userInput == 2) {
            Arabic_Listening_Test_Beginner arabicListeningTestBeginner = new Arabic_Listening_Test_Beginner();
            arabicListeningTestBeginner.startListeningPractice();
        } else if (userInput == 3) {
            Leaderboard.Leaderboard();
        }
        else if (userInput == 4) {
            System.out.println("Exiting...");
            System.exit(0);
        }
    }

}
