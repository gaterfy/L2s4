package goosegame;

public class WaitingCell extends BasicCell {
  /*  the waiting duration of this cell, will be used to count the number of turns */
  protected int waitingDuration;
  /* the number of turns the player will have to wait */
  protected int waitingTime;

  /**
   * Constructs this WaitingCell object
   * @param index the index of the cell
   * @param waitingTime the number of turns the player have to wait
   */
  public WaitingCell(int index, int waitingTime) {
    super(index);
    this.waitingDuration = 0;
    this.waitingTime = waitingTime;
  }

  /**
   * Says whether this Cell can be left
   * @return <code>true</code> if this Cell can be left, false otherwise
   */
  public boolean canBeLeft() {
    this.waitingDuration++;
    return this.waitingDuration == this.waitingTime;
  }

  /**
   * Represents this WaitingCell object
   * @return the description of this WaitingCell
   */
  public String toString() {
    return "(waiting for "  + (this.waitingTime - this.waitingDuration) + " turns)";
  }
}
