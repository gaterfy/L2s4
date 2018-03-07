package image.color;

/**
 * GrayColor class : a class that represents a gray color
 * @author LOMBART Thomas - VASILEV Martin
 * @version 1.0
 */
public class GrayColor {
    /** The black color */
    public final static GrayColor BLACK = new GrayColor(0);

    /** The white color */
    public final static GrayColor WHITE = new GrayColor(255);

    /** The gray level of this GrayColor */
    private int grayLevel;

    /**
     * Constructs this GrayColor object defined by its level
     * @param level the gray level
     */
    public GrayColor(int level) {
        this.grayLevel = level;
    }

    /**
     * Gets the gray level of this GrayColor
     * @return the gray level of this GrayColor
     */
    public int getGrayLevel() {
        return this.grayLevel;
    }

    /**
     * Tells if this GrayColor is equal to another
     * @param o the object we want to check
     * @return <code>true</code> if both GrayColors are equal
     */
    public boolean equals(Object o) {
        if (o instanceof GrayColor) {
            GrayColor theOther = (GrayColor) o;
            return this.grayLevel == theOther.getGrayLevel();
        } else {
            return false;
        }
    }
}
