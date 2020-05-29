package game;

import histogram.Histogram;
import histogram.SimpleHistogram;

public class Word implements Formable<Word>, Comparable<Word> {
    private String word;
    private Histogram hist;
    private Character[] wordArray;

    public Word(String word) {
        this.word = word;
        wordArray = new Character[word.length()];
        for (int i = 0; i < word.length();i++) {
            wordArray[i] = Character.toLowerCase(word.charAt(i));
        }
        hist = new SimpleHistogram<Character>(wordArray);
    }

    public String getWord() {
        return word;
    }

    public Histogram<Character> getHistogram() {
        return hist;
    }


    @Override
    public boolean canForm(Word other) {
        int counter = 0;
        String otherString = other.getWord();
        Histogram<Character> thisWord = this.getHistogram();
        Histogram<Character> otherWord = other.getHistogram();
        if (thisWord.equals(otherWord)) { return true; }
        if (otherWord.getTotalCount() > thisWord.getTotalCount()) { return false; }
        for (int i = 0; i < otherString.length(); i++) {
            if ((this.getWord()).indexOf(otherString.charAt(i)) !=  -1) {
                if ((otherWord.getCount(otherString.charAt(i)) <= thisWord.getCount(otherString.charAt(i)))) {
                    counter++;
                }
            }
        }
        return (counter == otherString.length());
    }

    @Override
    public int compareTo(Word o) {
        String oString = o.getWord();
        String thisString = this.getWord();
        return (thisString.compareTo(oString));
    }

    public static void main(String[] args) {
        Word one = new Word("penises");
        Word two = new Word("penis");
        System.out.println(two.canForm(one));
    }
}
