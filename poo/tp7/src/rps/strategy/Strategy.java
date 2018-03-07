package rps.strategy;

import rps.*;

/**
 * Strategy interface : represents a strategy
 * @author LOMBART Thomas - VASILEV Martin
 * @version 1.0
 */
public interface Strategy {
    /**
     * Chooses the shape to play
     * @return Shape the shape chosen
     */
    public Shape chooseShape();
}
