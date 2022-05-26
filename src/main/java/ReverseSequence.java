public class ReverseSequence {

    public static void recursive(int[] data, int low, int high){
        if(low < high){
            int temp = data[low];
            data[low] = data[high];
            data[high] = temp;
            recursive(data, low + 1, high - 1);
        }
    }

    public static void nonRecursive(int[] data, int low, int high){
        while(low < high){
            int temp = data[low];
            data[low++] = data[high];
            data[high--] = temp;
        }
    }
}
