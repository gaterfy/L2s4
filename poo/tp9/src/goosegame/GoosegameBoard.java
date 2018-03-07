package goosegame;

public class GoosegameBoard extends Board {

  /**
   * Constructs a goosegame board
   */
  public GoosegameBoard() {
    super(64);
  }

  /**
   * Initializes the board of the goosegame
   */
  public void initBoard() {
    /* set the first cell */
    this.theCells[0] = new StartCell();

    /* by default, all cells are basic cells */
    for (int i = 1; i < 64; i++) {
      this.theCells[i] = new BasicCell(i);
    }

    /* set the goose cells */
    int[] gooseCells = {9, 18, 27, 36, 45, 54};

    for (int i : gooseCells) {
      this.theCells[i] = new GooseCell(i);
    }

    /* set the waiting cell */
    this.theCells[19] = new WaitingCell(19, 2);

    /* set the trap cells */
    this.theCells[31] = new TrapCell(31);
    this.theCells[52] = new TrapCell(52);

    /* set the teleport cells */
    this.theCells[6] = new TeleportCell(6, 12);
    this.theCells[42] = new TeleportCell(42, 30);
    this.theCells[58] = new TeleportCell(58, 1);
  }
}
