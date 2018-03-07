package rental;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CarTest {

    @Test
    public void getCapacityTest() {
        Car tesla = new Car("Tesla", "Model X", 2016, 100, 5);
        assertEquals(5, tesla.getCapacity());
    }

    // ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(rental.CarTest.class);
    }

}
