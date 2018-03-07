import org.junit.*;
import static org.junit.Assert.*;

import rps.Shape;

/**
 * Class that tests the Shape class
 * @author LOMBART Thomas - VASILEV Martin
 * @version 1.0
 */
public class ShapeTest {

    @Test
    public void constructShape() {
        Shape rock = Shape.ROCK;
        assertNotNull(rock);
        Shape paper = Shape.PAPER;
        assertNotNull(paper);
        Shape scissors = Shape.SCISSORS;
        assertNotNull(scissors);
        //...?
    }

    @Test
    public void randomShapeTest() {
        Shape shape = Shape.random();
        assertNotNull(shape);
        assertTrue(shape == Shape.ROCK || shape == Shape.PAPER || shape == Shape.SCISSORS);
    }

    @Test
    public void compareShapesTest() {
        Shape shape1 = Shape.ROCK;
        assertNotNull(shape1);
        Shape shape2 = Shape.PAPER;
        assertNotNull(shape2);
        int res = shape1.compareShape(shape2);
        assertEquals(res, -1);
        res = shape2.compareShape(shape1);
        assertEquals(res, 1);
        res = shape1.compareShape(shape1);
        assertEquals(res, 0);
    }

    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(ShapeTest.class);
    }
}
