package goosegame;

import java.util.*;

public class StartCell extends BasicCell {

    /**
     * Constructs this StartCell Object
     */
    public StartCell() {
        super(0);
    }

    /**
     * Tells if this Cell has already a player on it
     * @return <code>false</code> because the start cell can have infinite players on it
     */
    public boolean isBusy() {
        return false;
    }

    /**
     * Represents this StartCell
     * @return the description of this StartCell
     */
    public String toString() {
      return "(start cell)";
    }
}
