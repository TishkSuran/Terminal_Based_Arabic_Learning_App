import java.util.Scanner;

public class Beginner_Screen {
    public static void BeginnerScreen() {
        System.out.println();
        System.out.println("Welcome to Arabic for Beginners");
        System.out.println("1. Arabic Listening Practice Test");
        System.out.println("2. Arabic Listening Practice Flashcards");
        System.out.println("3. To View Leaderboard");
        System.out.println("4. Exit Arabic for Beginners");

        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();

        if (userInput == 1) {
            Arabic_Listening_Test_Beginner arabicListeningTestBeginner = new Arabic_Listening_Test_Beginner();
            arabicListeningTestBeginner.startListeningPractice();
        } else if (userInput == 2) {
            Arabic_Flashcards_Beginner beginnerFlashcards = new Arabic_Flashcards_Beginner();
            beginnerFlashcards.startFlashCardPractice();
        } else if (userInput == 3) {
            Leaderboard leaderboard = new Leaderboard();
            leaderboard.Leaderboard();
        }
        else if (userInput == 4) {
            System.out.println("Exiting...");
            System.exit(0);
        }
    }

}
