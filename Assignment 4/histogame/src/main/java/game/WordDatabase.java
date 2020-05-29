package game;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// HINT(s):
//   To read from src/resources/<filename>
//   InputStream is = getClass().getClassLoader().getResourceAsStream(filename);

public class WordDatabase implements IDatabase {
    private List<Word> wordlist;

    public WordDatabase(String filename) throws IOException {
        Word word;
        wordlist = new ArrayList<Word>();
        InputStream is = getClass().getClassLoader().getResourceAsStream(filename);
        BufferedReader buff = new BufferedReader(new InputStreamReader(is));
        String line = buff.readLine();
        while (line != null) {
            word = new Word(line);
            wordlist.add(word);
            line = buff.readLine();
        }
    }
    @Override
    public void add(Word w) {
        wordlist.add(w);
    }

    @Override
    public void remove(Word w) {
        wordlist.remove(w);
    }

    @Override
    public List<Word> getWordWithLength(int l) {
        List<Word> ans = new ArrayList<Word>();
        for (Word i : wordlist) {
            if ((i.getWord().length() == l)) {
                ans.add(i);
            }
        }
        return ans;
    }

    @Override
    public List<Word> getAllSubWords(Word w, int minLen) {
        List<Word> ans = new ArrayList<Word>();
        for (Word i : wordlist) {
            if ((i.getWord().length() >= minLen) && w.canForm(i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    @Override
    public boolean contains(Word o) {
        return (wordlist.contains(o));
    }
}
