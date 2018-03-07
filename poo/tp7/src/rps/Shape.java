package rps;

import java.util.Random;

/**
 * Shape enum : represents a shape
 * @author LOMBART Thomas - VASILEV Martin
 * @version 1.0
 */
public enum Shape {
    ROCK,
    PAPER,
    SCISSORS;

    /**
     * Returns a random shape
     * @return a random shape
     */
    public static Shape random() {
        Random rand = new Random();
        int randint = rand.nextInt(3);
        return Shape.values()[randint];
    }

    /**
     * Compare shapes
     * @param s the shape to compare
     * @return -1 if this Shape is weaker then s, 1 if this Shape is stronger then s, 0 otherwise
     */
    public int compareShape(Shape s) {
        if (this == s)
            return 0;
        else if ((this == ROCK && s == PAPER) || (this == SCISSORS && s == ROCK) || (this == PAPER && s == SCISSORS))
            return -1;
        else
            return 1;
    }
}
