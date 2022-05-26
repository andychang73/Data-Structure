package Stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkedStackTest {

    private LinkedStack<Integer> linkedStack;

    @Before
    public void init(){
        linkedStack = new LinkedStack<Integer>();
    }

    @Test
    public void testPushSuccess_WhenStackIsEmptyAndSizeIsZero(){
        Assert.assertEquals(0, linkedStack.size());
    }

    @Test
    public void testPushSuccess_WhenPushedThreeElementsAndSizeIsThree(){
        linkedStack.push(1);
        linkedStack.push(2);
        linkedStack.push(3);
        Assert.assertEquals(3, linkedStack.size());
    }

    @Test
    public void testTop_WhenArrayStackIsEmpty(){
        Assert.assertNull(linkedStack.top());
        Assert.assertEquals(0, linkedStack.size());
    }

    @Test
    public void testTop_WhenPushedTwoElements(){
        linkedStack.push(1);
        linkedStack.push(2);

        Assert.assertEquals(Integer.valueOf(2), linkedStack.top());
        Assert.assertEquals(2, linkedStack.size());
    }

    @Test
    public void testPop_WhenArrayStackIsEmpty(){
        Assert.assertNull(linkedStack.pop());
        Assert.assertEquals(0, linkedStack.size());
    }

    @Test
    public void testPop_WhenPushedTwoElements(){
        linkedStack.push(1);
        linkedStack.push(2);

        Assert.assertEquals(Integer.valueOf(2), linkedStack.pop());
        Assert.assertEquals(1, linkedStack.size());
    }
}
