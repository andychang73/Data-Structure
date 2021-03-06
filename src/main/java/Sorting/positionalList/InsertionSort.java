package Sorting.positionalList;

import List.Position;
import List.PositionalList;

public class InsertionSort {

    public static void insertionSort(PositionalList<Integer> list){
        Position<Integer> marker = list.first();
        while(marker != list.last()){
            Position<Integer> pivot = list.after(marker);
            Integer value = pivot.getElement();
            if(value > marker.getElement()){
                marker = pivot;
            }else{
                Position<Integer> walk = marker;
                while(walk != list.first() && list.before(walk).getElement() > value){
                    walk = list.before(walk);
                }
                list.addBefore(walk, list.remove(pivot));
            }
        }
    }
}
