package DetectiveHangman;

/**
 * Main driver class for the Detective Hangman game.
 *
 * This class controls the flow of the game including:
 * - Starting the game
 * - Managing rounds
 * - Handling user guesses
 * - Determining win/loss conditions
 *
 * The player must solve riddles across multiple rounds
 * while avoiding too many incorrect guesses.
 *
 * @author Kyla Cooper
 * @version 1.0
 */
public class Game {

    /**
     * Main method that starts the program.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        Game game = new Game();
        game.startGame();
    }

    // Instance Variables
    private Character player;     // Represents the player (detective)
    private HangmanBody body;     // Tracks incorrect guesses (hangman drawing)
    private RiddleManager;        // Handles the word/riddle logic

    private int round;            // Current round number
    private final int TOTAL_ROUNDS = 5; // Total number of rounds in the game

    /**
     * Constructor initializes game objects and starting values.
     */
    public Game() {
        player = new Character("Detective");
        body = new HangmanBody();
        riddle = new Riddle();
        round = 1;
    }

    /**
     * Starts the game and prints introduction text.
     */
    public void startGame() {

        System.out.println("=== DETECTIVE HANGMAN ===");
        System.out.println("Solve the mystery before running out of guesses!\n");

        playGame();
    }

    /**
     * Main game loop that runs through all rounds.
     * Each round represents a part of the mystery.
     */
    public void playGame() {

        // Loop through all rounds
        while (round <= TOTAL_ROUNDS) {

            System.out.println("\n--- ROUND " + round + " ---");

            // Display what this round represents
            displayRoundType();

            // Reset hangman for new round
            body.reset();

            // Create a new riddle for this round
            riddle = new Riddle();
            riddle.askRiddle();

            // Loop until player solves riddle or loses
            while (!riddle.isSolved() && !body.isComplete()) {

                // Get player's guess
                char guess = player.makeGuess();

                // Check if guess is correct
                boolean correct = riddle.checkLetter(guess);

                // If incorrect, add hangman part
                if (!correct) {
                    body.addPart();
                }

                // Display progress and hangman
                riddle.displayProgress();
                body.displayBody();
            }

            // Check round result
            if (riddle.isSolved()) {
                System.out.println("You solved this part of the case!");
            } else {
                System.out.println("You failed this round.");
                System.out.println("Correct answer: " + riddle.getAnswer());
            }

            // Move to next round
            round++;
        }

        // End the game after all rounds
        endGame();
    }

    /**
     * Displays what each round represents in the mystery.
     */
    public void displayRoundType() {
        switch (round) {
            case 1:
                System.out.println("Find the Murderer!");
                break;
            case 2:
                System.out.println("Find the Victim!");
                break;
            case 3:
                System.out.println("Find the Motive!");
                break;
            case 4:
                System.out.println("Find the Location!");
                break;
            case 5:
                System.out.println("Find the Weapon!");
                break;
        }
    }

    /**
     * Ends the game and displays final results.
     */
    public void endGame() {
        System.out.println("\n=== CASE CLOSED ===");

        // TODO: Track correct answers and determine final success
        System.out.println("Review your findings...");
    }
}