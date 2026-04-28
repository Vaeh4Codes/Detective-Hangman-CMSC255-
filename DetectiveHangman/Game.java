package DetectiveHangman;

import java.io.File;
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
 * @version 4/27/26
 */
public class Game {
    public static void main(String[] args) {

        Detective player = new Detective();                   //Player (detective)
        HangMan body;                       //Hangman body
        Riddle riddle;                      //Current riddle
        final int TOTAL_ROUNDS = 5;         //Total number of rounds
        boolean validGuess = false;
        String[] answers;                   //Stores riddle answers from each round

        Scanner detectiveInput = new Scanner(System.in);  // Scanner for user input

        System.out.println("=== DETECTIVE HANGMAN ===");

        System.out.print("Start game? (yes/no): ");
        String response = detectiveInput.nextLine();

        while (response.equalsIgnoreCase("yes")) {

            playGame(TOTAL_ROUNDS, player, detectiveInput);

            System.out.print("\nPlay again? (yes/no): ");
            response = detectiveInput.nextLine();

        }

        System.out.println("Thanks for playing!");

    }



    /**
     * PlayGame method This method runs all rounds of the game.
     *
     *
     */
    public static void playGame(int TOTAL_ROUNDS, Detective player, Scanner userInput) {
        int round = 1;

        while (round <= TOTAL_ROUNDS) {
            int incorrectGuesses = 0;

            System.out.println("\n--- ROUND " + round + " ---");  //displays the round
            displayMysteryComponent(round);                       // displays the component of the mystery the detective is currently solving
            HangMan graphics = new HangMan();                     //Create Hangman object


            /* initalizes files and select a riddle for the round component */
            File locationRiddles = RiddleComponent.getLocations();
            File motiveRiddles = RiddleComponent.getMotives();
            File weaponRiddles = RiddleComponent.getWeapons();
            File victimRiddles = RiddleComponent.getVictims();
            File murdererRiddles = RiddleComponent.getMurderers();
            RiddleManager riddleManager = new RiddleManager(locationRiddles,motiveRiddles,weaponRiddles,victimRiddles,murdererRiddles);

            // selects a random riddle for the round component
            String randomRiddle = riddleManager.getRandomRiddleForComponent(getRoundComponent(round));

            /* Creates a riddle object from the string riddle */
            String[] randomRiddleSplit = randomRiddle.split(",");
            String fullRiddle = randomRiddleSplit[0];
            String missingWord = randomRiddleSplit[1];
            String riddleAnswer = randomRiddleSplit[2];

            Riddle riddle = new Riddle(fullRiddle, missingWord, riddleAnswer);

            String wordToGuess = riddle.getMissingWord();
            String currentBlanks = riddle.displayBlanks();

            String currentHangman = graphics.displayStand();
            /* Asks user for letter and Loop until solved */
            while (!riddle.isSolved() && incorrectGuesses != 6){
                System.out.println("\n" + riddle.getMaskedRiddle());
                System.out.println("\n" + currentHangman);                              // Display Hangman Stand
                System.out.println(currentBlanks);                                      // Display the blanks to be solved

                System.out.print("Guess a letter: ");
                char letterGuessed = userInput.nextLine().charAt(0);


                // Checks if detective guess is correct
                boolean correctGuess = player.guessLetter(letterGuessed, wordToGuess);

                //if guess incorrect add a limb
                if (!correctGuess){
                    incorrectGuesses++;
                    currentHangman = addLimb(round, graphics, incorrectGuesses);
                    System.out.println("\n" + currentHangman);
                    System.out.println(currentBlanks);                                  // Display the blanks to be solved
                } else{
                    currentBlanks = riddle.updateBlanks(letterGuessed, currentBlanks);
                }

                //ask user if they'd like to see what letters they've already guessed
                System.out.print("What you like to see the letters you already guessed? yes/no");

                if(userInput.nextLine().equals("yes")){
                    System.out.println("\n" + player.displayLettersGuessed());     //displays the users previous guesses
                }

                System.out.print("Would you like to guess the word? yes/no");
                if(userInput.nextLine().equals("yes")){
                    System.out.println("Enter your answer");
                    correctGuess = player.guessWord(userInput.nextLine(), riddle);
                }

                // check if user guess is correct
                if (correctGuess){
                    // print smth telling user they got it correct
                    System.out.println("Correct!");
                    // break out of this loop by setting isSolved to true
                    // okay I don't entirely understand what isSolved method is doing rn - Max
                }

            }

            if (incorrectGuesses == 6){
                System.out.println("You've made too many mistakes! Moving on to the next round.");
            } else{
                System.out.println("Solved!");
                System.out.println("The full riddle is: " + riddle.getFullRiddle());
            }

            round++;
        }
    }

    public static File getRoundComponent(int round){
        if (round == 1){
            return RiddleComponent.getMurderers();
        } else if(round == 2){
            return RiddleComponent.getVictims();
        } else if(round == 3){
            return RiddleComponent.getLocations();
        } else if (round == 4){
            return RiddleComponent.getMurderers();
        } else{
            return RiddleComponent.getWeapons();
        }
    }

    /**
     * Displays what each round represents.
     */
    public static void displayMysteryComponent(int round) {
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
     * @return
     * @parms ADD PARAMS HERE
     */
    public static String addLimb(int round, HangMan graphics, int incorrectGuesses){

        if (incorrectGuesses == 1){
            // display head
            return graphics.addHead();
        } else if (incorrectGuesses == 2){
            // display body
            return graphics.addBody();
        }  else if (incorrectGuesses == 3){
            // display left arm
            return graphics.addLeftArm();
        }  else if (incorrectGuesses == 4){
            // display right arm
            return graphics.addRightArm();
        }  else if (incorrectGuesses == 5){
            // display left leg
            return graphics.addLeftLeg();
        }  else {
            // display right leg
            return graphics.addRightLeg();
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