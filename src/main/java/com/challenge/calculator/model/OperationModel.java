package com.challenge.calculator.model;

import java.io.Serializable;
import java.math.BigDecimal;

import com.challenge.calculator.enums.OperationsEnum;

public class OperationModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2602905618792948838L;
	private BigDecimal a;
	private BigDecimal b;
	private OperationsEnum operation;

	public OperationModel() {
	}

	public BigDecimal getA() {
		return a;
	}

	public void setA(BigDecimal a) {
		this.a = a;
	}

	public BigDecimal getB() {
		return b;
	}

	public void setB(BigDecimal b) {
		this.b = b;
	}

	public OperationsEnum getOperation() {
		return operation;
	}

	public void setOperation(OperationsEnum operation) {
		this.operation = operation;
	}

	@Override
	public String toString() {
		return "OperationModel [a=" + a + ", b=" + b + ", operation=" + operation + "]";
	}

}
