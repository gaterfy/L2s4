package goosegame;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class WaitingCellTest {

  private WaitingCell c;
  private Player p;

  @Before
  public void before() {
    this.c = new WaitingCell(24, 2);
    this.p = new Player("thomas", this.c);
  }

  @Test
  public void testCanBeLeft() {
    assertFalse(this.c.canBeLeft());
    assertTrue(this.c.canBeLeft());
  }

  public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(goosegame.WaitingCellTest.class);
  }
}
