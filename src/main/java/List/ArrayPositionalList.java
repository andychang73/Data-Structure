package List;

import lombok.AllArgsConstructor;
import lombok.Data;

public class ArrayPositionalList implements PositionalList<String> {

    @Data
    @AllArgsConstructor
    private static class ArrayPosition implements Position<String>{

        private String element;
        private int index;

        @Override
        public String getElement() throws IllegalStateException {
            return element;
        }
    }

    private static final int CAPACITY = 16;
    private int size = 0;
    private ArrayPosition[] data;

    public ArrayPositionalList(){
        this(CAPACITY);
    }
    public ArrayPositionalList(int capacity){
        data = new ArrayPosition[capacity];
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
    public Position<String> first() {
        if(isEmpty()){
            return null;
        }
        return data[0];
    }

    @Override
    public Position<String> last() {
        if(isEmpty()){
            return null;
        }
        return data[size-1];
    }

    @Override
    public Position<String> addFirst(String s) {
        resize();
        if(isEmpty()){
            data[0] = new ArrayPosition(s, 0);
            size++;
            return data[0];
        }
        ArrayPosition[] newArray = new ArrayPosition[data.length];
        newArray[0] = new ArrayPosition(s, 0);
        for(int i = 0; i < size; i++){
            newArray[i + 1] = data[i];
        }
        data = newArray;
        size++;
        return data[0];
    }

    @Override
    public Position<String> addLast(String s) {
        resize();
        data[size] = new ArrayPosition(s, size);
        size++;
        return data[size - 1];
    }

    @Override
    public String remove(Position<String> p) {
        ArrayPosition arrayPosition = validate(p);
        String temp = data[arrayPosition.getIndex()].getElement();
        for(int i = arrayPosition.getIndex(); i < size - 1; i++){
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
        updateIndex(arrayPosition.getIndex());
        return temp;
    }

    @Override
    public String set(Position<String> p, String s) {
        ArrayPosition arrayPosition = validate(p);
        String temp = arrayPosition.getElement();
        arrayPosition.setElement(s);
        return temp;
    }

    @Override
    public Position<String> after(Position<String> p) {
        ArrayPosition arrayPosition = validate(p);
        if(arrayPosition.getIndex() == size - 1){
            return null;
        }
        return data[arrayPosition.getIndex() + 1];
    }

    @Override
    public Position<String> before(Position<String> p) {
        ArrayPosition arrayPosition = validate(p);
        if(arrayPosition.getIndex() == 0){
            return null;
        }
        return data[arrayPosition.getIndex() - 1];
    }

    @Override
    public Position<String> addAfter(Position<String> p, String s) {
        return addBetween(validate(p).getIndex() + 1, s);
    }

    @Override
    public Position<String> addBefore(Position<String> p, String s) {
        return addBetween(validate(p).getIndex(), s);
    }

    private Position<String> addBetween(int index, String s){
        resize();
        for(int i = size - 1; i >= index; i--){
            data[i + 1] = data[i];
        }
        data[index] = new ArrayPosition(s, index);
        updateIndex(index + 1);
        size++;
        return data[index];
    }

    private void resize(){
        if(size == data.length){
            ArrayPosition[] newData = new ArrayPosition[data.length * 2];
            for(int i = 0; i < data.length; i++){
                newData[i] = data[i];
            }
            data = newData;
        }
    }

    private void updateIndex(int from){
        for(int i = from; i < size; i++){
            data[i].setIndex(i);
        }
    }

    private ArrayPosition validate(Position<String> p){
        if(! (p instanceof ArrayPosition)){
            throw new IllegalArgumentException();
        }
        ArrayPosition arrayPosition = (ArrayPosition) p;
        if(arrayPosition.getIndex() < 0 || arrayPosition.getIndex() >= size){
            throw new IllegalArgumentException();
        }
        return arrayPosition;
    }
}
