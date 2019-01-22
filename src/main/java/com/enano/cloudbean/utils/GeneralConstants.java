package com.enano.cloudbean.utils;

import java.util.HashMap;
import java.util.Map;

import com.enano.cloudbean.dtos.MeasurmentUnitsDto;

public class GeneralConstants{
  
  public static final Map<Integer, MeasurmentUnitsDto> MEASURMENT_UNITS = getMeasurmentUnits();

  private static Map<Integer, MeasurmentUnitsDto> getMeasurmentUnits() {
    Map<Integer, MeasurmentUnitsDto> measurmentUnits = new HashMap<>();
    measurmentUnits.put(1, new MeasurmentUnitsDto("Kilogramo", "kg"));
    measurmentUnits.put(2, new MeasurmentUnitsDto("Litro", "l"));
    return measurmentUnits;
  }
}