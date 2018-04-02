package TaxCalculation.model.income;


import TaxCalculation.model.taxintrfaces.IncomeTax;
import TaxCalculation.model.taxintrfaces.MilitaryTax;
import TaxCalculation.utils.Constants;

public class Royalty extends Income implements MilitaryTax, IncomeTax {

    public Royalty(double incomeBeforeTax) {
        super(incomeBeforeTax);
    }

    @Override
    double getNetIncome() {
        return super.incomeBeforeTax - getIncomeTax() - getMilitaryTax();
    }

    @Override
    public double getIncomeTax() {
        return super.incomeBeforeTax* Constants.PIT_RATE_REDUCED;
    }

    @Override
    public double getMilitaryTax() {
        return super.incomeBeforeTax*Constants.MT_RATE;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Royalty(super.incomeBeforeTax);
    }
}
