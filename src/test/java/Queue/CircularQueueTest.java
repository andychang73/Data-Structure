package Queue;

import Queue.interfaces.CircularQueue;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CircularQueueTest {

    private CircularQueue<Integer> queue;

    @Before
    public void init(){
        queue = new LinkedCircularQueue<>();
    }

    @Test
    public void testFirstSuccess_WhenQueueIsEmpty(){
        Assert.assertNull(queue.first());
    }

    @Test
    public void TestFirstSuccess_WhenThereIsOneElement(){
        queue.enqueue(1);

        Assert.assertEquals(Integer.valueOf(1), queue.first());
        Assert.assertEquals(1, queue.size());
    }

    @Test
    public void testFirstSuccess_WhenThereAreTwoElements(){
        queue.enqueue(1);
        queue.enqueue(2);

        Assert.assertEquals(Integer.valueOf(1), queue.first());
        Assert.assertEquals(2, queue.size());
    }

    @Test
    public void testRotateSuccess_WhenQueueIsEmpty(){
        queue.rotate();

        Assert.assertNull(queue.first());
        Assert.assertEquals(0, queue.size());
    }

    @Test
    public void testRotateSuccess_WhenThereIsOneElement(){
        queue.enqueue(1);
        queue.rotate();

        Assert.assertEquals(Integer.valueOf(1), queue.first());
        Assert.assertEquals(1, queue.size());
    }

    @Test
    public void testRotateSuccess_WhenThereAreTwoElements(){
        queue.enqueue(1);
        queue.enqueue(2);
        queue.rotate();

        Assert.assertEquals(Integer.valueOf(2), queue.first());
        Assert.assertEquals(2, queue.size());
    }

    @Test
    public void testDequeueSuccess_WhenQueueIsEmpty(){
        Assert.assertNull(queue.dequeue());
    }

    @Test
    public void testDequeueSuccess_WhenThereIsOneElement(){
        queue.enqueue(1);

        Assert.assertEquals(Integer.valueOf(1), queue.dequeue());
        Assert.assertEquals(0, queue.size());
    }

    @Test
    public void testDequeueSuccess_WhenThereAreTwoElements(){
        queue.enqueue(1);
        queue.enqueue(2);

        Assert.assertEquals(Integer.valueOf(1), queue.dequeue());
        Assert.assertEquals(1, queue.size());
    }

    @Test
    public void testDequeueTwiceSuccess_WhenThereAreTwoElements(){
        queue.enqueue(1);
        queue.enqueue(2);

        Assert.assertEquals(Integer.valueOf(1), queue.dequeue());
        Assert.assertEquals(Integer.valueOf(2), queue.dequeue());
        Assert.assertEquals(0, queue.size());
    }
}
