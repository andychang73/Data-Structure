package Sorting;

import Comparator.Comparator;

public class BubbleSort {

    public static void sort(int[] data, Comparator comparator){
        for(int i = 1; i < data.length; i++){
            for(int k = 0; k < data.length - i; k++){
                if(comparator.compare(data[k], data[k+1])){
                    int temp = data[k];
                    data[k] = data[k+1];
                    data[k+1] = temp;
                }
            }
        }
    }
}
