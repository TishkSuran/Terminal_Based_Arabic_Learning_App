package Arabic_Listening_Tests.Arabic_Listening_Tests_JUnit_Tests;

import Arabic_Listening_Tests.Arabic_Listening_Test_Base;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertFalse;

public class Arabic_Listening_Test_Beginner_JUnits {

    private Arabic_Listening_Test_Base testBeginner;

    @Before
    public void setUp() {
        String[] audioFiles = {"Thank_you.wav", "Goodbye.wav", "Please.wav", "Busy.wav", "Delicious.wav", "Famous.wav", "Happy.wav", "Pretty.wav", "Water.wav", "Yes.wav"};
        testBeginner = new Arabic_Listening_Test_Base(audioFiles, "src/Arabic_Words.Arabic_Words_Beginner", "src/Audio_Method_And_Transcription_Files/transcriptions_beginner.txt");
    }

    @Test
    public void testCorrectTranscriptionThankYou() {
        String expected = "Thank you";
        String actual = testBeginner.getCorrectTranscription("Thank_you.wav");
        assertEquals(expected, actual);
    }

    @Test
    public void testCorrectTranscriptionGoodbye() {
        String expected = "Goodbye";
        String actual = testBeginner.getCorrectTranscription("Goodbye.wav");
        assertEquals(expected, actual);
    }

    @Test
    public void testCorrectTranscriptionPlease() {
        String expected = "Please";
        String actual = testBeginner.getCorrectTranscription("Please.wav");
        assertEquals(expected, actual);
    }

    @Test
    public void testCorrectTranscriptionBusy() {
        String expected = "Busy";
        String actual = testBeginner.getCorrectTranscription("Busy.wav");
        assertEquals(expected, actual);
    }

    @Test
    public void testCorrectTranscriptionDelicious() {
        String expected = "Delicious";
        String actual = testBeginner.getCorrectTranscription("Delicious.wav");
        assertEquals(expected, actual);
    }

    @Test
    public void testCorrectTranscriptionFamous() {
        String expected = "Famous";
        String actual = testBeginner.getCorrectTranscription("Famous.wav");
        assertEquals(expected, actual);
    }

    @Test
    public void testCorrectTranscriptionHappy() {
        String expected = "Happy";
        String actual = testBeginner.getCorrectTranscription("Happy.wav");
        assertEquals(expected, actual);
    }

    @Test
    public void testCorrectTranscriptionPretty() {
        String expected = "Pretty";
        String actual = testBeginner.getCorrectTranscription("Pretty.wav");
        assertEquals(expected, actual);
    }

    @Test
    public void testCorrectTranscriptionWater() {
        String expected = "Water";
        String actual = testBeginner.getCorrectTranscription("Water.wav");
        assertEquals(expected, actual);
    }

    @Test
    public void testCorrectTranscriptionYes() {
        String expected = "Yes";
        String actual = testBeginner.getCorrectTranscription("Yes.wav");
        assertEquals(expected, actual);
    }

    @Test
    public void testIncorrectTranscriptionReturnsFalse() {
        String incorrectTranscription = "Incorrect";
        String actual = testBeginner.getCorrectTranscription("Thank_you.wav");
        assertFalse(incorrectTranscription.equals(actual));
    }

    @Test
    public void testIncorrectFileReturnsNull() {
        String nonExistentFile = "NonExistent.wav";
        String actual = testBeginner.getCorrectTranscription(nonExistentFile);
        assertNull(actual);
    }

    @Test
    public void testAllAudioFilesTranscriptionsExist() {
        for (String audioFile : testBeginner.audioFiles) {
            String transcription = testBeginner.getCorrectTranscription(audioFile);
            assertNotNull("Transcription not found for audio file: " + audioFile, transcription);
        }
    }
}

