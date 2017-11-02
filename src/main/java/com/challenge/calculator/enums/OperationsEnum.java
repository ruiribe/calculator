package com.challenge.calculator.enums;

public enum OperationsEnum {

		SUM,
	    SUBTRACT,
	    MULTIPLY,
	    DIVIDE;
	
	public double calculate(double x, double y) {
	        switch (this) {
	            case SUM:
	                return x + y;
	            case SUBTRACT:
	                return x - y;
	            case MULTIPLY:
	                return x * y;
	            case DIVIDE:
	                return x / y;
	            default:
	                throw new AssertionError("Unknown operations " + this);
	        }
	    }
}
