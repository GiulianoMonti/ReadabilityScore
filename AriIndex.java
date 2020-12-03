package readability;

public class AriIndex extends Index {

    public AriIndex(String input) {
        super(input);
        System.out.print("Automated Readability Index: "+ getAriIndex()+" ");
        scores.readIndex(scoreAri);
    }

}
