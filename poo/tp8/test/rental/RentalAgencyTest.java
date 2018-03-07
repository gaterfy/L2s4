package rental;

import static org.junit.Assert.*;

import java.util.*;
import org.junit.Before;
import org.junit.Test;

public class RentalAgencyTest {

    private RentalAgency agency;
    private Client client;
    private Client moi;

    @Before
    public void before() {
        this.agency = new RentalAgency();
        this.client = new Client("JF Roos", 25);
        this.moi = new Client("Martin Vasilev", 19);
    }

    @Test
    public void constructorTest() {
        assertNotNull(this.agency);
    }

    @Test
    public void selectTest() {
        Vehicle car1 = new Vehicle("Timo", "leon", 301, 30);
        Vehicle car2 = new Vehicle("Raymond", "Calbuth", 805, 50);
        this.agency.addVehicle(car1);
        this.agency.addVehicle(car2);
        Criterion c = new PriceCriterion(60);
        List < Vehicle > l = this.agency.select(c);
        assertEquals(l.size(), 2);
        c = new PriceCriterion(40);
        l = this.agency.select(c);
        assertEquals(l.size(), 1);
        c = new BrandCriterion("Timo");
        l = this.agency.select(c);
        assertEquals(l.size(), 1);
    }

    @Test
    public void RentingAVehicleTest() {
        Vehicle car = new Vehicle("Mercedes-Benz", "CLS", 2015, 79);
        this.agency.addVehicle(car);
        try {
            float number = 79;
            assertEquals(this.agency.rentVehicle(this.client, car), number, 1e-15);
        } catch (Exception e) {}
    }

    @Test
    public void RentingANonExistingVehiculeTest() {
        Vehicle car = new Vehicle("Nissan", "GT-R", 2014, 85);
        try {
            this.agency.rentVehicle(this.client, car);
        } catch (Exception e) {}
    }

    @Test
    public void clientHasRentedVehiculeTest() {
        Vehicle theCarOfMyLife = new Vehicle("Tesla", "Model X", 2016, 100);
        try {
            this.agency.rentVehicle(this.client, theCarOfMyLife);
            assertTrue(this.agency.hasRentedAVehicle(this.client));
        } catch (Exception e) {}
        Client anotherClient = new Client("John Doe", 50);
        assertFalse(this.agency.hasRentedAVehicle(anotherClient));
    }

    @Test
    public void isRentedTest() {
        Vehicle theCarOfMyLife = new Vehicle("Tesla", "Model X", 2016, 100);
        assertFalse(this.agency.isRented(theCarOfMyLife));
        try {
            this.agency.rentVehicle(this.moi, theCarOfMyLife);
            assertTrue(this.agency.isRented(theCarOfMyLife)); /* assertFalse plutot ;( */
        } catch (Exception e) {}
    }

    @Test
    public void returningVehicleTest() {
        this.agency.returnVehicle(this.moi); /* goodbye */
    }

    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(rental.RentalAgencyTest.class);
    }

}
