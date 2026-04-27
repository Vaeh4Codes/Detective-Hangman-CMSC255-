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


    /**
     * Default constructor
     *
     */
    public Riddle() {
        this.fullRiddle = "";
        this.missingWord = "";
        this.answer = "";
    }

    /**
     * Parametrized constructor
     *
     * @param fullRiddle, String
     * @param missingWord, String
     * @param answer, String
     */
    public Riddle(String fullRiddle, String missingWord, String answer) {
        this.fullRiddle = fullRiddle;
        this.missingWord = missingWord;
        this.answer = answer;
    }


    /**
     * Generates masked version of the riddle
     * and returns the string
     *
     * @return string
     */
    public String displayMaskedRiddle() {
        String blanks = "_".repeat(missingWord.length());

        return fullRiddle.replace(missingWord, blanks);
    }



    /**
     * Checks if guessed letter is correct
     *
     * @param guess letter guessed
     * @return true if correct
     */
    public boolean checkLetter(char guess) {

        boolean correct = false;

        StringBuilder updated = new StringBuilder(maskedRiddle);

        for (int i = 0; i < missingWord.length(); i++) {
            if (missingWord.charAt(i) == guess) {
                correct = true;

                // Replace underscore with correct letter
                int index = fullRiddle.indexOf(missingWord) + i;
                updated.setCharAt(index, guess);
            }
        }

        maskedRiddle = updated.toString();
        return correct;
    }


    /**
     * Displays the full riddle
     */
    public void askRiddle() {
        System.out.println(maskedRiddle);
    }

    /**
     * Returns the answer
     *
     * @return missing word
     */
    public String getMissingWord() {
        return missingWord;
    }


    /**
     * Checks if riddle is fully solved
     *
     * @return true if solved
     */
    public boolean isSolved() {
        return !maskedRiddle.contains("_");
    }
}