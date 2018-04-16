package textmodifiertests.textmanagertest;

import org.junit.Test;
import textmodifier.model.TextManager;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TestTextManager {

    TextManager textManager;

    public TestTextManager() {
        textManager = new TextManager();
        textManager.setText(TextManagerTestHelper.PARSE_TEXT_STRING_PARAMETER);
    }

    @Test
    public void TestParseTextString() {
        assertArrayEquals(textManager.parseTextStr(), TextManagerTestHelper.PARSE_TEXT_EXPECTED_RESULT);
    }

    @Test
    public void TestParseSentence() {
        assertEquals(TextManagerTestHelper.createSentence(),
                textManager.parseSentenceStr(TextManagerTestHelper.PARSE_SENTENCE_PARAM));
    }
}
