/**
 * An exception to handle the case where a Hanoi.Tower is full
 *
 * @author LOMBART Thomas - VASILEV Martin
 * @version 1.0
 */

package hanoi.util;

/**
 * A class representing the exception thrown when a hanoi tower is full
 */
public class TowerIsFullException extends Exception {
    public TowerIsFullException() {
        System.out.println("You can't push a disc on a full tower");
    }
}
