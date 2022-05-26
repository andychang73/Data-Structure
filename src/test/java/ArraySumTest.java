import org.junit.Assert;
import org.junit.Test;

public class ArraySumTest {

    private final int[] odd = new int[]{1,2,3,4,5,6,7,8,9};
    private final int[] even = new int[]{1,2,3,4,5,6,7,8,9,10};

    @Test
    public void testRecursiveSum_OddArray(){
        Assert.assertEquals(45, ArraySum.linearSum(odd, odd.length-1));
    }

    @Test
    public void testBinarySum_OddArray(){
        Assert.assertEquals(45, ArraySum.binarySum(odd, 0, odd.length-1));
    }

    @Test
    public void testRecursiveSum_EvenArray(){
        Assert.assertEquals(55, ArraySum.linearSum(even, even.length-1));
    }
    @Test
    public void testBinarySum_EvenArray(){
        Assert.assertEquals(55, ArraySum.binarySum(even, 0,even.length-1));
    }
}
