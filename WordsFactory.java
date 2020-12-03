package readability;

public class WordsFactory {
    String file;
    public WordsFactory(String file) {
        this.file = file;
    }
    public Object makeNewIndex(String newIndexType) {
        String ar[] = new String[5];
        WordsFactory newWords = null;
        if (newIndexType.equals("ARI")) {
            return new AriIndex(file);
        } else if (newIndexType.equals("FK")) {
            return new FkIndex(file);
        } else if (newIndexType.equals("SMOG")) {
            return new SmogIndex(file);
        } else if (newIndexType.equals("CL")) {
            return new CliIndex(file);
        }else if (newIndexType.equals("all")){
            ar[0]= String.valueOf(new AriIndex(file));
            ar[1]= String.valueOf(new FkIndex(file));
            ar[2]= String.valueOf(new SmogIndex(file));
            ar[3]= String.valueOf(new CliIndex(file));
            ar[4]= String.valueOf(new AverageIndex(file));

            return ar;

        }
        return null;
    }
}

