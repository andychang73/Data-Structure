package map;

import Iterator.Iterator;
import map.impl.ChainHashMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChainHashMapTest {

    private ChainHashMap<Integer, Integer> map;

    @Before
    public void init(){
        map = new ChainHashMap<>();
    }

    @Test
    public void testPut_WhenMapIsEmpty(){
        Assert.assertEquals(Integer.valueOf(1), map.put(1,1));
        Assert.assertEquals(1, map.size());
    }

    @Test
    public void testPut_WhenPutSameKeyTwice(){
        map.put(1,1);
        Assert.assertEquals(Integer.valueOf(1), map.put(1,2));
        Assert.assertEquals(1, map.size());
    }

    @Test
    public void testPut_WhenPutTwoDifferentKeys(){
        Assert.assertEquals(Integer.valueOf(1), map.put(1,1));
        Assert.assertEquals(Integer.valueOf(2), map.put(2,2));
        Assert.assertEquals(2, map.size());
    }

    @Test
    public void testGet_WhenKeyDoesNotExist(){
        Assert.assertNull(map.get(1));
        Assert.assertEquals(0, map.size());
    }

    @Test
    public void testGet_WhenKeyExists(){
        map.put(1,1);

        Assert.assertEquals(Integer.valueOf(1), map.get(1));
        Assert.assertEquals(1, map.size());
    }

    @Test
    public void testRemove_WhenKeyDoesNotExists(){
        Assert.assertNull(map.remove(1));
        Assert.assertEquals(0, map.size());
    }

    @Test
    public void testRemove_WhenKeyExists(){
        map.put(1,1);

        Assert.assertEquals(Integer.valueOf(1), map.remove(1));
        Assert.assertEquals(0, map.size());
    }

    @Test
    public void testEntrySet(){
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
        map.put(4,4);
        map.put(5,5);

        int[] result = new int[]{1,2,3,4,5};
        Iterator<Entry<Integer,Integer>> iterator = map.entrySet().iterator();

        while(iterator.hasNext()){
            Assert.assertTrue(isEntryExists(iterator.next(), result));
        }
    }

    private boolean isEntryExists(Entry<Integer, Integer> entry, int[] result){
        for (int j : result) {
            if (entry.getKey().equals(j) && entry.getValue().equals(j)) {
                return true;
            }
        }
        return false;
    }
}
