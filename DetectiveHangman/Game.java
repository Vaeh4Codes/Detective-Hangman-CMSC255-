package DetectiveHangman;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Game.java
 * Main driver class for the Detective Hangman game.
 * Responsibilities:
 * - Starts and control the game logic
 * - Runs 5 rounds of riddles with a words for the user to try to guess
 * - Evaluate final mystery
 *
 * @author Kyla Cooper
 * @version 4/27/26
 */
public class Game {
    public static void main(String[] args) {

        Detective player = new Detective();                      //Player (detective)
        final int TOTAL_ROUNDS = 5;                             //Total number of rounds
        ArrayList<String> finalRoundRiddles = new ArrayList<>();
        Scanner detectiveInput = new Scanner(System.in);        // Scanner for user input

        System.out.println("=== DETECTIVE HANGMAN ===");
        System.out.print("Start game? (yes/no): ");
        String response = detectiveInput.nextLine();

        while (response.equalsIgnoreCase("yes")) {

            String[] roundAnswers = playGame(TOTAL_ROUNDS, player, detectiveInput, finalRoundRiddles);

            Scene finalScene = new Scene(
                    roundAnswers[0],  // victim
                    roundAnswers[1],    // murderer
                    roundAnswers[2],  // weapon
                    roundAnswers[3],  // location
                    roundAnswers[4]   // motive
            );

            solveMystery(detectiveInput, player, finalScene, finalRoundRiddles);

            System.out.print("\nPlay again? (yes/no): ");
            response = detectiveInput.nextLine();
        }

        System.out.println("Thanks for playing!");
    }


    /**
     * playGame()
     * this method runs all rounds of the game, and controls the game logic
     *
     * @param TOTAL_ROUNDS, int
     * @param player,       Detective
     * @param userInput,    Scanner
     *
     */
    public static String[] playGame(int TOTAL_ROUNDS, Detective player, Scanner userInput, ArrayList<String> finalRoundRiddles) {
        int round = 1;
        String[] collectedComponents = new String[TOTAL_ROUNDS];

        while (round <= TOTAL_ROUNDS) {
            int incorrectGuesses = 0;

            System.out.println("\n--- ROUND " + round + " ---");  //displays the round
            displayMysteryComponent(round);                       // displays the component of the mystery the detective is currently solving
            HangMan graphics = new HangMan();                     //Create Hangman object


            /* initializes files and select a riddle for the round component */
            File locationRiddles = RiddleComponent.getLocations();
            File motiveRiddles = RiddleComponent.getMotives();
            File weaponRiddles = RiddleComponent.getWeapons();
            File victimRiddles = RiddleComponent.getVictims();
            File murdererRiddles = RiddleComponent.getMurderers();
            RiddleManager riddleManager = new RiddleManager(locationRiddles, motiveRiddles, weaponRiddles, victimRiddles, murdererRiddles);

            // selects a random riddle for the round component
            String randomRiddle = riddleManager.getRandomRiddleForComponent(getRoundComponent(round));

            // Creates a riddle object from the string riddle
            String[] randomRiddleSplit = randomRiddle.split(",");
            String fullRiddle = randomRiddleSplit[0];
            String missingWord = randomRiddleSplit[1];
            String riddleAnswer = randomRiddleSplit[2];

            Riddle riddle = new Riddle(fullRiddle, missingWord, riddleAnswer);

            collectedComponents[round - 1] = riddleAnswer.trim().replace("_", " ");;

            String wordToGuess = riddle.getMissingWord();
            String currentBlanks = riddle.displayBlanks();
            String currentHangman = graphics.displayStand();

            char letterGuessed = ' ';
            boolean correctGuess = false;

            /* Asks user for letter and Loop until solved */
            while (!riddle.getSolved() && incorrectGuesses != 6) {
                System.out.println("\n" + riddle.getMaskedRiddle());
                System.out.println("\n" + currentHangman);                              // Display Hangman Stand
                System.out.println(currentBlanks);                                      // Display the blanks to be solved

                System.out.print("Enter 'g' to guess a letter, Enter 'p' to look at past guesses, Enter 'a' to guess the answer: ");
                String choice = userInput.nextLine();

                if (choice.equalsIgnoreCase("g")) {
                    System.out.print("Guess a letter: ");
                    letterGuessed = userInput.nextLine().toLowerCase().charAt(0);
                    correctGuess = player.guessLetter(letterGuessed, wordToGuess); // Checks if detective guess is correct

                    if (correctGuess) {
                        currentBlanks = riddle.updateBlanks(letterGuessed, currentBlanks);

                        if (!currentBlanks.contains("_")) {
                            riddle.setSolved(true);
                        }
                    } else {
                        incorrectGuesses++;
                        currentHangman = addLimb(graphics, incorrectGuesses);
                        System.out.println("\n" + currentHangman);
                        System.out.println(currentBlanks);
                    }

                } else if (choice.equalsIgnoreCase("p")) {       //ask user if they'd like to see what letters they've already guessed
                    System.out.println("\n Here are your previous guesses " + player.displayLettersGuessed());
                } else if (choice.equalsIgnoreCase("a")) {
                    System.out.print("Enter your answer: ");
                    correctGuess = player.guessWord(userInput.nextLine().toLowerCase(), riddle); //stores true or false if users guess is correct

                    if (correctGuess) {
                        riddle.setSolved(true);
                    } else {
                        System.out.println("Incorrect word guess! Keep guessing!");
                    }
                } else {
                    System.out.println("INVALID CHOICE, PLEASE ENTER EITHER 'g', 'p', or 'a': ");
                }
            }

            if (incorrectGuesses == 6){
                System.out.println("\nYou've made too many mistakes! Moving on to the next round.");
                finalRoundRiddles.add(riddle.getMaskedRiddle());
                player.resetLettersGuessed();

            } else {
                System.out.println("\nSolved!");
                System.out.println("The full riddle is: " + riddle.getFullRiddle());
                finalRoundRiddles.add(riddle.getFullRiddle());
                player.resetLettersGuessed();

            }

            round++;
        }

        return collectedComponents;
    }

