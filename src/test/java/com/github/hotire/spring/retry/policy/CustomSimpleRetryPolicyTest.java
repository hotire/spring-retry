package com.github.hotire.spring.retry.policy;

import org.junit.jupiter.api.Test;
import org.springframework.retry.policy.SimpleRetryPolicy;

class CustomSimpleRetryPolicyTest {

    @Test
    void setRetryPolicy() {
        // given
        final CustomSimpleRetryPolicy policy = new CustomSimpleRetryPolicy();
        final SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();

        // when
        policy.setRetryPolicy(retryPolicy);

        // no assert
    }
}