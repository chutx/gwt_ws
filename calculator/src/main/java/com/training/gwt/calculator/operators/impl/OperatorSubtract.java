package com.training.gwt.calculator.operators.impl;

import com.training.gwt.calculator.constants.CalculatorConstants;
import com.training.gwt.calculator.controller.CalculatorData;
import com.training.gwt.calculator.operators.BinaryOperator;

public class OperatorSubtract extends BinaryOperator {

	public OperatorSubtract() {
		super(CalculatorConstants.SUBSTRACT);
	}

	@Override
	public void operate(CalculatorData data) {
		data.setDisplay(String.valueOf(data.getBuffer() - Double.parseDouble(data.getDisplay())));
		data.setInitDisplay(true);		
	}

}
