package com.enano.cloudbean.validations;

import com.enano.cloudbean.entities.Analysis;

public class AnalysisValidation {
  
  public static boolean isValidAnalysis(Analysis analysis) {
    boolean result = true;
    try {
     if  (analysis.getId() <= 0 || analysis.getGramaje() < 0) {
       result = false;
     }
    }catch (NullPointerException npe) {
      result = false;
    }
    return result;
  }

}
