
/**
 * A class to represent boilers.
 */
public class Boiler {
 
    /* the state of this boiler */
    private boolean on;
	private float power;

	public float getPower() {
		return this.power;
	}
	
    /** builds a boiler, initially a boiler is off
     */
    public Boiler() {
        this.on = false;
    }
    
    /** provide a String description of this boiler
     * @return a String description of this boiler
     */
    public String toString() {
        return "this boiler is : "+(this.on ? "on" : "off");
    }

    /** switch on this boiler
     */
    public void switchOn() {
        this.on = true;
    }

    /** switch off this boiler
     */
    public void switchOff() {
        this.on = false;
    }

    /** returns <code>true</code> iff this boiler is on
     * @return  <code>true</code> iff this boiler is on
     */
    public boolean isOn() {
        return this.on;
    }
    
	/** returns <code>true</code> iff this boiler is off
     * @return  <code>true</code> iff this boiler is off
     */
    public boolean isOff() {
        return !this.on;
    }
 }
