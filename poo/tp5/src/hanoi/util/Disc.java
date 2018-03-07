package hanoi.util;

/**
 * A disc that is put on a hanoi tower
 *
 * @author LOMBART Thomas - VASILEV Martin
 * @version 1.0
 */
public class Disc {
    /* The size of the disc */
    private int size;

    /**
     * Creates a disc defined by its size
     * @param s the size of the disc
     */
    public Disc(int s) {
        this.size = s;
    }

    /**
     * Returns the size of the disc
     * @return the disc's size
     */
    public int getSize() {
        return this.size;
    }

    /**
     * A description of the disc
     * @return a string that describes the disc
     */
    public String toString() {
        return "The disc has a size of " + this.size;
    }
}
