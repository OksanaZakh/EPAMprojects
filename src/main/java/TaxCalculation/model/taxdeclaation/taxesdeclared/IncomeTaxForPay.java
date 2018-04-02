package TaxCalculation.model.taxdeclaation.taxesdeclared;


import TaxCalculation.model.income.Income;
import TaxCalculation.model.taxintrfaces.IncomeTax;
import TaxCalculation.model.taxintrfaces.Tax;


import java.util.ArrayList;
import java.util.List;

public class IncomeTaxForPay implements Tax {
    private List<IncomeTax> incomesCharged;

    public IncomeTaxForPay() {
        incomesCharged = new ArrayList<>();
    }

    public List<IncomeTax> getIncomesCharged() {
        return incomesCharged;
    }

    public boolean addIncome(IncomeTax tax) {
        if (!incomesCharged.contains(tax)) {
            incomesCharged.add(tax);
            return true;
        } else return false;
    }

    @Override
    public double getTax() {
        double totalTax = 0;
        for (IncomeTax tax : incomesCharged) {
            totalTax += tax.getIncomeTax();
        }
        return totalTax;
    }
    @Override
    public List<Income> getIncomes() {
        List<Income> incomes=new ArrayList<>();
        for (IncomeTax tax:incomesCharged){
            Income income=(Income) tax;
            incomes.add(income);
        }
        return incomes;
    }
    @Override
    public String toString() {
        return "Personal Income Tax: "+getTax()+" "+incomesCharged+"\n";
    }

}
