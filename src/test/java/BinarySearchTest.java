import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTest {

    private final int[] odd = new int[]{1,2,3,4,5,6,7,8,9};
    private final int[] even = new int[]{1,2,3,4,5,6,7,8,9,10};

    @Test
    public void testBinarySearchRecursive_OddArraySearchForOne(){
        Assert.assertTrue(BinarySearch.binarySearchRecursive(odd, 1, 0, odd.length-1));
    }

    @Test
    public void testBinarySearchRecursive_OddArraySearchForTwo(){
        Assert.assertTrue(BinarySearch.binarySearchRecursive(odd, 2, 0, odd.length-1));
    }

    @Test
    public void testBinarySearchRecursive_OddArraySearchForThree(){
        Assert.assertTrue(BinarySearch.binarySearchRecursive(odd, 3, 0, odd.length-1));
    }

    @Test
    public void testBinarySearchRecursive_OddArraySearchForFour(){
        Assert.assertTrue(BinarySearch.binarySearchRecursive(odd, 4, 0, odd.length-1));
    }

    @Test
    public void testBinarySearchRecursive_OddArraySearchForFive(){
        Assert.assertTrue(BinarySearch.binarySearchRecursive(odd, 5, 0, odd.length-1));
    }

    @Test
    public void testBinarySearchRecursive_OddArraySearchForSix(){
        Assert.assertTrue(BinarySearch.binarySearchRecursive(odd, 6, 0, odd.length-1));
    }

    @Test
    public void testBinarySearchRecursive_OddArraySearchForSeven(){
        Assert.assertTrue(BinarySearch.binarySearchRecursive(odd, 7, 0, odd.length-1));
    }

    @Test
    public void testBinarySearchRecursive_OddArraySearchForEight(){
        Assert.assertTrue(BinarySearch.binarySearchRecursive(odd, 8, 0, odd.length-1));
    }

    @Test
    public void testBinarySearchRecursive_OddArraySearchForNine(){
        Assert.assertTrue(BinarySearch.binarySearchRecursive(odd, 9, 0, odd.length-1));
    }

    @Test
    public void testBinarySearchRecursive_OddArraySearchForZero(){
        Assert.assertFalse(BinarySearch.binarySearchRecursive(odd, 0, 0, odd.length-1));
    }

    @Test
    public void testBinarySearchRecursive_OddArraySearchForEleven(){
        Assert.assertFalse(BinarySearch.binarySearchRecursive(odd, 10, 0, odd.length-1));
    }

    @Test
    public void testBinarySearchRecursive_EvenArraySearchForOne(){
        Assert.assertTrue(BinarySearch.binarySearchRecursive(even, 1, 0, even.length-1));
    }

    @Test
    public void testBinarySearchRecursive_EvenArraySearchForTwo(){
        Assert.assertTrue(BinarySearch.binarySearchRecursive(even, 2, 0, even.length-1));
    }

    @Test
    public void testBinarySearchRecursive_EvenArraySearchForThree(){
        Assert.assertTrue(BinarySearch.binarySearchRecursive(even, 3, 0, even.length-1));
    }

    @Test
    public void testBinarySearchRecursive_EvenArraySearchForFour(){
        Assert.assertTrue(BinarySearch.binarySearchRecursive(even, 4, 0, even.length-1));
    }

    @Test
    public void testBinarySearchRecursive_EvenArraySearchForFive(){
        Assert.assertTrue(BinarySearch.binarySearchRecursive(even, 5, 0, even.length-1));
    }

    @Test
    public void testBinarySearchRecursive_EvenArraySearchForSix(){
        Assert.assertTrue(BinarySearch.binarySearchRecursive(even, 6, 0, even.length-1));
    }

    @Test
    public void testBinarySearchRecursive_EvenArraySearchForSeven(){
        Assert.assertTrue(BinarySearch.binarySearchRecursive(even, 7, 0, even.length-1));
    }

    @Test
    public void testBinarySearchRecursive_EvenArraySearchForEight(){
        Assert.assertTrue(BinarySearch.binarySearchRecursive(even, 8, 0, even.length-1));
    }

    @Test
    public void testBinarySearchRecursive_EvenArraySearchForNine(){
        Assert.assertTrue(BinarySearch.binarySearchRecursive(even, 9, 0, even.length-1));
    }

    @Test
    public void testBinarySearchRecursive_EvenArraySearchForTen(){
        Assert.assertTrue(BinarySearch.binarySearchRecursive(even, 10, 0, even.length-1));
    }

    @Test
    public void testBinarySearchRecursive_EvenArraySearchForZero(){
        Assert.assertFalse(BinarySearch.binarySearchRecursive(even, 0, 0, even.length-1));
    }

    @Test
    public void testBinarySearchRecursive_EvenArraySearchForEleven(){
        Assert.assertFalse(BinarySearch.binarySearchRecursive(even, 11, 0, even.length-1));
    }

    @Test
    public void testBinarySearch_OddArraySearchForOne(){
        Assert.assertTrue(BinarySearch.binarySearch(odd, 1, 0, odd.length));
    }

    @Test
    public void testBinarySearch_OddArraySearchForTwo(){
        Assert.assertTrue(BinarySearch.binarySearch(odd, 2, 0, odd.length));
    }

    @Test
    public void testBinarySearch_OddArraySearchForThree(){
        Assert.assertTrue(BinarySearch.binarySearch(odd, 3, 0, odd.length));
    }

    @Test
    public void testBinarySearch_OddArraySearchForFour(){
        Assert.assertTrue(BinarySearch.binarySearch(odd, 4, 0, odd.length));
    }

    @Test
    public void testBinarySearch_OddArraySearchForFive(){
        Assert.assertTrue(BinarySearch.binarySearch(odd, 5, 0, odd.length));
    }

    @Test
    public void testBinarySearch_OddArraySearchForSix(){
        Assert.assertTrue(BinarySearch.binarySearch(odd, 6, 0, odd.length));
    }

    @Test
    public void testBinarySearch_OddArraySearchForSeven(){
        Assert.assertTrue(BinarySearch.binarySearch(odd, 7, 0, odd.length));
    }

    @Test
    public void testBinarySearch_OddArraySearchForEight(){
        Assert.assertTrue(BinarySearch.binarySearch(odd, 8, 0, odd.length));
    }

    @Test
    public void testBinarySearch_OddArraySearchForNine(){
        Assert.assertTrue(BinarySearch.binarySearch(odd, 9, 0, odd.length));
    }

    @Test
    public void testBinarySearch_OddArraySearchForZero(){
        Assert.assertFalse(BinarySearch.binarySearch(odd, 0, 0, odd.length-1));
    }

    @Test
    public void testBinarySearch_OddArraySearchForTen(){
        Assert.assertFalse(BinarySearch.binarySearchRecursive(odd, 10, 0, odd.length-1));
    }

    @Test
    public void testBinarySearch_EvenArraySearchForOne(){
        Assert.assertTrue(BinarySearch.binarySearchRecursive(even, 1, 0, even.length-1));
    }

    @Test
    public void testBinarySearch_EvenArraySearchForTwo(){
        Assert.assertTrue(BinarySearch.binarySearchRecursive(even, 2, 0, even.length-1));
    }

    @Test
    public void testBinarySearch_EvenArraySearchForThree(){
        Assert.assertTrue(BinarySearch.binarySearchRecursive(even, 3, 0, even.length-1));
    }

    @Test
    public void testBinarySearch_EvenArraySearchForFour(){
        Assert.assertTrue(BinarySearch.binarySearchRecursive(even, 4, 0, even.length-1));
    }

    @Test
    public void testBinarySearch_EvenArraySearchForFive(){
        Assert.assertTrue(BinarySearch.binarySearchRecursive(even, 5, 0, even.length-1));
    }

    @Test
    public void testBinarySearch_EvenArraySearchForSix(){
        Assert.assertTrue(BinarySearch.binarySearchRecursive(even, 6, 0, even.length-1));
    }

    @Test
    public void testBinarySearch_EvenArraySearchForSeven(){
        Assert.assertTrue(BinarySearch.binarySearchRecursive(even, 7, 0, even.length-1));
    }

    @Test
    public void testBinarySearch_EvenArraySearchForEight(){
        Assert.assertTrue(BinarySearch.binarySearchRecursive(even, 8, 0, even.length-1));
    }

    @Test
    public void testBinarySearch_EvenArraySearchForNine(){
        Assert.assertTrue(BinarySearch.binarySearchRecursive(even, 9, 0, even.length-1));
    }

    @Test
    public void testBinarySearch_EvenArraySearchForTen(){
        Assert.assertTrue(BinarySearch.binarySearchRecursive(even, 10, 0, even.length-1));
    }

    @Test
    public void testBinarySearch_EvenArraySearchForZero(){
        Assert.assertFalse(BinarySearch.binarySearch(even, 0, 0, even.length-1));
    }

    @Test
    public void testBinarySearch_EvenArraySearchForEleven(){
        Assert.assertFalse(BinarySearch.binarySearch(even, 11, 0, even.length-1));
    }

}
