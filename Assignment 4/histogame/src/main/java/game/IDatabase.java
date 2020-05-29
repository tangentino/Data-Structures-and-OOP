package game;

import java.util.List;

public interface IDatabase {
    // Adds a word to the database.
    void add(Word w);

    // Removes w from the database and has no effects if w is not present
    void remove(Word w);

    // Returns a List of Words in the database whose length is exactly l.
    List<Word> getWordWithLength(int l);

    // Returns a List of Words in the database whose length is at least minLen
    // and which can be formed from all or some of the letters of the word w
    List<Word> getAllSubWords(Word w, int minLen);

    // Returns true if the word o is in the database and false otherwise
    boolean contains(Word o);
}
