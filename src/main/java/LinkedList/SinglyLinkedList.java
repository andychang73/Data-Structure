package LinkedList;

import lombok.AllArgsConstructor;
import lombok.Data;

public class SinglyLinkedList<E> {

    @Data
    @AllArgsConstructor
    private static class Node<E>{
        private E element;
        private Node<E> next;
    }

    private Node<E> head = null;
    private Node<E> tail = null;
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
        return head.getElement();
    }

    public E last(){
        if(isEmpty()){
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E e){
        head = new Node<>(e, head);
        if(isEmpty()){
            tail = head;
        }
        size++;
    }

    public void addLast(E e){
        Node<E> node = new Node<>(e, null);
        if(isEmpty()){
            head = node;
        }else{
            tail.setNext(node);
        }
        tail = node;
        size++;
    }

    public E removeFirst(){
        if(isEmpty()){
            return null;
        }
        E element = head.getElement();
        head = head.getNext();
        size--;
        if(isEmpty()){
            tail = null;
        }
        return element;
    }
}
