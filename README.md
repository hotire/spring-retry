# Spring Retry 

![repeat](doc/repeat.png)

[Spring Retry](https://github.com/spring-projects/spring-retry)는 메서드 실행에 대한 실패, 

즉 예외에 대해서 재실행하는 기능을 graceful 하게 지원한다. 

네트워크와 같은 일시적인 장애 상황에 사용하면 유용하다. :)

## Annotation

AOP 기반 Retry / Recover를 제공한다.

- @EnableRetry를 붙여 자동설정한다. 

### Retry

```java
@Retryable(
            value = IllegalArgumentException.class,
            maxAttempts = 3,
            backoff = @Backoff(delay = 3000)
)
```

@Retryable 어노테이션을 통해 retry를 한다. 

- value : 재시도할 Exception을 정의한다. 

- maxAttempts : 재시도 횟수 지정

- backoff : 딜레이 지정


### Recover

## ETC

### Contribute

https://github.com/spring-projects/spring-retry/pull/255



