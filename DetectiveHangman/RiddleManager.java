package DetectiveHangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 *
 * @author Nevaeh Dickerson
 * @version
 */
public class RiddleManager {
    //data fields
    private File locationRiddles;
    private File motiveRiddles;
    private File murdererRiddles;
    private File victimRiddles;
    private File weaponRiddles;

    private RiddleComponent componentCategory;
//    private ArrayList<Riddle> riddleOptions;

    // constructor
    public RiddleManager(File locationRiddles, File motiveRiddles, File murdererRiddles, File victimRiddles, File weaponRiddles, RiddleComponent componentCategory) {
        this.locationRiddles = locationRiddles;
        this.motiveRiddles = motiveRiddles;
        this.murdererRiddles = murdererRiddles;
        this.victimRiddles = victimRiddles;
        this.weaponRiddles = weaponRiddles;
        this.componentCategory = componentCategory;
//       /  this.riddleOptions = new ArrayList<>();
    }


    /**
     * This method loads all the riddles txt files,
     * and parses it based on a chosen component type,
     * then saves the three parsed lines as objects in the ArrayList
     *
     * @param inputFile, Scanner
     * @return lines, ArrayList<String>
     *
     */
    public ArrayList<String> getRiddleOptions(Scanner inputFile) {

        //TODO these Scanner objects should be created in the main and used as arguments in this method
        //handles the locationRiddles file
//        Scanner locationFile = openFile("locationRiddles", locationRiddles);
//        Scanner motiveFile = openFile("motiveRiddles", motiveRiddles);
//        Scanner murdererFile = openFile("murdererRiddles", murdererRiddles);
//        Scanner victimFile = openFile("victimRiddles", victimRiddles);
//        Scanner weaponFile = openFile("weaponRiddles", weaponRiddles);

        int statingLine = 1;
        int count = 1;
        int component = (int)(Math.random() * 5) + 1; //generates a random num from 1-5 inclusive

        if (component == 2){
            statingLine = 5;
        } else if(component == 3){
            statingLine = 9;
        }else if(component == 4){
            statingLine = 13;
        }else if(component == 5){
            statingLine = 17;
        }

        //Moves Scanner curso to the appropriate start of the file
        //depending on what component option is randomly chose
        ArrayList<String> lines = new ArrayList<>();
        while(inputFile.hasNextLine()){
            count++;
            // TODO: split component category by chosen element
            if (count == (statingLine -1)){
               break;
            }
        }

        //adds the three lines for a randomized component selection
        //into the arrayList lines
        for(int i = 0; i < 3; i++){
            lines.add(inputFile.nextLine());
        }

        return lines;
    }

    /**
     * This is a helper method to the parseTxtFile().
     * It opens the passed in file within a try-catch block
     * and outputs a message that conveys if the file was able to be
     * opened or not.
     *
     * @param fileName, string
     * @param input, the specific component riddles txt file
     * @return inputFile, scanner object for the passed in file
     */
    public Scanner openFile(String fileName, File input) {

        Scanner inputFile = null;
        try {
            inputFile = new Scanner(input);
            System.out.print(fileName + " file opened successfully");

        } catch (FileNotFoundException e) {
            Scanner newFile = new Scanner(System.in);
            System.out.println(fileName + " Not Found. Please enter a valid " + fileName + " file.");

            input = new File(newFile.nextLine());
        }

        return inputFile;
    }
}
