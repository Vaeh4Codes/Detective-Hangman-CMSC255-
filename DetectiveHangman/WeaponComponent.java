package DetectiveHangman;

import java.util.Random;

/**
 * Represents the weapon riddle component.
 * Generates a weapon and builds riddles from file templates
 *
 * @Author
 * @version
 */
public class WeaponComponent extends RiddleComponent {

    /**
     * Randomly selects a weapon from enum.
     */
    @Override
    public void generateComponent() {
        // TODO:
        // 1. Get all Weapons enum values and store in list as strings
        // 2. Generate random index
        // 3. Set missingWord = selected weapon

    }

    /**
     * Builds full riddle using a random template.
     */
    @Override
    public void generateFullRiddle() {
        // TODO:
        // 1. Pick random riddle from riddles list
        // 2. Replace placeholder missingWord with answer

    }

    /**
     * Builds masked riddle (missing word).
     */
    @Override
    public void generateMaskedRiddle() {
        // TODO:
        // Replace chosen missing word with blanks in the sentence


    }
}