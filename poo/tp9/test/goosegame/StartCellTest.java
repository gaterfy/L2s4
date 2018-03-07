package goosegame;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class StartCellTest {

  private StartCell c;
  private Player p;

  @Before
  public void before() {
    this.c = new StartCell();
    this.p = new Player("thomas", this.c);
  }

  @Test
  public void testGetIndex() {
    assertEquals(0, this.c.getIndex());
  }

  @Test
  public void testCanBeLeft() {
    assertTrue(this.c.canBeLeft());
  }

  public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(goosegame.StartCellTest.class);
  }
}
