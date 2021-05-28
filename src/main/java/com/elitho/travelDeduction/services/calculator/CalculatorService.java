package com.elitho.travelDeduction.services.calculator;

import com.elitho.travelDeduction.domain.TravelDeduction;

public interface CalculatorService {
    double calculateTravelDeduction(TravelDeduction inputDTO);
}
