package textmodifier.model.sentence;

import java.util.regex.Pattern;

public class Number implements SentenceMember {
    private int positionInText;
    private static final String NUM_REGEX = "[0-9]+([,|.]{1}[0-9]+)?[0-9]*";
    private String number;
    public static final Pattern NUM_PATTERN = Pattern.compile(NUM_REGEX);

    public Number(String number, int startIndex) {
        this.number = number;
        this.positionInText = startIndex;
    }

    public Number(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String getMember() {
        return number;
    }

    @Override
    public int getPositionInText() {
        return positionInText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number that = (Number) o;
        return number.equals(that.getNumber());
    }

    @Override
    public int hashCode() {
        int res = 17;
        res = 31 * res + number.hashCode();
        return res;
    }
}
