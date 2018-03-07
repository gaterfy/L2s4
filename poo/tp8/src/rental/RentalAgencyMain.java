package rental;

import java.util.*;

/** main to test for rental agency */
public class RentalAgencyMain {
    public static void main(String[] args) {
        RentalAgency agency = new RentalAgency();
        agency.addVehicle(new Vehicle("Audi", "A5", 2007, 60));
        agency.addVehicle(new Car("Renault", "107", 1998, 30, 5));
        agency.addVehicle(new Motorbike("Harley-Davidson", "Buell", 2007, 90, 1200));
        agency.addVehicle(new Car("Tesla", "Model X", 2016, 100, 5));
        agency.displaySelection(new PriceCriterion(70));
    }
}
