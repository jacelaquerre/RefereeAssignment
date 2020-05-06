import java.util.Objects;

public class Crew {

    private Referee CR;
    private Referee AR1;
    private Referee AR2;
    private Referee standBy;

    public Crew() {
        CR = new Referee();
        AR1 = new Referee();
        AR2 = new Referee();
        standBy = new Referee();
    }

    public Crew(Referee CR) {
        this.CR = CR;
    }

    public Crew(Referee CR, Referee AR1, Referee AR2, Referee standBy) {
        this.CR = CR;
        this.AR1 = AR1;
        this.AR2 = AR2;
        this.standBy = standBy;
    }

    public Referee getCR() {
        return CR;
    }

    public void setCR(Referee CR) {
        this.CR = CR;
    }

    public Referee getAR1() {
        return AR1;
    }

    public void setAR1(Referee AR1) {
        this.AR1 = AR1;
    }

    public Referee getAR2() {
        return AR2;
    }

    public void setAR2(Referee AR2) {
        this.AR2 = AR2;
    }

    public Referee getStandBy() {
        return standBy;
    }

    public void setStandBy(Referee standBy) {
        this.standBy = standBy;
    }

    @Override
    public String toString() {
        return "Crew{" +
                "CR=" + CR.getName() +
                ", AR1=" + AR1.getName() +
                ", AR2=" + AR2.getName() +
                ", standBy=" + standBy.getName() +
                '}';
    }

    public boolean filledFull() {
        if (CR.getName().equals("Unknown")) {
            return false;
        } else if (AR1.getName().equals("Unknown")) {
            return false;
        } else if (AR2.getName().equals("Unknown")) {
            return false;
        } else if (standBy.getName().equals("Unknown")) {
            return false;
        } else {
            return true;
        }
    }

    public boolean filledSmall() {
        if (CR.getName().equals("Unknown")) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean crewFilled(int gameID, Tournament tourn) {
        Game game = tourn.findGame(gameID);
        int age = Objects.requireNonNull(Game.fieldFromGame(gameID)).getAge();
        if (age <= Tournament.SMALL_SIDED) {
            return game.getCrew().filledSmall();
        } else {
            return game.getCrew().filledFull();
        }
    }
}
