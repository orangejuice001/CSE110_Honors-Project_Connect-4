import java.util.Scanner;

/**
 * This class is used to TODO add stuff here
 */
public class Main {
    // global scanner for the program
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        // gets the player names from menu
        String[] players = displayMenu();

        // create a new game session and start playing
        GameWorld gameSession = new GameWorld(players);
        gameSession.startPlay();

        // this allows the users to replay the game
        while (true) {
            System.out.print("Would you like to play again? [y/n]: ");
            char userInput = scan.nextLine().charAt(0);

            if (userInput == 'y') {
                // restart the game
                System.out.println("\n\n\nStarting a new game...\n\n\n");
                gameSession.replay();
            } else {
                // invalid or n input will exit the game
                System.out.println("Exiting game. Thank you!");
                break;
            }
        }
    }

    public static String[] displayMenu() {
        String player1Name = "";
        String player2Name = "";

        System.out.println("Welcome to Connect 4!");
        System.out.println("=====================");
        System.out.println();

        System.out.print("Enter Player 1's Name: ");
        player1Name = Main.scan.nextLine();

        System.out.print("Enter Player 2's Name: ");
        player2Name = Main.scan.nextLine();

        // return a 2 index array of player names
        return new String[]{player1Name, player2Name};
    }
}

