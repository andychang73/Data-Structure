package Recursion;

import org.junit.Assert;
import org.junit.Test;

public class FibonacciTest {

    @Test
    public void testBadSuccess_WhenNIsZero(){
        Assert.assertEquals(0, Fibonacci.bad(0));
    }

    @Test
    public void testBadSuccess_WhenNIsOne(){
        Assert.assertEquals(1, Fibonacci.bad(1));
    }

    @Test
    public void testBadSuccess_WhenNIsTwo(){
        Assert.assertEquals(1, Fibonacci.bad(1));
    }

    @Test
    public void testBadSuccess_WhenNIsSeven(){
        Assert.assertEquals(13, Fibonacci.bad(7));
    }

    @Test
    public void testGoodSuccess_WhenNIsZero(){
        Assert.assertEquals(0, Fibonacci.good(0)[1]);
    }

    @Test
    public void testGoodSuccess_WhenNIsOne(){
        Assert.assertEquals(1, Fibonacci.good(1)[1]);
    }

    @Test
    public void testGoodSuccess_WhenNIsTwo(){
        Assert.assertEquals(1, Fibonacci.good(2)[1]);
    }

    @Test
    public void testGoodSuccess_WhenNIsSeven(){
        Assert.assertEquals(13, Fibonacci.good(7)[1]);
    }

    @Test
    public void testNonRecursive_WhenNIsZero(){
        Assert.assertEquals(0, Fibonacci.nonRecursive(0));
    }

    @Test
    public void testNonRecursive_WhenNIsOne(){
        Assert.assertEquals(1, Fibonacci.nonRecursive(1));
    }

    @Test
    public void testNonRecursive_WhenNIsTwo(){
        Assert.assertEquals(1, Fibonacci.nonRecursive(2));
    }

    @Test
    public void testNonRecursive_WhenNIsSeven(){
        Assert.assertEquals(13, Fibonacci.nonRecursive(7));
    }
}
