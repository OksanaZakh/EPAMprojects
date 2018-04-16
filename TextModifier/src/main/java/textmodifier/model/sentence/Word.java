package textmodifier.model.sentence;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Word implements SentenceMember {
    private int positionInText;
    private static final String WORD_REGEX = "[а-яА-Яa-zA-Z]+(([-]|[@]|[.]){1}[а-яА-Яa-zA-Z]+)?[а-яА-Яa-zA-Z]*";
    private String word;
    public static final Pattern WORD_PATTERN = Pattern.compile(WORD_REGEX);

    public Word(String word, int positionInText) {
        this.positionInText = positionInText;
        this.word = word;
    }

    public Word(String word) {
        this.word = word;
    }

    private boolean isFirstLetterUpperCase() {
        char first = word.charAt(0);
        Pattern pattern = Pattern.compile("[А-ЯA-Z]{1}");
        Matcher matcher = pattern.matcher(first + "");
        if (matcher.find()) {
            return true;
        } else return false;
    }

    @Override
    public String getMember() {
        return word;
    }

    public Word toUpperCaseFirstLetter() {
        return new Word((word.charAt(0)+"").toUpperCase()+word.substring(1));

    }

    public Word toLowerCaseFirstLetter() {
        if (word.length() > 2 && new Word(word.substring(1)).isFirstLetterUpperCase()) {
            return this;
        } else {
            return new Word(word.toLowerCase());
        }
    }

    @Override
    public int getPositionInText() {
        return positionInText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word that = (Word) o;
        return word.equals(that.word);
    }

    @Override
    public int hashCode() {
        int res=17;
        res=31*res+word.hashCode();
        return res;
    }
}
