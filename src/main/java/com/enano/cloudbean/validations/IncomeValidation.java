package com.enano.cloudbean.validations;

import com.enano.cloudbean.entities.Commodity;
import com.enano.cloudbean.entities.Income;

public class IncomeValidation {

  public static String NO_MIN_REQUIRED_FIELD = "Invalid Income: minimun requested fields are not present";
  public static boolean isValidIncome(Income income) {
    boolean result = true;
    try {
      if (!AnalysisValidation.isValidAnalysis(income.getAnalysis())) {
        income.setAnalysis(null);
      }
      if (income.getCommodities().size() > 0) {
        Commodity commodity = income.getCommodities().iterator().next();
        result = (commodity.getAmount() > 0);
      } else {
        result = false;
      }
    }catch (NullPointerException npe) {
      result = false;
    }
    return result;
  }
}
