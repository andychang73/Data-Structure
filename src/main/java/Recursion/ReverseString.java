package Recursion;

public class ReverseString {

    public static String reverse(String input){
        if(input.isEmpty()){
            return input;
        }
        return reverse(input.substring(1)) + input.charAt(0);
    }
}
