/**
 * This class is used to TODO add stuff here
 */
public class GameWorld {
    private final String player1;
    private final String player2;
    private Grid grid;

    /**
     * The constructor initializes the game world by assigning the players and creating a new grid
     *
     * @param players
     */
    public GameWorld(String[] players) {
        grid = new Grid();

        this.player1 = players[0];
        this.player2 = players[1];

        System.out.println();
        System.out.println(this.player1 + " is Red");
        System.out.println(this.player2 + " is Yellow");
    }

    /**
     * TODO: Write your own comments here
     *
     * @return a boolean value. True = win condition satisfied; False = no win condition satisfied.
     */
    public boolean checkWin() {
        //horizontal
        for (int row = 0; row < Grid.NUM_ROWS; row++) {
            int count = 0;
            for (int col = 0; col < Grid.NUM_COLS - 1; col++) {
                if ((this.grid.mainGrid[row][col] == 'R') || (this.grid.mainGrid[row][col] == 'Y')) {
                    if (this.grid.mainGrid[row][col] == this.grid.mainGrid[row][col + 1]) {
                        count++;
                    } else {
                        count = 0;
                    }
                    if (count == 3) {
                        System.out.println("Game Over!");
                        return true;
                    }
                }
            }
        }

        // vertical
        for (int col = 0; col < Grid.NUM_COLS; col++) {
            int count = 0;
            for (int row = Grid.NUM_ROWS - 1; row > 0; row--) {
                if ((this.grid.mainGrid[row][col] == 'R') || (this.grid.mainGrid[row][col] == 'Y')) {
                    if (this.grid.mainGrid[row][col] == this.grid.mainGrid[row - 1][col]) {
                        count++;
                    } else {
                        count = 0;
                    }
                    if (count == 3) {
                        System.out.println("game over - vertical");
                        return true;
                    }
                }

            }
        }

        //forward diagonal
        for (int col = 0; col < Grid.NUM_COLS; col++) {
            int count = 0;
            for (int row = Grid.NUM_ROWS - 1; row > 0; row--) {
                if ((this.grid.mainGrid[row][col] == 'R') || (this.grid.mainGrid[row][col] == 'Y')) {
                    if ((row > 2) && (col < 4)) {
                        for (int j = 1; j < 4; j++) {
                            if (this.grid.mainGrid[row][col] == this.grid.mainGrid[row - j][col + j]) {
                                count++;
                            } else {
                                count = 0;
                            }
                        }
                    }
                    if (count == 3) {
                        System.out.println("game over- forward diagonal");
                        return true;
                    }
                }
            }
        }

        //back diagonal
        for (int col = 0; col < Grid.NUM_COLS; col++) {
            int count = 0;
            for (int row = Grid.NUM_ROWS - 1; row > 0; row--) {
                if ((this.grid.mainGrid[row][col] == 'R') || (this.grid.mainGrid[row][col] == 'Y')) {
                    if ((row > 2) && (col > 2)) {
                        for (int j = 1; j < 4; j++) {
                            if (this.grid.mainGrid[row][col] == this.grid.mainGrid[row - j][col - j]) {
                                count++;
                            } else {
                                count = 0;
                            }
                        }
                    }
                    if (count == 3) {
                        System.out.println("game over- backward diagonal");
                        return true;
                    }
                }
            }
        }

        return false;
    }

    /**
     * This method controls the gameplay.
     * Starts with the turnCounter at 0 and updates based on the value returned by the Grid's dropChip method.
     * Checks for win criteria at the beginning of each turn and continues with the turn if no one has one.
     * <p>
     * turnCounter: used to keep track of player turns. Even = Player 1; Odd = Player 2
     * playerColumnChoice: user input of the column they would like to play in
     */
    public void startPlay() {
        int turnCounter = 0;

        while (!checkWin()) {
            int playerColumnChoice;

            if (turnCounter % 2 == 0) {
                System.out.print("\n\n" + this.player1 + "'s turn, pick a column [1-7]: ");
                while (!Main.scan.hasNextInt()) {
                    Main.scan.nextLine();
                    System.out.print("Please enter a valid number between 1 and 7: ");
                }
                playerColumnChoice = Main.scan.nextInt();
                turnCounter += grid.dropChip('R', playerColumnChoice);
            } else {
                System.out.print("\n\n" + this.player2 + "'s turn, pick a column [1-7]: ");
                while (!Main.scan.hasNextInt()) {
                    Main.scan.nextLine();
                    System.out.print("Please enter a valid number between 1 and 7: ");
                }
                playerColumnChoice = Main.scan.nextInt();
                turnCounter += grid.dropChip('Y', playerColumnChoice);
            }

            grid.printGrid(); // print grid after each turn
        }

        // declare the winner
        if (turnCounter % 2 == 0) {
            System.out.println("\n\n" + this.player1 + "won!");
        } else {
            System.out.println(this.player2 + "won!");
        }
    }

    /**
     * this utility method creates a new grid and restarts the game
     */
    public void replay() {
        this.grid.resetGrid();
        this.startPlay();
    }
}
