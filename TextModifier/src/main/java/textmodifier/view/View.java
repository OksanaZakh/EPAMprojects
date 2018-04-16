package textmodifier.view;

import textmodifier.model.sentence.Sentence;

import java.util.List;

public class View {
    public void printData(String data) {
        System.out.println(data);
    }

    public void printMenu() {
        System.out.println(Constants.MENU);
    }

    public void printList(List<Sentence> sentences) {
        for (Sentence sentence : sentences) {
            System.out.println(sentence);
        }
    }
}
