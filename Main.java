package readability;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
      String text = ("This is the front page of the Simple English Wikipedia. Wikipedias are places where people work together to write encyclopedias in different languages. We use Simple English words and grammar here. The Simple English Wikipedia is for everyone! That includes children and adults who are learning English. There are 142,262 articles on the Simple English Wikipedia. All of the pages are free to use. They have all been published under both the Creative Commons License and the GNU Free Documentation License. You can help here! You may change these pages and make new pages. Read the help pages and other good pages to learn how to write pages here. If you need help, you may ask questions at Simple talk. Use Basic English vocabulary and shorter sentences. This allows people to understand normally complex terms or phrases.");
        String fileName = readFileAsString(args[0]);
        Object indexes = new Index(text);
        // Create the factory object
        WordsFactory wordsFactory = new WordsFactory(text);
        Scanner userInput = new Scanner(System.in);
        ((Index) indexes).printOut();
        System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): \n");

        if (userInput.hasNextLine()) {
            String typeOfIndex = userInput.nextLine();
            indexes = wordsFactory.makeNewIndex(typeOfIndex);
           //    doStuffIndex(indexes);
            if (indexes != null) {
            } else System.out.print("Program terminated");
        }
    }
      public static String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }
}







