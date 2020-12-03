package readability;

public class FkIndex extends Index {

    public FkIndex(String input) {
        super(input);
        System.out.print("Flesch–Kincaid readability tests: "+getFkIndex()+" ");
        scores.readIndex(scoreFk);

    }
}
