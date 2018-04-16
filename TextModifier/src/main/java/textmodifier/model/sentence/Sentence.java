package textmodifier.model.sentence;

import java.util.*;

public class Sentence {
    private List<SentenceMember> sentence;

    public Sentence() {
        this.sentence = new ArrayList<>();
    }

    public void addMember(SentenceMember member) {
        sentence.add(member);
    }

    public boolean modifySentence() {
        if (sentence.size() >= 3) {
            try {
                int firstIndex = getFirstIndexOfWordOrNumber();
                SentenceMember first = sentence.get(firstIndex);
                int lastIndex = getLastIndexOfWordOrNumber();
                SentenceMember last = sentence.get(lastIndex);
                if (first instanceof Word) {
                    first = ((Word) first).toLowerCaseFirstLetter();
                }
                if (last instanceof Word) {
                    last = ((Word) last).toUpperCaseFirstLetter();
                }
                sentence.remove(firstIndex);
                sentence.add(firstIndex, last);
                sentence.remove(lastIndex);
                sentence.add(lastIndex, first);
                return true;

            } catch (NoSuchElementException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public int getLastIndexOfWordOrNumber() {
        for (int i = sentence.size() - 2; i >= 0; i--) {
            if (sentence.get(i) instanceof Word | sentence.get(i) instanceof Number) {
                return i;
            } else {
                throw new NoSuchElementException("Error to find last index");
            }
        }
        return -1;
    }

    public int getFirstIndexOfWordOrNumber() {
        for (int i = 0; i < sentence.size() - 1; i++) {
            if (sentence.get(i) instanceof Word | sentence.get(i) instanceof Number) {
                return i;
            } else {
                throw new NoSuchElementException("Error to fid first index");
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        String sentenceStr = "";
        for (SentenceMember member : sentence) {
            sentenceStr += member.getMember() + " ";
        }
        sentenceStr = sentenceStr.replaceAll("[\\s]+", " ");
        int length = sentenceStr.length();
        if (length > 4) {
            sentenceStr = sentenceStr.substring(0, length - 3) + sentenceStr.substring(length - 2,
                    length - 1);
        }
        return sentenceStr;
    }

    public void sortSentence() {
        Collections.sort(sentence, (a, b) -> {
            if (a.getPositionInText() - b.getPositionInText() > 0) return 1;
            if (a.getPositionInText() - b.getPositionInText() < 0) return -1;
            else return 0;
        });
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sentence)) return false;
        Sentence sentence1 = (Sentence) o;
        for (int i = 0; i < sentence.size(); i++) {
            if (!sentence.get(i).equals(sentence1.getSentence().get(i))) {
                return false;
            } else return true;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        for (int k = 0; k < sentence.size(); k++) {
            hash = 31 * hash + sentence.get(k).hashCode();
        }
        return hash;
    }

    public List<SentenceMember> getSentence() {
        return sentence;
    }
}