import org.junit.*;
import static org.junit.Assert.*;

import hanoi.util.Disc;

public class DiscTest {

    @Test
    public void testSize() {
        Disc d = new Disc(5);
        assertEquals(d.getSize(), 5);
    }

    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(DiscTest.class);
    }
}
