# Errors

## Properties <a name="properties"></a>

| Name | Type | Max Length | Description | Notes |
| :--- | :--- | :--------- | :---------- | :---- |
| **errors** | [**ErrorList**](ErrorList.md) | | Contains an object of error list | |

## Sample JSON

```json
{
  "Errors": {
    "Error": [
      {
        "Source": "MRS",
        "ReasonCode": "INVALID_FORMAT",
        "Description": "Member ICA should be numeric and less than or equal to 11 digit.",
        "Recoverable": false,
        "Details": null
      }
    ]
  }
}
```
