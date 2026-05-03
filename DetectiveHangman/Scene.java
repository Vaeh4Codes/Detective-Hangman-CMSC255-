package DetectiveHangman;
/**
 * Scene.java
 * This class creates the final mystery case, which will be printed as a string
 *
 * @Author Kiah Martin
 * @Version  4/27/26
 */

public class Scene {

    private String finalScene;


    /**
     *Scene()
     * constructor for a scene object
     */
    public Scene(String victim, String murderer,
                 String weapon, String location, String motive) {
        this.finalScene = String.format(
                "The victim %s was killed by %s with %s in the %s because of %s",
                victim, murderer, weapon, location, motive
        );
    }

    /**
     * checkScene()
     * Check if the user guess matches the final scene string.
     *
     * @param userGuess, String
     * @return true if guess matches the scene, false otherwise
     */
    public boolean checkScene(String userGuess){

        return finalScene.equalsIgnoreCase(userGuess.trim());
    }


    /**
     * getFinalScene()
     * Returns the final scene string (used for revealing the answer).
     *
     * @return finalScene, String
     */
    public String getFinalScene() {
        return finalScene;
    }

}
