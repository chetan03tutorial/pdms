package com.nataraj.management.auction.pdms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import({ConfigSelector.class})
public class PdmsApplication {
	public static void main(String args[]) {
		SpringApplication app = new SpringApplication(PdmsApplication.class);
		ConfigurableApplicationContext rootContext = app.run(args);
	}
}
