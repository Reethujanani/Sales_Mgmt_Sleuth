package com.example.SalesMgmt;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SalesMgmtApplication {
	private static final Logger LOGGER= (Logger) LoggerFactory.getLogger(SalesMgmtApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SalesMgmtApplication.class, args);
		LOGGER.info("Welcome to sales management");
	}

}
