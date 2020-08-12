package com.heronimus.apm.userservices;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.heronimus.apm.userservices.UserServicesApplication;


@SpringBootTest(classes = UserServicesApplication.class)
public class SpringContextTest {

    @Test
    public void whenSpringContextIsBootstrapped_thenNoExceptions() {
    }
}
