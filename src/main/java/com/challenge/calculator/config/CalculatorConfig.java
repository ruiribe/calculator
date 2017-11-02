package com.challenge.calculator.config;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("client")
@Configuration
public class CalculatorConfig {

	@Bean
	public DirectExchange exchange() {
		return new DirectExchange("calculator.rpc");
	}

}
