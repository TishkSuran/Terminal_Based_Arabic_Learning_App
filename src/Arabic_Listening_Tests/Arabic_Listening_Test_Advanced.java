package Arabic_Listening_Tests;

public class Arabic_Listening_Test_Advanced extends Arabic_Listening_Test_Base {
    public Arabic_Listening_Test_Advanced() {
        super(new String[]{
                "What_do_you_recommend_.wav",
                "Can_I_take_a_photo.wav",
                "Where_are_you_from.wav",
                "I_can_speak_a_little_bit_of_Arabic.wav",
                "Can_you_recommend_a_good_restaurant_nearby.wav",
                "Can_you_give_me_a_discount.wav",
                "Pigeon's_meat_is_legal_and_donkey's_meat_is_forbidden.wav",
                "Can_I_get_Internet_access_here.wav",
                "The_check_please.wav",
                "What_does_..._mean.wav"},
                "src/Arabic_Words/Arabic_Words_Advanced",
                "src/transcriptions_advanced.txt");
    }

    @Override
    protected void displayResults(int correctAnswerCount) {
        super.displayResults(correctAnswerCount);

        if (correctAnswerCount == audioFiles.length) {
            System.out.println("Congratulations, you have completed all three current levels of difficulty! Please continue to collect XP or come back later for new feature updates.");
        }
    }
}
