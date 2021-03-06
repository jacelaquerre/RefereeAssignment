import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileIO {

    //Delimiters used in the CSV file
    private static final String COMMA_DELIMITER = ",";

    ///////////////////////// REF FILE IO ///////////////////////////////
    public void refFileIO(String filename) {
        BufferedReader br = null;

        try {
            //Reading the csv file
            br = new BufferedReader(new FileReader(filename));

            String line = "";
            //Read to skip the header
            br.readLine();
            //Reading from the second line
            while ((line = br.readLine()) != null) {
                String[] refereeDetails = line.split(COMMA_DELIMITER);
                if (refereeDetails.length > 0) {
                    int ID = Integer.parseInt(refereeDetails[0]);
                    while (Referee.getAllRefNums().contains(ID)) {
                        ID = Game.randInt();
                    }
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
                    Tournament.refList.add(ref);
                }
            }
            System.out.println("File upload successful. Returning to main menu.");

        } catch(FileNotFoundException e) {
            System.out.println("File not found. Returning to main menu.");
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
    }

    ///////////////////////// FIELD FILE IO ///////////////////////////////
    public void fieldFileIO(String filename) {
        BufferedReader buff = null;

        try {
            //Reading the csv file
            buff = new BufferedReader(new FileReader(filename));

            String line = "";
            //Read to skip the header
            buff.readLine();
            //Reading from the second line
            while ((line = buff.readLine()) != null) {
                String[] fieldDetails = line.split(COMMA_DELIMITER);
                if (fieldDetails.length > 0) {
                    int ID = Integer.parseInt(fieldDetails[0]);
                    while (Field.getAllFieldNums().contains(ID)) {
                        ID = Game.randInt();
                    }
                    String name = fieldDetails[1];
                    int numGames = Integer.parseInt(fieldDetails[2]);
                    int age = Integer.parseInt(fieldDetails[3]);
                    String stringDay = fieldDetails[4];
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
                    //Save the field details in Referee object
                    /* May need to change games variable here */
                    Field field = new Field(ID, name, numGames, age, day, games);
                    Tournament.fieldList.add(field);
                }
            }
            System.out.println("File upload successful. Returning to main menu.");
        } catch(FileNotFoundException e) {
            System.out.println("File not found. Returning to main menu.");
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
    }

    public void scheduleOut() {
        try {
            FileWriter outFile = new FileWriter("Tournament.txt");

            for (Field.Day day : Field.Day.values()) {
                outFile.write("\n");
                outFile.write(day + "\n");

                // Find fields that have a game that day
                for (int n = 0; Tournament.fieldList.size() > n; ++n) {
                    if (Tournament.fieldList.get(n).getDay() == day) {
                        outFile.write(Tournament.fieldList.get(n).toString()+ "\n");
                        outFile.write(Tournament.fieldList.get(n).getGames().toString() + "\n");
                    }
                }
            }
            // Close file
            outFile.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void printRefereeList() {
        try {
            FileWriter outFile = new FileWriter("RefereeList.txt");

            outFile.write("List of Referee's signed up fo the Tournament");
            outFile.write("\n");
            for (int n = 0; Tournament.refList.size() > n; ++n) {
                outFile.write(Tournament.refList.get(n).toString()+ "\n");
            }
            // Close file
            outFile.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}