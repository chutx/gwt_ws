package com.training.gwt.calculator.operators.impl;

import com.training.gwt.calculator.constants.CalculatorConstants;
import com.training.gwt.calculator.controller.CalculatorData;
import com.training.gwt.calculator.operators.BinaryOperator;

public class OperatorMultiply extends BinaryOperator {

	public OperatorMultiply() {
		super(CalculatorConstants.MULTIPLY);
	}

	@Override
	public void operate(CalculatorData data) {
		data.setDisplay(String.valueOf(data.getBuffer() * Double.parseDouble(data.getDisplay())));
		data.setInitDisplay(true);
	}

}
