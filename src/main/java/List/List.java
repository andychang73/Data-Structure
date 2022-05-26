package List;

public interface List<E> {

    int size();

    boolean isEmpty();

    E get(int index);

    E set(int index, E e);

    void add(E e);

    void add(int index, E e);

    E remove(int index);
}

