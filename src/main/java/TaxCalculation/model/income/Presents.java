package TaxCalculation.model.income;


import TaxCalculation.model.taxintrfaces.IncomeTax;
import TaxCalculation.model.taxintrfaces.MilitaryTax;
import TaxCalculation.utils.Constants;

public class Presents extends Income implements MilitaryTax, IncomeTax {
    private boolean fromCloseRelatives;
    private boolean nonMonetary;

    public Presents(double incomeBeforeTax) {
        super(incomeBeforeTax);
        this.fromCloseRelatives = false;
        this.nonMonetary = false;
    }

    public Presents(double incomeBeforeTax, boolean fromCloseRelatives) {
        super(incomeBeforeTax);
        this.fromCloseRelatives = fromCloseRelatives;
        this.nonMonetary = false;
    }

    public Presents(double incomeBeforeTax, boolean fromCloseRelatives, boolean nonMonetary) {
        super(incomeBeforeTax);
        this.fromCloseRelatives = fromCloseRelatives;
        this.nonMonetary = nonMonetary;
    }

    @Override
    double getNetIncome() {
        return super.incomeBeforeTax - getIncomeTax() - getMilitaryTax();
    }

    @Override
    public double getIncomeTax() {
        return getTaxForPay(Constants.PIT_RATE_MAIN);
    }

    @Override
    public double getMilitaryTax() {
        return getTaxForPay(Constants.MT_RATE);
    }

    private double getTaxForPay(double rate) {
        if (fromCloseRelatives) {
            return 0;
        }
        double taxBase = super.incomeBeforeTax;
        if (nonMonetary) {
            taxBase = super.incomeBeforeTax * Constants.NATURAL_COEFFICIENT_PIT;
        }

        if (taxBase > Constants.CAP_PRESENTS) {
            return taxBase * rate;
        } else return 0;
    }

    @Override
    public String toString() {
        String result = super.toString().replace("\n", "");
        if (fromCloseRelatives) {
            result += " from close relative";
        }
        if (nonMonetary) {
            result += " in non-monetary form";
        } else {
            result += " in monetary form";
        }
        result += "\n";
        return result;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Presents(super.incomeBeforeTax, fromCloseRelatives, nonMonetary);
    }
}
