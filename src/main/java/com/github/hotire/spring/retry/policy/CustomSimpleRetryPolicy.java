package com.github.hotire.spring.retry.policy;

import org.springframework.retry.RetryPolicy;
import org.springframework.retry.support.RetryTemplate;

public class CustomSimpleRetryPolicy {
    private final RetryTemplate retryTemplate = new RetryTemplate();

    public void setRetryPolicy(final RetryPolicy retryPolicy) {
        retryTemplate.setRetryPolicy(retryPolicy);
    }
}
