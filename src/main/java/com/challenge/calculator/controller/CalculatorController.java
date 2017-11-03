package com.challenge.calculator.controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@Autowired
	private MessageConverter messageConverter;

	@RequestMapping(value = "/sum", method = RequestMethod.GET)
	public ResponseEntity<String> sum(@RequestParam(value = "a") BigDecimal a,
			@RequestParam(value = "b") BigDecimal b) {
		LOG.info(" [x] Requesting sum(" + a + ", " + b + ")");
		OperationModel model = new OperationModel(a, b, OperationsEnum.SUM, MDC.get("correlationId"));
		template.setMessageConverter(messageConverter);
		BigDecimal response = (BigDecimal) template.convertSendAndReceive(exchange.getName(), "rpc", model);
		LOG.info(" [.] Got '" + response + "'");
		return new ResponseEntity<String>(response + "", HttpStatus.OK);
	}

	@RequestMapping(value = "/subtract", method = RequestMethod.GET)
	public ResponseEntity<String> subtract(@RequestParam(value = "a") BigDecimal a,
			@RequestParam(value = "b") BigDecimal b) {
		LOG.info(" [x] Requesting subtract(" + a + ", " + b + ")");
		OperationModel model = new OperationModel(a, b, OperationsEnum.SUBTRACT, MDC.get("correlationId"));
		template.setMessageConverter(messageConverter);
		BigDecimal response = (BigDecimal) template.convertSendAndReceive(exchange.getName(), "rpc", model);
		LOG.info(" [.] Got '" + response + "'");
		return new ResponseEntity<String>(response + "", HttpStatus.OK);
	}

	@RequestMapping(value = "/multiply", method = RequestMethod.GET)
	public ResponseEntity<String> multiply(@RequestParam(value = "a") BigDecimal a,
			@RequestParam(value = "b") BigDecimal b) {
		LOG.info(" [x] Requesting multiply(" + a + ", " + b + ")");
		OperationModel model = new OperationModel(a, b, OperationsEnum.MULTIPLY, MDC.get("correlationId"));
		template.setMessageConverter(messageConverter);
		BigDecimal response = (BigDecimal) template.convertSendAndReceive(exchange.getName(), "rpc", model);
		LOG.info(" [.] Got '" + response + "'");
		return new ResponseEntity<String>(response + "", HttpStatus.OK);
	}

	@RequestMapping(value = "/divide", method = RequestMethod.GET)
	public ResponseEntity<String> divide(@RequestParam(value = "a") BigDecimal a,
			@RequestParam(value = "b") BigDecimal b) {
		LOG.info(" [x] Requesting divide(" + a + ", " + b + ")");
		OperationModel model = new OperationModel(a, b, OperationsEnum.DIVIDE, MDC.get("correlationId"));
		template.setMessageConverter(messageConverter);
		BigDecimal response = (BigDecimal) template.convertSendAndReceive(exchange.getName(), "rpc", model);
		LOG.info(" [.] Got '" + response + "'");
		return new ResponseEntity<String>(response + "", HttpStatus.OK);
	}
}