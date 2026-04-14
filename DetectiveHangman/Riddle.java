package DetectiveHangman;

import java.util.ArrayList;
import java.util.Random;

//Todo:
//1) cleanup javadocs

/**
 * Parent class for all riddle components.
 * Handles:
 * - Loading riddles
 * - Selecting a random riddle
 * - Masking the answer
 * - Checking guesses
 *
 * @author Nevaeh Dickerson
 * @version 1.0
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
     */
    public void generateMaskedRiddle() {
        String blanks = "_".repeat(missingWord.length());

        maskedRiddle = fullRiddle.replace(missingWord, blanks);
    }

    /**
     * Displays masked riddle
     */
    public void displayProgress() {
        System.out.println(maskedRiddle);
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
     * Checks if riddle is fully solved
     *
     * @return true if solved
     */
    public boolean isSolved() {
        return !maskedRiddle.contains("_");
    }

    /**
     * Displays the full riddle
     */
    public void askRiddle() {
        System.out.println(fullRiddle);
    }

    /**
     * Returns the answer
     *
     * @return missing word
     */
    public String getMissingWord() {
        return missingWord;
    }
}