import org.junit.*;
import static org.junit.Assert.*;

import image.Pixel;
import image.color.GrayColor;

/**
 * Class that tests the Pixel class
 * @author LOMBART Thomas - VASILEV Martin
 * @version 1.0
 */
public class PixelTest {

    @Test
    public void getColorTest() {
        GrayColor color = new GrayColor(187);
        Pixel pixel = new Pixel(color);
        GrayColor color2 = pixel.getColor();
        assertEquals(color, color2);
    }

    @Test
    public void setColorTest() {
        GrayColor color = new GrayColor(187);
        Pixel pixel = new Pixel(color);
        GrayColor newColor = new GrayColor(54);
        pixel.setColor(newColor);
        assertEquals(pixel.getColor(), newColor);
    }

    @Test
    public void equalsTest() {
        GrayColor color = new GrayColor(22);
        Pixel pixel = new Pixel(color);
        GrayColor color2 = new GrayColor(54);
        Pixel pixel2 = new Pixel(color2);
        GrayColor color3 = new GrayColor(22);
        Pixel pixel3 = new Pixel(color3);
        assertFalse(pixel.equals(pixel2));
        assertTrue(pixel.equals(pixel3));
    }

    @Test
    public void colorLevelDifferenceTest() {
        GrayColor color = new GrayColor(113);
        Pixel pixel = new Pixel(color);
        GrayColor color2 = new GrayColor(47);
        Pixel pixel2 = new Pixel(color2);
        int colorLevelDifference1 = pixel.colorLevelDifference(pixel2);
        int colorLevelDifference2 = pixel2.colorLevelDifference(pixel);
        assertEquals(66, colorLevelDifference1);
        assertEquals(colorLevelDifference1, colorLevelDifference2);
    }

    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(PixelTest.class);
    }
}
