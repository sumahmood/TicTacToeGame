package Model;

public class AI {

    private Game currentGame;
    private int numMoves = 1;
    private int lastMove;


    public AI(Game game) {
        this.currentGame = game;
    }

    public int getLastMove() {
        return lastMove;
    }

    public void AIMove() {
        if (currentGame.getCurrentPlayer() == 2 && numMoves == 1) {
            if (currentGame.getLocation(5).length() > 0) {
                currentGame.playerMove(1);
                lastMove = 1;
            }
            else {
                currentGame.playerMove(5);
                lastMove = 5;
            }
        }
    }
}
