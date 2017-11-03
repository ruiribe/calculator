package com.challenge.calculator.enums;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
	                return a.divide(b, 10, RoundingMode.HALF_UP); //to avoid  java.lang.ArithmeticException: Non-terminating decimal expansion; no exact representable decimal result.
	            default:
	                throw new IllegalArgumentException("Unknown operations " + this);
	        }
	    }
}
