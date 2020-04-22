# RebateTransactionRequestList

## Properties

| Name | Type | Max Length | Description | Notes |
| :--- | :--- | :--------- | :---------- | :---- |
| **rebateTransactionRequestList** | [**List&lt;RebateTransactionRequest&gt;**](RebateTransactionRequest.md) | | | [optional] |

## Sample JSON

```json
{
  "rebateTransactionRequestList": [
    {
      "accountIdentifier": "65203356",
      "devicePrimaryAccountNumber": "5100120000000004",
      "memberIca": "47441",
      "merchantCategoryCode": "6555",
      "merchantId": "6555",
      "rebateAmount": "50",
      "rebateReversalIndicator": "N",
      "rebateSourceCode": "ext1",
      "transactionAmount": "100",
      "transactionDate": "2019-08-01",
      "transactionDescription": "Rebate",
      "transactionSequenceNumber": "11123"
    }
  ]
}
```
