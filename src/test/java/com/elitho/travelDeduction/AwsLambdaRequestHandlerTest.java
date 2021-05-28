package com.elitho.travelDeduction;

import com.amazonaws.services.lambda.runtime.ClientContext;
import com.amazonaws.services.lambda.runtime.CognitoIdentity;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.tests.EventLoader;
import com.elitho.travelDeduction.dto.TravelDeductionDTO;
import com.elitho.travelDeduction.dto.TravelDeductionResponseDTO;

import junit.framework.TestCase;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AwsLambdaRequestHandlerTest extends TestCase {

    public void testHandleRequest() {
        TravelDeductionDTO travelDeductionDTO =
            EventLoader.loadEvent("bekkCaseATestInput.json", TravelDeductionDTO.class);
        AwsLambdaRequestHandler handler = new AwsLambdaRequestHandler();
        Context contextMock = getContextMock();
        TravelDeductionResponseDTO responseDTO = handler.handleRequest(travelDeductionDTO, contextMock);
        assertThat(responseDTO.getReisefradrag(), is(13168.0));
    }

    private Context getContextMock() {
        return new Context() {
            @Override
            public String getAwsRequestId() {
                return null;
            }

            @Override
            public String getLogGroupName() {
                return null;
            }

            @Override
            public String getLogStreamName() {
                return null;
            }

            @Override
            public String getFunctionName() {
                return null;
            }

            @Override
            public String getFunctionVersion() {
                return null;
            }

            @Override
            public String getInvokedFunctionArn() {
                return null;
            }

            @Override
            public CognitoIdentity getIdentity() {
                return null;
            }

            @Override
            public ClientContext getClientContext() {
                return null;
            }

            @Override
            public int getRemainingTimeInMillis() {
                return 0;
            }

            @Override
            public int getMemoryLimitInMB() {
                return 0;
            }

            @Override
            public LambdaLogger getLogger() {
                return null;
            }
        };
    }
}