package Recursion;

public class Power {

    public static long linear(int num, int n){
        if(n == 0)
            return 1;
        if(n <= 1){
            return num;
        }
        return num * linear(num, n - 1);
    }

    public static double logN(int num, int n){
        if(n == 0){
            return 1;
        }
        int partial = n / 2;
        double result = logN(num, partial);
        double x = result * result;
        if(n % 2 != 0){
            x *= num;
        }
        return x;
    }
}
