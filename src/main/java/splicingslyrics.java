import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class splicingslyrics {

    public static String[] splicingslyrics() throws FileNotFoundException {
        String song = "";

        File myObj = new File("src/main/java/pasteintothis.txt");
        Scanner myReader = new Scanner(myObj);


        while (myReader.hasNextLine()) {
            song += myReader.nextLine() + "\n";
        }

        String[] lyrics = song.split("\n\n");
        return lyrics;
    }

}
