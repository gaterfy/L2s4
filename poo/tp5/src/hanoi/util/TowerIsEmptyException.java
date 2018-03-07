/**
 * An exception to handle the case where a Hanoi.Tower is empty
 *
 * @author LOMBART Thomas - VASILEV Martin
 * @version 1.0
 */

package hanoi.util;


/**
 * A class representing the exception thrown when a hanoi tower is empty
 */
public class TowerIsEmptyException extends Exception {
    public TowerIsEmptyException() {
        System.out.println("You can't pop a disc from a empty tower");
    }
}
