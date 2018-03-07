import org.junit.*;
import static org.junit.Assert.*;

import image.color.GrayColor;

/**
 * Class that tests the GrayColor class
 * @author LOMBART Thomas - VASILEV Martin
 * @version 1.0
 */
public class GrayColorTest {

    @Test
    public void WhiteAndBlackTest() {
        GrayColor black = GrayColor.BLACK;
        assertNotNull(black);
        GrayColor white = GrayColor.WHITE;
        assertNotNull(white);
        assertEquals(white.getGrayLevel(), 255);
        assertEquals(black.getGrayLevel(), 0);
    }

    @Test
    public void GetGrayLevelTest() {
        GrayColor mid_col = new GrayColor(128);
        assertNotNull(mid_col);
        assertEquals(mid_col.getGrayLevel(), 128);
        GrayColor new_col = new GrayColor(64);
        assertEquals(new_col.getGrayLevel(), 64);
    }

    @Test
    public void EqualsTest() {
        GrayColor color1 = new GrayColor(128);
        assertNotNull(color1);
        GrayColor color2 = new GrayColor(64);
        assertNotNull(color2);
        GrayColor color3 = new GrayColor(64);
        assertNotNull(color3);
        assertFalse(color1.equals(color2));
        assertFalse(color2 == color3);
        assertFalse(color1.equals(color3));
        assertTrue(color2.equals(color3));
    }

    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(GrayColorTest.class);
    }
}
