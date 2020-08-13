package com.nataraj.management.auction.pdms.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(
    basePackages = {"com.nataraj.management.auction.pdms"}
)
@Import(com.nataraj.management.auction.pdms.ConfigSelector.class)
public class RootConfig {

    public RootConfig() {
        System.out.println("Initializing the ROOT CONFIG constructor");
    }

}
