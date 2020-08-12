package com.heronimus.apm.cloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class CloudGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudGatewayApplication.class, args);
    }

    @RestController
    @RequestMapping
    class ServerRestEndpoint {

        @GetMapping(value = "/", produces = "application/json")
        public String index() throws InterruptedException {
            return "{\"service_name\": \"api-gateway\", \"description\": \"Backend API Server using Spring Cloud Gateway\"}";
        }

    }

}
