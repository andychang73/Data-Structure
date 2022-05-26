package Queue;

import Queue.interfaces.CircularQueue;

public class Josephus<E> {

    private final CircularQueue<E> queue = new LinkedCircularQueue<>();

    public Josephus(E[] inputs){
        for(E i : inputs){
            queue.enqueue(i);
        }
    }

    public E josephus(int k){
        if(queue.isEmpty()){
            return null;
        }
        while(queue.size() > 1){
            for(int i = 0 ; i < k -1; i++){
                queue.rotate();
            }
            queue.dequeue();
        }
        return queue.dequeue();
    }

}
