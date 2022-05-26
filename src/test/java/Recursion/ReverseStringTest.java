package Recursion;

import org.junit.Assert;
import org.junit.Test;

public class ReverseStringTest {

    @Test
    public void testReverse_WhenStringIsEmpty(){
        Assert.assertEquals("", ReverseString.reverse(""));
    }

    @Test
    public void testReverse_123456(){
        Assert.assertEquals("654321", ReverseString.reverse("123456"));
    }

    @Test
    public void testReverse_654321(){
        Assert.assertEquals("123456", ReverseString.reverse("654321"));
    }
}
