package LinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DoublyLinkedListTest {

    private DoublyLinkedList<Integer> linkedList;

    @Before
    public void init(){
        linkedList = new DoublyLinkedList<Integer>();
    }

    @Test
    public void testAddFirstSuccess_WhenAddOneElement(){
        linkedList.addFirst(1);

        Assert.assertEquals(Integer.valueOf(1), linkedList.first());
        Assert.assertEquals(Integer.valueOf(1), linkedList.last());
        Assert.assertEquals(1, linkedList.size());
    }

    @Test
    public void testAddFirstSuccess_WhenAddTwoElements(){
        linkedList.addFirst(1);
        linkedList.addFirst(2);

        Assert.assertEquals(Integer.valueOf(2), linkedList.first());
        Assert.assertEquals(Integer.valueOf(1), linkedList.last());
        Assert.assertEquals(2, linkedList.size());
    }

    @Test
    public void testAddLastSuccess_WhenAddOneElement(){
        linkedList.addLast(1);

        Assert.assertEquals(Integer.valueOf(1), linkedList.first());
        Assert.assertEquals(Integer.valueOf(1), linkedList.last());
        Assert.assertEquals(1, linkedList.size());
    }

    @Test
    public void testAddLastSuccess_WhenAddTwoElement(){
        linkedList.addLast(1);
        linkedList.addLast(2);

        Assert.assertEquals(Integer.valueOf(1), linkedList.first());
        Assert.assertEquals(Integer.valueOf(2), linkedList.last());
        Assert.assertEquals(2, linkedList.size());
    }

    @Test
    public void testRemoveFirst_WhenListIsEmpty(){
        Assert.assertNull(linkedList.removeFirst());
    }

    @Test
    public void testRemoveFirst_WhenAddFirstOnce(){
        linkedList.addFirst(1);

        Assert.assertEquals(Integer.valueOf(1), linkedList.removeFirst());
        Assert.assertNull(linkedList.first());
        Assert.assertNull(linkedList.last());
        Assert.assertEquals(0, linkedList.size());
    }

    @Test
    public void testRemoveFirst_WhenAddFirstTwice(){
        linkedList.addFirst(1);
        linkedList.addFirst(2);

        Assert.assertEquals(Integer.valueOf(2), linkedList.removeFirst());
        Assert.assertEquals(Integer.valueOf(1), linkedList.first());
        Assert.assertEquals(Integer.valueOf(1), linkedList.last());
        Assert.assertEquals(1, linkedList.size());
    }

    @Test
    public void testRemoveFirst_WhenAddLastOnce(){
        linkedList.addLast(1);

        Assert.assertEquals(Integer.valueOf(1), linkedList.removeFirst());
        Assert.assertNull(linkedList.first());
        Assert.assertNull(linkedList.last());
        Assert.assertEquals(0, linkedList.size());
    }

    @Test
    public void testRemoveFirst_WhenAddLastTwice(){
        linkedList.addLast(1);
        linkedList.addFirst(2);

        Assert.assertEquals(Integer.valueOf(2), linkedList.removeFirst());
        Assert.assertEquals(Integer.valueOf(1), linkedList.first());
        Assert.assertEquals(Integer.valueOf(1), linkedList.last());
        Assert.assertEquals(1, linkedList.size());
    }

    @Test
    public void testRemoveLast_WhenListIsEmpty(){
        Assert.assertNull(linkedList.last());
    }

    @Test
    public void testRemoveLast_WhenAddFirstOnce(){
        linkedList.addFirst(1);

        Assert.assertEquals(Integer.valueOf(1), linkedList.removeLast());
        Assert.assertNull(linkedList.first());
        Assert.assertNull(linkedList.last());
        Assert.assertEquals(0, linkedList.size());
    }

    @Test
    public void testRemoveLast_WhenAddFirstTwice(){
        linkedList.addFirst(1);
        linkedList.addFirst(2);

        Assert.assertEquals(Integer.valueOf(1), linkedList.removeLast());
        Assert.assertEquals(Integer.valueOf(2), linkedList.first());
        Assert.assertEquals(Integer.valueOf(2), linkedList.last());
        Assert.assertEquals(1, linkedList.size());
    }

    @Test
    public void testRemoveLast_WhenAddLastOnce(){
        linkedList.addLast(1);

        Assert.assertEquals(Integer.valueOf(1), linkedList.removeLast());
        Assert.assertNull(linkedList.first());
        Assert.assertNull(linkedList.last());
        Assert.assertEquals(0, linkedList.size());
    }

    @Test
    public void testRemoveLast_WhenAddLastTwice(){
        linkedList.addLast(1);
        linkedList.addLast(2);

        Assert.assertEquals(Integer.valueOf(2), linkedList.removeLast());
        Assert.assertEquals(Integer.valueOf(1), linkedList.last());
        Assert.assertEquals(Integer.valueOf(1), linkedList.last());
        Assert.assertEquals(1, linkedList.size());
    }
}
