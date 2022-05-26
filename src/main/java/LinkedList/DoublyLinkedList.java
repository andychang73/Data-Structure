package LinkedList;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.LinkedList;

public class DoublyLinkedList<E> {

    @Data
    @AllArgsConstructor
    private static class Node<E>{
      private E element;
      private Node<E> prev;
      private Node<E> next;
    }

    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public DoublyLinkedList(){
        header = new Node<E>(null, null, null);
        trailer = new Node<E>(null, header, null);
        header.setNext(trailer);
    }

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
        return header.getNext().getElement();
    }

    public E last(){
        if(isEmpty()){
            return null;
        }
        return trailer.getPrev().getElement();
    }

    public void addFirst(E e){
        addBetween(e, header, header.getNext());
    }

    public void addLast(E e){
        addBetween(e, trailer.getPrev(), trailer);
    }

    public E removeFirst(){
        if(isEmpty()){
            return null;
        }
        Node<E> node = header.getNext();
        Node<E> next = node.getNext();
        header.setNext(next);
        next.setPrev(header);
        size--;
        return node.getElement();
    }

    public E removeLast(){
        if(isEmpty()){
            return null;
        }
        Node<E> node = trailer.getPrev();
        Node<E> prev = node.getPrev();
        trailer.setPrev(prev);
        prev.setNext(trailer);
        size--;
        return node.getElement();
    }

    private void addBetween(E e, Node<E> prev, Node<E> next){
        Node<E> node = new Node<E>(e, prev, next);
        prev.setNext(node);
        next.setPrev(node);
        size++;
    }
}
