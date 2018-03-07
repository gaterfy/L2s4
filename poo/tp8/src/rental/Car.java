package rental;

/**
 * Represents cars of a rental agency that can be rent by clients
 */
public class Car extends Vehicle {

    //Number of passengers the car can handle
    private int capacity;

    /**
     * Creates a Car with the given informations
     * @param brand the car's brand
     * @param model the car's model
     * @param productionYear the car's production year
     * @param dailyRentalPrice the rental price of the car for one day
     * @param capacity the number of passengers in the car
     */
    public Car(String brand, String model, int productionYear, float dailyRentalPrice, int capacity) {
        super(brand, model, productionYear, dailyRentalPrice);
        this.capacity = capacity;
    }

    /**
     * Returns the number of passengers the car can hold
     * @return the number of passengers the car can hold
     */
    public int getCapacity() {
        return this.capacity;
    }

    /**
     * Converts the car class to a printable string
     * @return the string describing the car
     */
    public String toString() {
        return super.toString() + " " + this.capacity; /* We add the capacity to the String of the super class */
    }
}
