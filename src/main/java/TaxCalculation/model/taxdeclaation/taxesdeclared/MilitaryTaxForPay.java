package TaxCalculation.model.taxdeclaation.taxesdeclared;


import TaxCalculation.model.income.Income;
import TaxCalculation.model.taxintrfaces.MilitaryTax;
import TaxCalculation.model.taxintrfaces.Tax;

import java.util.ArrayList;
import java.util.List;

public class MilitaryTaxForPay implements Tax {
    private List<MilitaryTax> incomesCharged;

    public MilitaryTaxForPay() {
        incomesCharged=new ArrayList<>();
    }

    public List<MilitaryTax> getIncomesCharged() {
        return incomesCharged;
    }

    public boolean addIncome(MilitaryTax tax){
        if(!incomesCharged.contains(tax)){
            incomesCharged.add(tax);
            return true;
        }
        else return false;
    }

    @Override
    public double getTax() {
        double totalTax=0;
        for(MilitaryTax tax: incomesCharged){
            totalTax+=tax.getMilitaryTax();
        }
        return totalTax;
    }
    @Override
    public List<Income> getIncomes() {
        List<Income> incomes=new ArrayList<>();
        for (MilitaryTax tax:incomesCharged){
            Income income=(Income) tax;
            incomes.add(income);
        }
        return incomes;
    }
    @Override
    public String toString() {
        return "Military Tax: "+getTax()+" "+incomesCharged+"\n";
    }
}
