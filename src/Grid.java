/**
 * This class is used to TODO add stuff here
 */
public class Grid {

    // static number of rows and columns for the connect 4 grid
    public static final int NUM_ROWS = 6;
    public static final int NUM_COLS = 7;

    // 2D grid with character representation of player R or Y
    public final char[][] mainGrid;

    /**
     * Constructor initializes a new Grid will null initial values
     */
    public Grid() {
        this.mainGrid = new char[NUM_ROWS][NUM_COLS];

        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++) {
                this.mainGrid[row][col] = '_';
            }
        }
    }

    /**
     * This method TODO write stuff here
     *
     * @param coin: represents the player coin as R(ed) or Y(ellow)
     * @param col:  the column in which player wants to drop the coin
     * @return 1 = increment turn; 0 = column full, pick another column.
     */
    public int dropChip(char coin, int col) {
        for (int row = Grid.NUM_ROWS - 1; row >= 0; row--) {
            if (this.mainGrid[row][col - 1] == '_') {
                this.mainGrid[row][col - 1] = coin;
                return 1;
            }
        }

        System.out.println("Column " + col + " is full! Please pick another column.");
        return 0; // col is full
    }

    /*
        This method prints the current state of the grid.
     */
    public void printGrid() {
        for (int row = 0; row < NUM_ROWS; row++) {
            System.out.print("| ");
            for (int col = 0; col < NUM_COLS; col++) {
                System.out.print(this.mainGrid[row][col] + " | ");
            }
            System.out.println();
        }
    }

    /*
        This utility method resets the grid to empty for a new game.
        Avoids re-creation of objects.
     */
    public void resetGrid() {
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++) {
                this.mainGrid[row][col] = '_';
            }
        }
    }
}





