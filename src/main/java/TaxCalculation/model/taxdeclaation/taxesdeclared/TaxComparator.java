package TaxCalculation.model.taxdeclaation.taxesdeclared;

import TaxCalculation.model.taxintrfaces.Tax;

import java.util.Comparator;

public class TaxComparator implements Comparator<Tax> {
    @Override
    public int compare(Tax o1, Tax o2) {
        if(o1.getTax()>o2.getTax()){
            return 1;
        }
        else if (o1.getTax()<o2.getTax()){
            return -1;
        }
        else return 0;
    }
}
