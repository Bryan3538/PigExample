import junit.framework.Assert;

/**
 * Created by Bryan on 10/9/2015.
 */
public class DieTest {

    @org.junit.Test
    public void testGetNumberOfSides() throws Exception {
        Die d = new Die();
        Assert.assertEquals(6, d.getNumberOfSides());

        d = new Die(15);
        Assert.assertEquals(15, d.getNumberOfSides());
    }

    @org.junit.Test
    public void testSetNumberOfSides() throws Exception {
        Die d = new Die();
        d.setNumberOfSides(20);
        Assert.assertEquals(20, d.getNumberOfSides());
    }

    @org.junit.Test
    public void testGetValue() throws Exception {
        Die d = new Die();
        int testVal = 0;
        int testRoll = 0;
        for (int i = 0; i < 10000; i++) {
            testRoll = d.roll();
            testVal = d.getValue();
            Assert.assertEquals(testRoll, testVal);
        }
    }

    @org.junit.Test
    public void testRoll() throws Exception {
        Die d = new Die();
        int val = 0;
        for (int i = 0; i < 10000; i++) {
            val = d.roll();
            Assert.assertTrue(val >= 1 && val <= d.getNumberOfSides());
        }
    }
}