package goosegame;

public interface Cell {

    /**
     * Says whether this Cell can be left
     * @return <code>true</code> if this Cell can be left, false otherwise
     */
    public boolean canBeLeft();

    /**
     * Gives the index of this Cell
     * @return the index of this Cell
     */
    public int getIndex();

    /**
     * Gets the player on this Cell
     * @return The player of this cell if occupied, null otherwise
     */
    public Player getPlayer();

    /**
     * Affects a player to this Cell
     * @param p The player to be affected
     */
    public void setPlayer(Player p);

    /**
     * Tells if this Cell has already another player on it
     * @return <code>true</code> if another player is already on that Cell, <code>false</code> otherwise
     */
    public boolean isBusy();

    /**
     * Handles the move on this Cell
     * @param result result of the dice throw
     * @return an integer representing how this Cell will affect the player's movement
     */
    public int handleMove(int result);
}
