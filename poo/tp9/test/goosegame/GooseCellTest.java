package goosegame;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class GooseCellTest {

  private GooseCell c;
  private Player p;

  @Before
  public void before() {
    this.c = new GooseCell(9);
    this.p = new Player("thomas", this.c);
  }

  @Test
  public void testHandleMove() {
    int diceThrow = this.p.twoDiceThrow();
    assertEquals(this.c.getIndex() + diceThrow, this.c.handleMove(diceThrow));
  }

  public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(goosegame.GooseCellTest.class);
  }
}
