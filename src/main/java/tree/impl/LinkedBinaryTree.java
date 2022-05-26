package tree.impl;

import Iterator.Iterable;
import Iterator.Iterator;
import Iterator.List;
import Iterator.ArrayList;
import Iterator.positionalList.Position;
import Queue.LinkedQueue;
import lombok.AllArgsConstructor;
import lombok.Data;
import tree.AbstractBinaryTree;

import java.util.NoSuchElementException;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {

    @Data
    @AllArgsConstructor
    private static class Node<E> implements Position<E>{

        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        @Override
        public E getElement() throws IllegalStateException {
            return element;
        }
    }

    private Node<E> root = null;
    private int size = 0;

    protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right){
        return new Node<>(e, parent, left, right);
    }

    protected Node<E> validate(Position<E> p){
        if(! (p instanceof Node)){
            throw new IllegalArgumentException("Invalid position type");
        }
        Node<E> node = (Node<E>)p;
        if(node.getParent() == node){
            throw new IllegalArgumentException("p is no longer in the tree");
        }
        return node;
    }

    @Override
    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        return validate(p).getLeft();
    }

    @Override
    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        return validate(p).getRight();
    }

    @Override
    public Position<E> root() {
        return root;
    }

    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        return validate(p).getParent();
    }

    @Override
    public int size() {
        return size;
    }

    private class PreorderIterator implements Iterator<E>{

        private final Iterator<Position<E>> posIterator = preorderPositions().iterator();

        @Override
        public boolean hasNext() {
            return posIterator.hasNext();
        }

        @Override
        public E next() throws NoSuchElementException {
            return posIterator.next().getElement();
        }

        @Override
        public void remove() throws IllegalStateException {
            posIterator.remove();
        }
    }

    public Iterator<E> preorderIterator(){
        return new PreorderIterator();
    }

    @Override
    public Iterable<Position<E>> preorderPositions() {
        List<Position<E>> snapShot = new ArrayList<Position<E>>();
        if(!isEmpty()){
            preorderSubTree(root(), snapShot);
        }
        return snapShot;
    }

    private void preorderSubTree(Position<E> p, List<Position<E>> snapShot){
        snapShot.add(p);
        Iterator<Position<E>> iterator = children(p).iterator();
        while(iterator.hasNext()){
            preorderSubTree(iterator.next(), snapShot);
        }
    }

    private class PostorderIterator implements Iterator<E>{

        private final Iterator<Position<E>> posIterator = postorderPositions().iterator();

        @Override
        public boolean hasNext() {
            return posIterator.hasNext();
        }

        @Override
        public E next() throws NoSuchElementException {
            return posIterator.next().getElement();
        }

        @Override
        public void remove() throws IllegalStateException {
            posIterator.remove();
        }
    }

    public Iterator<E> postorderIterator(){
        return new PostorderIterator();
    }

    @Override
    public Iterable<Position<E>> postorderPositions() {
        List<Position<E>> snapShot = new ArrayList<Position<E>>();
        if(!isEmpty()){
            postorderSubtree(root(), snapShot);
        }
        return snapShot;
    }

    private void postorderSubtree(Position<E> p, List<Position<E>> snapShot){
        Iterator<Position<E>> iterator = children(p).iterator();
        while(iterator.hasNext()){
            postorderSubtree(iterator.next(), snapShot);
        }
        snapShot.add(p);
    }

    private class InorderIterator implements Iterator<E>{

        private final Iterator<Position<E>> posIterator = inorderPositions().iterator();

        @Override
        public boolean hasNext() {
            return posIterator.hasNext();
        }

        @Override
        public E next() throws NoSuchElementException {
            return posIterator.next().getElement();
        }

        @Override
        public void remove() throws IllegalStateException {
            posIterator.remove();
        }
    }

    public Iterator<E> inorderIterator(){
        return new InorderIterator();
    }

    @Override
    public Iterable<Position<E>> inorderPositions() {
        List<Position<E>> snapShot = new ArrayList<Position<E>>();
        if(!isEmpty()){
            inorderSubtree(root(), snapShot);
        }
        return snapShot;
    }

    private void inorderSubtree(Position<E> p, List<Position<E>> snapShot){
        if(left(p) != null){
            inorderSubtree(left(p), snapShot);
        }
        snapShot.add(p);
        if(right(p) != null){
            inorderSubtree(right(p), snapShot);
        }
    }

    private class BreadthFirstIterator implements Iterator<E>{

        private final Iterator<Position<E>> posIterator = breadthFirstPositions().iterator();

        @Override
        public boolean hasNext() {
            return posIterator.hasNext();
        }

        @Override
        public E next() throws NoSuchElementException {
            return posIterator.next().getElement();
        }

        @Override
        public void remove() throws IllegalStateException {
            posIterator.remove();
        }
    }

    public Iterator<E> breadthFirstIterator(){
        return new BreadthFirstIterator();
    }

    @Override
    public Iterable<Position<E>> breadthFirstPositions() {
        List<Position<E>> snapShot = new ArrayList<Position<E>>();
        if(!isEmpty()){
            LinkedQueue<Position<E>> queue = new LinkedQueue<Position<E>>();
            queue.enqueue(root());
            while(!queue.isEmpty()){
                Position<E> p = queue.dequeue();
                snapShot.add(p);
                Iterator<Position<E>> iterator = children(p).iterator();
                while(iterator.hasNext()){
                    queue.enqueue(iterator.next());
                }
            }
        }
        return snapShot;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    public Position<E> addRoot(E e){
        if(!isEmpty()){
            throw new IllegalArgumentException("Tree is not empty");
        }
        Node<E> root = createNode(e, null, null, null);
        this.root = root;
        size++;
        return root;
    }

    public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException{
        Node<E> parent = validate(p);
        if(parent.getLeft() != null){
            throw new IllegalArgumentException("left is not null");
        }
        Node<E> left = createNode(e, parent, null, null);
        parent.setLeft(left);
        size++;
        return left;
    }

    public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException{
        Node<E> parent = validate(p);
        if(parent.getRight() != null){
            throw new IllegalArgumentException("right is not null");
        }
        Node<E> right = createNode(e, parent, null, null);
        parent.setRight(right);
        size++;
        return right;
    }

    public E set(Position<E> p, E e) throws IllegalArgumentException{
        Node<E> node = validate(p);
        E temp = node.getElement();
        node.setElement(e);
        return temp;
    }

    public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) throws IllegalArgumentException{
        if(!isExternal(p)){
            throw new IllegalArgumentException("p must be a leaf");
        }
        Node<E> node = validate(p);
        size += size + t1.size + t2.size;
        if(!t1.isEmpty()){
            node.setLeft(t1.root);
            t1.root.setParent(node);
            t1.size = 0;
            t1.root = null;
        }
        if(!t2.isEmpty()){
            node.setRight(t2.root);
            t2.root.setParent(node);
            t2.size = 0;
            t2.root = null;
        }
    }

    public E remove (Position<E> p) throws IllegalArgumentException{
        if(numChildren(p) == 2){
            throw new IllegalArgumentException("p has two children");
        }
        Node<E> node = validate(p);
        Node<E> child = node.getLeft() != null ? node.getLeft() : node.getRight();
        if(child != null){
            child.setParent(node.getParent());
        }
        if(node == root){
            root = child;
        }else{
            Node<E> parent = node.getParent();
            if(parent.getLeft() != null){
                parent.setLeft(child);
            }else{
                parent.setRight(child);
            }
        }
        size--;
        E temp = node.getElement();
        node.setElement(null);
        node.setRight(null);
        node.setLeft(null);
        node.setParent(node);
        return temp;
    }
}
