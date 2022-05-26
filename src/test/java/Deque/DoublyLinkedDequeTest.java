package Deque;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DoublyLinkedDequeTest {

    private DoublyLinkedDeque<Integer> deque;

    @Before
    public void init(){
        deque = new DoublyLinkedDeque<Integer>();
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
    public void testRemoveFirstSuccess_WhenDequeIsEmpty(){
        Assert.assertNull(deque.removeFirst());
    }

    @Test
    public void testRemoveFirstSuccess_WhenThereIsAnElement(){
        deque.addLast(1);

        Assert.assertEquals(Integer.valueOf(1), deque.removeFirst());
        Assert.assertNull(deque.first());
        Assert.assertNull(deque.last());
        Assert.assertEquals(0, deque.size());
    }

    @Test
    public void testRemoveFirstSuccess_WhenThereAreTwoElements(){
        deque.addLast(1);
        deque.addLast(2);

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
    public void testRemoveLastSuccess_WhenThereIsAnElement(){
        deque.addLast(1);

        Assert.assertEquals(Integer.valueOf(1), deque.removeLast());
        Assert.assertNull(deque.first());
        Assert.assertNull(deque.last());
        Assert.assertEquals(0, deque.size());
    }

    @Test
    public void testRemoveLastSuccess_WhenThereAreTwoElements(){
        deque.addLast(1);
        deque.addLast(2);

        Assert.assertEquals(Integer.valueOf(2), deque.removeLast());
        Assert.assertEquals(Integer.valueOf(1), deque.first());
        Assert.assertEquals(Integer.valueOf(1), deque.last());
        Assert.assertEquals(1, deque.size());
    }
}
