package com.github.hotire.spring.retry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RetryTemplateService {
    private final MessageClient messageClient;
    private final RetryTemplate retryTemplate = new RetryTemplate();

    public RetryTemplateService(MessageClient messageClient) {
        this.messageClient = messageClient;

        FixedBackOffPolicy fixedBackOffPolicy = new FixedBackOffPolicy();
        fixedBackOffPolicy.setBackOffPeriod(2000);
        retryTemplate.setBackOffPolicy(fixedBackOffPolicy);

        SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
        retryPolicy.setMaxAttempts(3);
        retryTemplate.setRetryPolicy(retryPolicy);
    }

    public String retry(String message) {
        return retryTemplate.execute(context -> messageClient.send(message));
    }

    public String recover(String message) {
        return retryTemplate.execute(context -> messageClient.send(message), retryContext -> {
            log.info("recover : {}", retryContext);
            return "recover";
        });
    }
}
