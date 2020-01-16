import java.util.ArrayList;
import java.util.List;

public class Assignment {

    public static void main(String[] args) {
        // List<Referee> refList;
        // List<Field> fieldList;
        FileIO file = new FileIO();
        file.refFileIO();
        file.fieldFileIO();
        Assignment assignment = new Assignment();
        assignment.assignment();
    }

    public void assignment() {
        // Set # of days including TBD
        //int numDays = 8;
        // Start day on Saturday
        Field.Day currDay = Field.Day.SATURDAY;
        // Loop Through the week
        for (int i = 0; Field.Day.values().length > i; ++i) {
            // Find fields that have a game that day
            for (int n = 0; FileIO.fieldList.size() > n; ++n) {
                if (FileIO.fieldList.get(n).getDay() == currDay) {
                    // If next field does not have a full crew
                    //if (!(FileIO.fieldList.get(n).Field.games.getCrew().filled())) {
                        // Get Next Ref
                        // If available, assign ref make availability to false
                    //}

                }
            }


            currDay.next();
        }

    }
}
