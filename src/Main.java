import java.util.ArrayList;
import java.util.List;
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
        System.out.println("7 - Check if crew on a field is full or not");
        System.out.println("8 - Assign referee to a field");
        System.out.println(("9 - Exit"));

        Scanner scan = new Scanner(System.in);
        //////// TODO: Input validation?
        System.out.print("Enter a number: ");
        int choice = scan.nextInt();
        //while (choice < 1 && choice > 10) {
        //    System.out.print("Enter a number: ");
        //    int choice = scan.nextInt();
        //}
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
                    System.out.println(Tournament.fieldList.toString());
                    break;
                case 4:
                    System.out.println(Tournament.refList.toString());
                    break;
                case 5:
                    Field.addField(scan);
                    break;
                case 6:
                    addReferee(scan);
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    finished = true;
                    break;
            }
        }

        // Closing Scanner after the use
        scan.close();
    }


    // int ID, String name, Availibility aval, int high, int low, int maxGames
    public static void addReferee(Scanner scan) {
        // TODO: check for overlap in variables
        System.out.print("Enter Referee's ID");
        int ID = scan.nextInt();
        System.out.print("Enter Referee's name");
        String name = scan.next();
        System.out.print("Enter Referee's ID");
        int ID = scan.nextInt();
        System.out.print("Enter Referee's ID");
        int ID = scan.nextInt();
        System.out.print("Enter Referee's ID");
        int ID = scan.nextInt();
    }
}
