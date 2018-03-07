package goosegame;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class GoosegameBoardTest {

  private Board b;

  @Before
  public void before() {
    this.b = new GoosegameBoard();
    this.b.initBoard();
  }

  @Test
  public void testGoosegameBoard() {
    assertNotNull(this.b);
  }

  @Test
  public void testGetCell() {
    assertNotNull(this.b.getCell(42));
  }

  @Test
  public void testGetNbOfCells() {
    assertEquals(64, this.b.getNbOfCells());
  }

  public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(goosegame.GoosegameBoardTest.class);
  }
}
