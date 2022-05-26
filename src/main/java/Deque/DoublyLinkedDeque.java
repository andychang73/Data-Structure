package Deque;


import LinkedList.DoublyLinkedList;

public class DoublyLinkedDeque<E> implements Deque<E> {

    private final DoublyLinkedList<E> linkedList = new DoublyLinkedList<E>();

    @Override
    public int size() {
        return linkedList.size();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public E first() {
        return linkedList.first();
    }

    @Override
    public E last() {
        return linkedList.last();
    }

    @Override
    public void addFirst(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public void addLast(E e) {
        linkedList.addLast(e);
    }

    @Override
    public E removeFirst() {
        return linkedList.removeFirst();
    }

    @Override
    public E removeLast() {
        return linkedList.removeLast();
    }
}
