package com.training.gwt.calculator.client.widgets;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.training.gwt.calculator.constants.CalculatorConstants;
import com.training.gwt.calculator.controller.CalculatorController;

public class ButtonDigit extends Button {

	public ButtonDigit(final CalculatorController controller, final String label){
		super(label);
		this.setStyleName(CalculatorConstants.STYLE_BUTTON_DIGIT);
		
		this.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				controller.processDigit(label);
			}
			
		});
	}
	
	
}
