package TaxCalculation.view;


import TaxCalculation.utils.Constants;

public class View {

    public void printData(String data) {
        System.out.println(data);
    }

    public void printMenu() {
        System.out.println(Constants.ACTIONS);
        System.out.println(Constants.MENU);
    }
}
