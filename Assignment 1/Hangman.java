public class Hangman {

    static String unique(String word) { // removes duplicate characters from word e.g. Cheese becomes ches
        String ans = "";
        for (int i = 0; i < word.length(); i++) {
            if (ans.indexOf(word.charAt(i)) < 0)
                ans += word.charAt(i);
        }
        return ans;
    }
    public static int refereeHangman(String actualWord, String guesses) {
        int wrong = 0;
        String correct = "";
        for (int i = 0; i < guesses.length(); i++) {
            if ( (actualWord.indexOf(guesses.charAt(i)) < 0) || (correct.indexOf(guesses.charAt(i)) >= 0) ) // if char in guesses is NOT in actualWord or char is already in correct
                wrong++;
            else if (correct.indexOf(guesses.charAt(i)) < 0) { // elif char in guesses is NOT in correct
                correct += guesses.charAt(i);
            }
            

        }
        if (wrong >= 7)
            return -1;
        else if (correct.length() == unique(actualWord).length())
            return 1;
        else
            return 0;
    }
}