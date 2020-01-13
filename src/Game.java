public class Game {

    private int ID;
    private Crew crew;

    public Game() {
        this.ID = 0;
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
}
