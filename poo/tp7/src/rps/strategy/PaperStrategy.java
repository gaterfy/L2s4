package rps.strategy;

import rps.*;

/**
 * PaperStrategy class : represents the PaperStrategy
 * @author LOMBART Thomas - VASILEV Martin
 * @version 1.0
 */
public class PaperStrategy implements Strategy {
    public PaperStrategy() {};
    public Shape chooseShape() {
        return Shape.PAPER;
    }
}
