package Arabic_Flashcards;

import Login_System_And_Difficulty_Screens.Login_System;
import Audio_Method_And_Transcription_Files.Play_Audio;

import java.io.File;
import java.util.Scanner;

public abstract class Arabic_Flashcards_Base {
    protected String[] audioFiles;
    protected String audioDirectory;
    protected String[] arabicWordsInEnglish;
    protected String[] arabicWordsPhonetic;
    protected String[] arabicWords;

    public Arabic_Flashcards_Base(String[] audioFiles, String audioDirectory, String[] arabicWordsInEnglish, String[] arabicWordsPhonetic, String[] arabicWords) {
        this.audioFiles = audioFiles;
        this.audioDirectory = audioDirectory;
        this.arabicWordsInEnglish = arabicWordsInEnglish;
        this.arabicWordsPhonetic = arabicWordsPhonetic;
        this.arabicWords = arabicWords;
    }

    public void startFlashCardPractice() {
        Scanner scanner = new Scanner(System.in);
        String email = Login_System.email;
        System.out.println("Welcome to Arabic Word Learning");
        System.out.println("1. " + arabicWordsInEnglish[0]);
        System.out.println("2. " + arabicWordsInEnglish[1]);
        System.out.println("3. " + arabicWordsInEnglish[2]);
        System.out.println("4. " + arabicWordsInEnglish[3]);
        System.out.println("5. " + arabicWordsInEnglish[4]);
        System.out.println("6. " + arabicWordsInEnglish[5]);
        System.out.println("7. " + arabicWordsInEnglish[6]);
        System.out.println("8. " + arabicWordsInEnglish[7]);
        System.out.println("9. " + arabicWordsInEnglish[8]);
        System.out.println("10. " + arabicWordsInEnglish[9]);
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
                    System.out.println("| " + arabicWordsInEnglish[0] + " | " + arabicWordsPhonetic[0] + " | " + arabicWords[0] + " |");
                    Login_System.updateExperiencePoints(email, 5);
                    break;
                case 2:
                    System.out.println("| " + arabicWordsInEnglish[1] + " | " + arabicWordsPhonetic[1] + " | " + arabicWords[1] + " |");
                    Login_System.updateExperiencePoints(email, 5);
                    break;
                case 3:
                    System.out.println("| " + arabicWordsInEnglish[2] + " | " + arabicWordsPhonetic[2] + " | " + arabicWords[2] + " |");
                    Login_System.updateExperiencePoints(email, 5);
                    break;
                case 4:
                    System.out.println("| " + arabicWordsInEnglish[3] + " | " + arabicWordsPhonetic[3] + " | " + arabicWords[3] + " |");
                    Login_System.updateExperiencePoints(email, 5);
                    break;
                case 5:
                    System.out.println("| " + arabicWordsInEnglish[4] + " | " + arabicWordsPhonetic[4] + " | " + arabicWords[4] + " |");
                    Login_System.updateExperiencePoints(email, 5);
                    break;
                case 6:
                    System.out.println("| " + arabicWordsInEnglish[5] + " | " + arabicWordsPhonetic[5] + " | " + arabicWords[5] + " |");
                    Login_System.updateExperiencePoints(email, 5);
                    break;
                case 7:
                    System.out.println("| " + arabicWordsInEnglish[6] + " | " + arabicWordsPhonetic[6] + " | " + arabicWords[6] + " |");
                    Login_System.updateExperiencePoints(email, 5);
                    break;
                case 8:
                    System.out.println("| " + arabicWordsInEnglish[7] + " | " + arabicWordsPhonetic[7] + " | " + arabicWords[7] + " |");
                    Login_System.updateExperiencePoints(email, 5);
                    break;
                case 9:
                    System.out.println("| " + arabicWordsInEnglish[8] + " | " + arabicWordsPhonetic[8] + " | " + arabicWords[8] + " |");
                    Login_System.updateExperiencePoints(email, 5);
                    break;
                case 10:
                    System.out.println("| " + arabicWordsInEnglish[9] + " | " + arabicWordsPhonetic[9] + " | " + arabicWords[9] + " |");
                    Login_System.updateExperiencePoints(email, 5);
                    break;
            }
        }
    }
}

