import org.junit.Assert;
import org.junit.Test;

public class MatchingTagsTest {

    @Test
    public void testIsHtmlMatchedTrue_case1(){
        String html = "<body></body>";
        Assert.assertTrue(MatchingTags.isHTMLMatched(html));
    }

    @Test
    public void testIsHtmlMatchedTrue_case2(){
        String html = "<body><center></center></body>";
        Assert.assertTrue(MatchingTags.isHTMLMatched(html));
    }

    @Test
    public void testIsHtmlMatchedTrue_case3(){
        String html = "<body></body><center></center>";
        Assert.assertTrue(MatchingTags.isHTMLMatched(html));
    }

    @Test
    public void testIsHtmlMatchedTrue_case4(){
        String html = "<html><body></body><center></center></html>";
        Assert.assertTrue(MatchingTags.isHTMLMatched(html));
    }

    @Test
    public void testIsHtmlMatchedFalse_case1(){
        String html = "<body>";
        Assert.assertFalse(MatchingTags.isHTMLMatched(html));
    }

    @Test
    public void testIsHtmlMatchedFalse_case2(){
        String html = "</body>";
        Assert.assertFalse(MatchingTags.isHTMLMatched(html));
    }

    @Test
    public void testIsHtmlMatchedFalse_case3(){
        String html = "</body><body>";
        Assert.assertFalse(MatchingTags.isHTMLMatched(html));
    }

    @Test
    public void testIsHtmlMatchedFalse_case4(){
        String html = "<body><body>";
        Assert.assertFalse(MatchingTags.isHTMLMatched(html));
    }

    @Test
    public void testIsHtmlMatchedFalse_case5(){
        String html = "<body></bdy>";
        Assert.assertFalse(MatchingTags.isHTMLMatched(html));
    }

    @Test
    public void testIsHtmlMatchedFalse_case6(){
        String html = "<body>/body>";
        Assert.assertFalse(MatchingTags.isHTMLMatched(html));
    }

    @Test
    public void testIsHtmlMatchedFalse_case7(){
        String html = "<body></body";
        Assert.assertFalse(MatchingTags.isHTMLMatched(html));
    }

    @Test
    public void testIsHtmlMatchedFalse_case8(){
        String html = "<body><center></body></center>";
        Assert.assertFalse(MatchingTags.isHTMLMatched(html));
    }

    @Test
    public void testIsHtmlMatchedFalse_case9(){
        String html = "<body><center></center>";
        Assert.assertFalse(MatchingTags.isHTMLMatched(html));
    }

    @Test
    public void testIsHtmlMatchedFalse_case10(){
        String html = "<body><center></body>";
        Assert.assertFalse(MatchingTags.isHTMLMatched(html));
    }
}
