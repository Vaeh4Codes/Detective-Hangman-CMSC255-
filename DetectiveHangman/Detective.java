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
    private Characters guessedMurderer;
    private Characters guessedVictim;
    private Location guessedLocation;
    private Motive guessedMotive;
    private Weapons guessedWeapon;


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
     * @param murderer the guessed murderer (can be null if not this round)
     * @param victim the guessed victim (can be null if not this round)
     * @param location the guessed location (can be null if not this round)
     * @param motive the guessed motive (can be null if not this round)
     * @param weapon the guessed weapon (can be null if not this round)
     */
    public void saveRoundAnswer(Characters murderer, Characters victim,
                                Location location, Motive motive, Weapons weapon) {

        // TODO:
        // Only update the data field for the round
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
     * @return a String indicating whether the mystery was solved correctly
     */
    public String solveMystery(Characters murderer, Characters victim, Location location, Motive motive, Weapons weapon) {
        // TODO:
        // 1. Compare user’s final guesses with actual mystery values
        // 2. Determine if each category is correct
        // 3. Build and return a result string (e.g., "Correct!" or "Incorrect")
        // 4. Optionally display which parts were correct/incorrect

        return "";
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