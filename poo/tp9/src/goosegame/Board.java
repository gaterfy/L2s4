package goosegame;

public abstract class Board {
  /* the number of cells of this Board */
  protected final int nbOfCells;

  /* the array that contains the cells of this Board */
  protected Cell[] theCells;

  /**
   * @param nbOfCells the number of cells of this Board
   */
  public Board(int nbOfCells) {
    this.nbOfCells = nbOfCells;
    this.theCells = new Cell[nbOfCells];
  }

  /**
   * Initializes this Board
   */
  public abstract void initBoard();

  /**
   * Returns the cell at a specified index
   * @param index the index of the cell we want to get
   * @return the cell at the specified index
   */
  public Cell getCell(int index) {
    return this.theCells[index];
  }

  /**
   * Returns the number of cells of this Board
   * @return the number of cells of this Board
   */
  public int getNbOfCells() {
    return this.nbOfCells;
  }
}
