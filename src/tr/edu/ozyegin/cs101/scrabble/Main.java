package tr.edu.ozyegin.cs101.scrabble;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Main {
    public static final char JOKER = '_';
    public static final char WILDCARD = '*';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String letters = scanner.nextLine().toUpperCase();
        ScrabbleChar[] scrabbleChars = new ScrabbleChar[letters.length()];
        for (int i = 0; i < letters.length(); i++) {
            scrabbleChars[i] = new ScrabbleChar(letters.charAt(i));
        }
        String pattern = scanner.nextLine().toUpperCase();

        String[] dict = WordReader.readWords("/Users/selim/IdeaProjects/ScrabbleAssistant/src/tr/edu/ozyegin/cs101/scrabble/dictionary.txt");

        ArrayList<Word> validWords = new ArrayList<>();

        for (String text : dict) {
            if (match(pattern, text)) {
                Word word = new Word(text);
                Word writtenWord = WordWriter.writeWord(word, scrabbleChars, pattern);
                if (writtenWord != null) {
                    validWords.add(writtenWord);
                }
            }
        }

        Collections.sort(validWords);
        for (Word validWord : validWords) {
            System.out.println("Word: " + validWord.getWord() + " --- Point of word: " + validWord.getPoint());
        }
    }

    private static boolean match(String pattern, String word) {
        if (!pattern.matches("[A-Z*]+"))
            throw new IllegalArgumentException();
        if (pattern.length() != word.length())
            return false;
        String regexPattern = "^" + pattern.replace('*', '.') + "$";
        return word.matches(regexPattern);
    }
}