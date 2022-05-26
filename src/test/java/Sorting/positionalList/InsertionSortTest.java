package Sorting.positionalList;


import List.LinkedPositionalList;
import List.Position;
import List.PositionalList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InsertionSortTest {

    private PositionalList<Integer> positionalList;

    @Before
    public void init(){
        positionalList = new LinkedPositionalList<Integer>();
    }

    @Test
    public void testSortSuccess_DescendingOrder(){
        positionalList.addLast(5);
        positionalList.addLast(4);
        positionalList.addLast(3);
        positionalList.addLast(2);
        positionalList.addLast(1);

        InsertionSort.insertionSort(positionalList);
        check(positionalList);
    }

    @Test
    public void testSortSuccess_AscendingOrder(){
        positionalList.addLast(1);
        positionalList.addLast(2);
        positionalList.addLast(3);
        positionalList.addLast(4);
        positionalList.addLast(5);

        InsertionSort.insertionSort(positionalList);
        check(positionalList);
    }

    @Test
    public void testSortSuccess_RandomOrder(){
        positionalList.addLast(5);
        positionalList.addLast(1);
        positionalList.addLast(4);
        positionalList.addLast(2);
        positionalList.addLast(3);

        InsertionSort.insertionSort(positionalList);
        check(positionalList);
    }

    private void check(PositionalList<Integer> list){
        Position<Integer> current = list.first();
        while(current != list.last()){
            System.out.println("current: " + current.getElement() + " next: " + list.after(current).getElement());
            Assert.assertTrue(current.getElement().compareTo(list.after(current).getElement()) < 0);
            current = list.after(current);
        }
    }
}
