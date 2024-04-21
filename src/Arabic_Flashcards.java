import java.io.File;
import java.util.Scanner;

public class Arabic_Flashcards {
    public static void arabicFlashcards() {
        Scanner scanner = new Scanner(System.in);
        String email = Login_System.email;

        String audioDirectory = "src/Arabic_Words_MP3";
        String[] audioFiles = {"Thank_you.wav", "Goodbye.wav", "Please.wav", "Busy.wav", "Delicious.wav", "Famous.wav", "Happy.wav", "Pretty.wav", "Water.wav", "Yes.wav"};

        System.out.println("Welcome to Arabic Word Learning");
        System.out.println("1. Thank you");
        System.out.println("2. Goodbye");
        System.out.println("3. Please");
        System.out.println("4. Busy");
        System.out.println("5. Delicious");
        System.out.println("6. Famous");
        System.out.println("7. Happy");
        System.out.println("8. Pretty");
        System.out.println("9. Water");
        System.out.println("10. Yes");
        System.out.println("0. Exit");
        System.out.println();
        System.out.println("Please input an integer from 0 to 10 to hear the corresponding word along with its phonetic pronunciation.");

        while (true) {
            int userInput = scanner.nextInt();
            if (userInput == 0) {
                System.out.println("Exiting...");
                return;
            } else if (userInput < 0 || userInput > 10) {
                System.out.println("Invalid choice. Please enter a number between 0 and 10.");
                continue;
            }

            String audioFile = audioFiles[userInput - 1];
            Play_Audio.playAudio(audioDirectory + File.separator + audioFile);

            switch (userInput) {
                case 1:
                    System.out.println("|  Thank you  |    Shukrān lak    |   شُكْرًا لَك");
                    Login_System.updateExperiencePoints(email, 5);
                    break;
                case 2:
                    System.out.println("|   Goodbye   |    Ila al-liqa'   |   إلى اللقاء");
                    Login_System.updateExperiencePoints(email, 5);
                    break;
                case 3:
                    System.out.println("|   Please    |    Min fadlik     |   مِن فَضْلَك");
                    Login_System.updateExperiencePoints(email, 5);
                    break;
                case 4:
                    System.out.println("|    Busy     |     Mashghūl      |   مَشْغُول");
                    Login_System.updateExperiencePoints(email, 5);
                    break;
                case 5:
                    System.out.println("|  Delicious  |     Ladhīdh       |   لَذِيذ");
                    Login_System.updateExperiencePoints(email, 5);
                    break;
                case 6:
                    System.out.println("|   Famous    |     Mashhūr       |   مَشْهُور");
                    Login_System.updateExperiencePoints(email, 5);
                    break;
                case 7:
                    System.out.println("|    Happy    |      Sa'īd        |   سَعِيد");
                    Login_System.updateExperiencePoints(email, 5);
                    break;
                case 8:
                    System.out.println("|  Beautiful  |      Jamīl        |   جَمِيلَة");
                    Login_System.updateExperiencePoints(email, 5);
                    break;
                case 9:
                    System.out.println("|   Water     |       Mā'         |   مَاء");
                    Login_System.updateExperiencePoints(email, 5);
                    break;
                case 10:
                    System.out.println("|    Yes      |      Na'am        |   نَعَم");
                    Login_System.updateExperiencePoints(email, 5);
                    break;
            }
        }
    }
}
