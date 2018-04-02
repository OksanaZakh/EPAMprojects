package TaxCalculation.model.taxintrfaces;


import TaxCalculation.model.income.Income;

import java.util.List;

public interface Tax extends Cloneable{
    double getTax();
    List<Income> getIncomes();
}
