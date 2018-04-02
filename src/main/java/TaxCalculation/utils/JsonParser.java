package TaxCalculation.utils;

import TaxCalculation.model.income.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class JsonParser {
    public static final String SALARY="Salary";
    public static final String CASH_TRANSFER="CashTransfer";
    public static final String ROYALTY="Royalty";
    public static final String PRESENTS="Presents";
    public static final String PROPERTY_SALE="PropertySale";
    public static final String JSON_RESOURCE="C:\\Users\\Administrator\\IdeaProjects\\EPAMprojects\\income_data";
    public static final String INCOME="income";
    public static final String INCOMES="incomes";
    public static final String CLASS="class";

    public static List<Income> getJsonIncomes() {
        List<Income> incomes = new ArrayList<>();

        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader(JSON_RESOURCE));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray incomesList = (JSONArray) jsonObject.get(INCOMES);

            for (Object object : incomesList) {
                JSONObject incomeObject = (JSONObject) object;
                String className = (String) incomeObject.get(CLASS);
                double incomeReceived=Double.parseDouble((String) incomeObject.get(INCOME));
                Income income=null;
                switch (className){
                    case SALARY:
                        income=new Salary(incomeReceived);
                        break;
                    case CASH_TRANSFER:
                        income=new CashTransfer(incomeReceived);
                        break;
                    case PRESENTS:
                        income=new Presents(incomeReceived);
                        break;
                    case PROPERTY_SALE:
                        income = new PropertySale(incomeReceived);
                        break;
                    case ROYALTY:
                        income=new Royalty(incomeReceived);
                        break;
                }
                incomes.add(income);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return incomes;
    }
}
