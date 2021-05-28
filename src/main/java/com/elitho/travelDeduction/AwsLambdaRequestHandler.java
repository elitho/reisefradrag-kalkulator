package com.elitho.travelDeduction;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import com.elitho.travelDeduction.dto.TravelDeductionDTO;
import com.elitho.travelDeduction.dto.TravelDeductionResponseDTO;
import com.elitho.travelDeduction.services.calculator.CalculatorService;
import com.elitho.travelDeduction.services.calculator.CalculatorServiceImpl;

public class AwsLambdaRequestHandler implements RequestHandler<TravelDeductionDTO, TravelDeductionResponseDTO> {

    @Override
    public TravelDeductionResponseDTO handleRequest(TravelDeductionDTO inputDTO, Context context) {
        CalculatorService calculatorService = CalculatorServiceImpl.getInstance();
        return new TravelDeductionResponseDTO(calculatorService.calculateTravelDeduction(inputDTO.toDomain()));
    }
}
