package com.mastercard.developer.example;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openapitools.client.model.RebateTransactionRequest;
import org.openapitools.client.model.RebateTransactions;

import java.util.Arrays;

/**
 * This is a rebate transaction example class, can be used to modify data to be passed to Rebate Transaction API.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RebateTransactionExample {

    /**
     * Create an instance of RebateTransactionRequest for Account Identifier and set all required and (available) optional information of Account.
     * required:
     * - accountIdentifier
     * - memberIca
     * - merchantCategoryCode
     * - merchantId
     * - rebateAmount
     * - rebateReversalIndicator
     * - rebateSourceCode
     * - transactionDescription
     * - transactionSequenceNumber
     *
     * @return An instance of RebateTransactionRequest
     * @implNote The required field values used in this tutorial are dummy and demo purposed only, please change it with valid one before running this application.
     */
    public static RebateTransactionRequest getRebateTransactionRequestForAccountIdentifier() {
        RebateTransactionRequest rebateTransactionRequest = new RebateTransactionRequest();
        return rebateTransactionRequest.memberIca("47441")
                .accountIdentifier("65203356")
                .merchantCategoryCode("6555")
                .merchantId("6555")
                .rebateAmount("50")
                .rebateReversalIndicator("N")
                .rebateSourceCode("ext1")
                .transactionAmount("100")
                .transactionDate("2019-08-01")
                .transactionDescription("Rebate")
                .transactionSequenceNumber("11123");
    }

    /**
     * Create an instance of RebateTransactionRequest for DPAN and set all required and (available) optional information of Account.
     * required:
     * - devicePrimaryAccountNumber
     * - memberIca
     * - merchantCategoryCode
     * - merchantId
     * - rebateAmount
     * - rebateReversalIndicator
     * - rebateSourceCode
     * - transactionDescription
     * - transactionSequenceNumber
     *
     * @return An instance of RebateTransactionRequest
     * @implNote The required field values used in this tutorial are dummy and demo purposed only, please change it with valid one before running this application.
     */
    public static RebateTransactionRequest getRebateTransactionRequestForDPAN() {
        RebateTransactionRequest rebateTransactionRequest = new RebateTransactionRequest();
        return rebateTransactionRequest.memberIca("47441")
                .devicePrimaryAccountNumber("5100120000000004")
                .merchantCategoryCode("6555")
                .merchantId("6555")
                .rebateAmount("50")
                .rebateReversalIndicator("N")
                .rebateSourceCode("ext1")
                .transactionAmount("100")
                .transactionDate("2019-08-01")
                .transactionDescription("Rebate")
                .transactionSequenceNumber("11123");
    }

    /**
     * Create an instance of RebateTransactionRequest for PAN and set all required and (available) optional information of Account.
     * required:
     * - primaryAccountNumber
     * - memberIca
     * - merchantCategoryCode
     * - merchantId
     * - rebateAmount
     * - rebateReversalIndicator
     * - rebateSourceCode
     * - transactionDescription
     * - transactionSequenceNumber
     *
     * @return An instance of RebateTransactionRequest
     * @implNote The required field values used in this tutorial are dummy and demo purposed only, please change it with valid one before running this application.
     */
    public static RebateTransactionRequest getRebateTransactionRequestForPAN() {
        RebateTransactionRequest rebateTransactionRequest = new RebateTransactionRequest();
        return rebateTransactionRequest.memberIca("47441")
                .primaryAccountNumber("5555555555555555555")
                .merchantCategoryCode("6555")
                .merchantId("6555")
                .rebateAmount("50")
                .rebateReversalIndicator("N")
                .rebateSourceCode("ext1")
                .transactionAmount("100")
                .transactionDate("2019-08-01")
                .transactionDescription("Rebate")
                .transactionSequenceNumber("11123");
    }

    /**
     * Create an instance of RebateTransactions. Pass list of RebateTransactionRequest object
     *
     * @return An instance of RebateTransactions
     */
    public static RebateTransactions getRebateTransactionRequestList(RebateTransactionRequest... rebateTransactionRequests) {
        RebateTransactions rebateTransactionList = new RebateTransactions();
        return rebateTransactionList.rebateTransactions(Arrays.asList(rebateTransactionRequests));
    }
}
