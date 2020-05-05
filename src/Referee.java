import java.util.Scanner;

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

    public void addReferee(int ID, String name, Availibility aval, int high, int low, int maxGames) {
        Referee ref = new Referee(ID, name, aval, high, low, maxGames);
        Tournament.refList.add(ref);
    }

    public void addReferee(Referee ref) {
        Tournament.refList.add(ref);
    }

    public static void addReferee(Scanner scan) {
        // TODO: check for overlap in variables
        System.out.print("Enter Referee's ID: ");
        int ID = scan.nextInt();
        System.out.print("Enter Referee's name: ");
        String name = scan.next();
        System.out.print("Is referee available Saturday (y/n)? ");
        String satA = scan.next();
        System.out.print("Is referee available Sunday (y/n)? ");
        String sunA = scan.next();
        boolean satB = false, sunB = false;
        if (satA.toLowerCase().equals("y")) {
            satB = true;
        }
        if (sunA.toLowerCase().equals("y")) {
            sunB = true;
        }
        Availibility avail = new Availibility(satB, sunB);
        System.out.print("Enter Referee's highest age level comfortably: ");
        int high = scan.nextInt();
        System.out.print("Enter Referee's lowest age level comfortably: ");
        int low = scan.nextInt();
        System.out.print("Enter Referee's maximum number of games");
        int max = scan.nextInt();
        Referee ref = new Referee(ID, name, avail, high, low, max);
        Tournament.refList.add(ref);
    }

}

