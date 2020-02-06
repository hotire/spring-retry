package com.github.hotire.spring.retry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageClient {

    public String send(String message) {
        log.info("message : {}", message);
        return message;
    }
}
