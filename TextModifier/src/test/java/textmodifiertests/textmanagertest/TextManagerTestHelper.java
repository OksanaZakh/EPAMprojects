package textmodifiertests.textmanagertest;

import textmodifier.model.sentence.EndSentenceSign;
import textmodifier.model.sentence.Number;
import textmodifier.model.sentence.Sentence;
import textmodifier.model.sentence.Word;

public class TextManagerTestHelper {
    public static final String PARSE_TEXT_STRING_PARAMETER = "Hello Java! I enjoy programming.";
    public static final String[] PARSE_TEXT_EXPECTED_RESULT = {"Hello Java! ", "I enjoy programming."};
    public static final String PARSE_SENTENCE_PARAM = "Java is a programming language released in 1995. ";


    public static Sentence createSentence() {
        Sentence sentence = new Sentence();
        sentence.addMember(new Word("Java"));
        sentence.addMember(new Word("is"));
        sentence.addMember(new Word("a"));
        sentence.addMember(new Word("programming"));
        sentence.addMember(new Word("language"));
        sentence.addMember(new Word("released"));
        sentence.addMember(new Word("in"));
        sentence.addMember(new Number("1995"));
        sentence.addMember(new EndSentenceSign(". "));
        return sentence;
    }
}
