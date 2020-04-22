package com.mastercard.developer.service;

import com.mastercard.developer.exception.ServiceException;
import org.openapitools.client.model.RebateTransactionRequestList;
import org.openapitools.client.model.RebateTransactionResponse;

public interface RebateTransactionService {

    RebateTransactionResponse create(RebateTransactionRequestList rebateTransactionRequestList) throws ServiceException;

}
