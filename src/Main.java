import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to the Tournament Referee Assignment System");
        System.out.println("Commands: ");
        System.out.println("1 - Load field list from csv file");
        System.out.println("2 - Load referee list from csv file");
        System.out.println("3 - Print field list");
        System.out.println("4 - Print referee list");
        System.out.println("5 - Manually add field");
        System.out.println("6 - Manually add Referee");
        System.out.println("7 - Check if crew on a game is full or not");
        System.out.println("8 - Assign referee to a field");
        System.out.println("9 - Assign referee to a game");
        System.out.println(("10 - Exit"));

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int choice = scan.nextInt();
        while (choice < 1 || choice > 11) {
            System.out.print("Enter a number: ");
            choice = scan.nextInt();
        }

        Tournament tourn = new Tournament();

        boolean finished = false;
        while (!finished) {
            switch (choice) {
                case 1:
                    FileIO fileIO = new FileIO();
                    System.out.print("Enter the name of the file: ");
                    String filename = scan.next();
                    fileIO.fieldFileIO(filename);
                    break;
                case 2:
                    FileIO fileIO2 = new FileIO();
                    System.out.print("Enter the name of the file: ");
                    String filename2 = scan.next();
                    fileIO2.refFileIO(filename2);
                    break;
                case 3:
                    tourn.printFieldList();
                    break;
                case 4:
                    tourn.printRefList();
                    break;
                case 5:
                    Field.addField(scan);
                    break;
                case 6:
                    Referee.addReferee(scan);
                    break;
                case 7:
                    System.out.print("Enter the game ID: ");
                    int gameID = scan.nextInt();
                    if (Crew.crewFilled(gameID, tourn)) {
                        System.out.print("The crew for this game is assigned");
                    }
                case 8:
                    System.out.print("Enter the field ID: ");
                    int fieldID = scan.nextInt();
                    System.out.print("Enter the referee's ID: ");
                    int refID = scan.nextInt();
                    tourn.assignField(fieldID, refID);
                case 9:
                    System.out.print("Enter the game ID: ");
                    gameID = scan.nextInt();
                    System.out.print("Enter the referee's ID: ");
                    refID = scan.nextInt();
                    tourn.assignGame(gameID, refID);
                case 10:
                    finished = true;
                    break;
            }
        }
        // Closing Scanner after the use
        scan.close();
    }




}
