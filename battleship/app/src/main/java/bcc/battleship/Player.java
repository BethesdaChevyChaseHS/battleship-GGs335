package bcc.battleship;
import bcc.battleship.Constants;

public class Player {
    private Grid myGrid;
    private Grid opponentGrid;

    public Player() {
        myGrid = new Grid();
        opponentGrid = new Grid();
    }

    public Grid getMyGrid() {
        return myGrid;
    }

    public Grid getOpponentGrid() {
        return opponentGrid;
    }

    public boolean recordOpponentGuess(int row, int col) {
        if (myGrid.alreadyGuessed(row, col)) {
            return false; 
        }

        boolean hit = myGrid.hasShip(row, col);
        if (hit) {
            myGrid.markHit(row, col);
            myGrid.setStatus(row, col, Constants.HIT);
        } else {
            myGrid.markMiss(row, col);
            myGrid.setStatus(row, col, Constants.MISSED);
        }

        return hit;
    }

    // Method to choose a ship location and direction
    public boolean chooseShipLocation(int shipIndex, int row, int col, int direction) {
        Ship ship = new Ship(Constants.SHIP_LENGTHS[shipIndex]);
        ship.setLocation(row, col);
        ship.setDirection(direction);
        
        // Try to add the ship to the grid
        return myGrid.addShip(ship);
    }

    // Optional method to check if all ships are sunk
    public boolean allShipsSunk() {
        return myGrid.allShipsSank();
    }

    // Optional method to reset player grids if needed
    public void resetGrids() {
        myGrid = new Grid();
        opponentGrid = new Grid();
    }
}
