package goosegame;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

  private Player p;
  private Cell c;

  @Before
  public void before() {
    this.c = new BasicCell(5);
    this.p = new Player("thomas", this.c);
  }

  @Test
  public void testPlayer() {
    assertNotNull(this.p);
  }

  @Test
  public void testGetCell() {
    Cell c2 = this.p.getCell();
    assertEquals(c2, this.c);
  }

  @Test
  public void testSetCell() {
    Cell newCell = new TrapCell(58);
    this.p.setCell(newCell);
    assertEquals(newCell, this.p.getCell());
  }

  public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(goosegame.PlayerTest.class);
  }
}
