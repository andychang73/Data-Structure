package LinkedList;

import org.junit.Assert;
import org.junit.Test;

public class CircularlyLinkedListTest {

    @Test
    public void testFirstSuccess_WhenListIsEmpty(){
        CircularlyLinkedList<Integer> linkedList = new CircularlyLinkedList<>();

        Assert.assertNull(linkedList.first());
    }

    @Test
    public void testFirstSuccess_WhenThereIsOneElement(){
        CircularlyLinkedList<Integer> linkedList = new CircularlyLinkedList<>();
        linkedList.addFirst(1);

        Assert.assertEquals(Integer.valueOf(1), linkedList.first());
    }

    @Test
    public void testFirstSuccess_WhenThereAreTwoElements(){
        CircularlyLinkedList<Integer> linkedList = new CircularlyLinkedList<>();
        linkedList.addFirst(1);
        linkedList.addFirst(2);

        Assert.assertEquals(Integer.valueOf(2), linkedList.first());
    }

    @Test
    public void testLastSuccess_WhenListIsEmpty(){
        CircularlyLinkedList<Integer> linkedList = new CircularlyLinkedList<>();

        Assert.assertNull(linkedList.last());
    }

    @Test
    public void testLastSuccess_WhenThereIsOneElement(){
        CircularlyLinkedList<Integer> linkedList = new CircularlyLinkedList<>();
        linkedList.addFirst(1);

        Assert.assertEquals(Integer.valueOf(1), linkedList.last());
    }

    @Test
    public void testAddFirstSuccess_WhenAddTwoElements(){
        CircularlyLinkedList<Integer> linkedList = new CircularlyLinkedList<>();
        linkedList.addFirst(1);
        linkedList.addFirst(2);

        Assert.assertEquals(2, linkedList.size());
        Assert.assertEquals(Integer.valueOf(2), linkedList.first());
        Assert.assertEquals(Integer.valueOf(1), linkedList.last());
    }

    @Test
    public void testAddLastSuccess_WhenAddTwoElements(){
        CircularlyLinkedList<Integer> linkedList = new CircularlyLinkedList<>();
        linkedList.addLast(1);
        linkedList.addLast(2);

        Assert.assertEquals(2, linkedList.size());
        Assert.assertEquals(Integer.valueOf(2), linkedList.last());
        Assert.assertEquals(Integer.valueOf(1), linkedList.first());
    }

    @Test
    public void testRotateSuccess_WhenThereIsOneElement(){
        CircularlyLinkedList<Integer> linkedList = new CircularlyLinkedList<>();
        linkedList.addLast(1);
        linkedList.rotate();

        Assert.assertEquals(Integer.valueOf(1), linkedList.last());
    }

    @Test
    public void testRotateSuccess_WhenThereAreTwoElements(){
        CircularlyLinkedList<Integer> linkedList = new CircularlyLinkedList<>();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.rotate();

        Assert.assertEquals(Integer.valueOf(2), linkedList.last());
        Assert.assertEquals(Integer.valueOf(1), linkedList.first());
    }

    @Test
    public void testRemoveFirstSuccess_WhenListIsEmpty(){
        CircularlyLinkedList<Integer> linkedList = new CircularlyLinkedList<>();

        Assert.assertNull(linkedList.removeFirst());
    }

    @Test
    public void testRemoveFirstSuccess_WhenThereIsOneElement(){
        CircularlyLinkedList<Integer> linkedList = new CircularlyLinkedList<>();
        linkedList.addFirst(1);

        Integer first = linkedList.removeFirst();
        Assert.assertEquals(Integer.valueOf(1), first);
        Assert.assertEquals(0, linkedList.size());
    }

    @Test
    public void testRemoveFirstSuccess_WhenThereAreTwoElements(){
        CircularlyLinkedList<Integer> linkedList = new CircularlyLinkedList<>();
        linkedList.addFirst(1);
        linkedList.addFirst(2);

        Integer first = linkedList.removeFirst();
        Assert.assertEquals(Integer.valueOf(2), first);
        Assert.assertEquals(1, linkedList.size());
    }
}
