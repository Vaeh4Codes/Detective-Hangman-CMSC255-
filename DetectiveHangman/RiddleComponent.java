package DetectiveHangman;

import java.io.File;

/**
 * enum class for each component of the riddles
 */

public enum RiddleComponent {
    LOCATION,
    MOTIVE,
    WEAPON,
    MURDERER,
    VICTIM;

    public static File getMurderers(){
        return new File ("MurdererRiddles.txt");
    }

    public static File getVictims(){
        return new File ("VictimRiddles.txt");
    }

    public static File getLocations() {
        return new File("locationRiddles.txt");
    }

    public static File getMotives(){
        return new File("MotiveRiddles.txt");
    }

    public static File getWeapons(){
        return new File ("WeaponRiddles.txt");
    }







}
