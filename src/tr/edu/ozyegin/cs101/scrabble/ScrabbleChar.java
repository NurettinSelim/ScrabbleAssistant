package tr.edu.ozyegin.cs101.scrabble;

public class ScrabbleChar {
    private boolean isJoker = false;
    private final char originalValue;
    public char value;

    public ScrabbleChar(char value) {
        this.originalValue = value;
        this.value = value;
        if (value == Main.JOKER)
            this.isJoker = true;
    }

    public void useJoker(char convertedValue){
        this.value = convertedValue;
    }

    public int getPoint() {
        if (isJoker)
            return 0;
        
        return switch (this.value) {
            case 'A', 'E', 'I', 'O', 'U', 'L', 'N', 'S', 'T', 'R' -> 1;
            case 'D', 'G' -> 2;
            case 'B', 'C', 'M', 'P' -> 3;
            case 'F', 'H', 'V', 'W', 'Y' -> 4;
            case 'K' -> 5;
            case 'J', 'X' -> 8;
            case 'Q', 'Z' -> 10;
            default -> 0;
        };
    }

    @Override
    public String toString() {
        return "ScrabbleChar{" +
                "isJoker=" + isJoker +
                ", originalValue=" + originalValue +
                ", value=" + value +
                "}\n";
    }
}
