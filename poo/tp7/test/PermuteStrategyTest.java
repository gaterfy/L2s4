import org.junit.*;
import static org.junit.Assert.*;

import rps.Shape;
import rps.strategy.PermuteStrategy;

/**
 * Class that tests the PermuteStrategy class that uses the Strategy interface
 * @author LOMBART Thomas - VASILEV Martin
 * @version 1.0
 */
public class PermuteStrategyTest {

    @Test
    public void createAPermuteStrategyTest() {
        PermuteStrategy strategy = new PermuteStrategy();
        assertNotNull(strategy);
        //...
    }

    @Test
    public void nextShapeIsNextShapeTest() {
        PermuteStrategy strategy = new PermuteStrategy();
        assertNotNull(strategy);
        Shape shape = strategy.chooseShape();
        assertNotNull(shape);
        assertTrue(shape == Shape.ROCK);
        shape = strategy.nextShape();
        assertTrue(shape == Shape.PAPER);
        shape = strategy.nextShape();
        assertTrue(shape == Shape.SCISSORS);
    }

    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(PermuteStrategyTest.class);
    }
}
