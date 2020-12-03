package readability;

public class CliIndex extends Index {
    public CliIndex(String input) {
        super(input);
        System.out.print("Coleman–Liau index: "+getCliIndex()+" ");
        scores.readIndex(scoreCli);
    }
}