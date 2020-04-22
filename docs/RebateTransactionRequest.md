# RebateTransactionRequest

## Properties

| Name | Type | Max Length | Description | Notes |
| :--- | :--- | :--------- | :---------- | :---- |
| **accountIdentifier** | **String** | 30 | An identifier that uniquely identifies the account enrolled into mastercard rewards. One of the supported account identifiers may be used. While using account identifier for processing, devicePrimaryAccountNumber is not required. | [optional] |
| **devicePrimaryAccountNumber** | **String** | 30 | An unique identifier assigned to an account number used for rebate processing. The account number assigned to this identifier may or may not enrolled into mastecard rewards. While using devicePrimaryAccountNumber for processing, account identifier is not required. | [optional] |
| **memberIca** | **String** | 11 | Mastercard assigned unique identifier for a client. | |
| **merchantCategoryCode** | **String** | | Mastercard merchant category code required for the processing of rebates. Usually 6555, Mastercard Rewards is used. | |
| **merchantId** | **String** | 15 | Merchant ID required for the rebate settlement process. | |
| **rebateAmount** | **String** | | The value of the rebate requested to be processed for the specified account. | |
| **rebateReversalIndicator** | **String** | |Indicates whether the transaction is credit or reversal of credit transaction. - Y means reversal and N means credit. | |
| **rebateSourceCode** | **String** | 20 | Unique identifier assigned to capture processing information required for rebate settlement by clearing house. | |
| **transactionAmount** | **String** | 14 | The payment transaction amount of the purchase. | [optional] |
| **transactionDate** | **String** | 10 | The purchase transaction date in the format YYYY-MM-DD | [optional] |
| **transactionDescription** | **String** | 22 | This is the transaction description that will appear on a cardholder’s account statement. | |
| **transactionSequenceNumber** | **String** | 13 | Unique identifier assigned to each cardholder transaction by the Merchant. | |
