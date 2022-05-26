package List;

import lombok.AllArgsConstructor;
import lombok.Data;

public class LinkedPositionalList<E> implements PositionalList<E>{

    @Data
    @AllArgsConstructor
    private static class Node<E> implements Position<E>{

        private E element;
        private Node<E> prev;
        private Node<E> next;

        @Override
        public E getElement() throws IllegalStateException {
            return element;
        }
    }

    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public LinkedPositionalList(){
        header = new Node<>(null, null, null);
        trailer = new Node<E>(null, header, null);
        header.setNext(trailer);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Position<E> first() {
        return position(header.getNext());
    }

    @Override
    public Position<E> last() {
        return position(trailer.getPrev());
    }

    @Override
    public Position<E> addFirst(E e) {
        return addBetween(e, header, header.getNext());
    }

    @Override
    public Position<E> addLast(E e) {
        return addBetween(e, trailer.getPrev(), trailer);
    }

    @Override
    public E remove(Position<E> p) {
        Node<E> node = validate(p);
        Node<E> prev = node.getPrev();
        Node<E> next = node.getNext();
        E temp = node.getElement();
        prev.setNext(next);
        next.setPrev(prev);
        size--;
        node.setNext(null);
        node.setPrev(null);
        node.setElement(null);
        return temp;
    }

    @Override
    public E set(Position<E> p, E e) {
        Node<E> node = validate(p);
        E temp = node.getElement();
        node.setElement(e);
        return temp;
    }

    @Override
    public Position<E> after(Position<E> p) {
        return position(validate(p).getNext());
    }

    @Override
    public Position<E> before(Position<E> p) {
        return position(validate(p).getPrev());
    }

    @Override
    public Position<E> addAfter(Position<E> p, E e) {
        Node<E> node = validate(p);
        return addBetween(e, node, node.getNext());
    }

    @Override
    public Position<E> addBefore(Position<E> p, E e) {
        Node<E> node = validate(p);
        return addBetween(e, node.getPrev(), node);
    }

    private Node<E> validate(Position<E> p){
        if(! (p instanceof Node)){
            throw new IllegalArgumentException();
        }
        Node<E> node = (Node<E>) p;
        if(node.getNext() == null){
            throw new IllegalArgumentException();
        }
        return node;
    }

    private Position<E> addBetween(E e, Node<E> prev, Node<E> next){
        Node<E> node = new Node<E>(e, prev, next);
        prev.setNext(node);
        next.setPrev(node);
        size++;
        return node;
    }

    private Position<E> position(Node<E> node){
        if(node == header || node == trailer){
            return null;
        }
        return node;
    }
}
