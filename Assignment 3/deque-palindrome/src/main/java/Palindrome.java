public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> ans = new LinkedListDeque<Character>();
        for (int i = 0; i < word.length();i++) {
            ans.addLast(word.charAt(i));
        }
        return ans;
    }

    public boolean isPalindrome(String word) {
        Deque temp = wordToDeque(word);
        String compare = "";
        for (int i = 0; i < word.length(); i++) {
            compare += temp.removeLast();
        }
        return compare.equals(word);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque temp = wordToDeque(word);
        String compare = "";
        int count = 1;
        for (int i = 0; i < word.length(); i++) {
            compare += temp.removeLast();
        }
        for (int j = 0; j < word.length(); j++) {
            if (cc.equalChars(word.charAt(j),compare.charAt(j)))
                count += 1;
        }
        return count == word.length();
    }
}