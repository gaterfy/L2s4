package goosegame;

public class GooseCell extends BasicCell {

   /**
    * Constructs this GooseCell object
    * @param index the index of this cell on the board
    */
    public GooseCell(int index) {
        super(index);
    }

    /**
     * Gives the index of the Cell
     * @return the index of the Cell
     */
    public int handleMove(int result) {
        return this.getIndex() + result;
    }

    /**
     * Represents this GooseCell
     * @return the description of this GooseCell
     */
    public String toString() {
        return "(goose)";
    }
}
