package TaxCalculation.model.taxdeclaation;

import TaxCalculation.model.income.Income;
import TaxCalculation.model.taxdeclaation.taxesdeclared.CustomsDutyForPay;
import TaxCalculation.model.taxdeclaation.taxesdeclared.IncomeTaxForPay;
import TaxCalculation.model.taxdeclaation.taxesdeclared.MilitaryTaxForPay;
import TaxCalculation.model.taxdeclaation.taxesdeclared.TaxComparator;
import TaxCalculation.model.taxintrfaces.CustomsDuty;
import TaxCalculation.model.taxintrfaces.IncomeTax;
import TaxCalculation.model.taxintrfaces.MilitaryTax;
import TaxCalculation.model.taxintrfaces.Tax;
import TaxCalculation.utils.Constants;
import TaxCalculation.utils.JsonParser;

import java.util.ArrayList;
import java.util.List;

public class TaxDeclaration {


    private List<Tax> totalTaxesForYear;
    private List<Income> incomes;

    public TaxDeclaration() {
        totalTaxesForYear = new ArrayList<>();
        incomes = JsonParser.getJsonIncomes();
        fillDeclaration();
    }

    public CustomsDutyForPay getCustomsDutyForPay() {
        for (Tax tax : totalTaxesForYear) {
            if (tax instanceof CustomsDutyForPay) {
                return (CustomsDutyForPay) tax;
            }
        }
        return null;
    }

    public IncomeTaxForPay getIncomeTaxForPay() {
        for (Tax tax : totalTaxesForYear) {
            if (tax instanceof IncomeTaxForPay) {
                return (IncomeTaxForPay) tax;
            }
        }
        return null;
    }

    public MilitaryTaxForPay getMilitaryTaxForPay() {
        for (Tax tax : totalTaxesForYear) {
            if (tax instanceof MilitaryTaxForPay) {
                return (MilitaryTaxForPay) tax;
            }
        }
        return null;
    }

    public List<Tax> getTotalTaxesForYear() {
        return totalTaxesForYear;
    }


    public List<Income> getIncomes() {
        return incomes;
    }

    private void fillDeclaration() {
        CustomsDutyForPay customsDutyTax = new CustomsDutyForPay();
        IncomeTaxForPay incomeTax = new IncomeTaxForPay();
        MilitaryTaxForPay militaryTax = new MilitaryTaxForPay();
        totalTaxesForYear.add(militaryTax);
        totalTaxesForYear.add(customsDutyTax);
        totalTaxesForYear.add(incomeTax);
        for (Income income : incomes) {
            if (income instanceof CustomsDuty) {
                customsDutyTax.addIncome((CustomsDuty) income);
            }
            if (income instanceof MilitaryTax) {
                militaryTax.addIncome((MilitaryTax) income);
            }
            if (income instanceof IncomeTax) {
                incomeTax.addIncome((IncomeTax) income);
            }
        }
    }

    public List<Tax> sortTaxes() {
        totalTaxesForYear.sort(new TaxComparator());
        return totalTaxesForYear;
    }

    public List<Income> getParticularTaxedIncome(Constants.TaxType taxType) {
        List<Income> particularTaxedIncome = null;
        switch (taxType) {
            case INCOME_TAX:
                particularTaxedIncome = getIncomeTaxForPay().getIncomes();
                break;
            case MILITARY_TAX:
                particularTaxedIncome = getMilitaryTaxForPay().getIncomes();
                break;
            case CUSTOMS_DUTY:
                particularTaxedIncome = getCustomsDutyForPay().getIncomes();
                break;
        }
        return particularTaxedIncome;
    }

}
