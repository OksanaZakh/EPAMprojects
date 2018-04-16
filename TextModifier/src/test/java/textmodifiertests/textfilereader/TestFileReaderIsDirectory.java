package textmodifiertests.textfilereader;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import textmodifier.utils.TextFileReader;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class TestFileReaderIsDirectory {
    private String dir;
    private boolean expResult;

    public TestFileReaderIsDirectory(String dir, boolean expResult) {
        this.dir = dir;
        this.expResult = expResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"D:\\ОКСАНА\\Android", true},
                {"D:\\ОКСАНА\\Android\\sampleApp\\com", false},
                {"C:\\Users\\Administrator\\Documents\\The Witcher 3\\gamesaves", true}
        });
    }

    @Test
    public void testIsDirectory() {
        Assert.assertEquals(expResult, TextFileReader.isDirectory(dir));
    }
}
