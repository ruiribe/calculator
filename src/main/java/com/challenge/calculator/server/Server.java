package com.challenge.calculator.server;

import java.math.BigDecimal;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

import com.challenge.calculator.enums.OperationsEnum;
import com.challenge.calculator.model.OperationModel;

public class Server {

	@RabbitListener(queues = "calculator.rpc.requests")
	public BigDecimal sum(OperationModel model) {
		BigDecimal result = null;
		System.out.println(" [x] Received request for ");
		OperationsEnum op = model.getOperation();
		result = op.calculate(model.getA(), model.getB());
		System.out.println(" [.] Returned " + result);
		return result;
	}

}
