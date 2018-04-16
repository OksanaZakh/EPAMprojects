package textmodifiertests.testsentence;

import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class TestSentence {
    @Test
    public void testHashCode() {
        assertEquals(TestSentenceHelper.createSentence1().hashCode(),
                TestSentenceHelper.createSentence2().hashCode());
    }

    @Test
    public void testEquals() {
        assertEquals(TestSentenceHelper.createSentence1(),
                TestSentenceHelper.createSentence2());

    }

    @Test
    public void testSort() {
        TestSentenceHelper.createSentence1().sortSentence();
        TestSentenceHelper.createSentence2().sortSentence();
        assertEquals(TestSentenceHelper.createSentence1(),
                TestSentenceHelper.createSentence2());
    }

    @Test
    public void testGetFirstIndex() {
        assertEquals(0, TestSentenceHelper.createSentence1().getFirstIndexOfWordOrNumber());
    }

    @Test
    public void testGetLastIndex() {
        assertEquals(7, TestSentenceHelper.createSentence1().getLastIndexOfWordOrNumber());
    }
}
