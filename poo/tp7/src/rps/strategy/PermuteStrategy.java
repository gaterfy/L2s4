package rps.strategy;

import rps.*;

/**
 * PermuteStrategy class : plays every shape consecutively: PAPER then ROCK then SCISSORS then PAPER...
 * @author LOMBART Thomas - VASILEV Martin
 * @version 1.0
 */
public class PermuteStrategy implements Strategy {

    /* Index of the last shape that was used */
    private int state;

    /*
     * Constructor for the Permutation strategy
     */
    public PermuteStrategy() {
        this.state = 0;
    }

    /**
     * Criteria function for the Strategy interface
     * @return Shape chosen by strategy
     */
    public Shape chooseShape() {
        return this.nextShape();
    }

    /**
     * Returns the next shape with our permutation strategy
     * @return The next shape in our permutation strategy
     */
    public Shape nextShape() {
        Shape res = Shape.values()[this.state];
        this.state = (this.state + 1) % 3;
        return res;
    }
}
