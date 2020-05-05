import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    private int ID;
    private Crew crew;

    public Game() {
        // Make sure the game ID is not already in use
        int ID = randInt();
        while (getAllGameNums().contains(ID)) {
            ID = randInt();
        }
        this.ID = ID;
        this.crew = new Crew();
    }

    public Game(int ID, Crew crew) {
        this.ID = ID;
        this.crew = crew;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Crew getCrew() {
        return crew;
    }

    public void setCrew(Crew crew) {
        this.crew = crew;
    }

    @Override
    public String toString() {
        return "Game{" +
                "ID=" + ID +
                ", crew=" + crew.toString() +
                '}';
    }

    // Returns a random int between 1-3000 for IDs
    public static int randInt() {
        Random rand = new Random();
        return rand.nextInt((3000));
    }

    // Returns a list of all game IDs
    public static List<Integer> getAllGameNums() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < Tournament.getFieldList().size(); ++i) {
            for (int n = 0; n < Tournament.getFieldList().get(i).getGames().size(); ++n) {
                list.add(Tournament.getFieldList().get(i).getGames().get(n).getID());
            }
        }
        return list;
    }

}
