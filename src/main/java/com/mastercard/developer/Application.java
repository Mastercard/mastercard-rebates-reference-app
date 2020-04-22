package com.mastercard.developer;

import com.mastercard.developer.executor.RebateTransactionExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@SpringBootApplication
public class Application implements CommandLineRunner {

    private RebateTransactionExecutor rebateTransactionExecutor;

    @Autowired
    public Application(RebateTransactionExecutor rebateTransactionExecutor) {
        this.rebateTransactionExecutor = rebateTransactionExecutor;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext appContext = SpringApplication.run(Application.class, args);
        appContext.close();
    }

    @Override
    public void run(String... args) {
        try {
            rebateTransactionExecutor.execute();
        } catch (Exception ex) {
            log.error("<-- APPLICATION ENDED WITH SOME ERROR --> {}", ex.getMessage());
        }
    }
}
