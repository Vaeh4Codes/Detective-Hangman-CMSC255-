package DetectiveHangman;

import java.util.ArrayList;

/**
 * Represents the user (detective) in the Detective Hangman game.
 * Handles guessing letters, tracking guesses, and solving the mystery.
 *
 * @author Max Mashack
 * @version 1.0
 */
public class Detective {

    // Stores the most recent guess
    private char guess;

    // Stores all guessed letters
    private ArrayList<Character> playerGuesses;

    //Stores correct letter guesses
    private ArrayList<Character> correctGueses;

    // Stores player's answers for each category
    private String guessedMurderer;
    private String guessedVictim;
    private String guessedLocation;
    private String guessedMotive;
    private String guessedWeapon;

    /**
     * Constructor initializes guess list.
     */
    public Detective() {
        playerGuesses = new ArrayList<>();
    }

    /**
     * guessLetter
     * This method processes a single letter guess from the player.
     *
     * @param guess the character guessed by the player
     * @param riddle the current riddle being solved
     * @return true if the guess is correct, false otherwise
     */
    public boolean guessLetter(char guess, Riddle riddle) {

        // Store guess
        this.guess = guess;

        // Add to list if not already guessed
        if (!playerGuesses.contains(guess)) {
            playerGuesses.add(guess);
        }

        // Check if guess exists in riddle
        boolean userGuess = riddle.checkLetter(guess);
        if (userGuess) {
            // add to correctLetters arraylist
            correctGueses.add(guess);
        }
        return userGuess;
    }

    /**
     * guessWord
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
     * displayLetters
     * This method returns all guessed letters.
     *
     * @return ArrayList of guessed characters
     */
    public ArrayList<Character> displayLetters() {

        return playerGuesses;
    }

    /**
     * saveRoundAnswer
     * This method stores the player's answer for a specific round/category.
     */
    public void saveRoundAnswer(String murderer, String victim,
                                String location, String motive, String weapon) {

        if (murderer != null) {
            guessedMurderer = murderer;
        }
        if (victim != null) {
            guessedVictim = victim;
        }
        if (location != null) {
            guessedLocation = location;
        }
        if (motive != null) {
            guessedMotive = motive;
        }
        if (weapon != null) {
            guessedWeapon = weapon;
        }
    }

    /**
     * getSavedAnswers
     * This method returns all user's saved answers
     * @return all saved answers.
     */
    public String getSavedAnswers() {
        return "Murderer: " + guessedMurderer +
                "\nVictim: " + guessedVictim +
                "\nLocation: " + guessedLocation +
                "\nMotive: " + guessedMotive +
                "\nWeapon: " + guessedWeapon;
    }

    /**
     * solveMystery
     * This method evaluates the player's final guesses.
     *
     * @return a string, it's contents changing depending on whether the user's guess is correct or incorrect
     */
    public String solveMystery(String murderer, String victim,
                               String location, String motive, String weapon) {
        String result;
        // create string of user final guess using user's answers
        // format it like Scene class is formatted (so it compares easily)
        String userFinalGuess = String.format("The victim %s was killed by %s with %s in the %s because of %s",
                victim, murderer, weapon, location, motive);

        // use string created and compare against Scene class string of actual scene
        boolean finalResult = Scene.checkScene(userFinalGuess);
        if (finalResult) {
            result = "Answer correct! Congrats on solving the mystery";
        } else {
            result = "Answer incorrect! Better luck next time?\n";
            // add the correct final scene to result string
            result += ("Correct Answer: " + Scene.getFinalScene());
        }

        /*
        result += (murderer == guessedMurderer ? "Murderer correct\n" : "Murderer incorrect\n");
        result += (victim == guessedVictim ? "Victim correct\n" : "Victim incorrect\n");
        result += (location == guessedLocation ? "Location correct\n" : "Location incorrect\n");
        result += (motive == guessedMotive ? "Motive correct\n" : "Motive incorrect\n");
        result += (weapon == guessedWeapon ? "Weapon correct\n" : "Weapon incorrect\n");
         */

        return result;
    }

    /**
     * getCorrectLetters
     * This is a getter method for the correctGueses instance variable
     * @return correctGueses instance variable
     */
    public ArrayList<Character> getCorrectLetters() {
        return correctGueses;
    }
}