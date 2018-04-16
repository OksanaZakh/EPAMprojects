package textmodifier;

import textmodifier.view.View;
import textmodifier.controller.Controller;
import textmodifier.model.TextManager;

public class MainModifier {
    public static void main(String[] args) {
        Controller controller = new Controller(new TextManager(), new View());
        controller.run();
    }
}
