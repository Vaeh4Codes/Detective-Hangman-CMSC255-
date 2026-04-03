package DetectiveHangman;

import java.util.ArrayList;

/**
 * Parent class for all riddle components
 * Handles shared structure for:
 * - Answer generation
 * - Full riddle
 * - Masked riddle
 * - Loading and choosing riddles from riddles.txt file
 *
 * @author
 * @version
 */
public class RiddleComponent {

    protected String missingWord;
    protected String fullRiddle;
    protected String maskedRiddle;

    // Stores riddles loaded from file
    protected ArrayList<String> riddles = new ArrayList<>();

    /**
     * Generates the component value (weapon, location, etc.)
     */
    public void generateComponent() {
        // TODO: override in subclasses
    }

    /**
     * Generates the full riddle using the selected answer.
     */
    public void generateFullRiddle() {
        // TODO: override in subclasses
    }

    /**
     * Generates the masked riddle with missing word.
     */
    public void generateMaskedRiddle() {
        // TODO: override in subclasses
    }

    /**
     * Loads riddles from a file.
     *
     * @param filename path to riddle file
     */
    public void loadRiddles(String filename) {
        // TODO:
        // 1. Use Scanner to read file
        // 2. Add each line to riddles ArrayList
    }

    public String getAnswer() {
        return missingWord;
    }

    public String getFullRiddle() {
        return fullRiddle;
    }

    public String getMaskedRiddle() {
        return maskedRiddle;
    }
}