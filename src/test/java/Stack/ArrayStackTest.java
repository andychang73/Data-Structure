package Stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayStackTest {

    private ArrayStack<Integer> arrayStack;

    @Before
    public void init(){
        arrayStack = new ArrayStack<Integer>(3);
    }

    @Test(expected = IllegalStateException.class)
    public void testPushFailed_WhenStackIsFull(){
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
    }

    @Test
    public void testPushSuccess_WhenStackIsEmptyAndSizeIsZero(){
        Assert.assertEquals(0, arrayStack.size());
    }

    @Test
    public void testPushSuccess_WhenPushedThreeElementsAndSizeIsThree(){
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        Assert.assertEquals(3, arrayStack.size());
    }

    @Test
    public void testTop_WhenArrayStackIsEmpty(){
        Assert.assertNull(arrayStack.top());
        Assert.assertEquals(0, arrayStack.size());
    }

    @Test
    public void testTop_WhenPushedTwoElements(){
        arrayStack.push(1);
        arrayStack.push(2);

        Assert.assertEquals(Integer.valueOf(2), arrayStack.top());
        Assert.assertEquals(2, arrayStack.size());
    }

    @Test
    public void testPop_WhenArrayStackIsEmpty(){
        Assert.assertNull(arrayStack.pop());
        Assert.assertEquals(0, arrayStack.size());
    }

    @Test
    public void testPop_WhenPushedTwoElements(){
        arrayStack.push(1);
        arrayStack.push(2);

        Assert.assertEquals(Integer.valueOf(2), arrayStack.pop());
        Assert.assertEquals(1, arrayStack.size());
    }
}
