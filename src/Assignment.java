import java.util.ArrayList;
import java.util.List;

public class Assignment {

    private static final int SMALL_SIDED = 12;

    public static void main(String[] args) {
        FileIO file = new FileIO();
        file.refFileIO();
        file.fieldFileIO();
        Assignment assignment = new Assignment();
        assignment.assignment();
    }

    public void assignment() {

        // Start day on Saturday
        Field.Day currDay = Field.Day.SATURDAY;

        // Loop Through the week
        for (int i = 0; Field.Day.values().length > i; ++i) {
            // Find fields that have a game that day
            for (int n = 0; FileIO.fieldList.size() > n; ++n) {
                if (FileIO.fieldList.get(n).getDay() == currDay) {
                    // Loop through all games on the field
                    for (int j = 0; FileIO.fieldList.get(n).getNumGames() > j; ++j) {
                        // Determine if the field is small sided (1 ref) or full (3-4 refs)
                        if (FileIO.fieldList.get(n).getAge() <= SMALL_SIDED) {
                            // Determine if game needs refs to be assigned to it
                            if (!(FileIO.fieldList.get(n).getGame(j).getCrew().filledSmall())) {
                                // Get Next Ref
                                    // If available, assign ref make availability to false
                            }
                        }
                        else {
                            if (!(FileIO.fieldList.get(n).getGame(j).getCrew().filledFull())) {
                                // Get Next Ref
                                // If available, assign ref make availability to false
                            }
                        }
                    }
                }
            }
            currDay = currDay.next();
        }


    }
}
