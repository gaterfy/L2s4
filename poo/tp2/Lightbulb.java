
/**
 * Class representing a good object
 * 
 * @LOMBART Thomas
 * @1.0
 */
public class Lightbulb
{
    /**
     * Attribute representing the power of the bulb
     */
    private final double power;
    
    /**
     * Attribute representing the color of the bulb;
     */
    private final String color;
    
    /**
     * Attribute telling if the lightbulb is on or off
     */
    private boolean isOn;
    
    /**
     * Constructor of the lightbulb object
     */
    public Lightbulb(double power, String color, boolean isOn) {
        this.power = power;
        this.color = color;
        this.isOn = isOn;
    }
    
    /**
     * Gives the power of the lightbulb
     * 
     * @return the power of the lightbulb
     */
    public double getPower() {
        return this.power;
    }

    /**
     * Gives the color of the lightbulb
     * 
     * @return the color of the lightbulb
     */
    public String getColor() {
        return this.color;
    } 
    
    /**
     * Gives the state of the lightbulb
     * 
     * @return the state of the lightbulb
     */
    public boolean getState() {
        return this.isOn;
    }
    
    /**
     * Switches on the lightbulb
     */
    public void switchOn() {
        this.isOn = true;
    }
    
    /**
     * Switches off the lightbulb
     */
    public void switchOff() {
        this.isOn = false;
    }
    
    /**
     * Represents the informations (value and name) of this lightbulb object
     * 
     * @return the string representing the lightbulb object
     */
    public String toString() {
        String state = this.isOn ? "switched on" : "switched off";
        return "Power of the lightbulb: " + this.power + "W, color:" + this.color + ", state: " + state + ".";
    }
}
