package DetectiveHangman;

import java.io.File;
import java.util.ArrayList;

// note from max: more information about class in doc, check it out
// if confused, lowk i'm just barely putting these classes together rn

public class RiddleManager {
    // data fields
    private File input;
    private RiddleComponent componentCategory;
    private ArrayList<Riddle> riddleOptions;

    // constructor
    public RiddleManager(File input, RiddleComponent componentCategory) {
        //TODO: set default values for each parameter
    }

    public void parseTxtFile() {
        //TODO take in text file in parameter
        // TODO: split data into component categories
        // TODO: split component category by chosen element
        // TODO: loop through the chosen element and create an object for each line
        // TODO: add the objects into the arraylist (there should be three objects in arraylist)
    }
}
