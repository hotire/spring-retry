package com.github.hotire.spring.retry;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class RetryTemplateServiceTest {

    @Test
    void retry() {
        // given
        final String message = "";
        final MessageClient messageClient = mock(MessageClient.class);

        // when
        when(messageClient.send(message)).thenThrow(IllegalArgumentException.class);
        assertThrows(IllegalArgumentException.class, () -> new RetryTemplateService(messageClient).retry(message));

        // then
        verify(messageClient, times(3)).send(message);
    }

    @Test
    void recover() {
        // given
        final String message = "";
        final MessageClient messageClient = mock(MessageClient.class);

        // when
        when(messageClient.send(message)).thenThrow(IllegalArgumentException.class);
        final String result = new RetryTemplateService(messageClient).recover(message);

        // then
        verify(messageClient, times(3)).send(message);
        assertThat(result).isEqualTo("recover");
    }
}