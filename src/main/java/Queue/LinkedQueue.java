package Queue;

import LinkedList.SinglyLinkedList;
import Queue.interfaces.Queue;

public class LinkedQueue<E> implements Queue<E> {

    private final SinglyLinkedList<E> linkedList = new SinglyLinkedList<>();

    @Override
    public int size() {
        return linkedList.size();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        linkedList.addLast(e);
    }

    @Override
    public E first() {
        return linkedList.first();
    }

    @Override
    public E dequeue() {
        return linkedList.removeFirst();
    }
}
