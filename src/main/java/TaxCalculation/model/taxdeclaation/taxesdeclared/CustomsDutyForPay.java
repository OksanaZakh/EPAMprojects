package TaxCalculation.model.taxdeclaation.taxesdeclared;


import TaxCalculation.model.income.Income;
import TaxCalculation.model.taxintrfaces.CustomsDuty;
import TaxCalculation.model.taxintrfaces.Tax;

import java.util.ArrayList;
import java.util.List;

public class CustomsDutyForPay implements Tax {
    private List<CustomsDuty> incomesCharged;

    public CustomsDutyForPay() {
        incomesCharged=new ArrayList<>();
    }

    public List<CustomsDuty> getIncomesCharged() {
        return incomesCharged;
    }

    public boolean addIncome(CustomsDuty tax){
        if(!incomesCharged.contains(tax)){
            incomesCharged.add(tax);
            return true;
        }
        else return false;
    }

    @Override
    public double getTax() {
        double totalTax=0;
        for(CustomsDuty tax: incomesCharged){
            totalTax+=tax.getCustomDuty();
        }
        return totalTax;
    }

    @Override
    public List<Income> getIncomes() {
        List<Income> incomes=new ArrayList<>();
        for (CustomsDuty tax:incomesCharged){
            Income income=(Income) tax;
            incomes.add(income);
        }
        return incomes;
    }

    @Override
    public String toString() {
        return "Customs Duty: "+getTax()+" "+incomesCharged+"\n";
    }
}
