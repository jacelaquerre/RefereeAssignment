import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Field {

    public enum Day {
        SATURDAY, SUNDAY, TBD;
        private static final Field.Day[] vals = values();
        public Field.Day next()
        {
            return vals[(this.ordinal()+1) % vals.length];
        }
    }

    private int ID;
    private String name;
    private int numGames;
    public  int age;
    private Day day;
    public static List<Game> games = new ArrayList<>();

    public Field() {
        int ID = Game.randInt();
        while (getAllFieldNums().contains(ID)) {
            ID = Game.randInt();
        }
        this.ID = ID;
        String name = "Unknown";
        int numGames = 0;
        int age = 10;
        Day day = Day.TBD;
        Game game = new Game();
        Tournament.gameList.add(game);
    }

    public Field(int ID, String name, int numGames, int age, Day day, List<Game> games) {
        while (getAllFieldNums().contains(ID)) {
            ID = Game.randInt();
            System.out.print("ID given is already used. Random ID created.");
        }
        this.ID = ID;
        this.name = name;
        this.numGames = numGames;
        this.age = age;
        this.day = day;
        for (int i = 0; i < numGames; ++i) {
            Game game = new Game();
            games.add(game);
            Tournament.gameList.add(game);
        }
        Field.games = games;
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
        Field.games = games;
    }

    public Game getGame(int index) {
        return games.get(index);
    }

    @Override
    public String toString() {
        return "Field-- " +
                "ID = " + ID +
                ", Name = " + name +
                ", Number of Games = " + numGames +
                ", Age Group = " + age;
    }

    public void addField(int ID, String name, int numGames, int age, Day day, List<Game> games) {
        Field field = new Field(ID, name, numGames, age, day, games);
        Tournament.fieldList.add(field);
    }

    public void addField(Field field) {
        Tournament.fieldList.add(field);
    }

    public static void addField(Scanner scan) {
        System.out.print("Enter fields's ID: ");
        int ID = scan.nextInt();
        System.out.print("Enter fields's name: ");
        String name = scan.next();
        System.out.print("Enter the number of games on the field: ");
        int numGames = scan.nextInt();
        System.out.print("Enter age of players on the field: ");
        int age = scan.nextInt();
        System.out.print("Enter the day the field is scheduled for: ");
        String stringDay = scan.next();
        Field.Day day;
        switch(stringDay.toLowerCase()) {
            case "sunday":
                day = Field.Day.SUNDAY;
                break;
            case "saturday":
                day = Field.Day.SATURDAY;
                break;
            default:
                day = Field.Day.TBD;
        }
        List<Game> games = new ArrayList<>();
        for (int i = 0; i < numGames; ++i) {
            Game game = new Game();
            games.add(game);
            Game.addGameList(game);
        }
        Field field = new Field(ID, name, numGames, age, day, games);
        Tournament.fieldList.add(field);
    }

    // Returns a list of all field IDs
    public static List<Integer> getAllFieldNums() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < Tournament.getFieldList().size(); ++i) {
            list.add(Tournament.getFieldList().get(i).getID());
        }
        return list;
    }
}
