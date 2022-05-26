package Recursion;

import org.junit.Assert;
import org.junit.Test;

public class PowerTest {

    @Test
    public void testLinearPower_WhenNIsZero(){
        Assert.assertEquals(1, Power.linear(2, 0));
    }

    @Test
    public void testLinearPower_TwoToThePowerOfTwo(){
        Assert.assertEquals(2, Power.linear(2, 1));
    }

    @Test
    public void testLinearPower_TwoToThePowerOfEight(){
        Assert.assertEquals(256, Power.linear(2, 8));
    }

    @Test
    public void testLogN_WhenNIsZero(){
        Assert.assertEquals(1,Power.logN(2, 0),1);
    }

    @Test
    public void testLogN_WhenNIsOne(){
        Assert.assertEquals(2, Power.logN(2,1), 1);
    }

    @Test
    public void testLogN_WhenNIsEight(){
        Assert.assertEquals(256, Power.logN(2, 8), 1);
    }
}
