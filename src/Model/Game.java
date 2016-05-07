package Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {

    private static final int NUM_ROWS = 3;
    private static final int NUM_COLUMNS = NUM_ROWS;

    private int currentPlayer;
    private List<String> locations;
    private Set<Integer> xVals;
    private Set<Integer> oVals;
    private String winner;

    // creates new game
    // EFFECTS: Constructs a game.
    public Game() {
        currentPlayer = 1;

        locations = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            locations.add("");
        }

        xVals = new HashSet<>();
        oVals = new HashSet<>();

        winner = "";
    }

    public int getNumRows() {
        return NUM_ROWS;
    }

    public int getNumColumns() {
        return NUM_COLUMNS;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public String getWinner() {
        return winner;
    }

    public String getLocation(int index) {
        return locations.get(index);
    }

    public void playerMove(int position) {

        if (currentPlayer == 1 && locations.get(position - 1).length() == 0) {
            locations.remove(position - 1);
            locations.add(position - 1, "X");
            xVals.add(position);
            currentPlayer = 2;
        }

        else if (currentPlayer == 2 && locations.get(position - 1).length() == 0) {
            locations.remove(position - 1);
            locations.add(position - 1, "O");
            oVals.add(position);
            currentPlayer = 1;
        }
    }

    public boolean IsOver() {

        if     (xVals.contains(1) && xVals.contains(2) && xVals.contains(3) ||
                xVals.contains(1) && xVals.contains(4) && xVals.contains(7) ||
                xVals.contains(1) && xVals.contains(5) && xVals.contains(9) ||
                xVals.contains(2) && xVals.contains(5) && xVals.contains(8) ||
                xVals.contains(3) && xVals.contains(6) && xVals.contains(9) ||
                xVals.contains(3) && xVals.contains(5) && xVals.contains(7) ||
                xVals.contains(4) && xVals.contains(5) && xVals.contains(6) ||
                xVals.contains(7) && xVals.contains(8) && xVals.contains(9)) {
                    winner = "Player 1";
                    return true;
        }

        else if (oVals.contains(1) && oVals.contains(2) && oVals.contains(3) ||
                 oVals.contains(1) && oVals.contains(4) && oVals.contains(7) ||
                 oVals.contains(1) && oVals.contains(5) && oVals.contains(9) ||
                 oVals.contains(2) && oVals.contains(5) && oVals.contains(8) ||
                 oVals.contains(3) && oVals.contains(6) && oVals.contains(9) ||
                 oVals.contains(3) && oVals.contains(5) && oVals.contains(7) ||
                 oVals.contains(4) && oVals.contains(5) && oVals.contains(6) ||
                 oVals.contains(7) && oVals.contains(8) && oVals.contains(9)) {
                    winner = "Player 2";
                    return true;
        }

        else {
            for (String next : locations) {
                if (next.length() == 0) {
                    return false;
                }
            }
            winner = "Draw";
            return true;
        }
    }
}