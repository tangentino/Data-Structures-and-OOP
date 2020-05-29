package game;

import java.io.IOException;
import java.util.*;

public class TextTwist {
    private Scanner input;
    private List<Word> temp;
    private Word startingWord;
    private double startTime;
    private double finishTime;
    private int currentScore;
    private int maxScore;
    private WordDatabase allWords;
    private List<Word> gameWords;
    private String letters;
    private Random rnd = new Random();
    private HashMap<Word,String> ansList;
    private List<Word> answeredWords;
    private double currentTime;

    public TextTwist() throws IOException {
        allWords = new WordDatabase("linuxwords.txt");
        input = new Scanner(System.in);
        temp = allWords.getWordWithLength(6);
        answeredWords = new ArrayList<Word>();
        startWord();
    }

    public void startWord() {
        startingWord = scrambleWord(temp.get(rnd.nextInt(temp.size())));
        gameWords = allWords.getAllSubWords(startingWord,3);
        maxScore = gameWords.size();
        currentScore = 0;
        startTime = (System.currentTimeMillis())/1000;
        ansList = createAnswerList(gameWords);
        System.out.println("Your letters are: "+startingWord.getWord());
    }

    public HashMap<Word,String> createAnswerList(List<Word> l) {
        HashMap<Word,String> ans = new HashMap<Word,String>();
        String temp;
        for (Word w : l) {
            temp = "";
            for (int i = 0; i < w.getWord().length(); i++) {
                temp += "?";
            }
            ans.put(w,temp);
        }
        return ans;
    }

    public String userInput() {
        return input.nextLine();
    }

    public Word scrambleWord(Word word) {
        String s = word.getWord();
        ArrayList<Character> sList = new ArrayList<Character>();
        for (int i = 0; i < s.length(); i++) {
            sList.add(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        Collections.shuffle(sList);
        for (Character c : sList) {
            sb.append(c);
        }
        Word ans = new Word(sb.toString());
        return ans;
    }

    public void checkWord(String word) {
        Word w = new Word(word);
        if (gameWords.contains(w) && !(answeredWords.contains(w))) {
            System.out.println(word + " is correct!");
            currentScore += 1;
            answeredWords.add(w);
        }
        else {
            System.out.println("Wrong answer! Try again.");
        }
    }

    public boolean winCondition() {
        if (currentScore == maxScore) {
            return true;
        }
        return false;
    }

    public void surrender() {
        System.out.println("You chose to surrender and restart. The answers are: ");
        String ans = "";
        for (Word w : gameWords) {
            ans += w.getWord() + " ";
        }
        System.out.println(ans);
        startWord();
    }
    public void showWordList() {
        System.out.println("Your current words are: ");
        String ans = "";
        for (String s : ansList.values()) {
            ans += s + " ";
        }
    }
    public void showInfo() {
        finishTime = System.currentTimeMillis()/1000;
        currentTime = finishTime - startTime;
        System.out.println("Elapsed time: "+ currentTime);
        System.out.println("Current score: "+currentScore+"/"+maxScore);
        System.out.println("Commands: q - quit, ! - give up, ? - info");
    }

    public boolean processCommand() {
        boolean wantToQuit = false;
        String command = userInput();

        if (command.equals("q")) {
            wantToQuit = true;
        }
        else if (command.equals("!")) {
            surrender();
        }
        else if (command.equals("?")) {
            showWordList();
        }
        else {
            checkWord(command.toLowerCase());
        }
        return wantToQuit;
    }

    public void playGame() {
        boolean finished = false;
        while (!finished) {
            showInfo();
            finished = processCommand();
            if (winCondition()) {
                System.out.println("Game over! You won!");
                break;
            }
        }
        System.out.println("Thank you, goodbye");
    }

    public static void main(String[] args) throws IOException {
        TextTwist game = new TextTwist();
        game.playGame();
    }

}