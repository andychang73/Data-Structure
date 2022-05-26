import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReverseSequenceTest {

    private int[] odd;
    private int[] even;
    private final int[] reversedOdd = new int[]{9,8,7,6,5,4,3,2,1};
    private final int[] reversedEven = new int[]{10,9,8,7,6,5,4,3,2,1};

    @Before
    public void init(){
        odd = new int[]{1,2,3,4,5,6,7,8,9};
        even = new int[]{1,2,3,4,5,6,7,8,9,10};
    }

    @Test
    public void testRecursive_OddArray(){
        ReverseSequence.recursive(odd, 0 , odd.length-1);

        checkResult(odd, reversedOdd);
    }

    @Test
    public void testRecursive_EvenArray(){
        ReverseSequence.recursive(even, 0, even.length-1);

        checkResult(even, reversedEven);
    }

    @Test
    public void testNonRecursive_OddArray(){
        ReverseSequence.nonRecursive(odd, 0, odd.length-1);

        checkResult(odd, reversedOdd);
    }

    @Test
    public void testNonRecursive_EvenArray(){
        ReverseSequence.nonRecursive(even, 0, even.length-1);

        checkResult(even, reversedEven);
    }

    private void checkResult(int[] result, int[] target){
        for(int i = 0; i < result.length; i++){
            Assert.assertEquals(result[i], target[i]);
        }
    }
}
