package Stack;


import LinkedList.SinglyLinkedList;

public class LinkedStack<E> implements Stack<E> {

    SinglyLinkedList<E> linkedList = new SinglyLinkedList<>();

    @Override
    public int size() {
        return linkedList.size();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E top() {
        return linkedList.first();
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }
}
