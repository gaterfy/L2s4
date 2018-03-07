package image;

import image.color.*;
import java.lang.Math;

/**
 * Pixel class : a class that represents a pixel
 * @author LOMBART Thomas - VASILEV Martin
 * @version 1.0
 */
public class Pixel {
    /** the gray color of the pixel */
    private GrayColor color;

    /**
     * Constructs this Pixel object defined by its color
     * @param color the color of the pixel
     */
    public Pixel(GrayColor color) {
        this.color = color;
    }

    /**
     * Gets the color
     * @return the color of this Pixel object
     */
    public GrayColor getColor() {
        return this.color;
    }

    /**
     * Sets the new color of this Pixel object
     * @param newColor the new color of this Pixel object
     */
    public void setColor(GrayColor newColor) {
        this.color = newColor;
    }

    /**
     * Tells if this Pixel is equal to the object o
     * @param o the object we want to check
     * @return <code>true</code> if both Pixel are equal
     */
    public boolean equals(Object o) {
        if (o instanceof Pixel) {
            Pixel theOther = (Pixel) o;
            return this.color.equals(theOther.getColor());
        } else {
            return false;
        }
    }

    /**
     * Gives the distance between this Pixel and another Pixel
     * @param otherPixel the other Pixel
     * @return the absolute distance between this Pixel and otherPixel
     */
    public int colorLevelDifference(Pixel otherPixel) {
        return Math.abs(this.color.getGrayLevel() - otherPixel.getColor().getGrayLevel());
    }

}
