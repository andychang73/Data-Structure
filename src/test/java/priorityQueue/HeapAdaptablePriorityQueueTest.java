package priorityQueue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import priorityQueue.impl.HeapAdaptablePriorityQueue;

public class HeapAdaptablePriorityQueueTest {

    private HeapAdaptablePriorityQueue<Integer, Integer> heap;

    @Before
    public void init(){
        heap = new HeapAdaptablePriorityQueue<>();
    }

    @Test
    public void testInsert_WhenHeapIsEmpty(){
        heap.insert(1,1);
        Entry<Integer, Integer> entry = heap.min();

        Assert.assertEquals(1, heap.size());
        Assert.assertEquals(Integer.valueOf(1), entry.getKey());
        Assert.assertEquals(Integer.valueOf(1), entry.getValue());
    }

    @Test
    public void testInsert_WhenInsertASmallerEntry(){
        heap.insert(2,2);
        heap.insert(1,1);

        Entry<Integer, Integer> entry = heap.min();

        Assert.assertEquals(2, heap.size());
        Assert.assertEquals(Integer.valueOf(1), entry.getKey());
        Assert.assertEquals(Integer.valueOf(1), entry.getValue());
    }

    @Test
    public void testInsert_WhenInsertAGreaterKey(){
        heap.insert(1,1);
        heap.insert(2,2);

        Entry<Integer, Integer> entry = heap.min();

        Assert.assertEquals(2, heap.size());
        Assert.assertEquals(Integer.valueOf(1), entry.getKey());
        Assert.assertEquals(Integer.valueOf(1), entry.getValue());
    }

    @Test
    public void testRemove_WhenRemoveSecondEntry(){
        heap.insert(1,1);
        Entry<Integer, Integer> entry = heap.insert(2,2);
        heap.insert(3,3);
        heap.remove(entry);

        Assert.assertEquals(2, heap.size());

        Entry<Integer, Integer> first = heap.removeMin();

        Assert.assertEquals(1, heap.size());
        Assert.assertEquals(Integer.valueOf(1), first.getKey());
        Assert.assertEquals(Integer.valueOf(1), first.getValue());

        Entry<Integer, Integer> second = heap.removeMin();

        Assert.assertEquals(0, heap.size());
        Assert.assertEquals(Integer.valueOf(3), second.getKey());
        Assert.assertEquals(Integer.valueOf(3), second.getValue());
    }

    @Test
    public void testRemove_WhenRemoveLastEntry(){
        heap.insert(1,1);
        heap.insert(2,2);
        Entry<Integer, Integer> entry = heap.insert(3,3);
        heap.remove(entry);

        Assert.assertEquals(2, heap.size());

        Entry<Integer, Integer> first = heap.removeMin();

        Assert.assertEquals(1, heap.size());
        Assert.assertEquals(Integer.valueOf(1), first.getKey());
        Assert.assertEquals(Integer.valueOf(1), first.getValue());

        Entry<Integer, Integer> second = heap.removeMin();

        Assert.assertEquals(0, heap.size());
        Assert.assertEquals(Integer.valueOf(2), second.getKey());
        Assert.assertEquals(Integer.valueOf(2), second.getValue());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemove_WhenRemoveInvalidEntry(){
        heap.insert(1,1);
        heap.insert(2,2);
        Entry<Integer, Integer> entry = heap.insert(3,3);
        heap.remove(entry);
        heap.remove(entry);
    }

    @Test
    public void testReplaceKey_WhenReplaceASmallerKey(){
        heap.insert(1,1);
        Entry<Integer, Integer> entry = heap.insert(2,2);
        heap.insert(3,3);

        heap.replaceKey(entry, 0);

        Assert.assertEquals(3, heap.size());
        Assert.assertEquals(Integer.valueOf(0), heap.min().getKey());
        Assert.assertEquals(Integer.valueOf(2), heap.min().getValue());
    }

    @Test
    public void testReplaceKey_WhenReplaceALargerKey(){
        heap.insert(1,1);
        Entry<Integer, Integer> entry = heap.insert(2,2);
        heap.insert(3,3);

        heap.replaceKey(entry, 4);

        heap.removeMin();
        heap.removeMin();
        Entry<Integer, Integer> last = heap.removeMin();

        Assert.assertEquals(0, heap.size());
        Assert.assertEquals(Integer.valueOf(4), last.getKey());
        Assert.assertEquals(Integer.valueOf(2), last.getValue());
    }

    @Test
    public void testReplaceKey_WhenReplaceEitherSmallerOrLargerKey(){
        heap.insert(0,1);
        Entry<Integer, Integer> entry = heap.insert(2,2);
        heap.insert(5,3);

        heap.replaceKey(entry, 4);

        heap.removeMin();
        Entry<Integer, Integer> last = heap.removeMin();

        Assert.assertEquals(1, heap.size());
        Assert.assertEquals(Integer.valueOf(4), last.getKey());
        Assert.assertEquals(Integer.valueOf(2), last.getValue());
    }

    @Test
    public void testReplaceValue_WhenReplaceAnyValue(){
        Entry<Integer, Integer> entry = heap.insert(1, 1);

        heap.replaceValue(entry, 2);

        entry = heap.min();

        Assert.assertEquals(1, heap.size());
        Assert.assertEquals(Integer.valueOf(1), entry.getKey());
        Assert.assertEquals(Integer.valueOf(2), entry.getValue());
     }
}
