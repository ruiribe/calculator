package com.challenge.calculator.server;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import com.challenge.calculator.enums.OperationsEnum;
import com.challenge.calculator.model.OperationModel;

public class Server {
	private static final Logger LOG = LoggerFactory.getLogger(Server.class);

	@RabbitListener(queues = "calculator.rpc.requests")
	public BigDecimal sum(OperationModel model) {
        MDC.put("mdcData",String.format("[requestId:%s] ", model.getUuid()));
		BigDecimal result = null;
		LOG.info(" [x] Received request for ");
		OperationsEnum op = model.getOperation();
		result = op.calculate(model.getA(), model.getB());
		LOG.info(" [.] Returned " + result);
		return result;
	}

}
