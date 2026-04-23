package DetectiveHangman;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
//Todo: (Nevaeh)
//1) reorganize
//2) create a RiddleManager object using the 1 parameter constructor
//3) create file objects for each txt file and set the each of those files for riddleManager
//4) create scanner objects for each of the txt files
//        Scanner locationFile = openFile("locationRiddles", locationRiddles);
//        Scanner motiveFile = openFile("motiveRiddles", motiveRiddles);
//        Scanner murdererFile = openFile("murdererRiddles", murdererRiddles);
//        Scanner victimFile = openFile("victimRiddles", victimRiddles);
//        Scanner weaponFile = openFile("weaponRiddles", weaponRiddles);
//5)get and store the three riddle options for each component using getRiddleOptions()
//6) randomly choose one of the riddles for each of the components and store them into a string arraylist
//7) create a riddle object for each string in the arraylist
//8) at each round display hangman display as well as blank word based on the object of the round


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
    public static void main(String[] args) {

        Detective player;                   //Player (detective)
        HangMan body;                       //Hangman body (future use)
        Riddle riddle;                      // Current riddle
        int round;                          //Current round
        final int TOTAL_ROUNDS = 5;         //Total number of rounds
        String[] answers;                   //Stores answers from each round

        Scanner input = new Scanner(System.in);  // Scanner for input

        System.out.println("=== DETECTIVE HANGMAN ===");

        System.out.print("Start game? (yes/no): ");
        String response = input.nextLine();

        while (response.equalsIgnoreCase("yes")) {

            round = 1;
            playGame(round);

            System.out.print("\nPlay again? (yes/no): ");
            response = input.nextLine();

        }

        System.out.println("Thanks for playing!");





        Game game = new Game();
        game.playGame(round, TOTAL_ROUNDS, player, input);
    }



    /**
     * PlayGame method This method runs all rounds of the game.
     *
     *
     */
    public void playGame(int round, int TOTAL_ROUNDS, Detective player, Scanner input) {

        while (round <= TOTAL_ROUNDS) {
            int incorrectGuesses = 0;

            //displays the round
            System.out.println("\n--- ROUND " + round + " ---");
            displayMysteryComponent(round); // displays the component of the mystery the detective is solving

            // Create new riddle
            Riddle riddle = new Riddle();

            //Create Hangman object
            HangMan graphics = new HangMan();


            //ToDO:
            // 1) select a riddle for the round component
            File locationRiddles = new File("locationRiddles.txt");
            File motive = new File("MotiveRiddles.txt");
            File weapon = new File ("WeaponRiddles.txt");
            File victim = new File ("VictimRiddles.txt");
            File murdererRiddles = new File ("MurdererRiddles.txt");
            RiddleManager loadRiddles = new RiddleManager(locationRiddles,motive,weapon,victim,murdererRiddles);
            // 2) generate a masked riddle

            //Displays the masked riddle for the round
            riddle.askRiddle();

            //ToDo:
            // Display Hangman Graphic
            graphics.displayStand();



            //ToDo:
            // display the blanks to be solved


            // Asks user for letter and Loop until solved
            while (!riddle.isSolved() || (incorrectGuesses == 6)){

                System.out.print("Guess a letter: ");
                String letterGuessed = input.nextLine();

                displayUI(round, riddle, graphics, player.getCorrectLetters(), incorrectGuesses);

                if (letterGuessed.isEmpty()) continue;

                char guess = letterGuessed.charAt(0);

                boolean correct = player.guessLetter(guess, riddle);

                if (correct) {
                    System.out.println("Correct!");
                } else {
                    incorrectGuesses++;
                    System.out.println("Incorrect!");

                    // TODO: Add hangman body logic here
                    else {
                        incorrectGuesses++;
                        System.out.println("Incorrect!");

                        // Add hangman parts based on number of incorrect guesses
                        if (incorrectGuesses == 1) {
                            graphics.addHead();
                        } else if (incorrectGuesses == 2) {
                            graphics.addBody();
                        } else if (incorrectGuesses == 3) {
                            graphics.addLeftArm();
                        } else if (incorrectGuesses == 4) {
                            graphics.addRightArm();
                        } else if (incorrectGuesses == 5) {
                            graphics.addLeftLeg();
                        } else if (incorrectGuesses == 6) {
                            graphics.addRightLeg();
                        }
                    }

            }

            if(incorrectGuesses == 6){
                System.out.println("Nice try!");
            } else{
                System.out.println("Solved!");
            }
            System.out.println("Answer: " + riddle.getMissingWord());

            answers[round - 1] = riddle.getMissingWord(); //???

            round++;
        }

        solveMystery();
    }

    /**
     * Displays what each round represents.
     */
    public void displayMysteryComponent(int round) {
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
     * Displays the Hangman chart, riddle with missing word, blanks for user to guess letter
     *
     * @parms ADD PARAMS HERE
     */
    public void displayUI(int round, Riddle riddle, HangMan graphics, ArrayList<Character> correctLetter, int incorrectGuesses){

        displayMysteryComponent(round); //Displays the component of the current round
        System.out.println(" insert riddle with missing word here"); //FIX THIS LINE HERE!

        //TODO: I (Nevaeh) will do this!
        // make the console clear at every user character guess
        graphics.displayStand(); //displays the stand holding the hangman

            if (correctGuess) {
                // handle correct guess
            } else {
                incorrectGuesses++;
                System.out.println("Incorrect!");

                if (incorrectGuesses == 1) {
                    graphics.addHead();
                } else if (incorrectGuesses == 2) {
                    graphics.addBody();
                } else if (incorrectGuesses == 3) {
                    graphics.addLeftArm();
                } else if (incorrectGuesses == 4) {
                    graphics.addRightArm();
                } else if (incorrectGuesses == 5) {
                    graphics.addLeftLeg();
                } else if (incorrectGuesses == 6) {
                    graphics.addRightLeg();
                }
            }

    /**
     * Final mystery guessing phase.
     */
    public void solveMystery(Scanner input, Detective player) {

        System.out.println("\n=== FINAL MYSTERY ===");

        System.out.print("Murderer: ");
        String murderer = input.nextLine();

        System.out.print("Victim: ");
        String victim = input.nextLine();

        System.out.print("Location: ");
        String location = input.nextLine();

        System.out.print("Motive: ");
        String motive = input.nextLine();

        System.out.print("Weapon: ");
        String weapon = input.nextLine();

        System.out.println("\n=== RESULTS ===");

        String gameResult = player.solveMystery(murderer, victim, location, motive, weapon); //Displays if the answer solved the mystery

        System.out.println(gameResult);
    }

}