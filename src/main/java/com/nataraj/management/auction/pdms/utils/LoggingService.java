package com.nataraj.management.auction.pdms.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LoggingService {
    private static final String LOGGER_NAME = "com.nataraj.management.als";
    private final Logger logger;

    public LoggingService(){
        this.logger = LoggerFactory.getLogger(LOGGER_NAME);
    }

    public void info(String message){
        logger.info(message);
    }

    public void debug(String message){
        logger.debug(message);
    }
}
