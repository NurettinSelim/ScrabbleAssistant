package tr.edu.ozyegin.cs101.scrabble;

public class WordWriter {
    public static Word writeWord(Word word, ScrabbleChar[] scrabbleChars, String boardText) {
        for (int i = 0; i < word.getOriginalWord().length(); i++) {
            if (boardText.charAt(i) != Main.WILDCARD) {
                word.putScrabbleChar(new ScrabbleChar(boardText.charAt(i)), i);
                continue;
            }

            char searchingChar = word.getOriginalWord().charAt(i);
            int charIndex = findIndex(scrabbleChars, searchingChar);
            int jokerIndex = findIndex(scrabbleChars, Main.JOKER);
            if (charIndex > -1) {
                word.putScrabbleChar(scrabbleChars[charIndex], i);
                scrabbleChars = deleteElementAtIndex(scrabbleChars, charIndex);
            } else if (jokerIndex > -1) {
                word.putScrabbleChar(new ScrabbleChar('_'), i);
                word.useJoker(searchingChar, i);
                scrabbleChars = deleteElementAtIndex(scrabbleChars, jokerIndex);
            } else {
                return null;
            }
        }

        return word;
    }

    private static int findIndex(ScrabbleChar[] array, char character) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].value == character) {
                return i;
            }
        }
        return -1;
    }

    private static ScrabbleChar[] deleteElementAtIndex(ScrabbleChar[] array, int indexToDelete) {
        if (indexToDelete < 0 || indexToDelete >= array.length) {
            return array;
        }

        ScrabbleChar[] newArray = new ScrabbleChar[array.length - 1];
        System.arraycopy(array, 0, newArray, 0, indexToDelete);
        if (newArray.length - indexToDelete >= 0)
            System.arraycopy(array, indexToDelete + 1, newArray, indexToDelete, newArray.length - indexToDelete);
        return newArray;
    }
}
