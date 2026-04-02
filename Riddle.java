import DetectiveHangman.*;

public class Riddle {
    private Location location;
    private Characters murderer;
    private Characters victim;
    private Weapons weapon;
    private Motive motive;

    public Riddle(Location location, Characters murderer, Characters victim, Weapons weapon, Motive motive) {
        this.location = location;
        this.murderer = murderer;
        this.victim = victim;
        this.weapon = weapon;
        this.motive = motive;
    }

    public String generateFullRiddle(){
        return "";
    }

    public String generateGuessRiddle(){
        return "";
    }
}
