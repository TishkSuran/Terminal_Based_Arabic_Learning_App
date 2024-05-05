package Arabic_Listening_Tests;

import Login_System_And_Difficulty_Screens.*;

public class Arabic_Listening_Test_Intermediate extends Arabic_Listening_Test_Base {
    public Arabic_Listening_Test_Intermediate() {
        super(new String[]{
                "Favourite.wav",
                "Good_morning.wav",
                "I_love_you.wav",
                "Interesting.wav",
                "No_problem.wav",
                "Of_course.wav",
                "Thank_you_very_much.wav",
                "Thats_good.wav",
                "What_is_that.wav",
                "You_are_welcome.wav"},
                "src/Arabic_Words/Arabic_Words_Intermediate",
                "src/Audio_Method_And_Transcription_Files/transcriptions_intermediate.txt");
    }

    @Override
    protected void displayResults(int correctAnswerCount) {
        super.displayResults(correctAnswerCount);
        String email = Login_System.email;

        if (correctAnswerCount == audioFiles.length) {
            System.out.println("Congratulations, you have been promoted to Arabic level: Advanced.");
            Login_System.updateUserProficiency(email, "Advanced");
            Advanced_Screen.AdvancedScreen();
        }
    }
}
