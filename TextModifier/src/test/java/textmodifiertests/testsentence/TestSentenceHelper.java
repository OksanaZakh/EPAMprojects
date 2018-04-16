package textmodifiertests.testsentence;

import textmodifier.model.sentence.EndSentenceSign;
import textmodifier.model.sentence.Number;
import textmodifier.model.sentence.Sentence;
import textmodifier.model.sentence.Word;

public class TestSentenceHelper {
    public static Sentence createSentence1() {
        Sentence sentence = new Sentence();
        sentence.addMember(new Word("Java", 1));
        sentence.addMember(new Word("is", 2));
        sentence.addMember(new Word("a", 3));
        sentence.addMember(new Word("programming", 4));
        sentence.addMember(new Word("language", 5));
        sentence.addMember(new Word("released", 6));
        sentence.addMember(new Word("in", 7));
        sentence.addMember(new Number("1995", 8));
        sentence.addMember(new EndSentenceSign(". ", 9));
        return sentence;
    }

    public static Sentence createSentence2() {
        Sentence sentence = new Sentence();
        sentence.addMember(new Word("Java", 1));
        sentence.addMember(new Word("is", 2));
        sentence.addMember(new Word("a", 3));
        sentence.addMember(new Word("programming", 4));
        sentence.addMember(new Word("language", 5));
        sentence.addMember(new Word("released", 6));
        sentence.addMember(new Word("in", 7));
        sentence.addMember(new Number("1995", 8));
        sentence.addMember(new EndSentenceSign(". ", 9));
        return sentence;
    }
}
