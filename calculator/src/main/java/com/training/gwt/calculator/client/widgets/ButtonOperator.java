package com.training.gwt.calculator.client.widgets;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.training.gwt.calculator.constants.CalculatorConstants;
import com.training.gwt.calculator.controller.CalculatorController;
import com.training.gwt.calculator.operators.AbstractOperator;

public class ButtonOperator extends Button {

	public ButtonOperator(final CalculatorController controller, final AbstractOperator operator) {
		super(operator.getLabel());
		this.setStyleName(CalculatorConstants.STYLE_BUTTON_OPERATOR);
		
		this.addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent event) {
				controller.processOperator(operator);
			}
		});
	}
}
