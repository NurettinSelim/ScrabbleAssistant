package tr.edu.ozyegin.cs101.scrabble;

import java.util.Arrays;

public class Word implements Comparable<Word> {
    private final ScrabbleChar[] scrabbleChars;
    private final String originalWord;

    public String getOriginalWord() {
        return originalWord;
    }

    public String getWord() {
        StringBuilder sb = new StringBuilder();
        for (ScrabbleChar scrabbleChar : scrabbleChars) {
            sb.append(scrabbleChar.value);
        }
        return sb.toString();
    }


    public Word(String originalWord) {
        this.originalWord = originalWord;
        this.scrabbleChars = new ScrabbleChar[originalWord.length()];
    }

    public void useJoker(char value, int index) {
        scrabbleChars[index].useJoker(value);
    }

    public void putScrabbleChar(ScrabbleChar scrabbleChar, int index) {
        scrabbleChars[index] = scrabbleChar;
    }

    public int getPoint() {
        int sum = 0;
        for (ScrabbleChar scrabbleChar : this.scrabbleChars) {
            sum += scrabbleChar.getPoint();
        }
        return sum;
    }

    @Override
    public String toString() {
        return "Word{" +
                "scrabbleChars=" + Arrays.toString(scrabbleChars) +
                ", originalWord='" + originalWord + '\'' +
                '}';
    }


    @Override
    public int compareTo(Word o) {
        return o.getPoint() - this.getPoint();
    }
}
