package com.mastercard.developer.response;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openapitools.client.model.RebateTransactionResponse;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MockRebateTransactionResponses {

    public static final String SOURCE = "MRS";
    public static final String INV_ACC_REASON_CODE = "INVALID_ACCOUNT";
    public static final String INV_ACC_DESCRIPTION = "Either no BAN Found or more than one BAN found for account Identifier";
    private static final String SEPARATOR = "\",\n";

    public static RebateTransactionResponse getRebateTransactionResponse() {
        RebateTransactionResponse rebateTransactionResponse = new RebateTransactionResponse();
        return rebateTransactionResponse.status("OK");
    }

    public static String getErrorResponseBody(String reasonCode, String description, boolean recoverable) {
        return "{\n" +
                "  \"Errors\": {\n" +
                "    \"Error\": [\n" +
                "      {\n" +
                "        \"Source\": \"" + SOURCE + SEPARATOR +
                "        \"ReasonCode\": \"" + reasonCode + SEPARATOR +
                "        \"Description\": \"" + description + SEPARATOR +
                "        \"Recoverable\": " + recoverable + ",\n" +
                "        \"Details\": null\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}";
    }
}
