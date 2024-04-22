public class Arabic_Listening_Test_Beginner extends Arabic_Listening_Test_Base {
    public Arabic_Listening_Test_Beginner() {
        super(new String[]{"Thank_you.wav", "Goodbye.wav", "Please.wav", "Busy.wav", "Delicious.wav", "Famous.wav", "Happy.wav", "Pretty.wav", "Water.wav", "Yes.wav"}, "src/Arabic_Words_Beginner", "src/transcriptions_beginner.txt");
    }

    @Override
    protected void displayResults(int correctAnswerCount) {
        super.displayResults(correctAnswerCount);
        String email = Login_System.email;

        if (correctAnswerCount == audioFiles.length) {
            System.out.println("Congratulations, you have been promoted to Arabic level: Intermediate.");
            Login_System.updateUserProficiency(email, "Intermediate");
            Intermediate_Screen intermediateScreen = new Intermediate_Screen();
            intermediateScreen.IntermediateScreen();
        }
    }
}