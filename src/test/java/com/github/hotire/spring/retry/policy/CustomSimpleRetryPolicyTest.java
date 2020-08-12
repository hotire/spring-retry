package com.github.hotire.spring.retry.policy;

import com.github.hotire.spring.retry.ServerException;
import org.junit.jupiter.api.Test;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class CustomSimpleRetryPolicyTest {

    @Test
    void setRetryPolicy() {
        // given
        final String expected = "recover";
        final RetryTemplate retryTemplate = new RetryTemplate();
        final int maxAttempts = 3;
        final Map<Class<? extends Throwable>, Boolean> retryableExceptions = Map.of(ServerException.class, true);
        final SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy(maxAttempts, retryableExceptions, true);

        // when
        retryTemplate.setRetryPolicy(retryPolicy);
        final String result = retryTemplate.execute(context -> {
            throw new RuntimeException(new ServerException());
        }, context -> expected);

        // then
        assertThat(result).isEqualTo(expected);
    }
}