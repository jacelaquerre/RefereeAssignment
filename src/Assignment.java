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
                                for (int k = 0; FileIO.refList.size() > k; ++k) {
                                    //TODO://////////// EXPAND MORE DAYS HERE ///////////////
                                    // Would need to expand csv file and Availability class
                                    // Check if Available on Saturday
                                    if (FileIO.fieldList.get(n).getDay() == Field.Day.SATURDAY) {
                                        // See if Ref is available on Sunday
                                        if (FileIO.refList.get(k).getAval().isSatAvail()) {
                                            assignRef(k, n, j);
                                        }
                                    }
                                    // GAME IS SUNDAY
                                    else {
                                        if (FileIO.refList.get(k).getAval().isSunAvail()) {
                                            assignRef(k, n, j);
                                        }
                                    }
                                }
                            }
                        }
                        // Field is full sized
                        else {
                            if (!(FileIO.fieldList.get(n).getGame(j).getCrew().filledFull())) {
                                for (int k = 0; FileIO.refList.size() > k; ++k) {
                                    //TODO://////////// EXPAND MORE DAYS HERE ///////////////
                                    // Would need to expand csv file and Availability class
                                    // Check if Available on Saturday
                                    if (FileIO.fieldList.get(n).getDay() == Field.Day.SATURDAY) {
                                        // See if Ref is available on Sunday
                                        if (FileIO.refList.get(k).getAval().isSatAvail()) {
                                            assignRef(k, n, j);
                                        }
                                    }
                                    // GAME IS SUNDAY
                                    else {
                                        if (FileIO.refList.get(k).getAval().isSunAvail()) {
                                            assignRef(k, n, j);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            currDay = currDay.next();
        }

    }

    public void assignRef(int k, int n, int j) {
        // Check if game is within age high and low preference
        //TODO: Need to see how to stop alg from keep assigning same ref to diff
        // Fields and stop when getting max games
        if ((FileIO.refList.get(k).getHigh() >= FileIO.fieldList.get(n).getAge())
                & (FileIO.refList.get(k).getLow() <= FileIO.fieldList.get(n).getAge())) {
            // See what position is open on crew and assign to it
            if (FileIO.fieldList.get(n).getGame(j).getCrew().getCR().equals("Unknown")) {
                // Assign ref to CR position
                FileIO.fieldList.get(n).getGame(j).getCrew().setCR(FileIO.refList.get(k));

            }
        }
    }
}
