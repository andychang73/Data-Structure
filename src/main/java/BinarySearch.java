public class BinarySearch {

    public static boolean binarySearchRecursive(int[] data, int target, int low , int high){
        if(low > high){
            return false;
        }
        int mid = (low + high) / 2;
        if(target == data[mid]){
            return true;
        }else if(target < data[mid]){
            return binarySearchRecursive(data, target, low, mid - 1);
        }else{
            return binarySearchRecursive(data, target, mid + 1, high);
        }
    }

    public static boolean binarySearch(int[] data, int target, int low, int high){
        while(true){
            if(low > high){
                return false;
            }
            int mid = (low + high) / 2;
            if(target == data[mid]){
                return true;
            }else if(target < data[mid]){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
    }
}
