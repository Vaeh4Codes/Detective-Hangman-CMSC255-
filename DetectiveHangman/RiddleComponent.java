package DetectiveHangman;

import java.io.File;

/**
 * RiddleComponent.java
 * Enum class for each component of the riddles, and has accessor methods
 * that return the file for each appropriate component.
 *
 * @author Nevaeh Dickerson
 * @version  4/27/26
 */

public enum RiddleComponent {
    LOCATION,
    MOTIVE,
    WEAPON,
    MURDERER,
    VICTIM;


    /**
     * getMurderers()
     * returns a file object for the MurdererRiddles.txt file
     *
     * @return MurdererRiddles txt File
     */
    public static File getMurderers(){
        return new File ("DetectiveHangman/MurdererRiddles.txt");
    }


    /**
     * getVictims()
     * returns a file object for the VicitimRiddles.txt file
     *
     * @return VictimRiddles txt File
     */
    public static File getVictims(){
        return new File ("DetectiveHangman/VicitimRiddles.txt");
    }

    /**
     * locationRiddles()
     * returns a file object for the locationRiddles.txt file
     *
     * @return locationRiddles txt File
     */
    public static File getLocations() {
        return new File("DetectiveHangman/locationRiddles.txt");
    }


    /**
     * MotiveRiddles()
     * returns a file object for the MotiveRiddles.txt file
     *
     * @return MotiveRiddles txt File
     */
    public static File getMotives(){
        return new File("DetectiveHangman/MotiveRiddles.txt");
    }

    /**
     * WeaponRiddles()
     * returns a file object for the WeaponRiddles.txt file
     *
     * @return WeaponRiddles txt File
     */
    public static File getWeapons(){
        return new File ("DetectiveHangman/WeaponRiddles.txt");
    }







}
