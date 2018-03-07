
/**
 * A class to represent thermostat, a thermostat controls a boiler.
 * It can switch on or off the boiler depending on the current
 * temperature, measured by a thermometer, and according to a chosen
 * threshold temperature.
 */
public class Thermostat {
    
    /* the boiler controlled by this thermostat */
    private Boiler boiler;
    /* the thermometer used to measure current temperature */
    private Thermometer thermo;
    /* the temperature threshold, above boiler must be turned off, below turned on */
    private float threshold;

    /** builds a thermostat for the given boiler, and tuned to
     * given threshold
     * @param boiler the controlled boiler
     * @param threshold the temperature threshold for boiler 
     *              triggering
     */
    public Thermostat(Boiler boiler, float threshold) {
        this.boiler = boiler;
        this.thermo = new Thermometer(22);
        this.threshold = threshold;
        this.update();
    }

    /** returns the controlled boiler
     * @return  the controlled boiler
     */
    public Boiler getBoiler() {
        return this.boiler;
    }
   
   /** return the current temperature measured by the inner thermometer
     * @retur the current temperature
     */
    public float currentTemperature() {
        return this.thermo.temperatureInCelsius();
    }
   
   /** notifies a change in ambient temperature
     * @param newTemperature the new ambient temperature
     */    
    public void temperatureChange(float newTemperature) {
        this.thermo.changeTemperature(newTemperature);
        // checks if boiler must be turned on or off as a consequence of ambient temperature change
        this.update();  
    }
    
	/** sets the triggering temperature (in celsius)
     * @param level the new triggering threshold
     */
    public void setThreshold(float level) {
        this.threshold = level;
        // checks if boiler must be turned on or off as a result of threshold change
        this.update();
    }
    
	/** returns the triggering threshold temperature (in celsius)
     * @return the triggering threshold temperature
     */
    public float getThreshold() {
            return this.threshold;
        }

    /** manages boiler switching on or off depending on measured 
     * temperature and triggering threshold
     * If temperature is lower than threshold, boiler must be on else
     * it must be off.
     */
    private void update() {
        if (this.threshold < this.thermo.temperatureInCelsius() && this.boiler.isOn()) {
            this.boiler.switchOff();
        }
        else if (this.threshold >= this.thermo.temperatureInCelsius() && this.boiler.isOff()) {
            this.boiler.switchOn();     
        }
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
