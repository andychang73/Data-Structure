package tree;

import Iterator.ArrayList;
import Iterator.Iterable;
import Iterator.List;
import Iterator.positionalList.Position;

public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {

    @Override
    public Position<E> sibling(Position<E> p) throws IllegalArgumentException {
        Position<E> parent = parent(p);
        if(parent == null){
            return null;
        }
        if(left(p) == p){
            return right(p);
        }
        return left(p);
    }

    @Override
    public int numChildren(Position<E> p) throws IllegalArgumentException {
        int count = 0;
        if(left(p) != null){
            count++;
        }
        if(right(p) != null){
            count++;
        }
        return count;
    }

    @Override
    public Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException {
        List<Position<E>> snapShot = new ArrayList<Position<E>>();
        if(left(p) != null){
            snapShot.add(left(p));
        }
        if(right(p) != null){
            snapShot.add(right(p));
        }
        return snapShot;
    }
}
