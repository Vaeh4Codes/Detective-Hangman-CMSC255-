package DetectiveHangman;

import java.util.Scanner;

/**
 * Main driver class for the Detective Hangman game.
 *
 * Controls:
 * - Game start and replay
 * - 5 rounds of hangman gameplay
 * - Player guessing logic
 * - Final mystery solving
 *
 * @author Kyla Cooper
 * @version 1.0
 */
public class Game {

    // Game objects
    private Detective player;
    private HangMan hangman;
    private Riddle riddle;
    private RiddleManager manager;

    // Game tracking
    private int round;
    private final int MAX_ROUNDS = 5;

    // Store correct answers
    private String[] answers;

    private Scanner input;

    /**
     * Constructor initializes game components.
     */
    public Game() {
        player = new Detective();
        hangman = new HangMan();
        manager = new RiddleManager();
        input = new Scanner(System.in);

        round = 1;
        answers = new String[MAX_ROUNDS];
    }

    /**
     * Main method
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }

    /**
     * Starts the game and asks user to play.
     */
    public void startGame() {

        printWelcome();

        System.out.print("Start game? (yes/no): ");
        String response = input.nextLine();

        while (response.equalsIgnoreCase("yes")) {

            playGame();

            System.out.print("\nPlay again? (yes/no): ");
            response = input.nextLine();

            // Reset for replay
            round = 1;
        }

        System.out.println("Goodbye!");
    }

    /**
     * Runs all rounds of the game.
     */
    public void playGame() {

        while (round <= MAX_ROUNDS) {

            System.out.println("\n--- ROUND " + round + " ---");
            displayRoundType();

            hangman.reset();

            // Get riddle from manager (safe fallback if method differs)
            riddle = new Riddle();

            // If your manager has a method, replace this:
            // riddle = manager.getRiddle(round);

            riddle.askRiddle();

            // Guess loop
            while (!riddle.isSolved() && !hangman.isComplete()) {

                hangman.displayStand();
                riddle.displayProgress();

                System.out.print("Guess a letter: ");
                String line = input.nextLine();

                if (line.isEmpty()) continue;

                char guess = line.charAt(0);

                boolean correct = player.guessLetter(guess, riddle);

                if (!correct) {
                    System.out.println("Incorrect!");
                    hangman.addPart();
                } else {
                    System.out.println("Correct!");
                }

                hangman.displayBody();
            }

            // Round result
            if (riddle.isSolved()) {
                System.out.println("You solved it!");
            } else {
                System.out.println("Out of tries!");
            }

            System.out.println("Answer: " + riddle.getAnswer());

            // Save answer
            answers[round - 1] = riddle.getAnswer();

            round++;
        }

        // Final phase
        solveMystery();
    }

    /**
     * Displays round objective.
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
     * Final guessing phase of the game.
     */
    public void solveMystery() {

        System.out.println("\n=== FINAL MYSTERY ===");

        System.out.print("Murderer: ");
        String murderer = input.nextLine();

        System.out.print("Victim: ");
        String victim = input.nextLine();

        System.out.print("Motive: ");
        String motive = input.nextLine();

        System.out.print("Location: ");
        String location = input.nextLine();

        System.out.print("Weapon: ");
        String weapon = input.nextLine();

        System.out.println("\n=== RESULTS ===");

        check("Murderer", murderer, answers[0]);
        check("Victim", victim, answers[1]);
        check("Motive", motive, answers[2]);
        check("Location", location, answers[3]);
        check("Weapon", weapon, answers[4]);
    }

    /**
     * Compares answers.
     */
    private void check(String category, String guess, String correct) {
        if (guess.equalsIgnoreCase(correct)) {
            System.out.println(category + ": Correct");
        } else {
            System.out.println(category + ": Incorrect (Correct: " + correct + ")");
        }
    }

    /**
     * Prints welcome banner.
     */
    private void printWelcome() {
        System.out.println("=================================");
        System.out.println("     DETECTIVE HANGMAN GAME      ");
        System.out.println("=================================");
    }
}