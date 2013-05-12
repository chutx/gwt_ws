package com.training.gwt.calculator.controller;

import com.training.gwt.calculator.constants.CalculatorConstants;
import com.training.gwt.calculator.operators.AbstractOperator;
import com.training.gwt.calculator.operators.BinaryOperator;
import com.training.gwt.calculator.operators.UnaryOperator;

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
				prevBuffer = parseDoubleFromDisplay();
			}
			lastOperator.operate(data);
			setDataBuffer(prevBuffer);
			data.setLastOpEquals(true);
		}
	}
	
	public void processOperator(final AbstractOperator op){
		if(op instanceof BinaryOperator){
			processBinaryOperator();
			lastOperator = op;
		}else if(op instanceof UnaryOperator){
			lastOperator.operate(data);
		}
		
		data.setLastOpEquals(false);
	}
	
	public void processDigit(String d){
		if(data.isLastOpEquals()){
			lastOperator = null;
		}
		
		if(data.isInitDisplay()){
			double buffer = data.isLastOpEquals() ? 0 :parseDoubleFromDisplay();
			setDataBuffer(buffer);
			data.setDisplay(d);
			data.setInitDisplay(false);
		}else{
			if(data.getDisplay().indexOf(CalculatorConstants.POINT) == -1 ){
				data.setDisplay(data.getDisplay() + d);
			}else if(!d.equals(CalculatorConstants.POINT)){
				data.setDisplay(data.getDisplay() + d);
			}
		}
		
		data.setLastOpEquals(false);
	}
	
	private void processBinaryOperator(){
		if(lastOperator == null || data.isLastOpEquals()){
			data.setBuffer(parseDoubleFromDisplay());
			data.setInitDisplay(true);
		}else{
			lastOperator.operate(data);
		}
	}
	
	private void setDataBuffer(double buffer){
		data.setBuffer(buffer);
	}
	
	private Double parseDoubleFromDisplay(){
		return Double.parseDouble(data.getDisplay());
	}
}
