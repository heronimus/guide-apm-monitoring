package com.heronimus.apm.cloudgateway;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.heronimus.apm.cloudgateway.CloudGatewayApplication;


@SpringBootTest(classes = CloudGatewayApplication.class)
public class SpringContextTest {

    @Test
    public void whenSpringContextIsBootstrapped_thenNoExceptions() {
    }
}
