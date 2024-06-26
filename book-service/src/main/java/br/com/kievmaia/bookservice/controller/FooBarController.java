package br.com.kievmaia.bookservice.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Foo bar")
@RestController
@RequestMapping("book-service")
public class FooBarController {
    private Logger logger = LoggerFactory.getLogger(FooBarController.class);

    @Operation(summary = "Foo bar")
    @GetMapping("/foo-bar")
//    @Retry(name = "foo-bar", fallbackMethod = "fallbackMethod")
//    @CircuitBreaker(name = "default", fallbackMethod = "fallbackMethod")
//    @RateLimiter(name = "default")
    @Bulkhead(name = "default")
    public String fooBarr() {
        logger.info("request foo-bar is received");
//        final var response =
//                new RestTemplate().getForEntity("http://localhost:8080/foo-bar", String.class);
        return "Foo-Bar";
//        return response.getBody();
    }

    public String fallbackMethod(Exception ex) {
        return ex.getMessage();
    }
}
