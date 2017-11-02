package com.challenge.calculator.controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.calculator.enums.OperationsEnum;
import com.challenge.calculator.model.OperationModel;

@RestController
public class CalculatorController {

	private static final Logger LOG = LoggerFactory.getLogger(CalculatorController.class);

	@Autowired
	private RabbitTemplate template;

	@Autowired
	private DirectExchange exchange;

	@Bean
	private MessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	@RequestMapping("/sum")
	public ResponseEntity<String> sum(@RequestParam(value = "a") BigDecimal a,
			@RequestParam(value = "b") BigDecimal b) {
		LOG.info(" [x] Requesting sum(" + a + ", " + b + ")");
		OperationModel model = new OperationModel(a, b, OperationsEnum.SUM, MDC.get("correlationId"));
		template.setMessageConverter(jsonMessageConverter());
		BigDecimal response = (BigDecimal) template.convertSendAndReceive(exchange.getName(), "rpc", model);
		LOG.info(" [.] Got '" + response + "'");
		return setResponseHeader(response);
	}

	@RequestMapping("/subtract")
	public ResponseEntity<String> subtract(@RequestParam(value = "a") BigDecimal a,
			@RequestParam(value = "b") BigDecimal b) {
		LOG.info(" [x] Requesting subtract(" + a + ", " + b + ")");
		OperationModel model = new OperationModel(a, b, OperationsEnum.SUBTRACT, MDC.get("correlationId"));
		template.setMessageConverter(jsonMessageConverter());
		BigDecimal response = (BigDecimal) template.convertSendAndReceive(exchange.getName(), "rpc", model);
		LOG.info(" [.] Got '" + response + "'");
		return setResponseHeader(response);
	}

	@RequestMapping("/multiply")
	public ResponseEntity<String> multiply(@RequestParam(value = "a") BigDecimal a,
			@RequestParam(value = "b") BigDecimal b) {
		LOG.info(" [x] Requesting multiply(" + a + ", " + b + ")");
		OperationModel model = new OperationModel(a, b, OperationsEnum.MULTIPLY,MDC.get("correlationId"));
		template.setMessageConverter(jsonMessageConverter());
		BigDecimal response = (BigDecimal) template.convertSendAndReceive(exchange.getName(), "rpc", model);
		LOG.info(" [.] Got '" + response + "'");
		return setResponseHeader(response);
	}

	@RequestMapping("/divide")
	public ResponseEntity<String> divide(@RequestParam(value = "a") BigDecimal a,
			@RequestParam(value = "b") BigDecimal b) {
		LOG.info(" [x] Requesting divide(" + a + ", " + b + ")");
		OperationModel model = new OperationModel(a, b, OperationsEnum.DIVIDE, MDC.get("correlationId"));
		template.setMessageConverter(jsonMessageConverter());
		BigDecimal response = (BigDecimal) template.convertSendAndReceive(exchange.getName(), "rpc", model);
		LOG.info(" [.] Got '" + response + "'");
		return setResponseHeader(response);
	}

	private ResponseEntity<String> setResponseHeader(BigDecimal response) {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("UUID", MDC.get("correlationId"));
		return new ResponseEntity<String>(response + "", responseHeaders, HttpStatus.CREATED);
	}
}