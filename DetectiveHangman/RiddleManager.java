package DetectiveHangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// note from max: more information about class in doc, check it out
// if confused, lowk i'm just barely putting these classes together rn
/**
 * This class loads the riddles.txt file,
 * and parses it based on a chosen component type,
 * then saves the three parsed lines as objects in the ArrayList
 *
 * @author Nevaeh Dickerson
 * @version
 */
public class RiddleManager {
    //data fields
    private File input;
    private RiddleComponent componentCategory;
    private ArrayList<Riddle> riddleOptions;

    // constructor
    public RiddleManager(File input, RiddleComponent componentCategory) {
        this.input = input;
        this.componentCategory = componentCategory;
        this.riddleOptions = new ArrayList<>();
    }

    public void parseTxtFile() {
        //TODO take in text file in parameter
        try{
            Scanner inputFile = new Scanner(input);
        } catch (FileNotFoundException e) {
            Scanner newFile = new Scanner(System.in);
            System.out.println("File Not Found. Please enter a valid file.");

            input = new File(newFile.nextLine());
        }

        // TODO: split data into component categories


        // TODO: split component category by chosen element
        // TODO: loop through the chosen element and create an object for each line
        // TODO: add the objects into the arraylist (there should be three objects in arraylist)
    }
}
