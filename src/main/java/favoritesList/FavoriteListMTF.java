package favoritesList;


import Iterator.Iterable;
import Iterator.Iterator;
import Iterator.LinkedPositionalList;
import Iterator.positionalList.Position;
import Iterator.positionalList.PositionalList;

public class FavoriteListMTF<E> extends FavoritesList<E> {

    @Override
    public void access(E e) {
        Position<Item<E>> p = findPosition(e);
        if(p == null){
            p = list.addLast(new Item<>(e));
        }
        p.getElement().increment();
        list.addFirst(list.remove(p));
    }

    @Override
    public Iterable<E> getFavorites(int k) throws IllegalArgumentException {
        if(k < 0 || k > size()){
            throw new IllegalArgumentException();
        }

        PositionalList<Item<E>> temp = new LinkedPositionalList<Item<E>>();
        Iterator<Item<E>> iterator = list.iterator();
        while(iterator.hasNext()){
            temp.addLast(iterator.next());
        }

        PositionalList<E> result = new LinkedPositionalList<E>();
        for(int i = 0; i < k; i++){
            Position<Item<E>> highest = list.first();
            Position<Item<E>> walk = list.after(highest);
            while(walk != null){
                if(count(walk) > count(highest)){
                    highest = walk;
                }
                walk = list.after(walk);
            }
            result.addLast(list.remove(highest).getValue());
        }
        return result;
    }
}
