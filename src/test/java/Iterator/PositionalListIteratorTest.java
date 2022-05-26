package Iterator;


import Iterator.positionalList.Position;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

public class PositionalListIteratorTest {

    private LinkedPositionalList<Integer> positionalList;

    @Before
    public void init(){
        positionalList = new LinkedPositionalList<Integer>();
    }

    @Test
    public void testPositionHasNextSuccess_WhenListIsEmpty(){
        Iterator<Position<Integer>> iterator = positionalList.positions().iterator();
        Assert.assertFalse(iterator.hasNext());
    }

    @Test
    public void testPositionHasNextSuccess_WhenThereIsAnElement(){
        positionalList.addLast(1);
        Iterator<Position<Integer>> iterator = positionalList.positions().iterator();
        Assert.assertTrue(iterator.hasNext());
    }

    @Test
    public void testPositionNextSuccess_WhenThereIsAnElement(){
        positionalList.addFirst(1);
        Iterator<Position<Integer>> iterator = positionalList.positions().iterator();
        Assert.assertEquals(Integer.valueOf(1),  iterator.next().getElement());
    }

    @Test(expected = NoSuchElementException.class)
    public void testPositionNextFailed_WhenListIsEmpty(){
        Iterator<Position<Integer>> iterator = positionalList.positions().iterator();
        iterator.next();
    }

    @Test(expected = IllegalStateException.class)
    public void testPositionRemoveFailed_WhenListIsEmpty(){
        Iterator<Position<Integer>> iterator = positionalList.positions().iterator();
        iterator.remove();
    }

    @Test(expected = IllegalStateException.class)
    public void testPositionRemoveFailed_WhenThereIsAnElementWithoutInvokingNext(){
        positionalList.addFirst(1);
        Iterator<Position<Integer>> iterator = positionalList.positions().iterator();
        iterator.remove();
    }

    @Test
    public void testPositionRemoveSuccess_WhenThereIsAnElementAndInvokedNext(){
        positionalList.addFirst(1);
        Iterator<Position<Integer>> iterator = positionalList.positions().iterator();
        iterator.next();
        iterator.remove();
    }

    @Test
    public void testHasNextSuccess_WhenListIsEmpty(){
        Iterator<Integer> iterator = positionalList.iterator();
        Assert.assertFalse(iterator.hasNext());
    }

    @Test
    public void testHasNextSuccess_WhenThereIsAnElement(){
        positionalList.addFirst(1);
        Iterator<Integer> iterator = positionalList.iterator();
        Assert.assertTrue(iterator.hasNext());
    }

    @Test
    public void testNextSuccess_WhenThereIsAnElement(){
        positionalList.addFirst(1);
        Iterator<Integer> iterator = positionalList.iterator();
        Assert.assertEquals(Integer.valueOf(1),  iterator.next());
    }

    @Test(expected = NoSuchElementException.class)
    public void testNextFailed_WhenListIsEmpty(){
        Iterator<Integer> iterator = positionalList.iterator();
        iterator.next();
    }

    @Test(expected = IllegalStateException.class)
    public void testRemoveFailed_WhenListIsEmpty(){
        Iterator<Integer> iterator = positionalList.iterator();
        iterator.remove();
    }

    @Test(expected = IllegalStateException.class)
    public void testRemoveFailed_WhenThereIsAnElementWithoutInvokingNext(){
        positionalList.addFirst(1);
        Iterator<Integer> iterator = positionalList.iterator();
        iterator.remove();
    }

    @Test
    public void testRemoveSuccess_WhenThereIsAnElementAndInvokedNext(){
        positionalList.addFirst(1);
        Iterator<Integer> iterator = positionalList.iterator();
        iterator.next();
        iterator.remove();
    }
}
