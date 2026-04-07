package DetectiveHangman;
/**
 * Description: Main driver class for Detective Hangman
 * @Kyla Cooper
 * @Version
 */

public class Game {

    public static void main(String[] args) {

        Game game = new Game();
        game.startGame();
    }

    // Instance Variables
    private Character player;
    private HangmanBody body;
    private Riddle riddle;

    private int round;
    private final int TOTAL_ROUNDS = 5;

    // Constructor
    public Game() {
        player = new Character("Detective");
        body = new HangmanBody();
        riddle = new Riddle();
        round = 1;
    }

    // Start the game
    public void startGame() {

        System.out.println("=== DETECTIVE HANGMAN ===");
        System.out.println("Solve the mystery before running out of guesses!\n");

        playGame();
    }

    // Main game loop
    public void playGame() {

        while (round <= TOTAL_ROUNDS) {

            System.out.println("\n--- ROUND " + round + " ---");
            displayRoundType();

            body.reset(); // reset hangman each round

            // TODO: load a new riddle/word for each round
            riddle.askRiddle();

            // Round loop
            while (!riddle.isSolved() && !body.isComplete()) {

                char guess = player.makeGuess();

                boolean correct = riddle.checkLetter(guess);

                if (!correct) {
                    body.addPart();
                }

                riddle.displayProgress();
                body.displayBody();
            }

            // Round result
            if (riddle.isSolved()) {
                System.out.println("You solved this part of the case!");
            } else {
                System.out.println("You failed this round.");
                System.out.println("Correct answer: " + riddle.getAnswer());
            }

            round++;
        }

        endGame();
    }

    // Shows what each round represents
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

    // End of game
    public void endGame() {
        System.out.println("\n=== CASE CLOSED ===");

        // TODO: track correct answers and determine success
        System.out.println("Review your findings...");
    }
}
