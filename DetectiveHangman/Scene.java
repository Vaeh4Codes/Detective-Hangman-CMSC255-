package DetectiveHangman;

import java.util.Random;

/**
 * This class creates the final mystery case, which will be printed as a string
 * @author Kiah Martin
 * @Version 1.0
 */

public class Scene {
    private Weapons weapon;
    private Location location;
    private Motive motive;
    private Characters murderer;
    private Characters victim;

    public void generateScene() {
        Random rand = new Random();

        Weapons[] weapons = Weapons.values();
        Location[] locations = Location.values();
        Motive[] motives = Motive.values();
        Characters[] characters = Characters.values();

        weapon = weapons[rand.nextInt(weapons.length)];
        location = locations[rand.nextInt(locations.length)];
        motive = motives[rand.nextInt(motives.length)];
        murderer = characters[rand.nextInt(characters.length)];
        victim = characters[rand.nextInt(characters.length)];

        while (victim == murderer) {
            victim = characters[rand.nextInt(characters.length)];
        }

    }

    public boolean checkScene(String userGuess) {
        String correctAnswer = murderer + " " + weapon + " " + location + " " + motive;
        return userGuess.equalsIgnoreCase(correctAnswer):
    }

    public String toString() {
        return "Murderer: " + murderer +
                "\nVictim: " + victim +
                "\nWeapon: " + weapon +
                "\nLocation: " + location +
                "\nMotive: " + motive;
    }
}
