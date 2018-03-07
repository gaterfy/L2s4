package image;

import image.color.*;
import java.util.*;

/**
 * Image class : a class that represents a image
 * @author LOMBART Thomas - VASILEV Martin
 * @version 1.0
 */
public class Image implements ImageInterface {

    /** the width of the image */
    private int width;

    /** the height of the image */
    private int height;

    /** 2-dimensional array of pixels */
    private Pixel[][] thePixels;

    /**
     * Constructs this Image object defined by its width and its height
     * @param width the width of the image
     * @param height the height of the image
     */
    public Image(int width, int height) {
        this.width = width;
        this.height = height;
        //Initialize pixels to WHITE
        this.thePixels = new Pixel[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                this.thePixels[x][y] = new Pixel(GrayColor.WHITE);
            }
        }
    }

    /**
     * Gets the width of this Image object
     * @return the width of this Image object
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Gets the height of this Image object
     * @return the height of this Image object
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Gets a single Pixel from the Image object
     * @param x the x-coordinate of the pixel
     * @param y the y-coordinate of the pixel
     * @return the extracted Pixel
     */
    public Pixel getPixel(int x, int y) throws UnknownPixelException {
        if (x < width && y < height)
            return this.thePixels[x][y];
        else
            throw new UnknownPixelException("Cannot get that pixel");
    }

    /**
     * Set a singel Pixel in the Image object
     * @param x the x-coordinate of the pixel
     * @param y the y-coordinate of the pixel
     * @param p The new pixel that will take the place of the old one
     */
    public void setPixel(int x, int y, Pixel p) throws UnknownPixelException {
        if (x < width && y < height)
            this.thePixels[x][y] = p;
        else
            throw new UnknownPixelException("Cannot set that pixel");
    }

    /**
     * Change the color of the pixel at the (x,y) position to color given in parameter
     * @param x the x-coordinate of the pixel
     * @param y the y-coordinate of the pixel
     * @param color The new color that will be applied to the pixel
     */
    public void changeColorPixel(int x, int y, GrayColor color) throws UnknownPixelException {
        Pixel p = this.getPixel(x, y);
        p.setColor(color);
    }

    /**
     * Produces an "edges" version of the Image using a given threshold
     * @param threshold The threshold that will be used to transform the image (represents the minimal distance between two pixels, so that they may be considered "very different")
     * @return returns the new transformed image
     */
    public Image edges(int threshold) {
        for (int x = 0; x < this.width; x++) {
            for (int y = 0; y < this.height; y++) {
                try {
                    Pixel pixel = this.getPixel(x, y);
                    Pixel rightPixel = this.getPixel(x + 1, y);
                    Pixel secondRightPixel = this.getPixel(x + 2, y);
                    Pixel underneathPixel = this.getPixel(x, y + 1);
                    Pixel secondUnderneathPixel = this.getPixel(x, y + 2);
                    int firstDifferenceRight = pixel.colorLevelDifference(rightPixel);
                    int secondDifferenceRight = pixel.colorLevelDifference(secondRightPixel);
                    int firstDifferenceUnderneath = pixel.colorLevelDifference(underneathPixel);
                    int secondDifferenceUnderneath = pixel.colorLevelDifference(secondUnderneathPixel);
                    boolean differenceRight = (firstDifferenceRight > threshold) || (secondDifferenceRight > threshold);
                    boolean differenceUnderneath = (firstDifferenceUnderneath > threshold) || (secondDifferenceUnderneath > threshold);
                    if (differenceRight || differenceUnderneath) {
                        this.changeColorPixel(x, y, GrayColor.BLACK);
                    } else {
                        this.changeColorPixel(x, y, GrayColor.WHITE);
                    }
                } catch (Exception e) {}
            }
        }
        return this;
    }

    /**
     * Produces a new image based on the initial image using a defined gray level
     * @param nbGrayLevels the gray level
     * @return the new transformed image
     */
    public Image decreaseNbGrayLevels(int nbGrayLevels) {
        int t = 256 / nbGrayLevels;
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Pixel pixel = this.getPixel(x, y);
                int grayLevel = pixel.getColor().getGrayLevel();
                int newGrayLevel = (int) Math.floor(grayLevel / t) * t;
                GrayColor newGrayColor = new GrayColor(newGrayLevel);
                this.changeColorPixel(x, y, newGrayColor);
            }
        }
        return this;
    }

    // ======================================================================
    /** Reads a PGM image from file.
     * It is assumed that file respects the following PGM file syntax:
     *  <ul><li> first line with string "P2"</li>
     *  <li>second line : a comment</li>
     *  <li>one int for width <code>w</code>, one int for height<code>h</code></li>
     *  <li>one int for max gray level (not used here, we consider this level to be 255 in our images)</li>
     *  <li><code>w</code> x <code>h</code> integers between 0 and max (for us max=255) for each pixel</li></ul>
     *
     * @param fileName the name of the image file in PGM format
     * @return the image built from the file
     */
    public static Image initImagePGM(String fileName) {
        Scanner scan = new Scanner(Image.class.getResourceAsStream(fileName));

        scan.nextLine(); // line P2
        scan.nextLine(); // line comment
        // read width
        int width = scan.nextInt();
        // read height
        int height = scan.nextInt();
        // read max gray level (not used)
        scan.nextInt();
        // create an initially white image
        Image result = new Image(width, height);
        // rad pixels
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                result.changeColorPixel(y, x, new GrayColor(scan.nextInt()));
            }
        }
        return result;
    }
}
