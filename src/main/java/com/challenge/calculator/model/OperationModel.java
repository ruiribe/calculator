package com.challenge.calculator.model;

import java.io.Serializable;

import com.challenge.calculator.enums.OperationsEnum;

public class OperationModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2602905618792948838L;
	private int a;
	private int b;
	private OperationsEnum operation;

	public OperationModel() {
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public OperationsEnum getOperation() {
		return operation;
	}

	public void setOperation(OperationsEnum operation) {
		this.operation = operation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + a;
		result = prime * result + b;
		result = prime * result + ((operation == null) ? 0 : operation.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OperationModel other = (OperationModel) obj;
		if (a != other.a)
			return false;
		if (b != other.b)
			return false;
		if (operation != other.operation)
			return false;
		return true;
	}

}
