package com.mastercard.developer.executor;

import com.mastercard.developer.example.RebateTransactionExample;
import com.mastercard.developer.exception.ServiceException;
import com.mastercard.developer.service.RebateTransactionService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.openapitools.client.model.Error;
import org.openapitools.client.model.RebateTransactionRequest;
import org.openapitools.client.model.RebateTransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.mastercard.developer.example.RebateTransactionExample.getRebateTransactionRequestForAccountIdentifier;
import static com.mastercard.developer.example.RebateTransactionExample.getRebateTransactionRequestForDPAN;
import static com.mastercard.developer.example.RebateTransactionExample.getRebateTransactionRequestForPAN;

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

        createRebateTransactionsForAccountIdentifier();

        createRebateTransactionsForDPAN();

        errorHandling();

        log.info("<<<---- REBATE TRANSACTION API EXECUTION COMPLETED ---->>>");
    }

    /**
     * USE CASE 1: REBATE WITH ACCOUNT IDENTIFIER
     * It will create rebate transaction for Account Identifier into Mastercard Rewards Platform
     *
     * @return An instance of RebateTransactionResponse
     */
    private RebateTransactionResponse createRebateTransactionsForAccountIdentifier() throws ServiceException {
        return rebateTransactionService.create(RebateTransactionExample.getRebateTransactionRequestList(getRebateTransactionRequestForAccountIdentifier()));
    }

    /**
     * USE CASE 2: REBATE WITH DPAN
     * It will create rebate transaction for DPAN into Mastercard Rewards Platform
     *
     * @return An instance of RebateTransactionResponse
     */
    private RebateTransactionResponse createRebateTransactionsForDPAN() throws ServiceException {
        return rebateTransactionService.create(RebateTransactionExample.getRebateTransactionRequestList(getRebateTransactionRequestForDPAN()));
    }

    /**
     * USE CASE 2: ERROR HANDLING
     * Creation can fail for various reasons, this scenario is added so that you should know what to expect where there is a failure.
     */
    private void errorHandling() {
        RebateTransactionRequest rebateTransactionRequest = getRebateTransactionRequestForAccountIdentifier();
        rebateTransactionRequest.setMerchantId(null);

        try {
            rebateTransactionService.create(RebateTransactionExample.getRebateTransactionRequestList(rebateTransactionRequest));
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

    /**
     * USE CASE 3: REBATE WITH PAN
     * It will create rebate transaction for PAN into Mastercard Rewards Platform
     *
     * @return An instance of RebateTransactionResponse
     */
    private RebateTransactionResponse createRebateTransactionsForPAN() throws ServiceException {
        return rebateTransactionService.create(RebateTransactionExample.getRebateTransactionRequestList(getRebateTransactionRequestForPAN()));
    }
}
