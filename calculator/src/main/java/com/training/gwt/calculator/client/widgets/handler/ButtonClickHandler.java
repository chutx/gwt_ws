package com.training.gwt.calculator.client.widgets.handler;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.training.gwt.calculator.controller.CalculatorController;
import com.training.gwt.calculator.operators.AbstractOperator;

/**
 * Queda pendiente, no tiene uso
 * @author angelo
 *
 */
public class ButtonClickHandler implements ClickHandler{

	private CalculatorController controller;
	private AbstractOperator operator;
	
	public ButtonClickHandler(CalculatorController controller, AbstractOperator operator) {
		this.controller = controller;
		this.operator = operator;
	}
	
	public void onClick(ClickEvent event) {
		controller.processOperator(operator);
	}

}
