package com.github.hotire.spring.retry;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;

@SpringBootTest
class RecoverServiceTest {

    @MockBean
    private MessageClient messageClient;

    @Autowired
    private RecoverService recoverService;

    @Test
    void recover() {
        // given
        final String message = "";

        // when
        when(messageClient.send(message)).thenThrow(IllegalArgumentException.class);
        final String result = recoverService.send(message);


        // then
        verify(messageClient, times(3)).send(message);
        Assertions.assertThat(result).isEqualTo("hello");
    }
}