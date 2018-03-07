package goosegame;

public class TeleportCell extends BasicCell {
    /* the index of the cell that this TeleportCell points to */
    protected int jumpInto;

    /**
     * Constructs this TeleportCell object
     * @param index the index of the cell
     * @param jumpInto the cell that the player teleports to
     */
    public TeleportCell(int index, int jumpInto) {
        super(index);
        this.jumpInto = jumpInto;
    }

    /**
     * Handles the move on this Cell
     * @param result result of the dice throw
     * @return an integer representing how this Cell will affect the player's movement
     */
    public int handleMove(int result) {
        return this.jumpInto;
    }

    /**
     * Represents this TeleportCell
     * @return the description of this TeleportCell
     */
    public String toString() {
        return "(teleport to " + this.jumpInto + ")";
    }
}
