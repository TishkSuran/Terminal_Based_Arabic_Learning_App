package Arabic_Listening_Tests.Arabic_Listening_Tests_JUnit_Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertFalse;

import Arabic_Listening_Tests.Arabic_Listening_Test_Base;
import org.junit.Before;
import org.junit.Test;

public class Arabic_Listening_Test_Advanced_JUnits {

    private Arabic_Listening_Test_Base testAdvanced;

    @Before
    public void setUp() {
        String[] audioFiles = {"What_do_you_recommend_.wav", "Can_I_take_a_photo.wav", "Where_are_you_from.wav", "I_can_speak_a_little_bit_of_Arabic.wav", "Can_you_recommend_a_good_restaurant_nearby.wav", "Can_you_give_me_a_discount.wav", "Pigeon's_meat_is_legal_and_donkey's_meat_is_forbidden.wav", "Can_I_get_Internet_access_here.wav", "The_check_please.wav", "What_does_..._mean.wav"};
        testAdvanced = new Arabic_Listening_Test_Base(audioFiles, "src/Audio_Method_And_Transcription_Files/Arabic_Words.Arabic_Words_Advanced", "src/Audio_Method_And_Transcription_Files/transcriptions_advanced.txt");
    }

    @Test
    public void testCorrectTranscriptionWhatDoYouRecommend() {
        String expected = "What do you recommend";
        String actual = testAdvanced.getCorrectTranscription("What_do_you_recommend_.wav");
        assertEquals(expected, actual);
    }

    @Test
    public void testCorrectTranscriptionCanITakeAPhoto() {
        String expected = "Can I take a photo";
        String actual = testAdvanced.getCorrectTranscription("Can_I_take_a_photo.wav");
        assertEquals(expected, actual);
    }

    @Test
    public void testCorrectTranscriptionWhereAreYouFrom() {
        String expected = "Where are you from";
        String actual = testAdvanced.getCorrectTranscription("Where_are_you_from.wav");
        assertEquals(expected, actual);
    }

    @Test
    public void testCorrectTranscriptionICanSpeakALittleBitOfArabic() {
        String expected = "I can speak a little bit of Arabic";
        String actual = testAdvanced.getCorrectTranscription("I_can_speak_a_little_bit_of_Arabic.wav");
        assertEquals(expected, actual);
    }

    @Test
    public void testCorrectTranscriptionCanYouRecommendAGoodRestaurantNearby() {
        String expected = "Can you recommend a good restaurant nearby";
        String actual = testAdvanced.getCorrectTranscription("Can_you_recommend_a_good_restaurant_nearby.wav");
        assertEquals(expected, actual);
    }

    @Test
    public void testCorrectTranscriptionCanYouGiveMeADiscount() {
        String expected = "Can you give me a discount";
        String actual = testAdvanced.getCorrectTranscription("Can_you_give_me_a_discount.wav");
        assertEquals(expected, actual);
    }

    @Test
    public void testCorrectTranscriptionPigeonsMeatIsLegalAndDonkeysMeatIsForbidden() {
        String expected = "Pigeon's meat is legal and donkey's meat is forbidden";
        String actual = testAdvanced.getCorrectTranscription("Pigeon's_meat_is_legal_and_donkey's_meat_is_forbidden.wav");
        assertEquals(expected, actual);
    }

    @Test
    public void testCorrectTranscriptionCanIGetInternetAccessHere() {
        String expected = "Can I get internet access here";
        String actual = testAdvanced.getCorrectTranscription("Can_I_get_Internet_access_here.wav");
        assertEquals(expected, actual);
    }

    @Test
    public void testCorrectTranscriptionTheCheckPlease() {
        String expected = "The check please";
        String actual = testAdvanced.getCorrectTranscription("The_check_please.wav");
        assertEquals(expected, actual);
    }

    @Test
    public void testCorrectTranscriptionWhatDoesMean() {
        String expected = "What does ... mean";
        String actual = testAdvanced.getCorrectTranscription("What_does_..._mean.wav");
        assertEquals(expected, actual);
    }

    @Test
    public void testIncorrectTranscriptionReturnsFalse() {
        String incorrectTranscription = "Incorrect";
        String actual = testAdvanced.getCorrectTranscription("What_do_you_recommend_.wav");
        assertFalse(incorrectTranscription.equals(actual));
    }

    @Test
    public void testIncorrectFileReturnsNull() {
        String nonExistentFile = "NonExistent.wav";
        String actual = testAdvanced.getCorrectTranscription(nonExistentFile);
        assertNull(actual);
    }

    @Test
    public void testAllAudioFilesTranscriptionsExist() {
        for (String audioFile : testAdvanced.audioFiles) {
            String transcription = testAdvanced.getCorrectTranscription(audioFile);
            assertNotNull("Transcription not found for audio file: " + audioFile, transcription);
        }
    }
}
