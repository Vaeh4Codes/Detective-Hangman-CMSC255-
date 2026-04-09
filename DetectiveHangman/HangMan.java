package DetectiveHangman;

/**
 * Represents the Hangman figure in the Detective Hangman game.
 * This class manages adding body parts as the player makes incorrect guesses
 * and resetting the hangman for a new round.
 *
 * @author Kiah Martin
 * @version 1.0
 */

public class HangMan {

    // Body part attributes
    private char head;
    private char body;
    private char leftLeg;
    private char rightLeg;
    private char leftArm;
    private char rightArm;


    public HangMan() {
        clearMan();
    }

    /**
     * Adds the head to the hangman.
     *
     * @return a visual representation of the head being added
     */
    public String addHead() {
        head = 'O';
        return displayHangman();
    }


    /**
     * Adds the body to the hangman.
     *
     * @return a visual representation of the body being added
     */
    public String addBody() {
        body = '|';
        return displayHangman();
    }

    /**
     * Adds the left leg to the hangman.
     *
     * @return a visual representation of the left leg being added
     */
    public String addLeftLeg() {
        leftLeg = '/';
        return displayHangman();
    }

    /**
     * Adds the right leg to the hangman.
     *
     * @return a visual representation of the right leg being added
     */
    public String addRightLeg() {
        rightLeg = '\\';
        return displayHangman();
    }

    /**
     * Adds the left arm to the hangman.
     *
     * @return a  visual representation of the left arm being added
     */
    public String addLeftArm() {
        leftArm = '/';
        return displayHangman();
    }

    /**
     * Adds the right arm to the hangman.
     *
     * @return a  visual representation of the right arm being added
     */
    public String addRightArm() {
        rightArm = '\\';
        return displayHangman();
    }

    /**
     * Resets the hangman by clearing all body parts.
     *
     * @return the starting hangman setup from displayHangman()
     */
    public String clearMan() {
        head = ' ';
        body = ' ';
        leftLeg = ' ';
        rightLeg = ' ';
        leftArm = ' ';
        rightArm = ' ';

        return displayHangman();
    }
    public String displayHangman() {
        return "  +---+\n" +
               "  |   |\n" +
               "  " + head + "   |\n" +
               " " + leftArm + body + rightArm + "  |\n" +
               " " + leftLeg + " " + rightLeg + "  |\n" +
               "      |\n" +
               "=========\n";
    }
}