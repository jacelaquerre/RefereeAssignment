public class Referee {

    private int ID;
    private String name;
    private Availibility aval;
    private int high;
    private int low;
    private int maxGames;

    public Referee() {
        ID = 0;
        name = "Unknown";
        aval = new Availibility();
        high = 10;
        low = 10;
        maxGames = 0;
    }

    public Referee(int ID, String name, Availibility aval, int high, int low, int maxGames) {
        this.ID = ID;
        this.name = name;
        this.aval = aval;
        this.high = high;
        this.low = low;
        this.maxGames = maxGames;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public void setMaxGames(int maxGames) {
        this.maxGames = maxGames;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getHigh() {
        return high;
    }

    public int getLow() {
        return low;
    }

    public int getMaxGames() {
        return maxGames;
    }

    public Availibility getAval() {
        return aval;
    }

    public void setAval(Availibility aval) {
        this.aval = aval;
    }

    @Override
    public String toString() {
        return "Referee{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", aval=" + aval.toString() +
                ", high=" + high +
                ", low=" + low +
                ", maxGames=" + maxGames +
                '}';
    }
}

