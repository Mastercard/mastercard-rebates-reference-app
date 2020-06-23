# RebateTransactions

## Properties <a name="properties"></a>

| Name | Type | Max Length | Description | Notes |
| :--- | :--- | :--------- | :---------- | :---- |
| **rebateTransactions** | [**List&lt;RebateTransactionRequest&gt;**](RebateTransactionRequest.md) | | | [optional] |

## Sample JSON

### Rebate with Account Identifier <a name="account-identifier"></a>
```json
{
  "rebateTransactions": [
    {
      "accountIdentifier": "65203356",
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

### Rebate with DPAN <a name="dpan"></a>
```json
{
  "rebateTransactions": [
    {
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
