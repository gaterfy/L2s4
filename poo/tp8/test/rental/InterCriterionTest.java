package rental;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class InterCriterionTest {

    private Vehicle v;

    @Before
    public void before() {
        this.v = new Vehicle("ford", "focus", 1997, 40);
    }

    @Test
    public void testInterCriterion() {
        assertNotNull(new InterCriterion());
    }

    @Test
    public void addCriterionTest() {
        InterCriterion c = new InterCriterion();
        assertFalse(c.isSatisfiedBy(this.v));
        c.addCriterion(new BrandCriterion("ford"));
        assertTrue(c.isSatisfiedBy(this.v));
    }

    @Test
    public void isSatisfiedByTest() {
        InterCriterion c = new InterCriterion();
        c.addCriterion(new BrandCriterion("ford"));
        assertTrue(c.isSatisfiedBy(this.v));
        c.addCriterion(new PriceCriterion(50));
        assertTrue(c.isSatisfiedBy(this.v));
        c.addCriterion(new PriceCriterion(30));
        assertFalse(c.isSatisfiedBy(this.v));
    }

    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(rental.InterCriterionTest.class);
    }
}
