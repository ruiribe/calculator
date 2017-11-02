package com.challenge.calculator.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"calculator"})
@Configuration
public class CalculatorConfig {
	
	@Profile("client")
	private static class ClientConfig {

		@Bean
		public DirectExchange exchange() {
			return new DirectExchange("calculator.rpc");
		}

	}

	@Profile("server")
	private static class ServerConfig {

		@Bean
		public Queue queue() {
			return new Queue("calculator.rpc.requests");
		}

		@Bean
		public DirectExchange exchange() {
			return new DirectExchange("calculator.rpc");
		}

		@Bean
		public Binding binding(DirectExchange exchange, Queue queue) {
			return BindingBuilder.bind(queue).to(exchange).with("rpc");
		}

	}

}
