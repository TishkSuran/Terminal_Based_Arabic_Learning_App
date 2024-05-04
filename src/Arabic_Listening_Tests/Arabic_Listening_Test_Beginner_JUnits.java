package Arabic_Listening_Tests;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Arabic_Listening_Test_Beginner_JUnits {

    private Arabic_Listening_Test_Base testBase;

    @Before
    public void setUp() {
        String[] audioFiles = {"Thank_you.wav", "Goodbye.wav", "Please.wav", "Busy.wav", "Delicious.wav", "Famous.wav", "Happy.wav", "Pretty.wav", "Water.wav", "Yes.wav"};
        testBase = new Arabic_Listening_Test_Base(audioFiles, "src/Arabic_Words_Beginner", "src/Audio_Method_And_Transcription_Files/transcriptions_beginner.txt");
    }

    @Test
    public void testCorrectTranscriptionThankYou() {
        String expected = "Thank you";
        String actual = testBase.getCorrectTranscription("Thank_you.wav");
        assertEquals(expected, actual);
    }

    @Test
    public void testCorrectTranscriptionGoodbye() {
        String expected = "Goodbye";
        String actual = testBase.getCorrectTranscription("Goodbye.wav");
        assertEquals(expected, actual);
    }

    @Test
    public void testCorrectTranscriptionPlease() {
        String expected = "Please";
        String actual = testBase.getCorrectTranscription("Please.wav");
        assertEquals(expected, actual);
    }

    @Test
    public void testCorrectTranscriptionBusy() {
        String expected = "Busy";
        String actual = testBase.getCorrectTranscription("Busy.wav");
        assertEquals(expected, actual);
    }

    @Test
    public void testCorrectTranscriptionDelicious() {
        String expected = "Delicious";
        String actual = testBase.getCorrectTranscription("Delicious.wav");
        assertEquals(expected, actual);
    }

    @Test
    public void testCorrectTranscriptionFamous() {
        String expected = "Famous";
        String actual = testBase.getCorrectTranscription("Famous.wav");
        assertEquals(expected, actual);
    }

    @Test
    public void testCorrectTranscriptionHappy() {
        String expected = "Happy";
        String actual = testBase.getCorrectTranscription("Happy.wav");
        assertEquals(expected, actual);
    }

    @Test
    public void testCorrectTranscriptionPretty() {
        String expected = "Pretty";
        String actual = testBase.getCorrectTranscription("Pretty.wav");
        assertEquals(expected, actual);
    }

    @Test
    public void testCorrectTranscriptionWater() {
        String expected = "Water";
        String actual = testBase.getCorrectTranscription("Water.wav");
        assertEquals(expected, actual);
    }

    @Test
    public void testCorrectTranscriptionYes() {
        String expected = "Yes";
        String actual = testBase.getCorrectTranscription("Yes.wav");
        assertEquals(expected, actual);
    }

    @Test
    public void testIncorrectTranscriptionReturnsFalse() {
        String incorrectTranscription = "Incorrect";
        String actual = testBase.getCorrectTranscription("Thank_you.wav");
        assertFalse(incorrectTranscription.equals(actual));
    }

    @Test
    public void testIncorrectFileReturnsNull() {
        String nonExistentFile = "NonExistent.wav";
        String actual = testBase.getCorrectTranscription(nonExistentFile);
        assertNull(actual);
    }

    @Test
    public void testAllAudioFilesTranscriptionsExist() {
        for (String audioFile : testBase.audioFiles) {
            String transcription = testBase.getCorrectTranscription(audioFile);
            assertNotNull("Transcription not found for audio file: " + audioFile, transcription);
        }
    }
}
