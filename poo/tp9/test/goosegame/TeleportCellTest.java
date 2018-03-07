package goosegame;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TeleportCellTest {

  private TeleportCell c;
  private Player p;

  @Before
  public void before() {
    this.c = new TeleportCell(9, 18);
    this.p = new Player("thomas", this.c);
  }

  @Test
  public void testHandleMove() {
    int diceThrow = this.p.twoDiceThrow();
    assertEquals(18, this.c.handleMove(diceThrow));
  }

  public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(goosegame.TrapCellTest.class);
  }
}
