package textmodifiertests.textfilereader;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import textmodifier.utils.TextFileReader;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class TestReadText {

    private String dir;
    private String name;
    private String expResult;

    public TestReadText(String dir, String name, String expResult) {
        this.dir = dir;
        this.name = name;
        this.expResult = expResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"D:\\ОКСАНА\\EPAM", "text.txt", TextFileReaderHelper.text.trim()},
                {"D:\\ОКСАНА\\EPAM", "text1.txt", TextFileReaderHelper.text1.trim()},
                {"D:\\ОКСАНА\\EPAM", "text2.txt", TextFileReaderHelper.text2.trim()}
        });
    }

    @Test
    public void testIsDirectory() throws IOException {
        Assert.assertEquals(expResult, TextFileReader.readText(dir, name).trim());
    }
}
