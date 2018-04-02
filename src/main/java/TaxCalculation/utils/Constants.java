package TaxCalculation.utils;

public class Constants {
    public static final double NATURAL_COEFFICIENT_PIT=1.2195;
    public static final double CAP_PRIVILEGE=2470.00;
    public static final double PRIVILEGE=881.0;
    public static final double CAP_PRESENTS=930.75;

    public static final double PIT_RATE_MAIN=0.18;
    public static final double PIT_RATE_REDUCED=0.05;
    public static final double MT_RATE=0.015;
    public static final double CUSTOMS_DUTY=0.01;

    public static final String WRONG_INPUT_DATA = "Input data is wrong, please try again";
    public static final String EXIT = "Exit";
    public static final String NUMBERS_IN_RANGE = "Please enter the number in range 0 - 5";
    public static final String INCOMES="List of incomes for a year:";
    public static final String TAXES="List of taxes occurred for tax year:";
    public static final String SORTED_TAXES="Sorted list of taxes:";
    public static final String PARTICULAR_TAX_INFO="Get list of incomes taxed by particular tax";
    public static final String CHOOSE_TAX="Pleas choose tax:"+"\n"+"1 - Income tax"+"\n"+"2 - Military tax"+"\n"+"3 - Customs duty";
    public static final String PUT_PAID_TAXES="Put amounts of taxes already paid during year:";
    public static final String DONE="Done!";
    public static final String TAX_DUE="Amounts of tax due based on calculated and paid taxes:";
    public static final String ACTIONS="Available actions:\npress";
    public static final String MENU="0 - to quit\n" +
            "1 - get list of incomes\n" +
            "2 - get list of taxes\n" +
            "3 - sort taxes\n" +
            "4 - get list of incomes taxed by particular tax\n" +
            "5 - put amounts of taxes already paid\n"+
            "6 - get amounts of tax due based on calculated and paid taxes\n"+
            "7 - print available actions.\n";

    public enum TaxType {INCOME_TAX, MILITARY_TAX, CUSTOMS_DUTY}
}
