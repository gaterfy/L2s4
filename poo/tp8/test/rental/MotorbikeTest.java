package rental;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MotorbikeTest {

    @Test
    public void getCilynderTest() {
        Motorbike harley = new Motorbike("Harley-Davidson", "Buell", 2007, 90, 1200);
        assertEquals(1200, harley.getCylinder());
    }

    // ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(rental.MotorbikeTest.class);
    }

}
