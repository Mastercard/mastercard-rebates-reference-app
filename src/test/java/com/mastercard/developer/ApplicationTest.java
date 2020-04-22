package com.mastercard.developer;

import com.mastercard.developer.exception.ServiceException;
import com.mastercard.developer.executor.RebateTransactionExecutor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ApplicationTest {

    @InjectMocks
    private Application application;

    @Mock
    private RebateTransactionExecutor rebateTransactionExecutor;

    @Test
    void testRun() throws Exception {
        doNothing().when(rebateTransactionExecutor).execute();

        application.run();

        verify(rebateTransactionExecutor, atMostOnce()).execute();
    }

    @Test
    void testRunException() throws Exception {
        doThrow(new ServiceException("Some error occurred")).when(rebateTransactionExecutor ).execute();

        application.run();

        verify(rebateTransactionExecutor, atMostOnce()).execute();
    }
}
