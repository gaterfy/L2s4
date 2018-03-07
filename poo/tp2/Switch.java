
/**
 * Class representing a switch object
 * 
 * @LOMBART Thomas
 * @1.0
 */
public class Switch
{
    /**
     * the lightbulb that this switch controls
     */
    private Lightbulb bulbControlled;
    
    public Switch(Lightbulb bulb) {
        this.bulbControlled = bulb;
    }
    
    /**
     * Switches on the lightbulb controlled is it's off, and switches off if it's on
     */
    public void flip() {
        boolean state = bulbControlled.getState();
        if (state) {
            bulbControlled.switchOff();
        } else {
            bulbControlled.switchOn();
        }
    }
}
