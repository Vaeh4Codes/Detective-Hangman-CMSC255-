package DetectiveHangman;

import java.util.Random;

/**
 * This class creates the final mystery case, which will be printed as a string
 * @author Kiah Martin
 * @Version 1.0
 */


public class Scene {
    private RiddleComponent weapon;
    private RiddleComponent location;
    private RiddleComponent motive;
    private RiddleComponent Murderer;
    private RiddleComponent victim;
    // made this static so it can be referenced from Detective class, lmk if it causes any issues -Max
    private static String finalScene;

    /**
     * constructor for a scene object
     */
    public Scene() {
        //TODO construct a scene object using riddle components
        // create a string in a specific format to easily compare against user guess
        // add in riddle parts in the String.format (check riddle and riddleManager class for necessary logic)
        finalScene = String.format("The victim %s was killed by %s with %s in the %s because of %s",
                victim, Murderer, weapon, location, motive
        );
    }

    public static boolean checkScene(String userGuess){
        // TODO:
        //  check if userGuess string is equal to scene string (Keep in this format!!)
        if (getFinalScene().equals(userGuess)) {
            return true;
        }
        return false;
    }

    public static String getFinalScene() {
        return finalScene;
    }

    public String toString(){
        return "";
    }
}