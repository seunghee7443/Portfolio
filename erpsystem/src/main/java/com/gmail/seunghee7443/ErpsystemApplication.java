package com.gmail.seunghee7443;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ErpsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErpsystemApplication.class, args);
	}

}
