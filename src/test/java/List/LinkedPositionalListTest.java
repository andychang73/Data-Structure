package List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkedPositionalListTest {

    private LinkedPositionalList<Integer> positionalList;

    @Before
    public void init(){
        positionalList = new LinkedPositionalList<Integer>();
    }

    @Test
    public void testFirstSuccess_WhenListIsEmpty(){
        Assert.assertNull(positionalList.first());
    }

    @Test
    public void testLastSuccess_WhenListIsEmpty(){
        Assert.assertNull(positionalList.last());
    }

    @Test
    public void testAddFirstSuccess_WhenAddFirstOnce(){
        positionalList.addFirst(1);

        Assert.assertEquals(Integer.valueOf(1), positionalList.first().getElement());
        Assert.assertEquals(Integer.valueOf(1), positionalList.last().getElement());
        Assert.assertEquals(1, positionalList.size());
    }

    @Test
    public void testFirstSuccess_WhenAddFirstTwice(){
        positionalList.addFirst(1);
        positionalList.addFirst(2);

        Assert.assertEquals(Integer.valueOf(2), positionalList.first().getElement());
        Assert.assertEquals(Integer.valueOf(1), positionalList.last().getElement());
        Assert.assertEquals(2, positionalList.size());
    }

    @Test
    public void testFirstSuccess_WhenAddLastOnce(){
        positionalList.addLast(1);

        Assert.assertEquals(Integer.valueOf(1), positionalList.first().getElement());
        Assert.assertEquals(Integer.valueOf(1), positionalList.last().getElement());
        Assert.assertEquals(1, positionalList.size());
    }

    @Test
    public void testFirstSuccess_WhenAddLastTwice(){
        positionalList.addLast(1);
        positionalList.addLast(2);

        Assert.assertEquals(Integer.valueOf(1), positionalList.first().getElement());
        Assert.assertEquals(Integer.valueOf(2), positionalList.last().getElement());
        Assert.assertEquals(2, positionalList.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFirstFailed_WhenPositionIsNoLongerValid(){
        Position<Integer> p = positionalList.addLast(1);
        positionalList.remove(p);

        positionalList.addAfter(p, 2);
    }

    @Test
    public void testAddAfterSuccess_WhenAddAfterAddFirst(){
        Position<Integer> p = positionalList.addFirst(1);
        p = positionalList.addAfter(p, 2);

        Assert.assertEquals(Integer.valueOf(2), p.getElement());
        Assert.assertEquals(Integer.valueOf(1), positionalList.first().getElement());
        Assert.assertEquals(2, positionalList.size());
    }

    @Test
    public void testAddBeforeSuccess_WhenAddAfterAddFirst(){
        Position<Integer> p = positionalList.addFirst(1);
        p = positionalList.addBefore(p, 2);

        Assert.assertEquals(Integer.valueOf(2), p.getElement());
        Assert.assertEquals(Integer.valueOf(1), positionalList.last().getElement());
        Assert.assertEquals(2, positionalList.size());
    }

    @Test
    public void testAfterSuccess_WhenThereIsAnElement(){
        Position<Integer> p = positionalList.addLast(1);
        p = positionalList.after(p);

        Assert.assertNull(p);
        Assert.assertEquals(1, positionalList.size());
    }

    @Test
    public void testAfterSuccess_WhenThereAreTwoElements(){
        Position<Integer> p = positionalList.addLast(1);
        positionalList.addLast(2);

        Assert.assertEquals(Integer.valueOf(2), positionalList.after(p).getElement());
        Assert.assertEquals(2, positionalList.size());
    }

    @Test
    public void testBeforeSuccess_WhenThereIsAnElement(){
        Position<Integer> p = positionalList.addLast(1);
        p = positionalList.before(p);

        Assert.assertNull(p);
        Assert.assertEquals(1, positionalList.size());
    }

    @Test
    public void testBeforeSuccess_WhenThereAreTwoElements(){
        Position<Integer> p = positionalList.addFirst(1);
        positionalList.addFirst(2);

        Assert.assertEquals(Integer.valueOf(2), positionalList.before(p).getElement());
        Assert.assertEquals(2, positionalList.size());
    }

    @Test
    public void testSetSuccess_WhenThereIsAnElement(){
        Position<Integer> p = positionalList.addFirst(1);
        Integer i = positionalList.set(p, 2);

        Assert.assertEquals(Integer.valueOf(1), i);
        Assert.assertEquals(Integer.valueOf(2), p.getElement());
        Assert.assertEquals(1, positionalList.size());
    }

    @Test
    public void testRemoveSuccess_WhenThereIsAnElement(){
        Position<Integer> p = positionalList.addFirst(1);
        Integer i = positionalList.remove(p);

        Assert.assertEquals(Integer.valueOf(1), i);
        Assert.assertEquals(0, positionalList.size());
    }
}
