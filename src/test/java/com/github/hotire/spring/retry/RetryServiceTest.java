package com.github.hotire.spring.retry;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;

@SpringBootTest
class RetryServiceTest {

    @MockBean
    private MessageClient messageClient;

    @Autowired
    private RetryService retryService;

    @Test
    void retry() {
        // given
        final String message = "";

        // when
        when(messageClient.send(message)).thenThrow(IllegalArgumentException.class);
        Assertions.assertThrows(IllegalArgumentException.class, () -> retryService.send(message));


        // then
        verify(messageClient, times(3)).send(message);
    }

}