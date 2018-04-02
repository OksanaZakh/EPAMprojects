package TaxCalculation.model.income;


import TaxCalculation.model.taxintrfaces.IncomeTax;
import TaxCalculation.model.taxintrfaces.MilitaryTax;
import TaxCalculation.utils.Constants;

public class Salary extends Income implements MilitaryTax, IncomeTax {

    private static double totalSalary = 0;

    public Salary(double incomeBeforeTax) {
        super(incomeBeforeTax);
        totalSalary = totalSalary + incomeBeforeTax;
    }

    public static double getTotalSalary() {
        return totalSalary;
    }

    @Override
    double getNetIncome() {
        return super.incomeBeforeTax-getIncomeTax()-getMilitaryTax();
    }


    @Override
    public double getIncomeTax() {
        if (totalSalary > Constants.CAP_PRIVILEGE) {
            return super.incomeBeforeTax * Constants.PIT_RATE_MAIN;
        } else {
            return (super.incomeBeforeTax - Constants.PRIVILEGE) * Constants.PIT_RATE_MAIN;
        }
    }

    @Override
    public double getMilitaryTax() {
        return super.incomeBeforeTax * Constants.MT_RATE;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Salary(super.incomeBeforeTax);
    }
}
