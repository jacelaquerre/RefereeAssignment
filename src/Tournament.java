import java.util.ArrayList;
import java.util.List;

public class Tournament {

    public static final int SMALL_SIDED = 12;
    public int numFields;
    // Create List for holding Referee objects
    public static List<Referee> refList = new ArrayList<>();
    // Create List for holding Field objects
    public static List<Field> fieldList = new ArrayList<>();
    // List of all Games
    public static List<Game> gameList = new ArrayList<>();

    public Tournament() {
        numFields = 0;
        fieldList = new ArrayList<>();
        refList = new ArrayList<>();
        gameList = new ArrayList<>();
    }
    public Tournament(int numFields, List<Field> fieldList, List<Referee> refList, List<Game> gameList) {
        this.numFields = numFields;
        Tournament.fieldList = fieldList;
        Tournament.refList = refList;
        Tournament.gameList = gameList;
    }

    public int getNumFields() {
        return numFields;
    }

    public void setNumFields(int numFields) {
        this.numFields = numFields;
    }

    public static List<Field> getFieldList() {
        return fieldList;
    }

    public static void setFieldList(List<Field> fieldList) {
        Tournament.fieldList = fieldList;
    }

    public static List<Referee> getRefList() {
        return refList;
    }

    public static void setRefList(List<Referee> refList) {
        Tournament.refList = refList;
    }

    public static List<Game> getGameList() {
        return gameList;
    }

    public static void setGameList(List<Game> gameList) {
        Tournament.gameList = gameList;
    }

    @Override
    public String toString() {
        return "Tournament{" +
                "numFields=" + numFields +
                "Field List: " + Tournament.fieldList.toString() +
                "Referee List: " + Tournament.refList.toString() +
                '}';
    }

    public void printRefList() {
        System.out.println(Tournament.refList.toString());
    }

    public void printFieldList() {
        System.out.println(Tournament.fieldList.toString());
    }

    public void assignField(int fieldID, int refID) {
        Referee ref = findRef(refID);
        int fieldIndex = fieldList.indexOf(findField(fieldID));
        Field.Day fieldDay = fieldList.get(fieldIndex).getDay();
        boolean refIsAval = false;
        if (fieldDay == Field.Day.SATURDAY) {
            refIsAval = ref.getAval().isSatAvail();
        }
        else if (fieldDay == Field.Day.SUNDAY) {
            refIsAval = ref.getAval().isSunAvail();
        }
        else { // TBD case
            if (!ref.getAval().isSatAvail() || !ref.getAval().isSunAvail()) {
                System.out.println("Cannot Assign, Referee may not be available.");
                refIsAval = false;
            }
        }
        if(refIsAval) {
            if (fieldList.get(fieldIndex).getAge() <= SMALL_SIDED) {
                for (int i = 0; i < fieldList.get(fieldIndex).getGames().size(); ++i) {
                    assignSmall(findGame(i), ref, fieldIndex);
                }
            }
            else {
                for (int i = 0; i < fieldList.get(fieldIndex).getGames().size(); ++i) {
                    Game game = fieldList.get(fieldIndex).getGame(i);
                    assignFull(game, ref, fieldIndex);
                }
            }
        }
        else {
            System.out.println("Cannot Assign, Referee is not available on that day.");
        }
    }

    public void assignGame(int gameID, int refID) {
        Referee ref = findRef(refID);
        Field field = Game.fieldFromGame(gameID);
        Game game = findGame(gameID);
        assert field != null;
        int fieldIndex = fieldList.indexOf(findField(field.getID()));
        Field.Day fieldDay = fieldList.get(fieldIndex).getDay();
        boolean refIsAval = false;
        if (fieldDay == Field.Day.SATURDAY) {
            refIsAval = ref.getAval().isSatAvail();
        }
        else if (fieldDay == Field.Day.SUNDAY) {
            refIsAval = ref.getAval().isSunAvail();
        }
        else { // TBD case
            if (!ref.getAval().isSatAvail() || !ref.getAval().isSunAvail()) {
                System.out.println("Cannot Assign, Referee may not be available.");
                refIsAval = false;
            }
        }
        if(refIsAval) {
            if (fieldList.get(fieldIndex).getAge() <= SMALL_SIDED) {
                assignSmall(game, ref, fieldIndex);
            } else {
                assignFull(game, ref, fieldIndex);
            }
        } else {
            System.out.println("Cannot Assign, Referee is not available on that day.");
        }
    }

    public static void assignFull(Game game, Referee ref, int fieldIndex) {
        if (!game.getCrew().filledFull()) {
            if (checkRefFactors(ref, fieldIndex)) {
                if (game.getCrew().getCR().getName().equals("Unknown")) {
                    game.getCrew().setCR(ref);
                } else if (game.getCrew().getAR1().getName().equals("Unknown")) {
                    game.getCrew().setAR1(ref);
                } else if (game.getCrew().getAR2().getName().equals("Unknown")) {
                    game.getCrew().setAR2(ref);
                } else if (game.getCrew().getStandBy().getName().equals("Unknown")) {
                    game.getCrew().setStandBy(ref);
                }
                Referee.updateGameCount(ref, fieldList.get(fieldIndex).getDay());
            }
        } else {
            System.out.println("Cannot Assign, game is already fully assigned.");
        }
    }
    public static void assignSmall(Game game, Referee ref, int fieldIndex) {
        if (!game.getCrew().filledSmall()) {
            if (checkRefFactors(ref, fieldIndex)) {
                game.getCrew().setCR(ref);
                Referee.updateGameCount(ref, fieldList.get(fieldIndex).getDay());
            }
        } else {
            System.out.println("Cannot Assign, game is already fully assigned.");
        }
    }

    // Checks if the game is in the referee's comfort level and also if
    // it does not exceed their max games per day
    public static boolean checkRefFactors(Referee ref, int fieldIndex) {
        int age = fieldList.get(fieldIndex).getAge();
        Field.Day day = fieldList.get(fieldIndex).getDay();
        if (age < ref.getHigh() || age > ref.getLow()) {
            if (day == Field.Day.SATURDAY) {
                if (ref.getSatNumGames() > ref.getMaxGames()) {
                    System.out.println("Cannot Assign, referee has reached their " +
                            "maximum number of games for this day.");
                    return false;
                }
            } else if (day == Field.Day.SUNDAY) {
                if (ref.getSunNumGames() > ref.getMaxGames()) {
                    System.out.println("Cannot Assign, referee has reached their " +
                            "maximum number of games for this day.");
                    return false;
                }
            } else {
                return true;
            }
        } else {
            System.out.println("Cannot Assign, Player age is not in referee's comfort zone.");
            return false;
        }
        return false;
    }

    public Referee findRef(int ID) {
        for (Referee ref : refList) {
            if (ref.getID() == ID) {
                return ref;
            }
        }
        return null;
    }

    public Field findField(int ID) {
        for (Field field : fieldList) {
            if (field.getID() == ID) {
                return field;
            }
        }
        return null;
    }

    public Game findGame(int ID) {
        for (Game game : gameList) {
            if (game.getID() == ID) {
                return game;
            }
        }
        return null;
    }

}