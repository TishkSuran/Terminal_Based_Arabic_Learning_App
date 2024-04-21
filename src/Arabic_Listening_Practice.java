import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Arabic_Listening_Practice {
        public static void arabicListeningPractice(){
            int experiencePoints = Login_System.experiencePoints;
            String email = Login_System.email;

            System.out.println("Welcome to Arabic Listening Practice!");
            Scanner scanner = new Scanner(System.in);

            String audioDirectory = "src/Arabic_Words_MP3";

            String[] audioFiles = {"Thank_you.wav", "Goodbye.wav", "Please.wav", "Busy.wav", "Delicious.wav", "Famous.wav", "Happy.wav", "Pretty.wav", "Water.wav", "Yes.wav"};

            Collections.shuffle(Arrays.asList(audioFiles));
            int currentIndex = 0;
            int correctAnswerCount = 0;

            while (true) {
                String randomAudioFile = audioFiles[currentIndex];

                Play_Audio.playAudio(audioDirectory + File.separator + randomAudioFile);

                System.out.println("Please transcribe what you heard in Arabic:");
                String userTranscription = scanner.nextLine().trim();

                String correctTranscription = getCorrectTranscription(randomAudioFile);

                if (userTranscription.equalsIgnoreCase(correctTranscription)) {
                    System.out.println("Correct!");
                    correctAnswerCount++;
                } else {
                    System.out.println("Incorrect. The correct transcription is: " + correctTranscription);
                }

                currentIndex++;

                if (currentIndex == 10) {
                    System.out.println("You got " + correctAnswerCount + " out of 10 listening question correct.");

                    if (correctAnswerCount == 10) {
                        System.out.println("Well done! You've achieved a flawless score, earning you 50 experience points.");
                        Login_System.updateExperiencePoints(email, 50);
                    } else if (correctAnswerCount >= 8) {
                        System.out.println("You have earned 25 experience points.");
                        Login_System.updateExperiencePoints(email, 25);
                    } else if (correctAnswerCount >= 5) {
                        System.out.println("You have earned 10 experience points.");
                        Login_System.updateExperiencePoints(email, 10);
                    }
                    System.out.println();
                    break;
                }
            }
        }

    public static String getCorrectTranscription(String audioFileName) {
        try {
            File file = new File("src/transcriptions_beginner.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].trim().equalsIgnoreCase(audioFileName.trim())) {
                    return parts[1].trim();
                }
            }

            return null;
        } catch (FileNotFoundException e) {
            System.out.println("Error: transcriptions file not found.");
            return null;
        }
    }
}

