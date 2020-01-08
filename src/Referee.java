public class Referee {

    private int ID;
    private String name;
    private boolean satAvail;
    private boolean sunAvail;
    private int high;
    private int low;
    private int maxGames;

    public Referee() {
        ID = 0;
        name = "Unknown";
        satAvail = false;
        sunAvail = false;
        high = 10;
        low = 10;
        maxGames = 0;
    }

    public Referee(int ID, String name, boolean satAvail, boolean sunAvail, int high, int low, int maxGames) {
        this.ID = ID;
        this.name = name;
        this.satAvail = satAvail;
        this.sunAvail = sunAvail;
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

    public void setSatAvail(boolean satAvail) {
        this.satAvail = satAvail;
    }

    public void setSunAvail(boolean sunAvail) {
        this.sunAvail = sunAvail;
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

    public boolean isSatAvail() {
        return satAvail;
    }

    public boolean isSunAvail() {
        return sunAvail;
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

    @Override
    public String toString() {
        return "Referee{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", satAvail=" + satAvail +
                ", sunAvail=" + sunAvail +
                ", high=" + high +
                ", low=" + low +
                ", maxGames=" + maxGames +
                '}';
    }
}

