package textmodifiertests.textfilereader;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import textmodifier.utils.TextFileReader;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class TestIsFileExist {

    private String dir;
    private String name;
    private boolean expResult;

    public TestIsFileExist(String dir, String name, boolean expResult) {
        this.dir = dir;
        this.name = name;
        this.expResult = expResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"D:\\ОКСАНА\\Android", "code-complete-2nd-edition-v413hav.pdf", true},
                {"D:\\ОКСАНА\\Android\\sampleApp\\res\\menu", "main.xml", true},
                {"C:\\Users\\Administrator\\Documents\\The Witcher 3", "tree.doc", false}
        });
    }

    @Test
    public void testIsDirectory() {
        Assert.assertEquals(expResult, TextFileReader.isFileExist(dir, name));
    }
}
