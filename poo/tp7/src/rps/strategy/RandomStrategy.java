package rps.strategy;

import rps.*;

/**
 * Random Strategy class : represents a RandomStrategy
 * @author LOMBART Thomas - VASILEV Martin
 * @version 1.0
 */
public class RandomStrategy implements Strategy {
    public RandomStrategy() {};

    /**
     * Chooses the shape to play
     * @return Shape the shape chosen
     */
    public Shape chooseShape() {
        return Shape.random();
    }
}
