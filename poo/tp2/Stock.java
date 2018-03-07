
/**
 * Class representing a stock object
 * 
 * @LOMBART Thomas
 * @1.0
 */
public class Stock
{
    private int quantity;
    
    
    /**
     * Constructor of the object Stock
     * Initialize the quantity to 0
     * 
     * @return a new Stock object
     */
    public Stock() {
        this.quantity = 0;
    }
    
    /**
     * Constructor of the object Stock
     * Initialize the quantity to the quantity given in parameter
     * 
     * @param n the quantity we want to set initially
     * @return a new Stock object
     */
    public Stock(int n) {
        this.quantity = n;
    }
    
    /**
     * Gives the quantity of this stock
     * 
     * @return the quantity
     */
    public int getQuantity() {
        return this.quantity;
    }
    
    /**
     * Add a quantity n to the quantity of this stock
     * 
     * @param n the number to add to the quantity
     */
    public void add (int n) {
        this.quantity += n;
    }
    
    /**
     * Removes a quantity n to the quantity of this stock
     * 
     * @param n the number to remove to the quantity
     * @return the quantity that has been removed
     */
    public int remove (int n) {
        if (n > this.quantity) {
            int previousQuantity = this.quantity;
            this.quantity = 0;
            return previousQuantity;
        } else {
            this.quantity -= n;
            return n;
        }
    }
    
    /**
     * Represents the actual quantity of this stock
     * 
     * @return the string showing the quantity of the stock
     */
    public String toString() {
        return "the stock's quantity is " + this.quantity;
    }
}
