package com.bips;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroservicedemoApplication {

    private static Logger LOGGER = LoggerFactory.getLogger(MicroservicedemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MicroservicedemoApplication.class, args);
        LOGGER.info("Application started ...");
    }
}
