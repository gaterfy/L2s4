import org.junit.*;
import static org.junit.Assert.*;

import example.Robot;
import example.util.Box;
import example.util.ConveyerBelt;

public class RobotTest {

  @Test
  public void testTake() {
    Robot r2d2 = new Robot();
    Box someBox = new Box(10);
    assertNull(r2d2.getCarriedBox());
    r2d2.take(someBox);
    // Replace With equals ?
    assertNotNull(r2d2.getCarriedBox());
  }

  @Test
  public void testCarryBox() {
    Robot r2d2 = new Robot();
    Box someBox = new Box(10);
    assertFalse(r2d2.carryBox());
    r2d2.take(someBox);
    assertTrue(r2d2.carryBox());
  }

  @Test
  public void testPutOn() {
    Robot r2d2 = new Robot();
    Box someBox = new Box(10);
    ConveyerBelt belt = new ConveyerBelt(100);
    r2d2.take(someBox);
    assertTrue(r2d2.carryBox());
    r2d2.putOn(belt);
    assertFalse(r2d2.carryBox());
    Box boxWayTooBig = new Box(150);
    r2d2.take(boxWayTooBig);
    r2d2.putOn(belt);
    assertEquals(boxWayTooBig, r2d2.getCarriedBox());
    ConveyerBelt biggerBelt = new ConveyerBelt(200);
    r2d2.putOn(biggerBelt);
    assertFalse(r2d2.carryBox());
    Box otherBox = new Box(20);
    r2d2.take(otherBox);
    r2d2.putOn(belt);
    Box boxInExcess = new Box(15);
    r2d2.take(boxInExcess);
    r2d2.putOn(belt);
    assertEquals(boxInExcess, r2d2.getCarriedBox());
  }

  public static junit.framework.Test suite() {
      return new junit.framework.JUnit4TestAdapter(RobotTest.class);
  }
}
