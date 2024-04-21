import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Play_Audio {

    public static void playAudio(String filePath) {
        try {
            File audioFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            Thread.sleep(clip.getMicrosecondLength() / 1000);
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException | InterruptedException e) {
            System.out.println("Error playing audio: " + e.getMessage());
        }
    }
}