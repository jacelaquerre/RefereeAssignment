public class Field {

    private int ID;
    private String name;
    private int numGames;
    private int age;
    private Referee CR;
    private Referee AR1;
    private Referee AR2;
    private Referee standBy;

    public Field() {
        int ID = 0;
        String name = "Unknown";
        int numGames = 0;
        int age = 10;
        Referee CR = new Referee();
        Referee AR1 = new Referee();
        Referee AR2 = new Referee();
        Referee standBy = new Referee();
    }

    public Field(int ID, String name, int numGames, int age, Referee CR, Referee AR1, Referee AR2, Referee standBy) {
        this.ID = ID;
        this.name = name;
        this.numGames = numGames;
        this.age = age;
        this.CR = CR;
        this.AR1 = AR1;
        this.AR2 = AR2;
        this.standBy = standBy;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumGames(int numGames) {
        this.numGames = numGames;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCR(Referee CR) {
        this.CR = CR;
    }

    public void setAR1(Referee AR1) {
        this.AR1 = AR1;
    }

    public void setAR2(Referee AR2) {
        this.AR2 = AR2;
    }

    public void setStandBy(Referee standBy) {
        this.standBy = standBy;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getNumGames() {
        return numGames;
    }

    public int getAge() {
        return age;
    }

    public Referee getCR() {
        return CR;
    }

    public Referee getAR1() {
        return AR1;
    }

    public Referee getAR2() {
        return AR2;
    }

    public Referee getStandBy() {
        return standBy;
    }

    @Override
    public String toString() {
        return "Field{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", numGames=" + numGames +
                ", age=" + age +
                ", CR=" + CR +
                ", AR1=" + AR1 +
                ", AR2=" + AR2 +
                ", standBy=" + standBy +
                '}';
    }
}
