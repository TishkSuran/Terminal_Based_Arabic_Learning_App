package Arabic_Listening_Tests.Arabic_Listening_Tests_JUnit_Tests;

import Arabic_Listening_Tests.Arabic_Listening_Test_Base;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Arabic_Listening_Test_Intermediate_JUnits{

    private Arabic_Listening_Test_Base testIntermediate;

    @Before
    public void setUp() {
        String[] audioFiles = {"Favourite.wav", "Good_morning.wav", "I_love_you.wav", "Interesting.wav", "No_problem.wav", "Of_course.wav", "Thank_you_very_much.wav", "Thats_good.wav", "What_is_that.wav", "You_are_welcome.wav"};
        testIntermediate = new Arabic_Listening_Test_Base(audioFiles, "src/Arabic_Words.Arabic_Words_Intermediate", "src/Audio_Method_And_Transcription_Files/transcriptions_intermediate.txt");
    }

    @Test
    public void testCorrectTranscriptionFavourite() {
        String expected = "Favourite";
        String actual = testIntermediate.getCorrectTranscription("Favourite.wav");
        assertEquals(expected, actual);
    }

    @Test
    public void testCorrectTranscriptionGoodMorning() {
        String expected = "Good morning";
        String actual = testIntermediate.getCorrectTranscription("Good_morning.wav");
        assertEquals(expected, actual);
    }

    @Test
    public void testCorrectTranscriptionILoveYou() {
        String expected = "I love you";
        String actual = testIntermediate.getCorrectTranscription("I_love_you.wav");
        assertEquals(expected, actual);
    }

    @Test
    public void testCorrectTranscriptionInteresting() {
        String expected = "Interesting";
        String actual = testIntermediate.getCorrectTranscription("Interesting.wav");
        assertEquals(expected, actual);
    }

    @Test
    public void testCorrectTranscriptionNoProblem() {
        String expected = "No problem";
        String actual = testIntermediate.getCorrectTranscription("No_problem.wav");
        assertEquals(expected, actual);
    }

    @Test
    public void testCorrectTranscriptionOfCourse() {
        String expected = "Of course";
        String actual = testIntermediate.getCorrectTranscription("Of_course.wav");
        assertEquals(expected, actual);
    }

    @Test
    public void testCorrectTranscriptionThankYouVeryMuch() {
        String expected = "Thank you very much";
        String actual = testIntermediate.getCorrectTranscription("Thank_you_very_much.wav");
        assertEquals(expected, actual);
    }

    @Test
    public void testCorrectTranscriptionThatsGood() {
        String expected = "That's good";
        String actual = testIntermediate.getCorrectTranscription("Thats_good.wav");
        assertEquals(expected, actual);
    }

    @Test
    public void testCorrectTranscriptionWhatIsThat() {
        String expected = "What is that";
        String actual = testIntermediate.getCorrectTranscription("What_is_that.wav");
        assertEquals(expected, actual);
    }

    @Test
    public void testCorrectTranscriptionYouAreWelcome() {
        String expected = "You are welcome";
        String actual = testIntermediate.getCorrectTranscription("You_are_welcome.wav");
        assertEquals(expected, actual);
    }

    @Test
    public void testIncorrectTranscriptionReturnsFalse() {
        String incorrectTranscription = "Incorrect";
        String actual = testIntermediate.getCorrectTranscription("Favourite.wav");
        assertNotEquals(incorrectTranscription, actual);
    }

    @Test
    public void testIncorrectFileReturnsNull() {
        String nonExistentFile = "NonExistent.wav";
        String actual = testIntermediate.getCorrectTranscription(nonExistentFile);
        assertNull(actual);
    }

    @Test
    public void testAllAudioFilesTranscriptionsExist() {
        for (String audioFile : testIntermediate.audioFiles) {
            String transcription = testIntermediate.getCorrectTranscription(audioFile);
            assertNotNull("Transcription not found for audio file: " + audioFile, transcription);
        }
    }
}
