
/**
 * Class representing a good object
 * 
 * @LOMBART Thomas
 * @1.0
 */
public class Goods
{
    /**
     * the value attribute of the goods
     */
    private double value;
    
    /**
     * the name attribute of the goods
     */
    private String name;
    
    /**
     * Constructor of the Goods object
     * 
     * @param name the name we want to set initially
     * @return a new Goods object
     */
    public Goods(String name) {
        this.name = name;
    }
    
    /**
     * Constructor of the Goods object
     * 
     * @param name the name we want to set initially
     * @param value the value we want to set initially
     * @return a new Goods object
     */
    public Goods(String name, double value) {
        this.name = name;
        this.value = value;
    }
    
    /**
     * Gets the actual value of this goods object
     * 
     * @return the value of the goods
     */
    public double getValue() {
        return this.value;
    }
    
    /**
     * Sets the new value of this goods object
     * 
     * @param newValue the newValue to set
     */
    public void setValue(double newValue) {
        this.value = newValue;
    }
    
    /**
     * Gets the actual name of this goods object
     * 
     * @return the name of the goods
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Represents the informations (value and name) of this goods object
     * 
     * @return the string representing the goods object
     */
    public String toString() {
        return "the goods " + this.name + " cost " + this.value;
    }
    
    /**
     * Indicates how much cost the goods TTC
     * 
     * @return the cost of the goods TTC
     */
    public double costTTC() {
        return this.value + 0.196*this.value;
    }
}
