package Sorting;

import Comparator.Ascending;
import Comparator.Descending;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import Utils.*;


public class BubbleSortTest {

    private int[] data;

    @Before
    public void init(){
        data = RandomUtil.generateRandomArray(new int[20], 1, 20);
    }

    @Test
    public void testSort_Ascending(){
        BubbleSort.sort(data, new Ascending());

        for(int i = 0; i < data.length -1; i++){
            Assert.assertTrue(data[i] <= data[i+1]);
        }
    }

    @Test
    public void testSort_Descending(){
        BubbleSort.sort(data, new Descending());

        for(int i = 0 ; i < data.length -1; i++){
            Assert.assertTrue(data[i] >= data[i+1]);
        }
    }
}
