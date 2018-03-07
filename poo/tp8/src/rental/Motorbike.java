package rental;

/**
 * Represents motorbikes of a rental agency that can be rent by clients
 */
public class Motorbike extends Vehicle {

    //Number of passengers the car can handle
    private int cylinder;

    /**
     * Creates a Car with the given informations
     * @param brand the car's brand
     * @param model the car's model
     * @param productionYear the car's production year
     * @param dailyRentalPrice the rental price of the car for one day
     * @param cylinder the cylinder capacity of the motorbike
     */
    public Motorbike(String brand, String model, int productionYear, float dailyRentalPrice, int cylinder) {
        super(brand, model, productionYear, dailyRentalPrice);
        this.cylinder = cylinder;
    }

    /**
     * Returns the number of passengers the car can hold
     * @return the number of passengers the car can hold
     */
    public int getCylinder() {
        return this.cylinder;
    }

    /**
     * Converts the car class to a printable string
     * @return the string describing the car
     */
    public String toString() {
        return super.toString() + " " + this.cylinder; /* We add the cylinder to the String of the super class */
    }
}
