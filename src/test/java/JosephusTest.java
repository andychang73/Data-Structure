import org.junit.Assert;
import org.junit.Test;

public class JosephusTest {

    private Queue.Josephus<String> josephus;

    @Test
    public void testJosephus_case1(){
        String[] case1 = {"Alice", "Bob", "Cindy", "Doug", "Ed", "Fred"};
        josephus = new Queue.Josephus(case1);
        Assert.assertEquals("Alice", josephus.josephus(3));
    }

    @Test
    public void testJosephus_case2(){
        String[] case2 = {"Gene", "Hope", "Irene", "Jack", "Kim", "Lance"};
        josephus = new Queue.Josephus(case2);
        Assert.assertEquals("Hope", josephus.josephus(10));
    }

    @Test
    public void testJosephus_case3(){
        String[] case3 = {"Mike", "Roberto"};
        josephus = new Queue.Josephus(case3);
        Assert.assertEquals("Roberto", josephus.josephus(7));
    }
}
