package Sorting;

import org.junit.Assert;
import org.junit.Test;

public class HeapSortTest {

    @Test
    public void testHeapSort1(){
        int[] array = new int[]{97,34,91,12,5,90,64,1};
        HeapSort.sort(array);

        for(int i = 0; i < array.length - 1; i++){
            Assert.assertTrue(array[i] <= array[i + 1]);
        }
    }

    @Test
    public void testHeapSort2(){
        int[] array = new int[]{1,1,1,1,1,1,1,1};
        HeapSort.sort(array);

        for(int i = 0; i < array.length - 1; i++){
            Assert.assertTrue(array[i] <= array[i + 1]);
        }
    }

    @Test
    public void testHeapSort3(){
        int[] array = new int[]{9,8,7,6,5,4,3,2,1};
        HeapSort.sort(array);

        for(int i = 0; i < array.length - 1; i++){
            Assert.assertTrue(array[i] <= array[i + 1]);
        }
    }

    @Test
    public void testHeapSort4(){
        int[] array = new int[]{0,1,2,3,4,5,6,7,8,9};
        HeapSort.sort(array);

        for(int i = 0; i < array.length - 1; i++){
            Assert.assertTrue(array[i] <= array[i + 1]);
        }
    }
}
