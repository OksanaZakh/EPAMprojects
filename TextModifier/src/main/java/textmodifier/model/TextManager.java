package textmodifier.model;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import textmodifier.model.sentence.*;
import textmodifier.model.sentence.Number;
import textmodifier.utils.TextFileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class TextManager {
    private String text;
    private List<Sentence> sentenceList;

    public TextManager() {
        sentenceList = new ArrayList<>();
    }

    public boolean readDataFromFile(String path, String name) {
        try {
            this.text = TextFileReader.readText(path, name) + " ";
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] parseTextStr() {
        String[] sentStrings = text.split(EndSentenceSign.END_SIGN_REGEX);
        Matcher matcherEndSign = EndSentenceSign.END_SIGN_PATTERN.matcher(text);
        int count = 0;
        while (matcherEndSign.find()) {
            sentStrings[count] = sentStrings[count] + matcherEndSign.group();
            count++;
        }
        return sentStrings;
    }

    public Sentence parseSentenceStr(String sentenceStr) {
        Sentence sentence = new Sentence();
        Matcher matcher = Word.WORD_PATTERN.matcher(sentenceStr);
        while (matcher.find()) {
            Word word = new Word(matcher.group(), matcher.start());
            sentence.addMember(word);
        }
        matcher = Number.NUM_PATTERN.matcher(sentenceStr);
        while (matcher.find()) {
            Number number = new Number(matcher.group(), matcher.start());
            sentence.addMember(number);
        }
        matcher = SignOther.SIGN_PATTERN.matcher(sentenceStr);
        while (matcher.find()) {
            SignOther signOther = new SignOther(matcher.group(), matcher.start());
            sentence.addMember(signOther);
        }
        matcher = EndSentenceSign.END_SIGN_PATTERN.matcher(sentenceStr);
        while (matcher.find()) {
            SignOther signEnd = new SignOther(matcher.group(), matcher.start());
            sentence.addMember(signEnd);
        }
        sentence.sortSentence();
        return sentence;

    }

    public boolean createText() {
        String[] strings = parseTextStr();
        for (String string : strings) {
            Sentence sentence = parseSentenceStr(string);
            sentenceList.add(sentence);
        }
        if (sentenceList.size() > 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean modifyText() {
        for (Sentence sentence : sentenceList) {
            if (!sentence.modifySentence()) {
                return false;
            }
        }
        return true;
    }

    public List<Sentence> getSentenceList() {
        return sentenceList;
    }
}
