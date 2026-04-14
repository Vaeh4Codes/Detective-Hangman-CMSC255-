package DetectiveHangman;

import java.util.ArrayList;
import java.util.Random;

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
    // Stores riddles and answers
//    private ArrayList<String> riddles = new ArrayList<>();
//    private ArrayList<String> answers = new ArrayList<>();

    /**
     * Default constructor
     */
    public Riddle() {
        this.missingWord = "";
        this.fullRiddle = "";
        this.answer = "";

        // Temporary sample data so program runs
//        riddles.add("The killer left behind a ____.");
//        answers.add("knife");
//
//        selectRandomRiddle();
//        generateMaskedRiddle();
    }

    /**
     * Parametrized constructor
     */
    public Riddle(String fullRiddle, String missingWord, String answer) {
        this.missingWord = missingWord;
        this.fullRiddle = fullRiddle;
        this.answer = answer;
    }

    /**
     * Loads riddles from file (NOT IMPLEMENTED YET)
     *
     * @param filename file name
     * @param category category
     */
    public void loadRiddles(String filename, String category) {
        // TODO: Implement file reading using Scanner
    }

    //todo select random riddle object in game file
//    /**
//     * Selects a random riddle from ArrayList of riddle oojects
//     */
//    public void selectRandomRiddle() {
//        Random rand = new Random();
//        int index = rand.nextInt(riddles.size());
//
//        fullRiddle = riddles.get(index);
//        missingWord = answers.get(index);
//    }


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
    public String getAnswer() {
        return missingWord;
    }
}