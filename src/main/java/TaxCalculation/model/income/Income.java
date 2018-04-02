package TaxCalculation.model.income;

public abstract class Income implements Cloneable{
    protected double incomeBeforeTax;

    public Income(double incomeBeforeTax) {
        this.incomeBeforeTax = incomeBeforeTax;
    }

    public double getIncomeBeforeTax() {
        return incomeBeforeTax;
    }

    abstract double getNetIncome();

    @Override
    public int hashCode() {
        int res = 17;
        long income = Double.doubleToLongBits(incomeBeforeTax);
        res = res * 31 + (int) (income ^ (income >>> 32));
        return res;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Income income = (Income) o;
        return Double.compare(income.incomeBeforeTax, incomeBeforeTax) == 0;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                ": incomeBeforeTax=" + incomeBeforeTax+"\n";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
