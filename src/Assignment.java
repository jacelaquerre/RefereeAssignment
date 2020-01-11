import java.util.ArrayList;
import java.util.List;

public class Assignment {

    public enum Day {
        Saturday, Sunday;
    }

    public static void main(String[] args) {
        List<Referee> refList;
        List<Field> fieldList;
        FileIO file = new FileIO();
        file.refFileIO();
        file.fieldFileIO();
        Assignment assignment = new Assignment();
        assignment.assignment();
    }

    public void assignment() {
        Day day = Day.Saturday;
        // Assign Saturday
        while (day == Day.Saturday) {
            // Get Next Field
            // If Field Needs Ref
            // Get Next Ref
            // If available, assign ref make availability to false
        }
        // Assign Saturday
            // Get Next Field
                // If Field Needs Ref
                    // Get Next Ref
                        // If available, assign ref make availability to false
    }

}
