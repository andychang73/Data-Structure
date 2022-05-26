package Queue;

import LinkedList.CircularlyLinkedList;
import Queue.interfaces.CircularQueue;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LinkedCircularQueue<E> implements CircularQueue<E> {

    private final CircularlyLinkedList<E> linkedList = new CircularlyLinkedList<>();

    @Override
    public void rotate() {
        linkedList.rotate();
    }

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
