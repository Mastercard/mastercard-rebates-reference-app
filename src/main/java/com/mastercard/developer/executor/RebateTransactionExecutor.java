package com.mastercard.developer.executor;

import com.mastercard.developer.example.RebateTransactionExample;
import com.mastercard.developer.exception.ServiceException;
import com.mastercard.developer.service.RebateTransactionService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.openapitools.client.model.Error;
import org.openapitools.client.model.RebateTransactionRequest;
import org.openapitools.client.model.RebateTransactionRequestList;
import org.openapitools.client.model.RebateTransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * This is demo executor class to represent how the Rebate Transaction operations can be perform.
 * You can have your own implementation logic to call Rebate Transaction API.
 */

@Slf4j
@Component
public class RebateTransactionExecutor {

    private RebateTransactionService rebateTransactionService;

    @Autowired
    public RebateTransactionExecutor(RebateTransactionService rebateTransactionService) {
        this.rebateTransactionService = rebateTransactionService;
    }

    public void execute() throws ServiceException {
        log.info("<<<---- REBATE TRANSACTION API EXECUTION STARTED ---->>>");

        createRebateTransactions();

        errorHandling();

        log.info("<<<---- REBATE TRANSACTION API EXECUTION COMPLETED ---->>>");
    }

    /**
     * USE CASE 1: CREATE REBATE TRANSACTION
     * It will create rebate transaction into Mastercard Rewards Platform
     *
     * @return An instance of RebateTransactionResponse
     */
    private RebateTransactionResponse createRebateTransactions() throws ServiceException {
        return rebateTransactionService.create(RebateTransactionExample.getRebateTransactionRequestList());
    }

    /**
     * USE CASE 2: ERROR HANDLING
     * Creation can fail for various reasons, this scenario is added so that you should know what to expect where there is a failure.
     */
    private void errorHandling() {
        RebateTransactionRequest rebateTransactionRequest = RebateTransactionExample.getRebateTransactionRequest();
        rebateTransactionRequest.setMerchantId(null);

        RebateTransactionRequestList rebateTransactionList = new RebateTransactionRequestList();
        rebateTransactionList.addRebateTransactionRequestListItem(rebateTransactionRequest);

        try {
            rebateTransactionService.create(rebateTransactionList);
        } catch (ServiceException e) {
            List<Error> errorList = e.getServiceErrors().getErrors().getError();
            Assertions.assertFalse(errorList.isEmpty());
            errorList.forEach(error -> {
                Assertions.assertEquals("MRS", error.getSource());
                Assertions.assertEquals("MISSING_REQUIRED_FIELD", error.getReasonCode());
                log.error("Failed to create Rebate Transaction in Error Handling Scenario - {}", error.getDescription());
            });
        }
    }
}
