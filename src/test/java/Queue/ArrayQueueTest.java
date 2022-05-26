package Queue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayQueueTest {

    private ArrayQueue<Integer> queue;

    @Before
    public void init(){
        queue = new ArrayQueue<Integer>(5);
    }

    @Test
    public void testEnqueueSuccess_WhenEnqueueOneElementFromIndexZero(){
        queue.enqueue(1);

        Assert.assertEquals(1, queue.size());
    }

    @Test
    public void testEnqueueSuccess_WhenEnqueueFiveElementsFirstThenDequeueOneThenEnqueueOne(){
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.dequeue();
        queue.enqueue(6);

        Assert.assertEquals(Integer.valueOf(2), queue.first());
        Assert.assertEquals(5, queue.size());
    }

    @Test(expected = IllegalStateException.class)
    public void testEnqueueFailed_WhenQueueIsFull(){
        queue.enqueue(1);
        queue.enqueue(1);
        queue.enqueue(1);
        queue.enqueue(1);
        queue.enqueue(1);
        queue.enqueue(1);
    }

    @Test
    public void testFirstSuccess_WhenQueueIsEmpty(){
        Assert.assertNull(queue.first());
        Assert.assertEquals(0,queue.size());
    }

    @Test
    public void testFirstSuccess_WhenQueueHasOneElement(){
        queue.enqueue(1);

        Assert.assertEquals(Integer.valueOf(1), queue.first());
        Assert.assertEquals(1, queue.size());
    }

    @Test
    public void testFirstSuccess_WhenQueueHasTwoElements(){
        queue.enqueue(1);
        queue.enqueue(2);

        Assert.assertEquals(Integer.valueOf(1), queue.first());
        Assert.assertEquals(2, queue.size());
    }

    @Test
    public void testDequeueSuccess_WhenQueueIsEmpty(){
        Assert.assertNull(queue.dequeue());
        Assert.assertEquals(0, queue.size());
    }

    @Test
    public void testDequeueSuccess_WhenThereIsOneElement(){
        queue.enqueue(1);

        Assert.assertEquals(Integer.valueOf(1), queue.dequeue());
        Assert.assertEquals(0, queue.size());
    }

    @Test
    public void testDequeueSuccess_WhenDequeueTheLastElement(){
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(6);

        Assert.assertEquals(Integer.valueOf(6), queue.dequeue());
        Assert.assertEquals(0, queue.size());
    }
}
