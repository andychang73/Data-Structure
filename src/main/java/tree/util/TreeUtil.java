package tree.util;

import Iterator.Iterator;
import Iterator.ArrayList;
import Iterator.positionalList.Position;
import tree.Tree;

public class TreeUtil {

    public static <E> void printPreorderIndent(Tree<E> T, Position<E> p, int d){
        System.out.println(spaces(2 * d) + p.getElement());
        Iterator<Position<E>> iterator = T.children(p).iterator();
        while(iterator.hasNext()){
            printPreorderIndent(T, iterator.next(), d + 1);
        }
    }

    public static <E> void printPreorderLabeled(Tree<E> T, Position<E> p, ArrayList<Integer> path){
        int d = path.size();
        System.out.print(spaces(2 * d));
        for(int i = 0; i < d; i++){
            System.out.print(path.get(i) + (i == d - 1 ? " " : "."));
        }
        System.out.println(p.getElement());
        path.add(1);
        Iterator<Position<E>> iterator = T.children(p).iterator();
        while(iterator.hasNext()){
            printPreorderLabeled(T, iterator.next(), path);
            path.set(d, 1 + path.get(d));
        }
        path.remove(d);
    }

    private static String spaces(int d){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < d; i++){
            builder.append(" ");
        }
        return builder.toString();
    }

    public static int diskSpace(Tree<Integer> T, Position<Integer> p){
        int subtotal = p.getElement();
        Iterator<Position<Integer>> iterator = T.children(p).iterator();
        while(iterator.hasNext()){
            subtotal += diskSpace(T, iterator.next());
        }
        return subtotal;
    }

    public static <E> void parenthesize(Tree<E> T, Position<E> p){
        System.out.print(p.getElement());
        if(T.isInternal(p)){
            boolean firstTime = true;
            Iterator<Position<E>> iterator = T.children(p).iterator();
            while(iterator.hasNext()){
                System.out.print(firstTime ? " (" : ", ");
                firstTime = false;
                parenthesize(T, iterator.next());
            }
            System.out.print(")");
        }
    }
}
