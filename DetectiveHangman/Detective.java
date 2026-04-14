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

    // Stores player's answers for each category
    private Characters guessedMurderer;
    private Characters guessedVictim;
    private Location guessedLocation;
    private Motive guessedMotive;
    private Weapons guessedWeapon;

    /**
     * Constructor initializes guess list.
     */
    public Detective() {
        playerGuesses = new ArrayList<>();
    }

    /**
     * Processes a single letter guess from the player.
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
        return riddle.checkLetter(guess);
    }

    /**
     * Allows the player to guess the full word.
     *
     * @param word the guessed word
     * @param riddle the current riddle
     * @return true if correct, false otherwise
     */
    public boolean guessWord(String word, Riddle riddle) {
        return word.equalsIgnoreCase(riddle.getMissingWord());
    }

    /**
     * Returns all guessed letters.
     *
     * @return ArrayList of guessed characters
     */
    public ArrayList<Character> displayLetters() {
        return playerGuesses;
    }

    /**
     * Stores the player's answer for a specific round/category.
     */
    public void saveRoundAnswer(Characters murderer, Characters victim,
                                Location location, Motive motive, Weapons weapon) {

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
     * Returns all saved answers.
     */
    public String getSavedAnswers() {
        return "Murderer: " + guessedMurderer +
                "\nVictim: " + guessedVictim +
                "\nLocation: " + guessedLocation +
                "\nMotive: " + guessedMotive +
                "\nWeapon: " + guessedWeapon;
    }

    /**
     * Evaluates the player's final guesses.
     *
     * @return result string
     */
    public String solveMystery(Characters murderer, Characters victim,
                               Location location, Motive motive, Weapons weapon) {

        String result = "";

        result += (murderer == guessedMurderer ? "Murderer correct\n" : "Murderer incorrect\n");
        result += (victim == guessedVictim ? "Victim correct\n" : "Victim incorrect\n");
        result += (location == guessedLocation ? "Location correct\n" : "Location incorrect\n");
        result += (motive == guessedMotive ? "Motive correct\n" : "Motive incorrect\n");
        result += (weapon == guessedWeapon ? "Weapon correct\n" : "Weapon incorrect\n");

        return result;
    }
}