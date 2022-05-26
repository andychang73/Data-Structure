package Recursion;

public class Fibonacci {

    public static int bad(int n){
        if(n <= 1){
            return n;
        }
        return bad(n - 1) + bad(n-2);
    }

    public static long[] good(int n){
        if(n <= 1){
            return new long[]{0,n};
        }
        long[] temp = good(n -1);
        return new long[]{temp[1], temp[0] + temp[1]};
    }

    public static int nonRecursive(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int s1 = 0;
        int s2 = 1;
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = s1 + s2;
            s1 = s2;
            s2 = result;
        }
        return result;
    }
}
