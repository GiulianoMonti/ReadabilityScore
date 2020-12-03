package readability;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Index {
    Scores scores = new Scores();
    String name;
    double sentences;
    double words;
    double characters;
    int syllables;
    int polysyllables;
    double scoreAri;
    double scoreFk;
    double scoreSmog;
    double scoreCli;

    public Index(String input) {
        sentences = input.split("[.!?]+\\s*").length;
        words = input.split("\\s+").length;
        this.characters = input.replaceAll("\\s", "").split("").length;
        syllables = getSyllables(input);

        polysyllables = calculatePolySyllableCount(input);
    }

    public void printOut() {
        System.out.println("Words: " + words);
        System.out.println("Sentences: " + sentences);
        System.out.println("Characters: " + characters);
        System.out.println("Syllables: " + syllables);
        System.out.println("Polysyllables: " + polysyllables);
    }
    public String getName() {
        return name;
    }

    public double getAriIndex() {
        this.scoreAri = 4.71 * (characters / words) + (0.5 * words / sentences) - 21.43;
        return this.scoreAri;
    }
    public double getFkIndex() {
        this.scoreFk = 0.39 * (words / sentences) + 11.8 * (syllables / words) - 15.59;
        return  this.scoreFk;

    }
    public double getSmogIndex() {
        this.scoreSmog= 1.043 * Math.sqrt(polysyllables * (30 / sentences)) + 3.1291;
        return this.scoreSmog;

    }

    public double getCliIndex() {
        double S = sentences / words * 100;
        double L = characters / words * 100;
        this.scoreCli = (0.0588 * L) - (0.296 * S) - 15.8;
        return this.scoreCli;

    }

    public double getAverages() {
        System.out.print("This text should be understood in average by: ");
        return (getSmogIndex()+getAriIndex()+getCliIndex()+getFkIndex())/4;
    }


    public int getSyllables(String word) {
        Pattern p = Pattern.compile("([aeiouyAEIOUYC]+[^e.\\s^!])|([aiouyAEIOUCY]+\\b)|(\\b[^aeiouy0-9.']+e\\b)|le\\b|ludes\\b|ive\\b|ee");
        Matcher m = p.matcher(word);
        int syllables = 0;
        while (m.find()) {
            syllables++;
        }
        return syllables;
    }

    private int calculatePolySyllableCount(String text) {
        String[] words = text.split(" ");
        int polySyllableCount = 0;
        for (String word : words) {
            int syllables = getSyllables(word);
            if (syllables > 2)
                polySyllableCount++;
        }
        return polySyllableCount;
    }



}

