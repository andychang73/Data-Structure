package Recursion;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class DiskUsageTest {

    private File file;

    @Before
    public void init(){
        file = new File("/Users/salesengineer4891/DeskTop/Lecture/");
    }

    @Test
    public void testDiskUsage(){
        Assert.assertEquals(24748934962L, DiskUsage.diskUsage(file));
    }
}
