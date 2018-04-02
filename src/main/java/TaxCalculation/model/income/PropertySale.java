package TaxCalculation.model.income;


import TaxCalculation.model.taxintrfaces.CustomsDuty;
import TaxCalculation.model.taxintrfaces.IncomeTax;
import TaxCalculation.model.taxintrfaces.MilitaryTax;
import TaxCalculation.utils.Constants;

public class PropertySale extends Income implements CustomsDuty, MilitaryTax, IncomeTax {

    private boolean taxedFully; // true if land or commercial property or second (or more) sale for a year

    public PropertySale(double incomeBeforeTax) {
        super(incomeBeforeTax);
        taxedFully=true;
    }

    public PropertySale(double incomeBeforeTax, boolean taxedFully) {
        super(incomeBeforeTax);
        this.taxedFully = taxedFully;
    }

    @Override
    double getNetIncome() {
        return super.incomeBeforeTax - getIncomeTax() - getMilitaryTax()-getCustomDuty();
    }

    @Override
    public double getCustomDuty() {
        return super.incomeBeforeTax* Constants.CUSTOMS_DUTY;
    }

    @Override
    public double getIncomeTax() {
        if (taxedFully){
            return super.incomeBeforeTax*Constants.PIT_RATE_REDUCED;
        }else return 0;
    }

    @Override
    public double getMilitaryTax() {
        if (taxedFully){
            return super.incomeBeforeTax*Constants.MT_RATE;
        }else return 0;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new PropertySale(super.incomeBeforeTax, taxedFully);
    }
}
