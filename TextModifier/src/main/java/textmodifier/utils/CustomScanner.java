package textmodifier.utils;

import textmodifier.view.Constants;
import textmodifier.view.View;

import java.util.Scanner;

public class CustomScanner {

    private Scanner scanner;
    View view;

    public CustomScanner(View view) {
        this.scanner = new Scanner(System.in);
        this.view = view;
    }

    public int inputIntValueWithScanner() {
        while (!scanner.hasNextInt()) {
            view.printData(Constants.WRONG_INPUT_DATA);
            scanner.next();
        }
        return scanner.nextInt();
    }

    public String inputStringValueWithScanner() {
        while (!scanner.hasNextLine()) {
            view.printData(Constants.WRONG_INPUT_DATA);
            scanner.next();
        }
        return scanner.nextLine();
    }

    public void goForward() {
        scanner.nextLine();
    }

}
