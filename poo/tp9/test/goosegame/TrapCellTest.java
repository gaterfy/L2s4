package goosegame;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TrapCellTest {

  private TrapCell c;
  private Player p;

  @Before
  public void before() {
    this.c = new TrapCell(31);
    this.p = new Player("thomas", this.c);
  }

  @Test
  public void testCanBeLeft() {
    assertFalse(this.c.canBeLeft());
  }

  public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(goosegame.TeleportCellTest.class);
  }
}
