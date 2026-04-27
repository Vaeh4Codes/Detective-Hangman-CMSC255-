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
    private ArrayList<String> allRiddles;

    // constructor
//    public RiddleManager(RiddleComponent componentCategory){
//        this.componentCategory = componentCategory;
//    }

    public RiddleManager(File locationRiddles, File motiveRiddles, File murdererRiddles, File victimRiddles, File weaponRiddles) {
        this.locationRiddles = locationRiddles;
        this.motiveRiddles = motiveRiddles;
        this.murdererRiddles = murdererRiddles;
        this.victimRiddles = victimRiddles;
        this.weaponRiddles = weaponRiddles;
    }


    /**
     * This method chooses and stores riddles for each round.
     *
     * @return chosenRiddles, ArrayList<String>
     *
     */
//    public  ArrayList<String> getRiddles(){
//
//    }


    /**
     * This method loads all the riddles from an input txt file,
     * then gets a random line and adds it to the allRiddles arraylist
     *
     * @param componentFile, Scanner
     * @return
     *
     */
    public String getRandomRiddleForComponent(File componentFile) {

        int lineIndex = (int)(Math.random() * 5) + 1; //generates a random num from 1-5 inclusive which decides which element to randomize
        int startingLine = (lineIndex - 1) * 4 + 1;

        //Uses the helper function to safely open the passed in file
        Scanner componentInput = openFile(componentFile);
        ArrayList<String> chosenLines = new ArrayList<>();

        //Moves Scanner cursor to the appropriate start of the file
        //depending on what component option is randomly chose
        int lineCount = 0;

        while(componentInput.hasNextLine()){
            lineCount++;
            String currentLine = componentInput.nextLine();

            // adds the three lines for a randomized element selection
            if (lineCount == startingLine){
                chosenLines.add(currentLine);

                for (int i = 0; i < 2 && componentInput.hasNextLine(); i++){
                    chosenLines.add(componentInput.nextLine());
                }
                break; //stops saving lines after the third
            }
        }

        int randomRiddleIndex = (int)(Math.random() * 3) + 1;
        return chosenLines.get(randomRiddleIndex);
    }

    /**
     * This is a helper method to the randomRiddleForComponent() file.
     * It opens the passed in file within a try-catch block
     * and outputs the scanner object if it was able to be opened. If not the method prompts the user to input the
     * correct file.
     *
     * @param input, the specific component riddles txt file
     * @return inputFile, scanner object for the passed in file
     */
    public Scanner openFile(File input) {
        Scanner userInput = new Scanner(System.in);

        while (true){
            try {
                return new Scanner(input); // this is what also stops the while loop
            } catch (FileNotFoundException e) {
                System.out.println(input.getName() + " Not Found. Please enter a valid " + input.getName() + " file.");
                input = new File(userInput.nextLine());
            }
        }
    }
}
