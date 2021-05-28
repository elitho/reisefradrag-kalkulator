package com.elitho.travelDeduction.services.calculator;

import java.util.List;
import java.util.stream.Stream;

import com.elitho.travelDeduction.domain.TravelDeduction;

public class CalculatorServiceImpl implements CalculatorService {

    private static final double NOK_PR_KM_UNDER_LOWER_LIMIT = 1.5;
    private static final double NOK_PR_KM_OVER_LOWER_LIMIT = 0.7;
    private static final double UPPER_KM_LIMIT = 75000;
    private static final double LOWER_KM_LIMIT = 50000;
    private static final double UPPER_LOWER_KM_DIFF = UPPER_KM_LIMIT - LOWER_KM_LIMIT;
    private static final double MINIMUM_EXPENSES_LIMIT = 3400;
    private static final double EXCESS = 22000;

    private static final CalculatorService calculatorService = new CalculatorServiceImpl();

    private CalculatorServiceImpl() {
    }

    @Override
    public double calculateTravelDeduction(TravelDeduction travelDeduction) {
        // add to total km from both types of trips
        int totalNumberOfKm = Stream.concat(
            Stream.ofNullable(travelDeduction.getArbeidsreiser()),
            Stream.ofNullable(travelDeduction.getBesoeksreiser()))
            .flatMap(List::stream)
            .mapToInt(travelEntity -> travelEntity.getKm() * travelEntity.getAntall())
            .sum();

        // add to travel deduction
        double travelDeductionSum = 0;
        if (totalNumberOfKm < LOWER_KM_LIMIT) {
            travelDeductionSum += NOK_PR_KM_UNDER_LOWER_LIMIT * totalNumberOfKm;
        } else {
            travelDeductionSum += NOK_PR_KM_UNDER_LOWER_LIMIT * LOWER_KM_LIMIT;
            if (totalNumberOfKm > UPPER_KM_LIMIT) {
                travelDeductionSum += NOK_PR_KM_OVER_LOWER_LIMIT * UPPER_LOWER_KM_DIFF;
            } else {
                travelDeductionSum += NOK_PR_KM_OVER_LOWER_LIMIT * (totalNumberOfKm - LOWER_KM_LIMIT);
            }
        }

        // if expenses is over expense limit, add everything or else add nothing
        double expenses = travelDeduction.getUtgifterBomFergeEtc();
        if (expenses > MINIMUM_EXPENSES_LIMIT) {
            travelDeductionSum += expenses;
        }

        // deduct excess (egenandel) from total travel deduction
        travelDeductionSum = travelDeductionSum - EXCESS;

        // if excess is larger than travelDeductionSum we just return 0
        return travelDeductionSum > 0 ? travelDeductionSum : 0;
    }

    public static CalculatorService getInstance() {
        return calculatorService;
    }
}
