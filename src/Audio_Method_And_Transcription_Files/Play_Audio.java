package Audio_Method_And_Transcription_Files;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Play_Audio {

    // Method to play audio from a specified file path
    public static void playAudio(String filePath) {
        try {
            // Creates a File object representing the audio file
            File audioFile = new File(filePath);

            // Gets an AudioInputStream from the audio file
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

            // Gets a Clip instance to play the audio
            Clip clip = AudioSystem.getClip();

            // Opens the audio clip with the audio stream
            clip.open(audioStream);

            // Starts playing the audio clip
            clip.start();

            // Waits for the audio clip to finish playing
            Thread.sleep(clip.getMicrosecondLength() / 1000);
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException | InterruptedException e) {
            // Prints abn error message if there's an exception
            System.out.println("Error playing audio: " + e.getMessage());
        }
    }
}
