package hanoi;

import hanoi.util.*;

/**
 * Hanoi game
 * @author LOMBART Thomas - VASILEV Martin
 * @version 1.0
 */

public class Hanoi {

    /* The capacity of the towers */
    private int capacity;

    /* The towers of the hanoi game */
    private Tower[] towers;

    /**
     * Creates a hanoi game defined by the capacity of a tower
     * @param c the capacity of one tower
     */
    public Hanoi(int c) {
        this.capacity = c;
        this.towers = new Tower[3];
        for (int i = 0; i < 3; i++) {
            this.towers[i] = new Tower(c);
        }
        for (int i = c; i > 0; i--) {
            try {
                Disc d = new Disc(i);
                this.towers[0].push(d);
            } catch (Exception e) {
                //Handle expcetion
            }
        }
    }

    /**
     * Says whether taking the top disc from source tower and placing it onto destination tower is allowed
     * @param source the index of the turret from which a disc will be taken
     * @param destination the index of the turret to which a disc will be placed
     * @throws TowerIsEmptyException if tower is empty
     * @return <code>true</code> if the movement is allowed, <code>false</code> otherwise.
     */
    public boolean isAllowed(int source, int destination) throws TowerIsEmptyException {
        Tower towerSource = this.towers[source];
        Tower towerDestination = this.towers[destination];
        if (!towerDestination.isEmpty() && !towerSource.isEmpty())
            return this.towers[source].top().getSize() < this.towers[destination].top().getSize();
        else
            return true;
    }

    /**
     * Displays the state of the current hanoi game
     */
    public void display() {
        for (int floor = this.capacity - 1; floor >= 0; floor--) {
            for (int j = 0; j < 3; j++) {
                System.out.print(this.towers[j].singleFloor(floor));
            }
            System.out.println("");
        }
        System.out.println("");
    }

    /**
     * Moves one disc from a the source tower to the destination tower and displays the game
     * @param source the number corresponding to the source tower
     * @param destination the number corresponding to the destination tower
     */
    public void moveOneDisc(int source, int destination) {
        Tower towerSource = this.towers[source];
        Tower towerDestination = this.towers[destination];
        try {
            Disc discToMove = towerSource.pop();
            towerDestination.push(discToMove);
        } catch (Exception e) {}
        this.display();
    }

    /**
     * Tells whether the game is solved or not
     * @return <code>true</code> if the right tower is full, <code>false</code> otherwise
     */
    public boolean isSolved() {
        return this.towers[2].isFull();
    }

    /**
     * solves the Hanoi game
     * @param nb the number of discs to move
     * @param source the number corresponding to the source tower
     * @param destination the number corresponding to the destination tower
     * @param auxiliary the number corresponding to the auxiliary tower
     */
    public void solve(int nb, int source, int destination, int auxiliary) {
        if (nb == 1) {
            this.moveOneDisc(source, destination);
        } else {
            this.solve(nb - 1, source, auxiliary, destination);
            this.moveOneDisc(source, destination);
            this.solve(nb - 1, auxiliary, destination, source);
        }
    }
}
