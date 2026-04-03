package DetectiveHangman;

import java.util.ArrayList;


/**
 * Parent class for all riddle components.
 * Handles:
 * - Loading riddles from a file
 * - Storing selected riddle and missing word
 * - Providing full and masked riddle formats
 *
 * @author
 * @version
 */
public class RiddleComponent {

    protected String missingWord;
    protected String fullRiddle;
    protected String maskedRiddle;

    // Stores riddles and answers loaded from file
    protected ArrayList<String> riddles = new ArrayList<>();
    protected ArrayList<String> answer = new ArrayList<>();

    /**
     * Loads riddles from a file for a specific category.
     *
     * @param filename the file containing riddles
     * @param category the category to filter (e.g., "Weapon")
     */
    public void loadRiddles(String filename, String category) {
        // TODO:
        // 1. Open file using Scanner
        // 2. Locate correct category section (ex) "-Weapon")
        // 3. Read riddle line
        // 4. Read missing word line
        // 5. Store both in ArrayLists
        // 6. Stop when next category is reached
    }

    /**
     * Selects a random riddle from the loaded list.
     */
    public void selectRandomRiddle() {
        // TODO:
        // 1. Generate random index
        // 2. Set fullRiddle from riddles list
        // 3. Set missingWord from answers list
    }

    /**
     * Generates the masked version of the riddle.
     */
    public void generateMaskedRiddle() {
        // TODO:
        // 1. Replace missingWord in fullRiddle with blanks (e.g., "______")
        // 2. Store result in maskedRiddle
    }

    /**
     * Returns the missing word (answer).
     *
     * @return missing word
     */
    public String getAnswer() {
        return missingWord;
    }

    /**
     * Returns the full riddle with answer included.
     *
     * @return full riddle
     */
    public String getFullRiddle() {
        return fullRiddle;
    }

    /**
     * Returns the masked riddle with missing word removed.
     *
     * @return masked riddle
     */
    public String getMaskedRiddle() {
        return maskedRiddle;
    }
}