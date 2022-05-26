package List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayPositionalListTest {

    private ArrayPositionalList positionalList;

    @Before
    public void init(){
        positionalList = new ArrayPositionalList(5);
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
    public void testAddFirstSuccess_WhenAddOnce(){
        positionalList.addFirst("a");

        Assert.assertEquals("a", positionalList.first().getElement());
        Assert.assertEquals("a", positionalList.last().getElement());
        Assert.assertEquals(1, positionalList.size());
    }

    @Test
    public void testAddFirstSuccess_WhenAddTwice(){
        positionalList.addFirst("a");
        positionalList.addFirst("b");

        Assert.assertEquals("b", positionalList.first().getElement());
        Assert.assertEquals("a", positionalList.last().getElement());
        Assert.assertEquals(2, positionalList.size());
    }

    @Test
    public void testAddLastSuccess_WhenAddOnce(){
        positionalList.addLast("a");

        Assert.assertEquals("a", positionalList.first().getElement());
        Assert.assertEquals("a", positionalList.last().getElement());
        Assert.assertEquals(1, positionalList.size());
    }

    @Test
    public void testAddLastSuccess_WhenAddTwice(){
        positionalList.addLast("a");
        positionalList.addLast("b");

        Assert.assertEquals("a", positionalList.first().getElement());
        Assert.assertEquals("b", positionalList.last().getElement());
        Assert.assertEquals(2, positionalList.size());
    }

    @Test
    public void testRemoveSuccess_WhenThereIsOnlyAnElement(){
        Position<String> p = positionalList.addLast("a");

        Assert.assertEquals("a", positionalList.remove(p));
        Assert.assertEquals(0, positionalList.size());
    }

    @Test
    public void testRemoveSuccess_WhenRemoveFirstElementWhenThereAreTwoElements(){
        positionalList.addLast("a");
        Position<String> p = positionalList.addLast("b");

        Assert.assertEquals("a", positionalList.remove(positionalList.before(p)));
        Assert.assertEquals(1, positionalList.size());
    }

    @Test
    public void testBeforeSuccess_WhenAddLastOnce(){
        Position<String> p = positionalList.addLast("a");

        Assert.assertNull(positionalList.before(p));
    }

    @Test
    public void testBeforeSuccess_WhenAddLastTwice(){
        positionalList.addLast("a");
        Position<String> p = positionalList.addLast("b");

        Assert.assertEquals("a", positionalList.before(p).getElement());
    }

    @Test
    public void testAfterSuccess_WhenAddFirstOnce(){
        Position<String> p =positionalList.addFirst("a");

        Assert.assertNull(positionalList.after(p));
    }

    @Test
    public void testAfterSuccess_WhenAddFirstTwice(){
        positionalList.addFirst("a");
        Position<String> p = positionalList.addFirst("b");

        Assert.assertEquals("a", positionalList.after(p).getElement());
    }

    @Test
    public void testSetSuccess_WhenAddFirstOnce(){
        Position<String> p = positionalList.addFirst("a");

        Assert.assertEquals("a", positionalList.set(p, "b"));
    }

    @Test
    public void testAddAfterSuccess_WhenAddAfterFirstElementWhenThereIsAnElement(){
        Position<String> p = positionalList.addFirst("a");
        p = positionalList.addAfter(p, "b");

        Assert.assertEquals("b", p.getElement());
        Assert.assertEquals("a", positionalList.before(p).getElement());
        Assert.assertNull(positionalList.after(p));
        Assert.assertEquals(2, positionalList.size());
    }

    @Test
    public void testAddAfterSuccess_WhenAddAfterSecondElementWhenThereAreTwoElements(){
        positionalList.addLast("a");
        Position<String> p = positionalList.addLast("c");
        p = positionalList.before(p);
        p = positionalList.addAfter(p, "b");

        Assert.assertEquals("b", p.getElement());
        Assert.assertEquals("a", positionalList.before(p).getElement());
        Assert.assertEquals("c", positionalList.after(p).getElement());
        Assert.assertEquals(3, positionalList.size());
    }

    @Test
    public void testAddBeforeSuccess_WhenAddAfterFirstElementWhenThereIsAnElement(){
        Position<String> p = positionalList.addFirst("a");
        p = positionalList.addBefore(p, "b");

        Assert.assertEquals("b", p.getElement());
        Assert.assertEquals("a", positionalList.after(p).getElement());
        Assert.assertNull(positionalList.before(p));
        Assert.assertEquals(2, positionalList.size());
    }

    @Test
    public void testAddBeforeSuccess_WhenAddBeforeSecondElementWhenThereAreTwoElements(){
        positionalList.addLast("a");
        Position<String> p = positionalList.addLast("c");
        p = positionalList.addBefore(p, "b");

        Assert.assertEquals("b", p.getElement());
        Assert.assertEquals("a", positionalList.before(p).getElement());
        Assert.assertEquals("c", positionalList.after(p).getElement());
        Assert.assertEquals(3, positionalList.size());
    }
}
