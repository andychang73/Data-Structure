package Comparator;

public class Ascending implements Comparator {

    @Override
    public boolean compare(int first, int second) {
        return first > second;
    }
}
