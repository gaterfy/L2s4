package hanoi.util;

/**
 * A Tower that can hold discs and is used for the Hanoi game
 *
 * @author LOMBART Thomas - VASILEV Martin
 * @version 1.0
 */
public class Tower {

    private int capacity;
    private int nbDiscs;
    private Disc[] theDiscs;

    /**
     * Builds a tower defined by its capacity
     * @param c The capacity of the tower (how much discs it can hold)
     */
    public Tower(int c) {
        this.nbDiscs = 0;
        this.capacity = c;
        this.theDiscs = new Disc[c];
    }

    /**
     * Gets the number of discs of this tower object
     * @return the number of discs that are on this tower object
     */
    public int getNbDiscs() {
        return this.nbDiscs;
    }

    /**
     * Gets the capacity of this tower object
     * @return the capcatiy of this tower object (max discs it can hold)
     */
    public int getCapacity() {
        return this.capacity;
    }

    /**
     * Tells whether this tower object is full or not
     * @return <code>true</code> if the tower is full, <code>false</code> otherwise
     */
    public boolean isFull() {
        return this.nbDiscs == this.capacity;
    }

    /**
     * Tells whether this tower object is empty of not
     * @return <code>true</code> if the tower is empty, <code>false</code> otherwise
     */
    public boolean isEmpty() {
        return this.nbDiscs == 0;
    }

    /**
     * Gets the top disc of this tower object if tower is not empty
     * @return the disc on top of the tower
     * @throws TowerIsEmptyException if tower is empty
     */
    public Disc top() throws TowerIsEmptyException {
        if (!this.isEmpty())
            return this.theDiscs[this.nbDiscs - 1];
        else
            throw new TowerIsEmptyException();
    }

    /**
     * Puts a disc on top of the tower if there is enough space
     * @param d the disc that will be put on top of the tower object
     * @throws TowerIsFullException if tower is full
     */
    public void push(Disc d) throws TowerIsFullException {
        if (!this.isFull()) {
            this.theDiscs[this.nbDiscs] = d;
            this.nbDiscs++;
        } else
            throw new TowerIsFullException();
    }

    /**
     * Pops the top disc off the tower (if there is a disc)
     * @return the disc on top of the tower object
     * @throws TowerIsEmptyException if tower is empty
     */
    public Disc pop() throws TowerIsEmptyException {
        if (!this.isEmpty()) {
            nbDiscs--;
            return this.theDiscs[nbDiscs];
        } else
            throw new TowerIsEmptyException();
    }

    /**
     * Represents a single floor of the tower
     * @param floor the floor's number to be represented
     * @return the representation of that floor
     */
    public String singleFloor(int floor) {
        String res = "";
        if (floor >= this.nbDiscs) {
            int i;
            for (i = 0; i < this.capacity; i++)
                res += " ";
            res += "|";
            for (i = i; i > 0; i--)
                res += " ";
        } else {
            int dSize = this.theDiscs[floor].getSize();
            int capacity = this.capacity;
            int i;
            for (i = 0; i < (capacity - dSize); i++)
                res += " ";
            for (i = i; i < capacity; i++)
                res += "_";
            res += "|";
            for (i = i; i > (capacity - dSize); i--)
                res += "_";
            for (i = i; i > 0; i--)
                res += " ";
        }
        return res;
    }
}
