import org.junit.*;
import static org.junit.Assert.*;

import image.*;
import image.color.*;

/**
 * Class that tests the Image class
 * @author LOMBART Thomas - VASILEV Martin
 * @version 1.0
 */
public class ImageTest {

    @Test
    public void getDimensionsTest() {
        Image img = new Image(500, 800);
        assertEquals(500, img.getWidth());
        assertEquals(800, img.getHeight());
    }

    @Test
    public void getPixelTest() {
        Image img = new Image(500, 800);
        Pixel pixel = new Pixel(GrayColor.WHITE);
        assertEquals(img.getPixel(0, 0), pixel);
        Pixel newPixel = new Pixel(new GrayColor(54));
        img.setPixel(1, 4, newPixel);
        assertEquals(img.getPixel(1, 4), newPixel);
    }

    @Test
    public void changeColorPixelTest() {
        Image img = new Image(600, 400);
        GrayColor newColor = new GrayColor(211);
        Pixel pixel = img.getPixel(173, 234);
        assertEquals(pixel.getColor(), GrayColor.WHITE);
        img.changeColorPixel(173, 234, newColor);
        assertEquals(pixel.getColor(), newColor);
    }

    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(ImageTest.class);
    }
}
