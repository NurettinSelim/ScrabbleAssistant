package tr.edu.ozyegin.cs101.scrabble;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.stream.Stream;

public class WordReader {

    public static void main(String[] args) throws Exception  {

        String[] wordList = readWords("/usr/share/dict/words");

        for (String word : wordList) {
            System.out.println(word);
        }
    }


    public static String[] readWords(String filename) {
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            return stream.map(s -> s.toUpperCase(Locale.ROOT)).toArray(String[]::new);
        } catch(IOException e) {
            throw new IllegalArgumentException("The file " + filename + " could not be opened for reading.");
        }
    }

}