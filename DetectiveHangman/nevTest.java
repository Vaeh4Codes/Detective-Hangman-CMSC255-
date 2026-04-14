package DetectiveHangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class nevTest {
    static void main() throws FileNotFoundException {
        File locationRiddles = new File("LocationRiddles.txt");
        File motiveRiddles = new File("MotiveRiddles.txt");
        File murdererRiddles = new File("MurdererRiddles.txt");
        File victimRiddles = new File("VicitimRiddles.txt");
        File weaponRiddles = new File("WeaponRiddles.txt");

        RiddleManager riddle = new RiddleManager(locationRiddles, motiveRiddles, murdererRiddles, victimRiddles, weaponRiddles, RiddleComponent.LOCATION);
        Scanner input = new Scanner(locationRiddles);
        ArrayList<String> chosen = riddle.getRiddleOptions(input);

        System.out.print(chosen);
    }
}
