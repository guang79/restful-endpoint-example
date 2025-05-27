package com.axaxl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AXAXLApplication {

    private static final Logger logger = LoggerFactory.getLogger(AXAXLApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AXAXLApplication.class);
        logger.info("AXAXLApplication started");
    }

}