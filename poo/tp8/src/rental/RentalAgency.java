package rental;

import java.util.*;

/** a rental vehicle agency, client can rent one vehicle at a time */
public class RentalAgency {
    /** vehicles of this agency */
    protected List < Vehicle > theVehicles;
    /** maps client and rented vehicle (at most one vehicle by client) */
    protected Map < Client, Vehicle > rentedVehicles;

    public RentalAgency() {
        this.theVehicles = new ArrayList < Vehicle > ();
        this.rentedVehicles = new HashMap < Client, Vehicle > ();
    }

    /** adds a vehicle to this agency
     * @param v the added vehicle
     */
    public void addVehicle(Vehicle v) {
        this.theVehicles.add(v);
    }

    /** provides the list of the vehicles that satisfy the criterion c
     * @param c the selection criterion
     * @return  the list of the vehicles that satisfy the criterion c
     */
    public List < Vehicle > select(Criterion c) {
        List < Vehicle > selectedVehicles = new ArrayList < Vehicle > ();
        for (Vehicle v: this.theVehicles) {
            if (c.isSatisfiedBy(v)) {
                selectedVehicles.add(v);
            }
        }
        return selectedVehicles;
    }

    /** displays the vehicles that satisfy the criterion c
     * @param c the selection criterion
     */
    public void displaySelection(Criterion c) {
        List < Vehicle > selectedVehicles = this.select(c);
        for (Vehicle v: selectedVehicles) {
            System.out.println(v);
        }
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
            return v.getDailyPrice();
        }
    }

    /** returns <em>true</em> iff client c is renting a vehicle
     * @param client the client that might rented a vehicle
     * @return <em>true</em> iff client c is renting a vehicle
     */
    public boolean hasRentedAVehicle(Client client) {
        return this.rentedVehicles.containsKey(client);
    }

    /** returns <em>true</em> iff vehicle v is rented
     * @param v the vehicke that might be rented
     * @return <em>true</em> iff vehicle v is rented
     */
    public boolean isRented(Vehicle v) {
        return this.rentedVehicles.containsValue(v);
    }

    /** the client returns a rented vehicle. Nothing happens if client didn't have rented a vehicle.
     * @param client the client who returns a vehicle
     */
    public void returnVehicle(Client client) {
            if (this.hasRentedAVehicle(client)) {
                this.rentedVehicles.remove(client);
            }
        }
        /** provides the collection of rented vehicles for this agency
         * @return collection of currently rented vehicles
         */
    public Collection < Vehicle > allRentedVehicles() {
        return this.rentedVehicles.values();
    }

}
