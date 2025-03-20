package bcc.battleship;

public class Grid {
    public static final int NUM_ROWS = 10;
    public static final int NUM_COLS = 10;

    private Location[][] grid = new Location[NUM_ROWS][NUM_COLS];

    public Grid() {
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                grid[i][j] = new Location();
            }
        }
    }

    public void markHit(int row, int col) {
        grid[row][col].markHit();
    }

    public void markMiss(int row, int col) {
        grid[row][col].markMiss();
    }

    public boolean hasShip(int row, int col) {
        return grid[row][col].hasShip();
    }

    public boolean addShip(Ship s) {
        int length = s.getLength();
        int direction = s.getDirection();
        int row = s.getRow();
        int col = s.getCol();

        if (direction == Constants.VERTICAL) {
            if (row + length > NUM_ROWS) return false;
            for (int i = row; i < row + length; i++) {
                if (hasShip(i, col)) return false;
            }
            for (int i = row; i < row + length; i++) {
                grid[i][col].setShip(true);
            }
        } else {
            if (col + length > NUM_COLS) return false;
            for (int j = col; j < col + length; j++) {
                if (hasShip(row, j)) return false;
            }
            for (int j = col; j < col + length; j++) {
                grid[row][j].setShip(true);
            }
        }
        return true;
    }

    public boolean allShipsSank() {
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                if (grid[i][j].hasShip() && !grid[i][j].checkHit()) {
                    return false;
                }
            }
        }
        return true;
    }

    public Location get(int row, int col) {
        return grid[row][col];
    }

    public int getStatus(int row, int col) {
        return grid[row][col].getStatus();
    }

    public void setStatus(int row, int col, int status) {
        grid[row][col].setStatus(status);
    }

    // New methods to get the number of rows and columns
    public int numRows() {
        return NUM_ROWS;
    }

    public int numCols() {
        return NUM_COLS;
    }

    // New method to check if a location has already been guessed
    public boolean alreadyGuessed(int row, int col) {
        return !grid[row][col].isUnguessed();
    }

    // New method to set whether there is a ship at this location
    public void setShip(int row, int col, boolean val) {
        grid[row][col].setShip(val);
    }
}
