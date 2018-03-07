package goosegame;

public class TrapCell extends BasicCell {

    /**
     * Constructs this TrapCell object
     * @param index the index of this cell
     */
    public TrapCell(int index) {
        super(index);
    }

    /**
     * @return <code>false</code> because a trap cell can never be left
     */
    public boolean canBeLeft() {
        return false;
    }

    /**
     * Represents this TrapCell
     * @return the description of this TrapCell
     */
    public String toString() {
      return "(trap)";
    }
}
