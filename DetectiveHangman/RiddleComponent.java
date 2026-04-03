package DetectiveHangman;

/**
 * Represents the parent class to all the component classes.
 * Provides a shared structure for generating and retrieving the values of each
 * game stage (location, murderer, victim, motive, weapon).
 *
 * @author Your Name
 * @version
 */
public class Riddle {
    
    /**
     * Generates a value for the select component.
     */
    //Todo: Child classes should override this method.
    public void generate() {
        // Default implementation (can be empty)
    }

    /**
     * Returns the value of the select component as a string.
     *
     * @return string representation of the component
     */
    public String getValue() {
        return "";
    }

}