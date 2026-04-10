package DetectiveHangman;

import java.util.Scanner;

/**
 * Main driver class for the Detective Hangman game.
 *
 * Responsibilities:
 * - Start and control the game
 * - Run 5 rounds of riddles
 * - Handle user guesses
 * - Track answers
 * - Evaluate final mystery
 *
 * @author Kyla Cooper
 * @version 1.0
 */
public class Game {

    /** Player (detective) */
    private Detective player;

    /** Hangman body (future use) */
    private HangMan body;

    /** Current riddle */
    private Riddle riddle;

    /** Current round */
    private int round;

    /** Total number of rounds */
    private final int TOTAL_ROUNDS = 5;

    /** Stores answers from each round */
    private String[] answers;

    /** Scanner for input */
    private Scanner input;

    /**
     * Constructor initializes game variables.
     */
    public Game() {
        player = new Detective();
        body = new HangMan();
        input = new Scanner(System.in);

        round = 1;
        answers = new String[TOTAL_ROUNDS];
    }

    /**
     * Main method (entry point).
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }

    /**
     * Starts the game and handles replay.
     */
    public void startGame() {

        System.out.println("=== DETECTIVE HANGMAN ===");

        System.out.print("Start game? (yes/no): ");
        String response = input.nextLine();

        while (response.equalsIgnoreCase("yes")) {

            playGame();

            System.out.print("\nPlay again? (yes/no): ");
            response = input.nextLine();

            round = 1;
        }

        System.out.println("Thanks for playing!");
    }

    /**
     * Runs all rounds of the game.
     */
    public void playGame() {

        while (round <= TOTAL_ROUNDS) {

            System.out.println("\n--- ROUND " + round + " ---");
            displayRoundType();

            // Create new riddle
            riddle = new Riddle();
            riddle.askRiddle();

            // Loop until solved
            while (!riddle.isSolved()) {

                riddle.displayProgress();

                System.out.print("Guess a letter: ");
                String line = input.nextLine();

                if (line.isEmpty()) continue;

                char guess = line.charAt(0);

                boolean correct = player.guessLetter(guess, riddle);

                if (correct) {
                    System.out.println("Correct!");
                } else {
                    System.out.println("Incorrect!");

                    // TODO: Add hangman body logic here
                    // body.addPart();
                }
            }

            System.out.println("Solved!");
            System.out.println("Answer: " + riddle.getAnswer());

            answers[round - 1] = riddle.getAnswer();

            round++;
        }

        solveMystery();
    }

    /**
     * Displays what each round represents.
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
     * Final mystery guessing phase.
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
     * Compares user guess with correct answer.
     *
     * @param category category name
     * @param guess user guess
     * @param correct correct answer
     */
    private void check(String category, String guess, String correct) {

        if (guess.equalsIgnoreCase(correct)) {
            System.out.println(category + ": Correct!");
        } else {
            System.out.println(category + ": Incorrect (Correct: " + correct + ")");
        }
    }
}