import java.util.ArrayList;
import java.util.List;

public class Tournament {

    private static final int SMALL_SIDED = 12;
    private int numFields;
    // Create List for holding Referee objects
    public static List<Referee> refList = new ArrayList<>();
    // Create List for holding Field objects
    public static List<Field> fieldList = new ArrayList<>();

    public Tournament() {
        numFields = 0;
        fieldList = new ArrayList<>();
        refList = new ArrayList<>();
    }
    public Tournament(int numFields, List<Field> fieldList, List<Referee> refList) {
        this.numFields = numFields;
        Tournament.fieldList = fieldList;
        Tournament.refList = refList;
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
                    if (!fieldList.get(fieldIndex).getGame(i).getCrew().filledSmall()) {
                        fieldList.get(fieldIndex).getGame(i).getCrew().setCR(ref);
                    }
                }
            }
            else {
                for (int i = 0; i < fieldList.get(fieldIndex).getGames().size(); ++i) {
                    if (!fieldList.get(fieldIndex).getGame(i).getCrew().filledFull()) {
                        if (fieldList.get(fieldIndex).getGame(i).getCrew().getCR().getName().equals("Unknown")) {
                            fieldList.get(fieldIndex).getGame(i).getCrew().setCR(ref);
                        } else if (fieldList.get(fieldIndex).getGame(i).getCrew().getAR1().getName().equals("Unknown")) {
                            fieldList.get(fieldIndex).getGame(i).getCrew().setAR1(ref);
                        } else if (fieldList.get(fieldIndex).getGame(i).getCrew().getAR2().getName().equals("Unknown")) {
                            fieldList.get(fieldIndex).getGame(i).getCrew().setAR2(ref);
                        } else if (fieldList.get(fieldIndex).getGame(i).getCrew().getStandBy().getName().equals("Unknown")) {
                            fieldList.get(fieldIndex).getGame(i).getCrew().setStandBy(ref);
                        }
                    }
                }
            }
        }
        else {
            System.out.println("Cannot Assign, Referee is not available on that day.");
        }
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
}