package DetectiveHangman;

/**
 * Responsibilities:
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
     * Riddle()
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
     * Riddle()
     * Parameterized constructor
     */
    public Riddle(String fullRiddle, String missingWord, String answer) {
        this.fullRiddle = fullRiddle;
        this.missingWord = missingWord == null ? "" : missingWord.trim();
        this.answer = answer;
        this.currentBlanks = "_".repeat(this.missingWord.length());      // initialize blanks

        generateMaskedRiddle();      // create initial masked riddle
    }

    /**
     * generateMaskedRiddle()
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
     * getMaskedRiddle()
     * Returns masked riddle (with updated blanks)
     *
     * @return maskedRiddle, String
     */
    public String getMaskedRiddle() {
        return maskedRiddle;
    }

    /**
     * displayBlanks()
     * Returns the blanks for the word that the user is trying to guess
     *
     * @return currentBlanks
     */
    public String displayBlanks() {
        return currentBlanks;
    }

    /**
     * updateBlanks()
     * Updates blanks when a correct letter is guessed
     *
     * @param guess, char
     * @param ignored, String
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
     * getMissingWord()
     * Returns the missing word the user is trying to guess
     *
     * @return missingWord, String
     */
    public String getMissingWord() {
        return missingWord;
    }

    /**
     * getFullRiddle()
     * Returns full riddle
     *
     * @return fullRiddle, String
     */
    public String getFullRiddle() {
        return fullRiddle;
    }

    /**
     * isSolved()
     * Checks if the user solved the missing word
     *
     * @return true or false, boolean
     */
    public boolean isSolved() {
        return currentBlanks.equalsIgnoreCase(missingWord.trim());
    }
}