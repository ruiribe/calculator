package com.challenge.calculator.enums;

import java.math.BigDecimal;

public enum OperationsEnum {

		SUM,
	    SUBTRACT,
	    MULTIPLY,
	    DIVIDE;
	
	public BigDecimal calculate(BigDecimal a, BigDecimal b) {
	        switch (this) {
	            case SUM:
	                return a.add(b);
	            case SUBTRACT:
	                return a.subtract(b);
	            case MULTIPLY:
	                return a.multiply(b);
	            case DIVIDE:
	                return a.divide(b);
	            default:
	                throw new AssertionError("Unknown operations " + this);
	        }
	    }
}
