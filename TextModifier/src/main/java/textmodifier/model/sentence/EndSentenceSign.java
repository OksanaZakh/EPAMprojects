package textmodifier.model.sentence;

import java.util.Objects;
import java.util.regex.Pattern;

public class EndSentenceSign implements SentenceMember {
    private int positionInText;
    public static final String END_SIGN_REGEX = "([.]{1,3}|[?]|[!])[\\s]+";
    private String endSign;
    public static final Pattern END_SIGN_PATTERN = Pattern.compile(END_SIGN_REGEX);

    public EndSentenceSign(String endSign) {
        this.endSign = endSign;
    }

    public EndSentenceSign(String endSign, int positionInText) {
        this.positionInText = positionInText;
        this.endSign = endSign;
    }


    @Override
    public String getMember() {
        return endSign;
    }

    @Override
    public int getPositionInText() {
        return positionInText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EndSentenceSign that = (EndSentenceSign) o;
        return endSign.equals(that.endSign);
    }

    @Override
    public int hashCode() {
        int res = 17;
        res = 31 * res + endSign.hashCode();
        return res;
    }
}
