package textmodifier.model.sentence;

import java.util.regex.Pattern;

public class SignOther implements SentenceMember {
    private int positionInText;
    private static final String SIGN_REGEX = "[\\/|\"|\\\\|:|;||@|#|'|)|(]{1}|(\\s-\\s){1}";
    private String sign;
    public static final Pattern SIGN_PATTERN = Pattern.compile(SIGN_REGEX);

    public SignOther(String sign, int positionInText) {
        this.sign = sign;
        this.positionInText = positionInText;
    }

    @Override
    public String getMember() {
        return sign;
    }

    @Override
    public int getPositionInText() {
        return positionInText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SignOther that = (SignOther) o;
        return sign.equals(that.sign);
    }

    @Override
    public int hashCode() {
        int res = 17;
        res = 31 * res + sign.hashCode();
        return res;
    }
}
