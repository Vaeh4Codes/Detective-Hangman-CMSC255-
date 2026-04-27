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
 * @version 4/27/26
 */
public class Game {
    public static void main(String[] args) {

        Detective player = new Detective();                   //Player (detective)
        HangMan body;                       //Hangman body
        Riddle riddle;                      //Current riddle
        final int TOTAL_ROUNDS = 5;         //Total number of rounds
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
            Riddle loadRiddles = new Riddle();                    // Create new riddle
            HangMan graphics = new HangMan();                     //Create Hangman object


            //ToDO:
            // 1) select a riddle for the round component
            File locationRiddles = RiddleComponent.getLocations();
            File motiveRiddles = RiddleComponent.getMotives();
            File weaponRiddles = RiddleComponent.getWeapons();
            File victimRiddles = RiddleComponent.getVictims();
            File murdererRiddles = RiddleComponent.getMurderers();
            RiddleManager riddleManager = new RiddleManager(locationRiddles,motiveRiddles,weaponRiddles,victimRiddles,murdererRiddles);

            // selects a riddle for the round component
            String randomRiddle = riddleManager.getRandomRiddleForComponent(getRoundComponent(round));

            // 2) creates a riddle object from the string riddle
            String[] randomRiddleSplit = randomRiddle.split(",");
            String fullRiddle = randomRiddleSplit[0];
            String missingWord = randomRiddleSplit[1];
            String riddleAnswer = randomRiddleSplit[2];

            Riddle riddle = new Riddle(fullRiddle, missingWord, riddleAnswer);

            String wordToGuess = riddle.getMissingWord();

            // generate a masked riddle and displays it
            System.out.println(riddle.displayMaskedRiddle());

            //ToDo:
            // Display Hangman Stand
            graphics.displayStand();

            //ToDo:
            // Display the blanks to be solved
            riddle.displayBlanks();


            // Asks user for letter and Loop until solved
            while (!riddle.isSolved() || (incorrectGuesses == 6)){

                System.out.print("Guess a letter: ");
                char letterGuessed = userInput.nextLine().charAt(0);

                //TODO:
                // Check if detective guess is correct
                boolean correctGuess = player.guessLetter(letterGuessed, wordToGuess);

                //if guess incorrect add limb
                if (!correctGuess){
                    //Todo:
                    //adds appropriate limb
                    incorrectGuesses++;
                    addLimb(round, graphics, incorrectGuesses);
                }

                //ask user if theyd like to see what letters theyve already guessed
                System.out.println("What you like to see the letters you already guessed? yes/no");
                if(userInput.nextLine().equals("yes")){
                    player.displayLettersGuessed();
                } else{
                    System.out.println("Would you like to guess the word? yes/no");

                    if(userInput.nextLine().equals("yes")){
                        System.out.println("Enter your answer");
                        String userAnswer = userInput.nextLine();
                        player.displayLettersGuessed();
                    }
                }
            }

            System.out.println("Solved!");
            System.out.println("Answer: " + riddle.getMissingWord());

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
     * @parms ADD PARAMS HERE
     */
    public static void addLimb(int round, HangMan graphics, int incorrectGuesses){

        displayMysteryComponent(round); //Displays the component of the current round
        System.out.println(" insert riddle with missing word here"); //FIX THIS LINE HERE!

        graphics.displayStand(); //displays the stand holding the hangman

        if (incorrectGuesses == 1){
            // display head
            graphics.addHead();
        } else if (incorrectGuesses == 2){
            // display body
            graphics.addBody();
        }  else if (incorrectGuesses == 3){
            // display left arm
            graphics.addLeftArm();
        }  else if (incorrectGuesses == 4){
            // display right arm
            graphics.addRightArm();
        }  else if (incorrectGuesses == 5){
            // display left leg
            graphics.addLeftLeg();
        }  else {
            // display right leg
            graphics.addRightLeg();
        }
    }

    /**
    * After user makes a guess, the entire console resets so
     * that there is not a lengthy history of previous guesses and new ascii art
    *
    * */
    //TODO: I (Nevaeh) will do this!
    // make the console clear at every user character guess
    public void resetConsole(){

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