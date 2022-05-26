package Recursion;

public class CountDown {

    public static void countDown(int count){
        if(count < 0){
            return;
        }
        System.out.println(count);
        countDown(count - 1);
    }

}
