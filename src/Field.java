import java.util.ArrayList;
import java.util.List;

public class Field {

    public enum Day {
        Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, TBD
    }

    private int ID;
    private String name;
    private int numGames;
    public static int age;
    private Day day;
    public static List<Game> games = new ArrayList<Game>();

    public Field() {
        int ID = 0;
        String name = "Unknown";
        int numGames = 0;
        int age = 10;
        Day day = Day.TBD;
        Game games = new Game();
    }

    public Field(int ID, String name, int numGames, int age, Day day, List<Game> games) {
        this.ID = ID;
        this.name = name;
        this.numGames = numGames;
        this.age = age;
        this.day = day;
        for (int i = 0; i < numGames; ++i) {
            Game game = new Game();
            games.add(game);
        }
        this.games = games;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumGames() {
        return numGames;
    }

    public void setNumGames(int numGames) {
        this.numGames = numGames;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    @Override
    public String toString() {
        return "Field{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", numGames=" + numGames +
                ", age=" + age +
                ", day=" + day +
                ", games=" + games.toString() +
                '}';
    }
}
