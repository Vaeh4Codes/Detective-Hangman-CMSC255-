package DetectiveHangman;
/**
 * Description
 * @author Kiah Martin
 * @version 1.0
 */

public enum Motive {
    JEALOUSY ("Jealousy"),
    REVENGE ("Revenge"),
    MONEY("Money"),
    THRILL("Thrill"),
    FAME("Fame");

    private String displayName;

    Motive(String displayName) {
        this.displayName = displayName;

    }
    public String getDisplayName() {
        return displayName;
    }

}
