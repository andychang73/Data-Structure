package priorityQueue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import priorityQueue.impl.HeapPriorityQueue;

public class HeapPriorityQueueTest {

    private HeapPriorityQueue<Integer, String> queue;

    @Before
    public void init(){
        queue = new HeapPriorityQueue<>();
    }

    @Test
    public void testInsert_WhenEnteredTheSmallestValueInTheEnd(){
        queue.insert(6,"6");
        queue.insert(5,"5");
        queue.insert(4,"4");
        queue.insert(3,"3");
        queue.insert(2,"2");
        queue.insert(1,"1");

        Assert.assertEquals(6, queue.size());
        Assert.assertEquals("1", queue.min().getValue());
    }

    @Test
    public void testRemoveMin(){
        queue.insert(6,"6");
        queue.insert(5,"5");
        queue.insert(4,"4");
        queue.insert(3,"3");
        queue.insert(2,"2");
        queue.insert(1,"1");

        Assert.assertEquals("1", queue.removeMin().getValue());
        Assert.assertEquals("2", queue.min().getValue());
        Assert.assertEquals(5, queue.size());
    }

    @Test
    public void testBottomUpConstruction(){
        Integer[] keys = new Integer[]{10,9,8,7,6,5,4,3,2,1};
        String[] values = new String[]{"10","9","8","7","6","5","4","3","2","1"};
        queue = new HeapPriorityQueue<>(keys,  values);

        for(int i = 1; i < queue.size(); i++){
            Assert.assertEquals(Integer.valueOf(i), queue.removeMin().getKey());
        }
    }

    @Test
    public void testHeapSort(){
        queue = new HeapPriorityQueue<>((o1, o2) -> 0);
    }
}
