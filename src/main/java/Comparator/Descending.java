package Comparator;

public class Descending implements Comparator{
    @Override
    public boolean compare(int first, int second) {
        return first < second;
    }
}
