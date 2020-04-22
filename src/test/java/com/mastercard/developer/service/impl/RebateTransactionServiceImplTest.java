package com.mastercard.developer.service.impl;

import com.mastercard.developer.example.RebateTransactionExample;
import com.mastercard.developer.exception.ServiceException;
import okhttp3.Call;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.ApiResponse;
import org.openapitools.client.model.Error;
import org.openapitools.client.model.RebateTransactionResponse;
import org.springframework.http.HttpStatus;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

import static com.mastercard.developer.response.MockRebateTransactionResponses.INV_ACC_DESCRIPTION;
import static com.mastercard.developer.response.MockRebateTransactionResponses.INV_ACC_REASON_CODE;
import static com.mastercard.developer.response.MockRebateTransactionResponses.SOURCE;
import static com.mastercard.developer.response.MockRebateTransactionResponses.getErrorResponseBody;
import static com.mastercard.developer.response.MockRebateTransactionResponses.getRebateTransactionResponse;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RebateTransactionServiceImplTest {

    @InjectMocks
    private RebateTransactionServiceImpl rebateTransactionService;

    @Mock
    private ApiClient apiClient;

    @BeforeEach
    void setUp() throws Exception {
        when(apiClient.buildCall(anyString(), anyString(), anyList(), anyList(), any(), anyMap(), anyMap(), anyMap(), any(), any())).thenReturn(mock(Call.class));
    }

    @Test
    void testCreate() throws Exception {
        when(apiClient.execute(any(Call.class), any(Type.class))).thenReturn(new ApiResponse<>(HttpStatus.CREATED.value(), new HashMap<>(), getRebateTransactionResponse()));

        RebateTransactionResponse rebateTransactionResponse = rebateTransactionService.create(RebateTransactionExample.getRebateTransactionRequestList());

        verify(apiClient, atMostOnce()).buildCall(anyString(), anyString(), anyList(), anyList(), any(), anyMap(), anyMap(), anyMap(), any(), any());
        verify(apiClient, atMostOnce()).execute(any(Call.class), any(Type.class));

        assertAll(
                () -> assertNotNull(rebateTransactionResponse),
                () -> assertEquals("OK", rebateTransactionResponse.getStatus())
        );
    }

    @Test
    void testErrorResponse() throws Exception {
        when(apiClient.execute(any(Call.class), any(Type.class))).thenThrow(new ApiException(400, new HashMap<>(), getErrorResponseBody(INV_ACC_REASON_CODE, INV_ACC_DESCRIPTION, false)));

        ServiceException serviceException = Assertions.assertThrows(ServiceException.class, () -> rebateTransactionService.create(RebateTransactionExample.getRebateTransactionRequestList()));

        verify(apiClient, atMostOnce()).buildCall(anyString(), anyString(), anyList(), anyList(), any(), anyMap(), anyMap(), anyMap(), any(), any());
        verify(apiClient, atMostOnce()).execute(any(Call.class), any(Type.class));

        Assertions.assertNotNull(serviceException.getServiceErrors());
        List<Error> errors = serviceException.getServiceErrors().getErrors().getError();
        Assertions.assertFalse(errors.isEmpty());
        errors.forEach(error -> {
            Assertions.assertEquals(SOURCE, error.getSource());
            Assertions.assertEquals(INV_ACC_REASON_CODE, error.getReasonCode());
            Assertions.assertEquals(INV_ACC_DESCRIPTION, error.getDescription());
            Assertions.assertFalse(error.getRecoverable());
        });
    }
}
