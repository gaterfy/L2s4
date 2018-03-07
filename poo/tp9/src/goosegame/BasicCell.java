package goosegame;

public class BasicCell implements Cell {
    /* the index of this BasicCell */
    protected int index;

    /* the player in this BasicCell */
    protected Player player;

    /**
     * Constructs this BasicCell object
     * @param index the index of this cell on the board
     */
    public BasicCell(int index) {
      this.index = index;
      this.player = null;
    }

    /**
     * Says whether a cell can be left or not
     * @return <code>true</code> because a basic cell can always be left
     */
    public boolean canBeLeft() {
        return true;
    }

    /**
     * Gives the index of the Cell
     * @return the index of the Cell
     */
    public int getIndex() {
        return this.index;
    }

    /**
     * Gets the player on the Cell
     * @return The player of the cell if occupied, <code>null</code> otherwise
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * Affects a player to this Cell
     * @param p The player to be affected to this Cell
     */
    public void setPlayer(Player p) {
        this.player = p;
    }

    /**
     * Tells if this Cell has already a player on it
     * @return <code>true</code> if an player is already on that Cell, <code>false</code> otherwise
     */
    public boolean isBusy() {
        return this.player != null;
    }

    /**
     * Handles the move on this Cell
     * @param result result of the dice throw
     * @return an integer representing how this Cell will affect the player's movement
     */
    public int handleMove(int result) {
        return this.getIndex();
    }

    public String toString() {
        return "(basic cell)";
    }
}
