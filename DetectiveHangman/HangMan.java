package DetectiveHangman;

/**
 * Represents the Hangman figure in the Detective Hangman game.
 * This class manages adding body parts as the player makes incorrect guesses
 * and resetting the hangman for a new round.
 *
 * @author Max Mashack
 * @version 1.0
 */

public class HangMan {
    // datafields
    private String HangMan;

    /**
     * Constructor for HangMan class
     */
    public HangMan() {
        this.HangMan = "";
    }

    /**
     * getHangMan
     * getter method for HangMan data field
     * @return HangMan data field
     */
    public String getHangMan() {
        return HangMan;
    }
    /**
     * Displays the hangman stand
     *
     * @return a visual representation of the hangman stand
     */

    public String displayStand(){
        // Return string of Hangman stand Ascii Art
        return String.format("%s\n\t\t%s\n\t\t%s\n\t\t%s\n\t\t%s\n\t\t%s\n\t\t%s\n%s\n",
                "|```````|","|","|","|","|","|","|","--------------");
    }

    /**
     * Adds the head to the hangman.
     *
     * @return a visual representation of the head being added
     */
    public String addHead() {
        // 2. Return updated hangman display with head
        return String.format("%s\n%s\n\t\t%s\n\t\t%s\n\t\t%s\n\t\t%s\n\t\t%s\n%s\n",
                "|```````|","O       |","|","|","|","|","|","--------------");
    }

    /**
     * Adds the body to the hangman.
     *
     * @return a visual representation of the body being added
     */
    public String addBody() {
        // 2. Return updated display with body AND head
        return String.format("%s\n%s\n%s\n%s\n\t\t%s\n\t\t%s\n\t\t%s\n%s\n",
                "|```````|","O       |","|       |","|       |","|","|","|","--------------");
    }

    /**
     * Adds the left leg to the hangman.
     *
     * @return a visual representation of the left leg being added
     */
    public String addLeftLeg() {
        // 2. Return updated display with left leg AND body AND head
        return String.format("%s\n%s\n%s\n%s\n%s\n\t\t%s\n\t\t%s\n%s\n",
                " |```````|"," O       |","/|\\      |"," |       |","/        |"," |"," |"," --------------");
    }

    /**
     * Adds the right leg to the hangman.
     *
     * @return a visual representation of the right leg being added
     */
    public String addRightLeg() {
        // 2. Return updated display with right leg
        return String.format("%s\n%s\n%s\n%s\n%s\n\t\t%s\n\t\t%s\n%s\n",
                " |```````|"," O       |","/|\\      |"," |       |","/ \\      |"," |"," |"," --------------");
    }

    /**
     * Adds the left arm to the hangman.
     *
     * @return a  visual representation of the left arm being added
     */
    public String addLeftArm() {
        // 2. Return updated display with left arm
        return String.format("%s\n%s\n%s\n%s\n\t\t%s\n\t\t%s\n\t\t%s\n%s\n",
                " |```````|"," O       |","/|       |"," |       |"," |"," |"," |"," --------------");
    }

    /**
     * Adds the right arm to the hangman.
     *
     * @return a  visual representation of the right arm being added
     */
    public String addRightArm() {
        // 2. Return updated display with right arm
        return String.format("%s\n%s\n%s\n%s\n\t\t%s\n\t\t%s\n\t\t%s\n%s\n",
                " |```````|"," O       |","/|\\      |"," |       |"," |"," |"," |"," --------------");
    }

    /**
     * Resets the hangman by clearing all body parts.
     *
     * @return the starting hangman setup from displayHangman()
     */
    public String clearMan() {
        // 2. Return empty display
        return "";
    }


}