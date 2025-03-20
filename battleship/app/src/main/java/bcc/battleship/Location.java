package bcc.battleship;

public class Location {
    public static final int UNGUESSED = Constants.UNGUESSED;
    public static final int HIT = Constants.HIT;
    public static final int MISSED = Constants.MISSED;

    private boolean shipHere = false;
    private int status = UNGUESSED;

    public boolean checkHit() {
        return status == HIT;
    }

    public boolean checkMiss() {
        return status == MISSED;
    }

    public boolean isUnguessed() {
        return status == UNGUESSED;
    }

    public void markHit() {
        status = HIT;
    }

    public void markMiss() {
        status = MISSED;
    }

    public boolean hasShip() {
        return shipHere;
    }

    public void setShip(boolean val) {
        shipHere = val;
    }

    public void setStatus(int theStatus) {
        status = theStatus;
    }

    public int getStatus() {
        return status;
    }
}