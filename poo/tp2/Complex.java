/*
Class representing complex numbers

@author LOMBART Thomas
@version 1.0
*/
public class Complex {
  private double realPart;
  private double imaginaryPart;

  public Complex() {
  };

  /**
  * Constructs a new Complex with the given real and imaginary parts
  * @param realPart real part value
  * @param imaginaryPart imaginary part value
  */
  public Complex(double realPart, double imaginaryPart) {
    this.realPart = realPart;
    this.imaginaryPart = imaginaryPart;
  }

  /**
  * Gets the real part value of this complex object
  * @return the real part value
  */
  public double getRealPart() {
    return this.realPart;
  }

  /**
  * Gets the imaginary part value of this complex object
  * @return the imaginary part value
  */
  public double getImaginaryPart() {
    return this.imaginaryPart;
  }

  /**
  * Sets the real part value of this complex object
  * @param newRealPart the new real part we want to set
  */
  public void setRealPart(double newRealPart) {
    this.realPart = newRealPart;
  }

  /**
  * Sets the imaginary part value of this complex object
  * @param newImaginaryPart the new imaginary part we want to set
  */
  public void setImaginaryPart(double newImaginaryPart) {
    this.imaginaryPart = newImaginaryPart;
  }

  /**
  * Tells whether the complex object is a real number or not
  * @return a boolean set to true if the complex object is real, false otherwise
  */
  public boolean isReal() {
    return this.imaginaryPart == 0;
  }

  /**
  * Add two complex numbers
  * @param complexToAdd The complex we want to add
  * @return a new complex object that is the result of the calculation
  */
  public Complex plus(Complex complexToAdd) {
    double c = this.realPart + complexToAdd.getRealPart();
    double d = this.imaginaryPart + complexToAdd.getImaginaryPart();
    return new Complex(c, d);
  }

  /**
  * Substract two complex numbers
  * @param complexToSubstract The complex we want to Substract
  * @return a new complex object that is the result of the calculation
  */
  public Complex minus(Complex complexToSubstract) {
    double c = this.realPart - complexToSubstract.getRealPart();
    double d = this.imaginaryPart - complexToSubstract.getImaginaryPart();
    return new Complex(c, d);
  }


  /**
  * Multiply two complex numbers
  * @param complexToSubstract The complex we want to multiply
  * @return a new complex object that is the result of the calculation
  */
  public Complex times (Complex complexToMultiply) {
    double c = complexToMultiply.getRealPart();
    double d = complexToMultiply.getImaginaryPart();
    return new Complex((this.realPart*c) - (this.imaginaryPart*d), (this.realPart*d) + (this.imaginaryPart*c));
  }

  /**
  * Returns the conjugate of the complex object
  * @return a new complex object that is the conjugate of the complex
  */
  public Complex conjugate() {
    return new Complex(this.realPart, -this.imaginaryPart);
  }

  /**
  * Tells if two complex are equals
  * @param complexToTest The complex we want to test
  * @return a boolean that is true if the complex objects are equal, false otherwise
  */
  public boolean equals(Object complexToTest) {
    if (complexToTest instanceof Complex) {
      Complex c = (Complex) complexToTest;
      return (this.realPart == c.getRealPart()) && (this.imaginaryPart == c.getImaginaryPart());
    } else {
      return false;
    }
  }

  /**
  * Displays the complex Number in a better way
  * @return the representation of a complex number 
  */
  public String toString() {
    String sign = (this.imaginaryPart > 0) ? "+" : "";
	   return this.realPart + sign + this.imaginaryPart + "i";
  }
}
