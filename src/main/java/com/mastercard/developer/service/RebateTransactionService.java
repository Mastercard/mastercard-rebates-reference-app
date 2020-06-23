package com.mastercard.developer.service;

import com.mastercard.developer.exception.ServiceException;
import org.openapitools.client.model.RebateTransactions;
import org.openapitools.client.model.RebateTransactionResponse;

public interface RebateTransactionService {

    RebateTransactionResponse create(RebateTransactions rebateTransactionRequestList) throws ServiceException;

}
