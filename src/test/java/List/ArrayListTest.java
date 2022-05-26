package List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayListTest {

    private ArrayList<Integer> arrayList;

    @Before
    public void init(){
        arrayList = new ArrayList<Integer>(2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetFailed_WhenListIsEmpty(){
        arrayList.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetFailed_WhenThereIsAnElementAndIndexIsOne(){
        arrayList.add(1);
        arrayList.get(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetFailed_WhenThereIsAnElementAndIndexIsLessThanZero(){
        arrayList.add(1);
        arrayList.get(-1);
    }

    @Test
    public void testGetSuccess_WhenThereIsAnElementAndIndexIsZero(){
        arrayList.add(1);

        Assert.assertEquals(Integer.valueOf(1), arrayList.get(0));
        Assert.assertEquals(1, arrayList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetFailed_WhenThereIsAnElementAndIndexIsOne(){
        arrayList.add(1);

        arrayList.set(1, 2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetFailed_WhenThereIsAnElementAndIndexIsLessThanZero(){
        arrayList.add(1);

        arrayList.set(-1, 1);
    }

    @Test
    public void testSetSuccess_WhenThereIsAnElementAndIndexIsZero(){
        arrayList.add(1);

        Assert.assertEquals(Integer.valueOf(1), arrayList.set(0, 2));
        Assert.assertEquals(Integer.valueOf(2), arrayList.get(0));
        Assert.assertEquals(1, arrayList.size());
    }

    @Test
    public void testAddSuccess_WhenThreeElementsWhenInitialCapacityIsTwo(){
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        Assert.assertEquals(3, arrayList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddFailed_WhenThereIsAnElementAndIndexIsTwo(){
        arrayList.add(1);

        arrayList.add(2, 2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddFailed_WhenThereIsAnElementAndIndexIsLessThanZero(){
        arrayList.add(1);

        arrayList.add(2, 2);
    }

    @Test
    public void testAddSuccess_WhenThereAreTwoElementsAndIndexIsZero(){
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(0, 3);

        Assert.assertEquals(Integer.valueOf(3), arrayList.get(0));
        Assert.assertEquals(Integer.valueOf(1), arrayList.get(1));
        Assert.assertEquals(Integer.valueOf(2), arrayList.get(2));
        Assert.assertEquals(3, arrayList.size());
    }

    @Test
    public void testAddSuccess_WhenThereAreTwoElementsAndIndexIsOne(){
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(1,3);

        Assert.assertEquals(Integer.valueOf(1), arrayList.get(0));
        Assert.assertEquals(Integer.valueOf(3), arrayList.get(1));
        Assert.assertEquals(Integer.valueOf(2), arrayList.get(2));
        Assert.assertEquals(3, arrayList.size());
    }

    @Test
    public void testAddSuccess_WhenThereAreTwoElementsAndIndexIsTwo(){
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(2, 3);

        Assert.assertEquals(Integer.valueOf(1), arrayList.get(0));
        Assert.assertEquals(Integer.valueOf(2), arrayList.get(1));
        Assert.assertEquals(Integer.valueOf(3), arrayList.get(2));
        Assert.assertEquals(3, arrayList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveFailed_WhenArrayListIsEmpty(){
        arrayList.remove(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveFailed_WhenThereIsAnElementAndIndexIsOne(){
        arrayList.add(1);

        arrayList.remove(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveFailed_WhenThereIsAnElementAndIndexIsLessThanZero(){
        arrayList.add(1);

        arrayList.remove(-1);
    }

    @Test
    public void testRemoveSuccess_WhenThereAreThreeElementsAndIndexIsZero(){
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        Assert.assertEquals(Integer.valueOf(1), arrayList.remove(0));
        Assert.assertEquals(Integer.valueOf(2), arrayList.get(0));
        Assert.assertEquals(Integer.valueOf(3), arrayList.get(1));
        Assert.assertEquals(2, arrayList.size());
    }

    @Test
    public void testRemoveSuccess_WhenThereAreThreeElementsAndIndexIsOne(){
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        Assert.assertEquals(Integer.valueOf(2), arrayList.remove(1));
        Assert.assertEquals(Integer.valueOf(1), arrayList.get(0));
        Assert.assertEquals(Integer.valueOf(3), arrayList.get(1));
        Assert.assertEquals(2, arrayList.size());
    }

    @Test
    public void testRemoveSuccess_WhenThereAreThreeElementsAndIndexIsTwo(){
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        Assert.assertEquals(Integer.valueOf(3), arrayList.remove(2));
        Assert.assertEquals(Integer.valueOf(1), arrayList.get(0));
        Assert.assertEquals(Integer.valueOf(2), arrayList.get(1));
        Assert.assertEquals(2, arrayList.size());
    }
}
