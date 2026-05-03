package DetectiveHangman;

/**
 * HangMan.java
 * Represents the Hangman figure in the Detective Hangman game.
 * This class manages adding body parts as the player makes incorrect guesses
 * and resetting the hangman for a new round.
 *
 * @author Max Mashack
 * @version 4/27/26
 */

public class HangMan {

    private String HangMan;

    /**
     * HangMan()
     * Constructor for HangMan class
     */
    public HangMan() {
        this.HangMan = "";
    }

    /**
     * getHangMan()
     * getter method for HangMan data field
     *
     * @return HangMan data field
     */
    public String getHangMan() {
        return HangMan;
    }

    /**
     * displayStand()
     * Displays the hangman stand as a string
     *
     * @return string, a visual representation of the hangman stand
     */
    public String displayStand(){
        // Return string of Hangman stand Ascii Art
        return String.format("%s\n\t\t%s\n\t\t%s\n\t\t%s\n\t\t%s\n\t\t%s\n\t\t%s\n%s\n",
                "|```````|","|","|","|","|","|","|","--------------");
    }

    /**
     * addHead()
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
     * addBody()
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
     * addLeftLeg()
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
     * addRightLeg()
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
     * addLeftArm()
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
     * addRightArm()
     * Adds the right arm to the hangman.
     *
     * @return a  visual representation of the right arm being added
     */
    public String addRightArm() {
        // 2. Return updated display with right arm
        return String.format("%s\n%s\n%s\n%s\n\t\t%s\n\t\t%s\n\t\t%s\n%s\n",
                " |```````|"," O       |","/|\\      |"," |       |"," |"," |"," |"," --------------");
    }


}