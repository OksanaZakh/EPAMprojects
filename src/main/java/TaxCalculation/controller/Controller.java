package TaxCalculation.controller;

import model.ModelManager;
import model.taxintrfaces.Constants;
import utils.CustomScanner;
import view.View;

public class Controller {
    View view;
    ModelManager model;
    CustomScanner customScanner;

    public Controller(View view, ModelManager model) {
        this.view = view;
        this.model = model;
        customScanner = new CustomScanner(view);
    }

    public void runCalculation() {
        boolean quit = false;
        view.printMenu();
        while (!quit) {
            int action = customScanner.inputIntValueWithScanner();
            customScanner.goForward();
            switch (action) {
                case 0:
                    view.printData(Constants.EXIT);
                    quit = true;
                    break;
                case 1:
                    getListOfIncomes();
                    break;
                case 2:
                    getListOfTaxes();
                    break;
                case 3:
                    getSortedTaxes();
                    break;
                case 4:
                    getParticularTaxInfo();
                    break;
                case 5:
                    putAlreadyPaidAmountsOfTax();
                    break;
                case 6:
                    getTaxDueAmounts();
                    break;
                case 7:
                    view.printMenu();
                    break;
                default:
                    view.printData(Constants.NUMBERS_IN_RANGE);
                    view.printMenu();
                    break;
            }
        }
    }

    private void getListOfIncomes() {
        view.printData(Constants.INCOMES);
        view.printData(model.getDeclaration().getIncomes().toString());
    }

    private void getListOfTaxes() {
        view.printData(Constants.TAXES);
        view.printData(model.getDeclaration().getIncomeTaxForPay().toString());
        view.printData(model.getDeclaration().getMilitaryTaxForPay().toString());
        view.printData(model.getDeclaration().getCustomsDutyForPay().toString());
    }

    private void getSortedTaxes() {
        view.printData(Constants.SORTED_TAXES);
        view.printData(model.getDeclaration().sortTaxes().toString());
    }

    private void getParticularTaxInfo() {
        view.printData(Constants.PARTICULAR_TAX_INFO);
        view.printData(Constants.CHOOSE_TAX);
        int input = customScanner.inputIntValueWithScanner();
        Constants.TaxType taxType = null;
        switch (input) {
            case 1:
                taxType = Constants.TaxType.INCOME_TAX;
                view.printData(Constants.TaxType.INCOME_TAX.toString());
                break;
            case 2:
                taxType = Constants.TaxType.MILITARY_TAX;
                view.printData(Constants.TaxType.MILITARY_TAX.toString());
                break;
            case 3:
                taxType = Constants.TaxType.CUSTOMS_DUTY;
                view.printData(Constants.TaxType.CUSTOMS_DUTY.toString());
                break;
            default:
                view.printData(Constants.WRONG_INPUT_DATA);

        }
        view.printData(model.getDeclaration().getParticularTaxedIncome(taxType).toString());
    }

    private void putAlreadyPaidAmountsOfTax() {
        view.printData(Constants.PUT_PAID_TAXES);
        view.printData(Constants.TaxType.INCOME_TAX.toString());
        int incomeTax = customScanner.inputIntValueWithScanner();
        customScanner.goForward();
        view.printData(Constants.TaxType.MILITARY_TAX.toString());
        int militaryTax = customScanner.inputIntValueWithScanner();
        customScanner.goForward();
        view.printData(Constants.TaxType.CUSTOMS_DUTY.toString());
        int customsDuty = customScanner.inputIntValueWithScanner();
        model.setPaidTaxes(incomeTax, militaryTax, customsDuty);
        view.printData(Constants.DONE);
    }

    private void getTaxDueAmounts() {
        view.printData(Constants.TAX_DUE);
        if (model.calculateTaxDiff()) {
            view.printData(model.getTaxDue().toString());
        } else {
            putAlreadyPaidAmountsOfTax();
            getTaxDueAmounts();
        }
    }

}
