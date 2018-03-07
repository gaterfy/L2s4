import org.junit.*;
import static org.junit.Assert.*;

import rps.*;
import rps.strategy.*;

/**
 * Class that tests the Player class
 * @author LOMBART Thomas - VASILEV Martin
 * @version 1.0
 */
public class PlayerTest {

    @Test
    public void scoreTest() {
        Player player1 = new Player("timoleon", new RandomStrategy());
        assertEquals(0, player1.getScore());
        player1.addScore(5);
        assertEquals(5, player1.getScore());
    }

    @Test
    public void getNameTest() {
        Player player1 = new Player("timoleon", new RandomStrategy());
        String name = player1.getName();
        assertEquals("timoleon", name);
    }

    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(PlayerTest.class);
    }
}
