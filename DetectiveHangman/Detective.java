package DetectiveHangman;

import java.util.ArrayList;

/**
 * Detective.java
 * Represents the player (detective) in the Detective Hangman game.
 * Handles guessing letters, tracking guesses, and solving the mystery.
 *
 * @author Max Mashack
 * @version 4/27/26
 */
public class Detective {


    private ArrayList<Character> playerGuesses;            // Stores all guessed letters
    private ArrayList<Character> correctLettersGuessed;    //Stores correct letter guesses

    // Stores player's answers for each category
    private String guessedMurderer;
    private String guessedVictim;
    private String guessedLocation;
    private String guessedMotive;
    private String guessedWeapon;

    /**
     * Detective()
     * Constructor that initializes guess list.
     */
    public Detective() {
        playerGuesses = new ArrayList<>();
        this.correctLettersGuessed = new ArrayList<>();
    }

    /**
     * guessLetter()
     * This method processes a single letter guess from the player.
     *
     * @param guess the character guessed by the player
     * @return true if the guess is correct, false otherwise
     */
    public boolean guessLetter(char guess, String wordToGuess) {

        boolean valid = true;

        // Add to list if not already guessed
        if (playerGuesses.contains(guess)) {
            return false;
        }

        playerGuesses.add(guess);

        if (wordToGuess.contains(String.valueOf(guess))) { // Check if guess exists in riddle
            correctLettersGuessed.add(guess); // add to correctLetters arraylist
            return true;
        }

        return false;
    }

    /**
     * guessWord()
     * This method allows the player to guess the full word.
     *
     * @param word the guessed word
     * @param riddle the current riddle
     * @return true if correct, false otherwise
     */
    public boolean guessWord(String word, Riddle riddle) {
        return word.equalsIgnoreCase(riddle.getMissingWord());
    }

    /**
     * displayLettersGuessed()
     * This method returns all the previously guessed letters.
     *
     * @return ArrayList of guessed characters
     */
    public ArrayList<Character> displayLettersGuessed() {
        return playerGuesses;
    }


    /**
     * getSavedAnswers()
     * This method returns all user's saved answers
     * @return all saved answers in a string
     */
    public String getSavedAnswers() {
        return "Murderer: " + guessedMurderer +
                "\nVictim: " + guessedVictim +
                "\nLocation: " + guessedLocation +
                "\nMotive: " + guessedMotive +
                "\nWeapon: " + guessedWeapon;
    }

    /**
     * solveMystery()
     * This method evaluates the player's final guesses.
     *
     * @return a string, it's contents changing depending on whether the user's guess is correct or incorrect
     */
    public String solveMystery(String murderer, String victim,
                               String location, String motive, String weapon, Scene scene) {

        String userFinalGuess = String.format(
                "The victim %s was killed by %s with %s in the %s because of %s",
                victim, murderer, weapon, location, motive
        );

        boolean finalResult = scene.checkScene(userFinalGuess);

        if (finalResult) {
            return "Answer correct! Congrats on solving the mystery!";
        } else {
            return "Answer incorrect! Better luck next time?\n"
                    + "Correct Answer: " + scene.getFinalScene();
        }
    }

}