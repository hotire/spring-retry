package com.github.hotire.spring.retry;

import lombok.RequiredArgsConstructor;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class RetryService {

    private final MessageClient messageClient;

    @Retryable(
            value = IllegalArgumentException.class,
            maxAttempts = 3,
            backoff = @Backoff(delay = 3000)
    )
    public String send(String message) {
        return messageClient.send(message);
    }
}
