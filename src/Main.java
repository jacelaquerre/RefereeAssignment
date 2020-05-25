import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to the Tournament Referee Assignment System");

        Scanner scan = new Scanner(System.in);
        int choice = getChoice(scan);
        Tournament tourn = new Tournament();
        FileIO fileIO = new FileIO();

        boolean finished = false;
        while (!finished) {
            switch (choice) {
                case 1:
                    System.out.print("Enter the name of the file: ");
                    String filename = scan.next();
                    fileIO.fieldFileIO(filename);
                    choice = getChoice(scan);
                    break;
                case 2:
                    System.out.print("Enter the name of the file: ");
                    String filename2 = scan.next();
                    fileIO.refFileIO(filename2);
                    choice = getChoice(scan);
                    break;
                case 3:
                    fileIO.scheduleOut();
                    choice = getChoice(scan);
                    break;
                case 4:
                    fileIO.printRefereeList();
                    choice = getChoice(scan);
                    break;
                case 5:
                    Field.addField(scan);
                    choice = getChoice(scan);
                    break;
                case 6:
                    Referee.addReferee(scan);
                    choice = getChoice(scan);
                    break;
                case 7:
                    System.out.print("Enter the game ID: ");
                    int gameID = scan.nextInt();
                    try {
                        if (Crew.crewFilled(gameID, tourn)) {
                            System.out.print("The crew for this game is assigned.");
                        } else {
                            System.out.print("There are unassigned crew members for this game.");
                        }
                        choice = getChoice(scan);
                    } catch (NullPointerException e) {
                        choice = getChoice(scan);
                    }
                case 8:
                    System.out.print("Enter the field ID: ");
                    int fieldID = scan.nextInt();
                    System.out.print("Enter the referee's ID: ");
                    int refID = scan.nextInt();
                    tourn.assignField(fieldID, refID);
                    choice = getChoice(scan);
                case 9:
                    System.out.print("Enter the game ID: ");
                    gameID = scan.nextInt();
                    System.out.print("Enter the referee's ID: ");
                    refID = scan.nextInt();
                    tourn.assignGame(gameID, refID);
                    choice = getChoice(scan);
                case 10:
                    finished = true;
                    break;
            }
        }
        // Closing Scanner after the use
        scan.close();
    }

    public static int getChoice(Scanner scan) {
        System.out.println("\nCommands: ");
        System.out.println("1 - Load field list from csv file");
        System.out.println("2 - Load referee list from csv file");
        System.out.println("3 - Output Tournament schedule to txt file");
        System.out.println("4 - Output referee list to a txt file");
        System.out.println("5 - Manually add field");
        System.out.println("6 - Manually add Referee");
        System.out.println("7 - Check if crew on a game is full or not");
        System.out.println("8 - Assign referee to a field");
        System.out.println("9 - Assign referee to a game");
        System.out.println(("10 - Exit"));

        System.out.print("Enter a number: ");
        int choice = scan.nextInt();
        while (choice < 1 || choice > 11) {
            System.out.print("Enter a number: ");
            choice = scan.nextInt();
        }
        return choice;
    }


}
