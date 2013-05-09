package com.training.gwt.calculator.operators;

import com.training.gwt.calculator.controller.CalculatorData;

public abstract class AbstractOperator {

	private String label;
	
	public AbstractOperator(String label) {
		this.label = label;
	}
	
	/**
	 * Responsible to execute the operation
	 */
	public abstract void operate(CalculatorData data);

	public String getLabel() {
		return label;
	}
}
