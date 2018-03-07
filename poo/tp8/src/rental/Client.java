package rental;

/** represent clients of a rental agency, the names are supposed to be
 * unique then two Client objects with same name are considered equals
 */
public class Client {

    private String name;
    private int age;

    /** create a client with given name and age, two different clients
     * have different names by assumption (no verification)
     * @param name name of the client
     * @param age age of the client
     */
    public Client(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * @return the client's name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return the client's age
     */
    public int getAge() {
        return this.age;
    }

    /**
     * tells if two clients are equals
     * @param o the other client
     * @return if both clients are equals
     */
    public boolean equals(Object o) {
        if (o instanceof Client) {
            Client theOther = (Client) o;
            return this.getName() == theOther.getName();
        } else {
            return false;
        }
    }

    /**
     * Returns a hash code value for the client
     * @return a hash code value for the client
     */
    public int hashCode() {
        return this.name.hashCode();
    }
}
