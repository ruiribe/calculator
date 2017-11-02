package com.challenge.calculator.controller;

import java.math.BigDecimal;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.calculator.enums.OperationsEnum;
import com.challenge.calculator.model.OperationModel;

@RestController
public class CalculatorController {

	@Autowired
	private RabbitTemplate template;

	@Autowired
	private DirectExchange exchange;

	@Bean
	private MessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	@RequestMapping("/sum")
	public String sum(@RequestParam(value = "a") BigDecimal a, @RequestParam(value = "b") BigDecimal b) {
		System.out.println(" [x] Requesting sum(" + a + ", " + b + ")");
		OperationModel model = new OperationModel();
		model.setA(a);
		model.setB(b);
		model.setOperation(OperationsEnum.SUM);
		template.setMessageConverter(jsonMessageConverter());
		BigDecimal response = (BigDecimal) template.convertSendAndReceive(exchange.getName(), "rpc", model);
		System.out.println(" [.] Got '" + response + "'");
		return response + "";
	}

	@RequestMapping("/subtract")
	public String subtract(@RequestParam(value = "a") BigDecimal a, @RequestParam(value = "b") BigDecimal b) {
		System.out.println(" [x] Requesting sum(" + a + ", " + b + ")");
		OperationModel model = new OperationModel();
		model.setA(a);
		model.setB(b);
		model.setOperation(OperationsEnum.SUBTRACT);
		template.setMessageConverter(jsonMessageConverter());
		Double response = (Double) template.convertSendAndReceive(exchange.getName(), "rpc", model);
		System.out.println(" [.] Got '" + response + "'");
		return response + "";
	}

	@RequestMapping("/multiply")
	public String multiply(@RequestParam(value = "a") BigDecimal a, @RequestParam(value = "b") BigDecimal b) {
		System.out.println(" [x] Requesting sum(" + a + ", " + b + ")");
		OperationModel model = new OperationModel();
		model.setA(a);
		model.setB(b);
		model.setOperation(OperationsEnum.MULTIPLY);
		template.setMessageConverter(jsonMessageConverter());
		Double response = (Double) template.convertSendAndReceive(exchange.getName(), "rpc", model);
		System.out.println(" [.] Got '" + response + "'");
		return response + "";
	}

	@RequestMapping("/divide")
	public String divide(@RequestParam(value = "a") BigDecimal a, @RequestParam(value = "b") BigDecimal b) {
		System.out.println(" [x] Requesting sum(" + a + ", " + b + ")");
		OperationModel model = new OperationModel();
		model.setA(a);
		model.setB(b);
		model.setOperation(OperationsEnum.DIVIDE);
		template.setMessageConverter(jsonMessageConverter());
		Double response = (Double) template.convertSendAndReceive(exchange.getName(), "rpc", model);
		System.out.println(" [.] Got '" + response + "'");
		return response + "";
	}

}