package bcc.battleship;

public class Ship {
    private int row;
    private int col;
    private int length;
    private int direction;

    // Constructor that initializes length, direction, row, and column
    public Ship(int length) {
        this.length = length;
        this.row = Constants.UNSET;
        this.col = Constants.UNSET;
        this.direction = Constants.UNSET;
    }

    public Ship(int length, int direction, int row, int col) {
        this.length = length;
        this.direction = direction;
        this.row = row;
        this.col = col;
    }

    public boolean isLocationSet() {
        return row != Constants.UNSET && col != Constants.UNSET;
    }

    public boolean isDirectionSet() {
        return direction != Constants.UNSET;
    }

    public void setLocation(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getLength() {
        return length;
    }

    public int getDirection() {
        return direction;
    }

    private String directionToString() {
        if (direction == Constants.HORIZONTAL) {
            return "horizontal";
        } else if (direction == Constants.VERTICAL) {
            return "vertical";
        } else {
            return "unset direction";
        }
    }

    private String locationToString() {
        if (isLocationSet()) {
            return "(" + row + ", " + col + ")";
        } else {
            return "(unset location)";
        }
    }

    @Override
    public String toString() {
        return directionToString() + " ship of length " + getLength() + " at " + locationToString();
    }
}
