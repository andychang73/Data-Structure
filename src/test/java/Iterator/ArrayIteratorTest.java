package Iterator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

public class ArrayIteratorTest {

    private ArrayList<Integer> arrayList;

    @Before
    public void init(){
        arrayList = new ArrayList<Integer>();
    }

    @Test
    public void testHasNextSuccess_WhenListIsEmpty(){
        Iterator<Integer> iterator = arrayList.iterator();
        Assert.assertFalse(iterator.hasNext());
    }

    @Test
    public void testHasNextSuccess_WhenThereIsAnElement(){
        arrayList.add(1);
        Iterator<Integer> iterator = arrayList.iterator();
        Assert.assertTrue(iterator.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void testNextFailed_WhenListIsEmpty(){
        Iterator<Integer> iterator = arrayList.iterator();
        iterator.next();
    }

    @Test
    public void testNextSuccess_WhenThereIsAnElement(){
        arrayList.add(1);
        Iterator<Integer> iterator = arrayList.iterator();
        Assert.assertEquals(Integer.valueOf(1), iterator.next());
    }

    @Test(expected = IllegalStateException.class)
    public void testRemoveFailed_WhenListIsEmpty(){
        Iterator<Integer> iterator = arrayList.iterator();
        iterator.remove();
    }

    @Test(expected = IllegalStateException.class)
    public void testRemoveFailed_WhenThereIsAnElementWithoutInvokingNext(){
        arrayList.add(1);
        Iterator<Integer> iterator = arrayList.iterator();
        iterator.remove();
    }

    @Test
    public void testRemoveSuccess_WhenThereIsAnElementAndInvokedNext(){
        arrayList.add(1);
        Iterator<Integer> iterator = arrayList.iterator();
        iterator.next();
        iterator.remove();
    }
}
