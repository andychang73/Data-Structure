package Recursion;

import org.junit.Assert;
import org.junit.Test;

public class FactorialTest {

    @Test
    public void testFactorial_WhenNIsZero(){
        Assert.assertEquals(0, Factorial.factorial(0));
    }

    @Test
    public void testFactorial_WhenNIsOne(){
        Assert.assertEquals(1, Factorial.factorial(1));
    }

    @Test
    public void testFactorial_WhenNIsSix(){
        Assert.assertEquals(720, Factorial.factorial(6));
    }
}
