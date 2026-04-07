package DetectiveHangman;

/**
 * Represents the victim riddle component.
 * Responsible for generating a victim-based riddle.
 *
 * @author Kyla Cooper
 * @version 1.0
 */
public class VictimComponent extends RiddleComponent {

    /**
     * Generates the victim riddle.
     */
    @Override
    public void generateComponent() {

        // Load victim riddles
        loadRiddles("Victim");

        // Select a random riddle
        selectRandomRiddle();

        // Mask the riddle for gameplay
        generateMaskedRiddle();
    }
}