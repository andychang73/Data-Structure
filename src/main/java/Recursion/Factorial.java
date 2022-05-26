package Recursion;

public class Factorial {

    public static int factorial(int n){
        if(n <= 1){
            return n;
        }
        return n * factorial(n -1 );
    }
}
