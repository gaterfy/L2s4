import java.awt.Color;

/**
 * A class to represent thermometer that measures a
 * temperature. Temperature can be read in celsius or Fahrenheit and a
 * color is associated to the temperature level.
 */
public class Thermometer {   
    
    /* the current temperature measured by this thermometer */
    private float temperature;

    /** builds a thermometer with given initial temperature
     * @param initialTemp the initalTemperature
     */
    public Thermometer(float initialTemp) {
        this.temperature = initialTemp;
    }
    
    /** builds a thermometer, initial temperature is set to 0
     */
    public Thermometer() {
        this.temperature = 0;
        // ou : 
        // this(0);
    }
    
	/** provide a String description of this themometer
     * @return a String description of this themometer
	*/
    public String toString() {
        return "the current temperature is : "+this.temperature;
    }

    /** provides the temperature measured by this thermometer in celsius
     * @return the temperature measured by this thermometer in celsius
     */
    public float temperatureInCelsius() {
        return this.temperature;
    }

    /** modify current temperature of this thermometer
     * @param newTemp the new temperature measured by this thermometer
     */
    public void changeTemperature(float newTemp) {
        this.temperature = newTemp;
    }

    /** provides the temperature measured by this thermometer in Fahrenheit
     * @return the temperature measured by this thermometer in Fahrenheit
     */
    public float temperatureInFahrenheit() {
        return (9.0f/5.0f)*this.temperature+32;
    }

    /** gives the color displaid by this thermometer depending of the
     * measured temperature
     * @return the displaid color
     */
    public Color displaidColor() {
        if (this.temperature < COLD_LIMIT) {
            return COLD_COLOR;
        } 
        else if (this.temperature < HOT_LIMIT) {
            return TEMPERATE_COLOR;
        }
        else {
            return HOT_COLOR;
        }
    }

	
	private static int COLD_LIMIT = 10;
    private static int HOT_LIMIT = 30;

    private static Color COLD_COLOR = Color.BLUE;
    private static Color TEMPERATE_COLOR = Color.GREEN;
    private static Color HOT_COLOR = Color.RED;
}
