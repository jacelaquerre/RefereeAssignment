public class Field {

    private int ID;
    private String name;
    private int numGames;
    private int age;
    private Crew crew;

    public Field() {
        int ID = 0;
        String name = "Unknown";
        int numGames = 0;
        int age = 10;
        crew = new Crew();
    }

    public Field(int ID, String name, int numGames, int age, Crew crew) {
        this.ID = ID;
        this.name = name;
        this.numGames = numGames;
        this.age = age;
        this.crew = crew;
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

    public Crew getCrew() {
        return crew;
    }

    public void setCrew(Crew crew) {
        this.crew = crew;
    }

    @Override
    public String toString() {
        return "Field{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", numGames=" + numGames +
                ", age=" + age +
                ", crew=" + crew +
                '}';
    }
}
