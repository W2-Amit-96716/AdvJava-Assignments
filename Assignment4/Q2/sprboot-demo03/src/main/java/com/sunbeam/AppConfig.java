package com.sunbeam;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
@ComponentScan("com.sunbeam")
@Configuration
public class AppConfig {
	@Bean
	Account acc() {
		Account a = new AccountImpl();
		a.setId(101);
		a.setType("Saving");
		a.setBalance(40000);
		return a;
	}
}
