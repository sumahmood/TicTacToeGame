package Tests;

import Model.Game;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

// In the process of adding additional tests.

public class GameTest {

    private Game testGame;

    @Before
    public void testGame() {
        testGame = new Game();
    }

    @Test
    public void testMove() {
        testGame.playerMove(1);
        assertEquals("X", testGame.getLocation(1));
    }
}
