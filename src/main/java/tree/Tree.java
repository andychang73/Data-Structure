package tree;

import Iterator.Iterable;
import Iterator.positionalList.Position;

public interface Tree<E> extends Iterable<E> {

    Position<E> root();

    Position<E> parent(Position<E> p) throws IllegalArgumentException;

    Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException;

    int numChildren(Position<E> p ) throws IllegalArgumentException;

    boolean isExternal(Position<E> p) throws IllegalArgumentException;

    boolean isInternal(Position<E> p) throws IllegalArgumentException;

    boolean isRoot(Position<E> p) throws IllegalArgumentException;

    int size();

    boolean isEmpty();

    Iterable<Position<E>> preorderPositions ();

    Iterable<Position<E>> postorderPositions ();

    Iterable<Position<E>> inorderPositions ();

    Iterable<Position<E>> breadthFirstPositions();
}