    /**
     * solveMystery()
     * prompts user to assemble their full solution and checks it against the Scene.
     *
     * @param input,  Scanner
     * @param player, Detective
     * @param scene,  Scene
     * @param finalRoundRiddles,    ArrayList<String>
     */
    public static void solveMystery(Scanner input, Detective player, Scene scene, ArrayList<String> finalRoundRiddles) {

        System.out.println("\n=== FINAL MYSTERY ===");
        System.out.println("You've gathered all the clues. Now solve the mystery!");
        System.out.println("Format: The victim __ was killed by __ with __ in the __ because of __");

        //Displays the riddles from each round
        System.out.println("\nHere are the riddles from each round. If you failed to fill in the word, one word will be missing?  ");

        System.out.print("\n");
        for (String riddle: finalRoundRiddles){
            System.out.println(riddle);
        }

        System.out.println(" ");
        // collects each part of the answer individually
        System.out.print("Who was the victim?   ");
        String victim = input.nextLine().trim();

        System.out.print("Who was the murderer? ");
        String murderer = input.nextLine().trim();

        System.out.print("What was the weapon?  ");
        String weapon = input.nextLine().trim();

        System.out.print("What was the location? ");
        String location = input.nextLine().trim();

        System.out.print("What was the motive?  ");
        String motive = input.nextLine().trim();

        // this assembles the guess in the same format as Scene
        String userGuess = String.format(
                "The victim %s was killed by %s with %s in the %s because of %s", victim, murderer, weapon, location, motive
        );


        System.out.println("\n=== RESULTS ===");
        System.out.println("Your answer: " + userGuess);
        System.out.println(scene.getFinalScene());
        finalRoundRiddles.clear();
    }

    /**
     * getRoundComponent()
     * This method gets the associated component file (locations, motives, murderers, victims, weapons)
     * associated with the current round
     *
     * @param round, int
     * @return component file, File
     *
     */
    public static File getRoundComponent(int round) {
        if (round == 1) {
            return RiddleComponent.getVictims();
        } else if (round == 2) {
            return RiddleComponent.getMurderers();
        } else if (round == 3) {
            return RiddleComponent.getWeapons();
        } else if (round == 4) {
            return RiddleComponent.getLocations();
        } else {
            return RiddleComponent.getMotives();
        }
    }

    /**
     * displayMysteryComponent()
     * Displays text for what the user is trying to find in
     * each round.
     *
     * @param round, int
     */
    public static void displayMysteryComponent(int round) {
        switch (round) {
            case 1:
                System.out.println("Find the Victim!");
                break;
            case 2:
                System.out.println("Find the Murderer!");
                break;
            case 3:
                System.out.println("Find the Weapon!");
                break;
            case 4:
                System.out.println("Find the Location!");
                break;
            case 5:
                System.out.println("Find the Motive!");
                break;
        }
    }

    /**
     * addLimb()
     * Adds and displays the HangMan graphic with an additional limb after each
     * incorrect letter guess by the user.
     *
     * @param graphics,         HangMan
     * @param incorrectGuesses, int
     */
    public static String addLimb(HangMan graphics, int incorrectGuesses) {

        if (incorrectGuesses == 1) {
            // display head
            return graphics.addHead();
        } else if (incorrectGuesses == 2) {
            // display body
            return graphics.addBody();
        } else if (incorrectGuesses == 3) {
            // display left arm
            return graphics.addLeftArm();
        } else if (incorrectGuesses == 4) {
            // display right arm
            return graphics.addRightArm();
        } else if (incorrectGuesses == 5) {
            // display left leg
            return graphics.addLeftLeg();
        } else {
            // display right leg
            return graphics.addRightLeg();
        }
    }
}