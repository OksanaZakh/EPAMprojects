package TaxCalculation.model;

import model.taxdeclaation.TaxDeclaration;
import utils.Constants;

import java.util.Map;

public class ModelManager {

    private TaxDeclaration declaration;
    private Map<Constants.TaxType, Double> alreadyPaidTaxes;
    private Map<Constants.TaxType, Double> taxDue;

    public ModelManager() {
        alreadyPaidTaxes = new HashMap<>();
        taxDue = new HashMap<>();
        declaration = new TaxDeclaration();
    }

    public boolean calculateTaxDiff() {
        if (alreadyPaidTaxes.size() != 0) {
            Map<Constants.TaxType, Double> declaredTax = new HashMap<>();
            declaredTax.put(Constants.TaxType.INCOME_TAX, declaration.getIncomeTaxForPay().getTax());
            declaredTax.put(Constants.TaxType.MILITARY_TAX, declaration.getMilitaryTaxForPay().getTax());
            declaredTax.put(Constants.TaxType.CUSTOMS_DUTY, declaration.getCustomsDutyForPay().getTax());
            double incomeDiffForPay = declaredTax.get(Constants.TaxType.INCOME_TAX) - alreadyPaidTaxes.get(Constants.TaxType.INCOME_TAX);
            taxDue.put(Constants.TaxType.INCOME_TAX, incomeDiffForPay);
            double militaryDiffForPay = declaredTax.get(Constants.TaxType.MILITARY_TAX) - alreadyPaidTaxes.get(Constants.TaxType.MILITARY_TAX);
            taxDue.put(Constants.TaxType.MILITARY_TAX, militaryDiffForPay);
            double customsDiffForPay = declaredTax.get(Constants.TaxType.CUSTOMS_DUTY) - alreadyPaidTaxes.get(Constants.TaxType.CUSTOMS_DUTY);
            taxDue.put(Constants.TaxType.CUSTOMS_DUTY, customsDiffForPay);
            return true;
        } else return false;
    }

    public void setPaidTaxes(double incomeTax, double militaryTax, double customsDuty) {
        alreadyPaidTaxes.put(Constants.TaxType.INCOME_TAX, incomeTax);
        alreadyPaidTaxes.put(Constants.TaxType.MILITARY_TAX, militaryTax);
        alreadyPaidTaxes.put(Constants.TaxType.CUSTOMS_DUTY, customsDuty);
    }

    public Map<Constants.TaxType, Double> getTaxDue() {
        return taxDue;
    }

    public TaxDeclaration getDeclaration() {
        return declaration;
    }
}
