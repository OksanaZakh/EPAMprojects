package TaxCalculation;

import TaxCalculation.controller.Controller;
import TaxCalculation.model.ModelManager;
import TaxCalculation.view.View;

public class MainTaxCalculation {
    public static void main(String[] args) {
        Controller controller = new Controller(new View(), new ModelManager());
        controller.runCalculation();
    }
}
