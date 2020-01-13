import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileIO {

    //Delimiters used in the CSV file
    private static final String COMMA_DELIMITER = ",";
    //Create List for holding Referee objects
    public static List<Referee> refList = new ArrayList<>();
    //Create List for holding Field objects
    public static List<Field> fieldList = new ArrayList<>();

    public List<Referee> refFileIO() {
        ///////////////////////// REF FILE IO ///////////////////////////////
        String refFileName = "referee.csv";
        BufferedReader br = null;

        try {
            //Reading the csv file
            br = new BufferedReader(new FileReader(refFileName));

            String line = "";
            //Read to skip the header
            br.readLine();
            //Reading from the second line
            while ((line = br.readLine()) != null) {
                String[] refereeDetails = line.split(COMMA_DELIMITER);
                if (refereeDetails.length > 0) {
                    int ID = Integer.parseInt(refereeDetails[0]);
                    String name = refereeDetails[1];
                    boolean satAvail = false;
                    if (refereeDetails[2].equals("TRUE")) {
                        satAvail = true;
                    }
                    boolean sunAvail = false;
                    if (refereeDetails[3].equals("TRUE")) {
                        sunAvail = true;
                    }
                    Availibility aval = new Availibility(satAvail, sunAvail);
                    int high = Integer.parseInt(refereeDetails[4]);
                    int low = Integer.parseInt(refereeDetails[5]);
                    int maxGames = Integer.parseInt(refereeDetails[6]);
                    //Save the ref details in Referee object
                    Referee ref = new Referee(ID, name, aval, high, low, maxGames);
                    refList.add(ref);
                }
            }
            System.out.println(refList.toString());
        } catch (Exception ee) {
            ee.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ie) {
                System.out.println("Error occured while closing the BufferedReader");
                ie.printStackTrace();
            }
        }
        return refList;
    }

    ///////////////////////// FIELD FILE IO ///////////////////////////////
    public List<Field> fieldFileIO() {
        String fieldFileName = "schedule.csv";
        BufferedReader buff = null;

        try {
            //Reading the csv file
            buff = new BufferedReader(new FileReader(fieldFileName));

            String line = "";
            //Read to skip the header
            buff.readLine();
            //Reading from the second line
            while ((line = buff.readLine()) != null) {
                String[] fieldDetails = line.split(COMMA_DELIMITER);
                if (fieldDetails.length > 0) {
                    int ID = Integer.parseInt(fieldDetails[0]);
                    String name = fieldDetails[1];
                    int numGames = Integer.parseInt(fieldDetails[2]);
                    int age = Integer.parseInt(fieldDetails[3]);
                    String stringDay = fieldDetails[4];
                    Field.Day day;
                    switch(stringDay) {
                        case "Sunday":
                            day = Field.Day.Sunday;
                            break;
                        case "Monday":
                            day = Field.Day.Monday;
                            break;
                        case "Tuesday":
                            day = Field.Day.Tuesday;
                            break;
                        case "Wednesday":
                            day = Field.Day.Wednesday;
                            break;
                        case "Thursday":
                            day = Field.Day.Thursday;
                            break;
                        case "Saturday":
                            day = Field.Day.Saturday;
                            break;
                        default:
                            day = Field.Day.TBD;
                    }
                    List<Game> games = new ArrayList<Game>();
                    //Save the ref details in Referee object
                    /* May need to change games variable here */
                    Field field = new Field(ID, name, numGames, age, day, games);
                    fieldList.add(field);
                }
            }
            System.out.println(fieldList.toString());
        } catch (Exception ee) {
            ee.printStackTrace();
        } finally {
            try {
                if (buff != null) {
                    buff.close();
                }
            } catch (IOException ie) {
                System.out.println("Error occured while closing the BufferedReader");
                ie.printStackTrace();
            }
        }
        return fieldList;
    }
}
