package LinkedList;

import lombok.AllArgsConstructor;
import lombok.Data;

public class CircularlyLinkedList<E> {

    @Data
    @AllArgsConstructor
    private static class Node<E>{
        private E element;
        private Node<E> next;
    }

    private Node<E> tail;
    private int size = 0;

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E first(){
        if(isEmpty()){
            return null;
        }
        return tail.getNext().getElement();
    }

    public E last(){
        if(isEmpty()){
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E e){
        Node<E> node = new Node<>(e, null);
        if(isEmpty()){
            tail = node;
            tail.setNext(tail);
        }else{
            node.setNext(tail.getNext());
            tail.setNext(node);
        }
        size++;
    }

    public void addLast(E e){
        addFirst(e);
        tail = tail.getNext();
    }

    public void rotate(){
        if(tail != null){
            tail = tail.getNext();
        }
    }

    public E removeFirst(){
        if(isEmpty()){
            return null;
        }
        Node<E> head = tail.getNext();
        if(head == tail){
            tail = null;
        }else{
            tail.setNext(head.getNext());
        }
        size--;
        return head.getElement();
    }
}
