package com.training.gwt.calculator.controller;

import com.training.gwt.calculator.operators.AbstractOperator;

public class CalculatorController {

	private CalculatorData data;
	private AbstractOperator lastOperator;
	private double prevBuffer;
	
	public CalculatorController(CalculatorData data){
		this.data = data;
	}
	
	public void processClear(){
		data.clear();
		lastOperator = null;
	}
	
	public void processEqual(){
		if(lastOperator != null){
			if(!data.isLastOpEquals()){
				prevBuffer = Double.parseDouble(data.getDisplay());
			}
			lastOperator.operate(data);
			data.setBuffer(prevBuffer);
			data.setLastOpEquals(true);
		}
	}
	
	public void processOperator(final AbstractOperator op){
		//TODO
	}
	
	public void processDigit(String d){
		//TODO
	}
}
