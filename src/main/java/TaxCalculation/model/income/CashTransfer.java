package TaxCalculation.model.income;


import TaxCalculation.model.taxintrfaces.IncomeTax;
import TaxCalculation.model.taxintrfaces.MilitaryTax;
import TaxCalculation.utils.Constants;

public class CashTransfer extends Income implements MilitaryTax, IncomeTax {
    private boolean fromCloseRelative;

    public CashTransfer(double incomeBeforeTax, Boolean fromCloseRelative) {
        super(incomeBeforeTax);
        this.fromCloseRelative=fromCloseRelative;
    }

    public CashTransfer(double incomeBeforeTax) {
        super(incomeBeforeTax);
        this.fromCloseRelative=false;
    }

    @Override
    double getNetIncome() {
        return super.incomeBeforeTax-getIncomeTax()-getMilitaryTax();
    }

    @Override
    public double getIncomeTax() {
        if(fromCloseRelative) {
            return 0;
        }else{
            return super.incomeBeforeTax * Constants.PIT_RATE_MAIN;
        }
    }

    @Override
    public double getMilitaryTax() {
        if(fromCloseRelative) {
            return 0;
        }else{
            return super.incomeBeforeTax * Constants.MT_RATE;
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new CashTransfer(super.incomeBeforeTax, fromCloseRelative);
    }
}
