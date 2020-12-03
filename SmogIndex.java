package readability;

public class SmogIndex extends Index {
    public SmogIndex(String input) {
        super(input);
        System.out.print("Simple Measure of Gobbledygook: "+ getSmogIndex()+" ");
        scores.readIndex(scoreSmog);
    }
}
