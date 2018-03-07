package rental;

import java.util.*;

/** a suspicous rental vehicle agency, client can rent one vehicle at a time and young clients (under 25) are taxed*/
public class SuspiciousRentalAgency extends RentalAgency {

    public SuspiciousRentalAgency() {
        super();
    }

    /** client rents a vehicle
     * @param client the renter
     * @param v the rented vehicle
     * @return the daily rental price
     * @exception UnknownVehicleException   if v is not a vehicle of this agency
     * @exception IllegalStateException if v is already rented or client rents already another vehicle
     */
    public float rentVehicle(Client client, Vehicle v) throws UnknownVehicleException, IllegalStateException {
        if (!this.theVehicles.contains(v)) {
            throw new UnknownVehicleException("The vehicle is unknown");
        } else if (this.isRented(v) || this.hasRentedAVehicle(client)) {
            throw new IllegalStateException("The vehicle is already rented or you've already rented a vehicle");
        } else {
            this.rentedVehicles.put(client, v);
            float dailyPrice = v.getDailyPrice();
            return client.getAge() < 25 ? (float)(dailyPrice * 1.1) : (float) dailyPrice;
        }
    }
}
