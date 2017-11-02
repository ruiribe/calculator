package com.challenge.calculator.server;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

import com.challenge.calculator.enums.OperationsEnum;
import com.challenge.calculator.model.OperationModel;

public class Server {

	@RabbitListener(queues = "calculator.rpc.requests")
	public Double sum(OperationModel model) {
		Double result = null;
		System.out.println(" [x] Received request for ");
		OperationsEnum op = model.getOperation();
		result = op.calculate(model.getA(), model.getB());
		System.out.println(" [.] Returned " + result);
		return result;
	}

}
