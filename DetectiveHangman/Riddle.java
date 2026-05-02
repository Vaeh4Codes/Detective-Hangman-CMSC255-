package DetectiveHangman;

//Todo:
//1) cleanup javadocs

/**
 * Class responsible for:
 * - Parsing a full riddle component
 * - gets the full riddle text
 * - Masking the answer from the riddle text
 * - Display the masked riddle
 * - stores what the masked word is
 *
 * @author Nevaeh Dickerson
 * @version 4/27/26
 */
public class Riddle {

    private String fullRiddle;
    private String missingWord;
    private String answer;

    private String maskedRiddle;
    private String currentBlanks; // tracks progress

    /**
     * Default constructor
     */
    public Riddle() {
        this.fullRiddle = "";
        this.missingWord = "";
        this.answer = "";
        this.currentBlanks = "";
        this.maskedRiddle = "";
    }

    /**
     * Parameterized constructor
     */
    public Riddle(String fullRiddle, String missingWord, String answer) {
        this.fullRiddle = fullRiddle;
        this.missingWord = missingWord == null ? "" : missingWord.trim();
        this.answer = answer;

        // initialize blanks
        this.currentBlanks = "_".repeat(this.missingWord.length());

        // create initial masked riddle
        generateMaskedRiddle();
    }

    /**
     * Builds the masked riddle using current blanks
     */
    private void generateMaskedRiddle() {
        if (fullRiddle == null || missingWord.isEmpty()) {
            maskedRiddle = fullRiddle;
            return;
        }
        maskedRiddle = fullRiddle.replace(missingWord, currentBlanks);
    }

    /**
     * Returns masked riddle (with updated blanks)
     */
    public String getMaskedRiddle() {
        return maskedRiddle;
    }

    /**
     * Returns the blanks (what user sees)
     */
    public String displayBlanks() {
        return currentBlanks;
    }

    /**
     * Updates blanks when a correct letter is guessed
     */
    public String updateBlanks(char guess, String ignored) {

        char g = Character.toLowerCase(guess);
        String word = missingWord.toLowerCase();

        StringBuilder updated = new StringBuilder(currentBlanks);

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == g) {
                updated.setCharAt(i, missingWord.charAt(i)); // preserve original case
            }
        }

        currentBlanks = updated.toString();

        // update masked riddle display
        maskedRiddle = fullRiddle.replace(missingWord, currentBlanks);

        return currentBlanks;
    }

    /**
     * Returns missing word
     */
    public String getMissingWord() {
        return missingWord;
    }

    /**
     * Returns full riddle
     */
    public String getFullRiddle() {
        return fullRiddle;
    }

    /**
     * Checks if solved
     */
    public boolean isSolved() {
        return currentBlanks.equalsIgnoreCase(missingWord.trim());
    }
}