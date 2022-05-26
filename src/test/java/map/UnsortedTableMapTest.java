package map;

import Iterator.Iterator;
import map.impl.UnsortedTableMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UnsortedTableMapTest {

    private UnsortedTableMap<Integer, Integer> map;

    @Before
    public void init(){
        map = new UnsortedTableMap<>();
    }

    @Test
    public void testGet_WhenKeyDoesNotExist(){
        Assert.assertNull(map.get(1));
    }

    @Test
    public void testGet_WhenKeyExists(){
        map.put(1,1);

        Assert.assertEquals(Integer.valueOf(1), map.get(1));
    }

    @Test
    public void testPut_WhenKeyDoesNotExists(){

        Assert.assertEquals(Integer.valueOf(1), map.put(1, 1));
    }

    @Test
    public void testPut_WhenKeyExists(){
        map.put(1, 1);

        Assert.assertEquals(Integer.valueOf(1), map.put(1,2));
    }

    @Test
    public void testRemove_WhenKeyDoesNotExist(){
        Assert.assertNull(map.remove(1));
    }

    @Test
    public void testRemove_WhenKeyExists(){
        map.put(1, 1);

        Assert.assertEquals(Integer.valueOf(1), map.remove(1));
    }

    @Test
    public void testIterator(){
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
        map.put(4,4);

        int[] result = new int[]{1,2,3,4};
        int count = 0;
        Iterator<Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Entry<Integer, Integer> entry = iterator.next();
            Assert.assertEquals(Integer.valueOf(result[count]), entry.getKey());
            Assert.assertEquals(Integer.valueOf(result[count++]), entry.getValue());
        }
    }
}
