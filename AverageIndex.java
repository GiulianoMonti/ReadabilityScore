package readability;

public class AverageIndex extends Index {
    public AverageIndex(String input) {
        super(input);
        scores.readIndex(getAverages());
    }
}
