package com.mastercard.developer.service.impl;

import com.mastercard.developer.exception.ServiceException;
import com.mastercard.developer.service.RebateTransactionService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.JSON;
import org.openapitools.client.api.RebateTransactionApi;
import org.openapitools.client.model.Errors;
import org.openapitools.client.model.RebateTransactionRequestList;
import org.openapitools.client.model.RebateTransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RebateTransactionServiceImpl implements RebateTransactionService {

    private RebateTransactionApi rebateTransactionApi;

    private JSON json;

    @Autowired
    public RebateTransactionServiceImpl(ApiClient apiClient) {
        log.info("-->> INITIALIZING REBATE TRANSACTION API");
        rebateTransactionApi = new RebateTransactionApi(apiClient);
        json = new JSON();
    }

    /**
     * Creates new rebate transactions in Mastercard Rewards Platform
     * URL: /rebate-transactions
     * Method: POST
     * Success Response: 201(CREATED)
     * Error Response: 4XX or 5XX
     *
     * @param rebateTransactionRequestList List of Rebate Transactions (required)
     * @return An instance of RebateTransactionResponse
     * @throws ServiceException If error occurred while calling rebate transaction create endpoint
     */
    @Override
    public RebateTransactionResponse create(RebateTransactionRequestList rebateTransactionRequestList) throws ServiceException {
        try {
            log.info("<-- CALLING REBATE TRANSACTION CREATE ENDPOINT -->");
            RebateTransactionResponse rebateTransactionResponse = rebateTransactionApi.createRebateTransaction(rebateTransactionRequestList);
            Assertions.assertNotNull(rebateTransactionResponse, "Missing object 'rebateTransactionResponse' when calling createRebateTransaction(Async)");
            log.info("<-- REBATE TRANSACTION CREATED SUCCESSFULLY -->");
            return rebateTransactionResponse;
        } catch (ApiException e) {
            log.error("<-- REBATE TRANSACTION CREATION FAILED -->");
            throw new ServiceException(e.getMessage(), deserializeErrors(e.getResponseBody()));
        }
    }

    private Errors deserializeErrors(String body) {
        return json.deserialize(body, Errors.class);
    }
}
