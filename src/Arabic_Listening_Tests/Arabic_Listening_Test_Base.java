package Arabic_Listening_Tests;

import Login_System_And_Difficulty_Screens.*;
import Audio_Method_And_Transcription_Files.Play_Audio;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Arabic_Listening_Test_Base {
    protected String[] audioFiles;
    protected String audioDirectory;
    protected String transcriptionFile;

    public Arabic_Listening_Test_Base(String[] audioFiles, String audioDirectory, String transcriptionFile) {
        this.audioFiles = audioFiles;
        this.audioDirectory = audioDirectory;
        this.transcriptionFile = transcriptionFile;
    }

    public void startListeningPractice() {
        System.out.println("Welcome to Listening Practice!");
        Scanner scanner = new Scanner(System.in);

        Collections.shuffle(Arrays.asList(audioFiles));
        int currentIndex = 0;
        int correctAnswerCount = 0;

        while (true) {
            String randomAudioFile = audioFiles[currentIndex];

            Play_Audio.playAudio(audioDirectory + File.separator + randomAudioFile);

            System.out.println("Please transcribe what you heard:");
            String userTranscription = scanner.nextLine().trim();

            String correctTranscription = getCorrectTranscription(randomAudioFile);

            if (userTranscription.equalsIgnoreCase(correctTranscription)) {
                System.out.println("Correct!");
                correctAnswerCount++;
            } else {
                System.out.println("Incorrect. The correct transcription is: " + correctTranscription);
            }

            currentIndex++;

            if (currentIndex == audioFiles.length) {
                System.out.println("You got " + correctAnswerCount + " out of " + audioFiles.length + " listening questions correct.");
                displayResults(correctAnswerCount);
                break;
            }
        }
    }

    protected String getCorrectTranscription(String audioFileName) {
        try {
            File file = new File(transcriptionFile);
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

    protected void displayResults(int correctAnswerCount) {
        int experiencePoints = Login_System.experiencePoints;
//        String proficiency = Login_System.Login_System.proficiency;
        String email = Login_System.email;
        if (correctAnswerCount == audioFiles.length) {
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
    }
}


