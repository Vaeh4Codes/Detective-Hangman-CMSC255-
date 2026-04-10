package DetectiveHangman;

import java.util.ArrayList;

/**
 * Represents the user(or "detective") in the Detective Hangman game.
 * This class handles letter guessing, word guessing, tracking guessed letters,
 * and solving the final mystery.
 *
 * @author Max Mashack
 * @version
 */
public class Detective {

    // Stores the most recent guess
    private char guess;

    // stores all player guesses
    private ArrayList<Character> playerGuesses;

    // Stores player's answers for each category
    private String guessedMurderer;
    private String guessedVictim;
    private String guessedLocation;
    private String guessedMotive;
    private String guessedWeapon;


    /**
     * Processes a single letter guess from the player.
     *
     * @param guess the character guessed by the player
     * @return true if the guess is correct, false otherwise
     */
    public boolean guessLetter(char guess) {
        // TODO:
        // 1. Store the guessed letter in the 'guess' variable
        setGuess(guess);
        // 2. Add the letter to the list of guessed letters (if not already guessed)
        addGuess(guess);
        // 3. Check if the letter exists in the current word/puzzle
        // ^ little confused on how exactly to do this -max
        // 4. Return true if correct guess, false otherwise

        return false;
    }

    /**
     * addGuess
     *
     * method adds player guess to ArrayList of previous player guesses
     * @param guess is the player guess being added
     */
    private void addGuess(char guess) {
        // add player guess to arraylist of past guesses
        playerGuesses.add(guess);
    }

    /**
     * Allows the player to guess the full word.
     *
     * @return true if the guessed word is correct, false otherwise
     */
    public boolean guessWord(String word) {
        // TODO:
        // 1. Accept or define a full word guess (may need parameter later)
        // 2. Compare guessed word with the actual answer
        /**
        if (word.equals(answer)){
            return true;
        }
         */
        // 3. Return true if correct, false otherwise

        return false;
    }

    /**
     * Returns a list of all letters guessed by the player.
     *
     * @return an ArrayList containing guessed characters
     */
    public ArrayList<Character> displayLetters() {
        return playerGuesses;
    }

    /**
     * Stores the player's answer for a specific round/category.
     *
     * @param murderer the guessed murderer (can be null/empty string if not this round)
     * @param victim the guessed victim (can be null/empty string if not this round)
     * @param location the guessed location (can be null/empty string if not this round)
     * @param motive the guessed motive (can be null/empty string if not this round)
     * @param weapon the guessed weapon (can be null/empty string if not this round)
     */
    public void saveRoundAnswer(String murderer, String victim,
                                String location, String motive, String weapon) {

        // TODO:
        // Only update the data field for the round

        // check what round user is on
            // then update accordingly
    }

    /**
     * Returns all saved answers from previous rounds.
     *
     * @return a formatted string containing all stored guesses
     */
    public String getSavedAnswers() {
        // TODO: format nicely if needed
        return "Murderer: " + guessedMurderer +
                "\nVictim: " + guessedVictim +
                "\nLocation: " + guessedLocation +
                "\nMotive: " + guessedMotive +
                "\nWeapon: " + guessedWeapon;
    }

    /**
     * Evaluates the player's final guesses for the mystery.
     *
     * @param murderer the guessed murderer
     * @param victim the guessed victim
     * @param location the guessed location
     * @param motive the guessed motive
     * @param weapon the guessed weapon
     * @return a String of user's guess, to be tested against actual scene/correct answer
     */
    public String solveMystery(String murderer, String victim, String location, String motive, String weapon) {
        // changed parameters to be string, so that in main logic we can ask for user input in order
        // then create a string from their answers using this method
        // i have the logic for this method and for main to make this work, lmk if yall need it i got it typed up

        // build string with users answers in SAME format as FINAL SCENE
        String userGuess = "The victim " + victim + " was killed by " + murderer + " with " + weapon +
                " in the " + location + " because of " + motive;
        // compare string against FINAL SCENE from scene class
        // actually probably do this in the scene class, because it has the checkScene method
        // can call this method with the string of user answer returned from this method
        // have that method return whether answer is right or wrong, if wrong display actual scene

        return userGuess;
    }

    /**
     * getGuess
     * getter method for instance variable guess
     * @return guess instance variable
     */
    public char getGuess() {
        return guess;
    }

    /**
     * setGuess
     * setter method for instance variable guess
     * @param guess is the character being set
     */
    private void setGuess(char guess) {
        this.guess = guess;
    }
}