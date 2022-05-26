package Deque;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayDequeTest {

    private ArrayDeque<Integer> deque;

    @Before
    public void init(){
        deque = new ArrayDeque<Integer>(5);
    }

    @Test
    public void testFirstSuccess_WhenDequeIsEmpty(){
        Assert.assertNull(deque.first());
    }

    @Test
    public void testLastSuccess_WhenDequeIsEmpty(){
        Assert.assertNull(deque.last());
    }

    @Test
    public void testAddFirstSuccess_WhenAddOnce(){
        deque.addFirst(1);

        Assert.assertEquals(Integer.valueOf(1), deque.first());
        Assert.assertEquals(Integer.valueOf(1), deque.last());
        Assert.assertEquals(1, deque.size());
    }

    @Test
    public void testAddFirstSuccess_WhenAddTwice(){
        deque.addFirst(1);
        deque.addFirst(2);

        Assert.assertEquals(Integer.valueOf(2), deque.first());
        Assert.assertEquals(Integer.valueOf(1), deque.last());
        Assert.assertEquals(2, deque.size());
    }

    @Test
    public void testAddFirstSuccess_WhenAddThreeTimes(){
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);

        Assert.assertEquals(Integer.valueOf(3), deque.first());
        Assert.assertEquals(Integer.valueOf(1), deque.last());
        Assert.assertEquals(3, deque.size());
    }

    @Test(expected = IllegalStateException.class)
    public void testAddFirstFailed_WhenAddSixTimes(){
        deque.addFirst(1);
        deque.addFirst(1);
        deque.addFirst(1);
        deque.addFirst(1);
        deque.addFirst(1);
        deque.addFirst(1);
    }

    @Test
    public void testAddLastSuccess_WhenAddOnce(){
        deque.addLast(1);

        Assert.assertEquals(Integer.valueOf(1), deque.first());
        Assert.assertEquals(Integer.valueOf(1), deque.last());
        Assert.assertEquals(1, deque.size());
    }

    @Test
    public void testAddLastSuccess_WhenAddTwice(){
        deque.addLast(1);
        deque.addLast(2);

        Assert.assertEquals(Integer.valueOf(1), deque.first());
        Assert.assertEquals(Integer.valueOf(2), deque.last());
        Assert.assertEquals(2, deque.size());
    }

    @Test
    public void testAddLastSuccess_WhenAddThreeTimes(){
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);

        Assert.assertEquals(Integer.valueOf(1), deque.first());
        Assert.assertEquals(Integer.valueOf(3), deque.last());
        Assert.assertEquals(3, deque.size());
    }

    @Test
    public void testAddLastSuccess_WhenAddLastFiveTimesThenRemoveFirstOnceThenAddLastOnce(){
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.addLast(4);
        deque.addLast(5);
        deque.removeFirst();
        deque.addLast(6);

        Assert.assertEquals(Integer.valueOf(6), deque.last());
        Assert.assertEquals(Integer.valueOf(2), deque.first());
        Assert.assertEquals(5, deque.size());
    }

    @Test(expected = IllegalStateException.class)
    public void testAddLastFailed_WhenAddSixTimes(){
        deque.addLast(1);
        deque.addLast(1);
        deque.addLast(1);
        deque.addLast(1);
        deque.addLast(1);
        deque.addLast(1);
    }

    @Test
    public void testRemoveFirstSuccess_WhenDequeIsEmpty(){
        Assert.assertNull(deque.removeFirst());
    }

    @Test
    public void testRemoveFirstSuccess_WhenAddFirstOnce(){
        deque.addFirst(1);

        Assert.assertEquals(Integer.valueOf(1), deque.removeFirst());
        Assert.assertNull(deque.first());
        Assert.assertNull(deque.last());
        Assert.assertEquals(0, deque.size());
    }

    @Test
    public void testRemoveFirstSuccess_WhenAddFirstTwice(){
        deque.addFirst(1);
        deque.addFirst(2);

        Assert.assertEquals(Integer.valueOf(2), deque.removeFirst());
        Assert.assertEquals(Integer.valueOf(1), deque.first());
        Assert.assertEquals(Integer.valueOf(1), deque.last());
        Assert.assertEquals(1, deque.size());
    }

    @Test
    public void testRemoveFirstSuccess_WhenAddFirstThreeTimes(){
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);

        Assert.assertEquals(Integer.valueOf(3), deque.removeFirst());
        Assert.assertEquals(Integer.valueOf(2), deque.first());
        Assert.assertEquals(Integer.valueOf(1), deque.last());
        Assert.assertEquals(2, deque.size());
    }

    @Test
    public void testRemoveFirstSuccess_WhenAddLastOnce(){
        deque.addLast(1);

        Assert.assertEquals(Integer.valueOf(1), deque.removeFirst());
        Assert.assertNull(deque.first());
        Assert.assertNull(deque.last());
        Assert.assertEquals(0, deque.size());
    }

    @Test
    public void testRemoveFirstSuccess_WhenAddLastTwice(){
        deque.addLast(1);
        deque.addLast(2);

        Assert.assertEquals(Integer.valueOf(1), deque.removeFirst());
        Assert.assertEquals(Integer.valueOf(2), deque.first());
        Assert.assertEquals(Integer.valueOf(2), deque.last());
        Assert.assertEquals(1, deque.size());
    }

    @Test
    public void testRemoveFirstSuccess_WhenAddLastThreeTimes(){
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);

        Assert.assertEquals(Integer.valueOf(1), deque.removeFirst());
        Assert.assertEquals(Integer.valueOf(2), deque.first());
        Assert.assertEquals(Integer.valueOf(3), deque.last());
        Assert.assertEquals(2, deque.size());
    }

    @Test
    public void testRemoveFirstTwiceSuccess_WhenAddFirstTwiceAndAddLastOnce(){
        deque.addFirst(1);
        deque.addFirst(0);
        deque.addLast(2);

        Assert.assertEquals(Integer.valueOf(0), deque.removeFirst());
        Assert.assertEquals(Integer.valueOf(1), deque.removeFirst());
        Assert.assertEquals(Integer.valueOf(2), deque.first());
        Assert.assertEquals(Integer.valueOf(2), deque.last());
        Assert.assertEquals(1, deque.size());
    }

    @Test
    public void testRemoveLastSuccess_WhenDequeIsEmpty(){
        Assert.assertNull(deque.removeLast());
    }

    @Test
    public void testRemoveLastSuccess_WhenAddFirstOnce(){
        deque.addFirst(1);

        Assert.assertEquals(Integer.valueOf(1), deque.removeLast());
        Assert.assertNull(deque.first());
        Assert.assertNull(deque.last());
        Assert.assertEquals(0, deque.size());
    }

    @Test
    public void testRemoveLastSuccess_WhenAddFirstTwice(){
        deque.addFirst(1);
        deque.addFirst(2);

        Assert.assertEquals(Integer.valueOf(1), deque.removeLast());
        Assert.assertEquals(Integer.valueOf(2),deque.first());
        Assert.assertEquals(Integer.valueOf(2), deque.last());
        Assert.assertEquals(1, deque.size());
    }

    @Test
    public void testRemoveLastSuccess_WhenAddFirstThreeTimes(){
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);

        Assert.assertEquals(Integer.valueOf(1), deque.removeLast());
        Assert.assertEquals(Integer.valueOf(3),deque.first());
        Assert.assertEquals(Integer.valueOf(2), deque.last());
        Assert.assertEquals(2, deque.size());
    }

    @Test
    public void testRemoveLastSuccess_WhenAddLastOnce(){
        deque.addLast(1);

        Assert.assertEquals(Integer.valueOf(1), deque.removeLast());
        Assert.assertNull(deque.first());
        Assert.assertNull(deque.last());
        Assert.assertEquals(0, deque.size());
    }

    @Test
    public void testRemoveLastSuccess_WhenAddLastTwice(){
        deque.addLast(1);
        deque.addLast(2);

        Assert.assertEquals(Integer.valueOf(2), deque.removeLast());
        Assert.assertEquals(Integer.valueOf(1),deque.first());
        Assert.assertEquals(Integer.valueOf(1), deque.last());
        Assert.assertEquals(1, deque.size());
    }

    @Test
    public void testRemoveLastSuccess_WhenAddLastThreeTimes(){
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);

        Assert.assertEquals(Integer.valueOf(3), deque.removeLast());
        Assert.assertEquals(Integer.valueOf(1),deque.first());
        Assert.assertEquals(Integer.valueOf(2), deque.last());
        Assert.assertEquals(2, deque.size());
    }

    @Test
    public void testRemoveLastTwiceSuccess_WhenAddFirstTwiceAndAddLastOnce(){
        deque.addFirst(1);
        deque.addFirst(0);
        deque.addLast(2);

        Assert.assertEquals(Integer.valueOf(2), deque.removeLast());
        Assert.assertEquals(Integer.valueOf(1), deque.removeLast());
        Assert.assertEquals(Integer.valueOf(0), deque.first());
        Assert.assertEquals(Integer.valueOf(0), deque.last());
        Assert.assertEquals(1, deque.size());
    }

}
