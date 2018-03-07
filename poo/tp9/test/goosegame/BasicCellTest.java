package goosegame;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BasicCellTest {

  private BasicCell c;
  private Player p;

  @Before
  public void before() {
    this.c = new BasicCell(5);
    this.p = new Player("thomas", this.c);
  }

  @Test
  public void testBasicCell() {
    assertNotNull(this.c);
  }

  @Test
  public void testCanBeLeft() {
    assertTrue(this.c.canBeLeft());
  }

  @Test
  public void testGetIndex() {
    assertEquals(5, this.c.getIndex());
  }

  @Test
  public void testGetPlayer() {
    assertEquals(null, this.c.getPlayer());
  }

  @Test
  public void testSetPlayer() {
    this.c.setPlayer(this.p);
    assertEquals(this.p, this.c.getPlayer());
  }

  @Test
  public void testIsBusy() {
    assertFalse(this.c.isBusy());
    this.c.setPlayer(this.p);
    assertTrue(this.c.isBusy());
  }

  @Test
  public void testHandleMove() {
    int diceThrow = this.p.twoDiceThrow();
    assertEquals(this.c.getIndex(), this.c.handleMove(diceThrow));
  }

  public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(goosegame.BasicCellTest.class);
  }
}
