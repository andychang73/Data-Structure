package Iterator;

public interface List<E> extends Iterable<E>{

    int size();

    boolean isEmpty();

    E get(int index);

    void add(E e);

    void add(int index, E e);

    E set(int index, E e);

    E remove(int index);
}
