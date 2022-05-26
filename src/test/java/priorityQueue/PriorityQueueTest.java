package priorityQueue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import priorityQueue.impl.SortedPriorityQueue;

public class PriorityQueueTest {

    private SortedPriorityQueue<String, Integer> queue;

    @Before
    public void init(){
        queue = new SortedPriorityQueue<>();
    }

    @Test
    public void testInsert_WhenQueueIsEmpty(){
        queue.insert("A",1);
        Assert.assertEquals(Integer.valueOf(1), queue.min().getValue());
        Assert.assertEquals(1, queue.size());
    }

    @Test
    public void testInsert_WhenThereAreTwoElementsAndInsertTheSmallestKey(){
        queue.insert("C", 3);
        queue.insert("B", 2);
        queue.insert("A", 1);

        Assert.assertEquals(3, queue.size());
        Assert.assertEquals(Integer.valueOf(1), queue.min().getValue());
    }

    @Test
    public void testInsert_WhenThereAreTwoElementsAndInsertTheSecondSmallestKey(){
        queue.insert("A", 1);
        queue.insert("C", 3);
        queue.insert("B", 2);

        Assert.assertEquals(3, queue.size());
        Assert.assertEquals(Integer.valueOf(1), queue.removeMin().getValue());
        Assert.assertEquals(Integer.valueOf(2), queue.removeMin().getValue());
    }
}
