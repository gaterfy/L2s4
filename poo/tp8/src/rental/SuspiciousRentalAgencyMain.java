package rental;

import java.util.*;

/** main to test for suspicous rental agency */
public class SuspiciousRentalAgencyMain {
    public static void main(String[] args) {
      RentalAgency agency = new SuspiciousRentalAgency();
      Car greatCar = new Car("Tesla","Model X", 2016, 100, 5);
      Client usualClient = new Client("Marc", 42);
      Client youngClient = new Client("Thomas", 19);
      agency.addVehicle(greatCar);
      try {
        float normalPrice = agency.rentVehicle(usualClient, greatCar);
        agency.returnVehicle(usualClient);
        float suspiciousPrice = agency.rentVehicle(youngClient, greatCar);
        agency.returnVehicle(youngClient);
        System.out.println("42 years old, experienced driver... The price is : " + normalPrice);
        System.out.println("19 years old, probably a dangerous driver... let's tax this guy! The price is : " + suspiciousPrice);
      } catch (UnknownVehicleException e) {}
    }
}
