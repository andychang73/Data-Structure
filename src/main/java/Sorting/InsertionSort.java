package Sorting;

import Comparator.Comparator;

public class InsertionSort {

    public static void sort(int[] data, Comparator comparator){
        for(int i = 1; i < data.length; i++){
            int currentIndex = i;
            int currentValue = data[i];
            while(currentIndex > 0 && comparator.compare(data[currentIndex-1], currentValue)){
                data[currentIndex] = data[currentIndex-1];
                currentIndex--;
            }
            data[currentIndex] = currentValue;
        }
    }
}
