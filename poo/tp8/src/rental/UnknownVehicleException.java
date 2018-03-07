package rental;

/**
 * If no vehicle was found in an agency
 */
public class UnknownVehicleException extends Exception {
	public UnknownVehicleException(String msg) {
		super(msg);
	}
}
