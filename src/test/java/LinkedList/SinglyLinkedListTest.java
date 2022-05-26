package LinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

public class SinglyLinkedListTest {

    private SinglyLinkedList<Integer> linkedList;

    @Before
    public void init(){
        linkedList = new SinglyLinkedList<>();
    }

    @Test
    public void testFirstSuccess_WhenListIsEmpty(){
        Assert.assertNull(linkedList.first());
    }

    @Test
    public void testFirstSuccess_WhenThereIsAnElement(){
        linkedList.addLast(1);

        Assert.assertEquals(Integer.valueOf(1), linkedList.first());
    }

    @Test
    public void testFirstSuccess_WhenThereAreTwoElements(){
        linkedList.addLast(1);
        linkedList.addLast(2);

        Assert.assertEquals(Integer.valueOf(1), linkedList.first());
    }

    @Test
    public void testLastSuccess_WhenListIsEmpty(){
        Assert.assertNull(linkedList.last());
    }

    @Test
    public void testLastSuccess_WhenThereIsAnElement(){
        linkedList.addLast(1);

        Assert.assertEquals(Integer.valueOf(1), linkedList.last());
    }

    @Test
    public void testLastSuccess_WhenThereAreTwoElements(){
        linkedList.addLast(1);
        linkedList.addLast(2);

        Assert.assertEquals(Integer.valueOf(2), linkedList.last());
    }

    @Test
    public void testAddFirstSuccess_WhenAddOnce(){
        linkedList.addFirst(1);

        Assert.assertEquals(Integer.valueOf(1), linkedList.first());
        Assert.assertEquals(Integer.valueOf(1), linkedList.last());
        Assert.assertEquals(1, linkedList.size());
    }

    @Test
    public void testAddFirstSuccess_WhenAddTwice(){
        linkedList.addFirst(1);
        linkedList.addFirst(2);

        Assert.assertEquals(Integer.valueOf(2), linkedList.first());
        Assert.assertEquals(Integer.valueOf(1), linkedList.last());
        Assert.assertEquals(2, linkedList.size());
    }

    @Test
    public void testAddLastSuccess_WhenAddOnce(){
        linkedList.addLast(1);

        Assert.assertEquals(Integer.valueOf(1), linkedList.first());
        Assert.assertEquals(Integer.valueOf(1), linkedList.last());
        Assert.assertEquals(1, linkedList.size());
    }

    @Test
    public void testAddLastSuccess_WhenAddTwice(){
        linkedList.addLast(1);
        linkedList.addLast(2);

        Assert.assertEquals(Integer.valueOf(1), linkedList.first());
        Assert.assertEquals(Integer.valueOf(2), linkedList.last());
        Assert.assertEquals(2, linkedList.size());
    }

    @Test
    public void testRemoveFirstSuccess_WhenListIsEmpty(){
        Assert.assertNull(linkedList.removeFirst());
    }

    @Test
    public void testRemoveFirstSuccess_WhenThereIsAnElement(){
        linkedList.addLast(1);

        Assert.assertEquals(Integer.valueOf(1), linkedList.removeFirst());
        Assert.assertNull(linkedList.first());
        Assert.assertNull(linkedList.last());
        Assert.assertEquals(0, linkedList.size());
    }

    @Test
    public void testRemoveFirstSuccess_WhenThereAreTwoElements(){
        linkedList.addLast(1);
        linkedList.addLast(2);

        Assert.assertEquals(Integer.valueOf(1), linkedList.removeFirst());
        Assert.assertEquals(Integer.valueOf(2), linkedList.first());
        Assert.assertEquals(Integer.valueOf(2), linkedList.last());
        Assert.assertEquals(1, linkedList.size());
    }
}
