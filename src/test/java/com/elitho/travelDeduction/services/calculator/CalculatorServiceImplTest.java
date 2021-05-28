package com.elitho.travelDeduction.services.calculator;

import java.util.Collections;

import com.elitho.travelDeduction.domain.Travel;
import com.elitho.travelDeduction.domain.TravelDeduction;

import junit.framework.TestCase;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class CalculatorServiceImplTest extends TestCase {

    private final CalculatorService calculatorService = CalculatorServiceImpl.getInstance();

    // testing expected input
    public void testCalculateTravelDeduction() {
        TravelDeduction inputWithExpenses = createInput(50000, 10000, 10000);
        TravelDeduction inputWithoutExpenses = createInput(50000, 10000, 0);
        double withExpensesResponse = calculatorService.calculateTravelDeduction(inputWithExpenses);
        double withoutExpensesResponse = calculatorService.calculateTravelDeduction(inputWithoutExpenses);
        assertThat(70000.0, is(withExpensesResponse));
        assertThat(60000.0, is(withoutExpensesResponse));
    }

    // testing null safety
    public void testWithOnlyOneList() {
        TravelDeduction input = createInput(50000, 10000, 0);
        input.setBesoeksreiser(null);
        double travelDeductionResponse = calculatorService.calculateTravelDeduction(input);
        assertThat(53000.0, is(travelDeductionResponse));
    }

    // testing that upper limit restriction works as expected
    public void testUpperLimitRestriction() {
        TravelDeduction limitInput = createInput(25000, 50000, 0);
        TravelDeduction overLimitInput = createInput(30000, 50000, 0);
        TravelDeduction underLimitInput = createInput(10000, 50000, 0);

        double limitResponse = calculatorService.calculateTravelDeduction(limitInput);
        double overLimitResponse = calculatorService.calculateTravelDeduction(overLimitInput);
        double underLimitResponse = calculatorService.calculateTravelDeduction(underLimitInput);

        // 50000 * 1.5 = 75000
        // 25000 * 0.7 = 17500
        // 75000 + 17500 = 92500
        // 92500 - 22000 = 70500
        // with no expenses you should max get 70500
        assertThat(70500.0, is(limitResponse));
        // limit and overLimit should return the same
        assertThat(limitResponse, is(overLimitResponse));
        // over and under limit should not be the same
        assertThat(overLimitResponse, not(underLimitResponse));
    }

    public void testNoDeduction() {
        // this is not enough kilometers to get travel deduction, we expect the calculator to return 0
        TravelDeduction input = createInput(10000, 1000, 0);
        double travelDeductionResponse = calculatorService.calculateTravelDeduction(input);
        assertThat(0.0, is(travelDeductionResponse));
    }

    private TravelDeduction createInput(int workTripsKm, int visitTripsKm, int expenses) {
        return new TravelDeduction(
            Collections.singletonList(new Travel(workTripsKm, 1)),
            Collections.singletonList(new Travel(visitTripsKm, 1)),
            expenses);
    }
}