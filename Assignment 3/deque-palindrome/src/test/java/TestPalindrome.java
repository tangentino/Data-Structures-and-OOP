//IMPORTANT: Uncomment this file after you're done with the Deque interface and wordToDeque

 
import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        OffByOne cc = new OffByOne();
        assertEquals("racecar", true, palindrome.isPalindrome("racecar"));
        assertEquals("horse", false, palindrome.isPalindrome("horse"));
        assertEquals("naran", true, palindrome.isPalindrome("naran"));
        assertEquals("empty string", true, palindrome.isPalindrome(""));
        assertEquals("a", true, palindrome.isPalindrome("a"));
        assertEquals("paprika", false, palindrome.isPalindrome("paprika"));
        assertEquals("noon", true, palindrome.isPalindrome("noon"));

        assertEquals("flake",true,palindrome.isPalindrome("flake",cc));
    }
}

