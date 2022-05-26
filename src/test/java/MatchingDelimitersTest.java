import org.junit.Assert;
import org.junit.Test;

public class MatchingDelimitersTest {

    @Test
    public void testIsMatchedTrue_case1(){
        Assert.assertTrue(MatchingDelimiters.isMatched("(){}[]"));
    }

    @Test
    public void testIsMatchedTrue_case2(){
        Assert.assertTrue(MatchingDelimiters.isMatched("({[]})"));
    }

    @Test
    public void testIsMatchedTrue_case3(){
        Assert.assertTrue(MatchingDelimiters.isMatched("()(()){([()])}"));
    }

    @Test
    public void testIsMatchedTrue_case4(){
        Assert.assertTrue(MatchingDelimiters.isMatched("((( )(( )){([( )])}))"));
    }

    @Test
    public void testIsMatchedFalse_case1(){
        Assert.assertFalse(MatchingDelimiters.isMatched("(){}["));
    }

    @Test
    public void testIsMatchedFalse_case2(){
        Assert.assertFalse(MatchingDelimiters.isMatched("(){{[]"));
    }

    @Test
    public void testIsMatchedFalse_case3(){
        Assert.assertFalse(MatchingDelimiters.isMatched("({[]}})"));
    }

    @Test
    public void testIsMatchedFalse_case4(){
        Assert.assertFalse(MatchingDelimiters.isMatched(")"));
    }

    @Test
    public void testIsMatchedFalse_case5(){
        Assert.assertFalse(MatchingDelimiters.isMatched(")(()){([()])}"));
    }

    @Test
    public void testIsMatchedFalse_case6(){
        Assert.assertFalse(MatchingDelimiters.isMatched("({[])}"));
    }

    @Test
    public void testIsMatchedFalse_case7(){
        Assert.assertFalse(MatchingDelimiters.isMatched("("));
    }
}
