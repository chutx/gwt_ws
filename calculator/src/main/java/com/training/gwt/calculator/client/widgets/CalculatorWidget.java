package com.training.gwt.calculator.client.widgets;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ValueBoxBase.TextAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.training.gwt.calculator.constants.CalculatorConstants;
import com.training.gwt.calculator.controller.CalculatorController;
import com.training.gwt.calculator.controller.CalculatorData;
import com.training.gwt.calculator.listeners.CalculatorChangeListener;
import com.training.gwt.calculator.operators.impl.OperatorAdd;
import com.training.gwt.calculator.operators.impl.OperatorDivide;
import com.training.gwt.calculator.operators.impl.OperatorMultiply;
import com.training.gwt.calculator.operators.impl.OperatorSubtract;

public class CalculatorWidget extends VerticalPanel {

	private TextBox display;
	
	private CalculatorController calController;
	private CalculatorData data;

	public CalculatorWidget(final String title) {
		super();

		data = new CalculatorData();
		calController = new CalculatorController(data);

		VerticalPanel vp = createVerticalPanel();
		Grid grid = createGrid();

		Button[] btns = createButtons();
		arrangeNumberButtonsOnGrid(grid, btns);
		createAndArrangeOperators(grid);
		createAndArrangeClear(grid);
		createAndArrangeEquals(grid);
		
		display = new TextBox();
		
		data.addChangeListener(new CalculatorChangeListener() {
			
			public void onChange(CalculatorData data) {
				display.setText(String.valueOf(data.getDisplay()));
			}
		});
		
		display.setText("0");
		display.setAlignment(TextAlignment.RIGHT);
		
		vp.add(display);
		vp.add(grid);
		
		this.add(vp);
	}

	private VerticalPanel createVerticalPanel() {
		VerticalPanel vp = new VerticalPanel();
		vp.setHorizontalAlignment(ALIGN_RIGHT);
		vp.setStyleName(CalculatorConstants.STYLE_PANEL);
		return vp;
	}

	private Grid createGrid() {
		Grid grid = new Grid(4, 5);
		grid.setStyleName(CalculatorConstants.STYLE_GRID);
		return grid;
	}

	private void createAndArrangeEquals(Grid grid){
		Button equals = new Button(CalculatorConstants.EQUALS);
		equals.addStyleName(CalculatorConstants.STYLE_BUTTON_DIGIT);
		equals.addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent event) {
				calController.processEqual();
			}
		});
		grid.setWidget(3, 4, equals);
	}
	
	private void createAndArrangeClear(Grid grid){
		Button clear = new Button(CalculatorConstants.CLEAR);
		clear.setStyleName(CalculatorConstants.STYLE_BUTTON_DIGIT);
		clear.addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent event) {
				calController.processClear();
			}
		});
		grid.setWidget(2, 4, clear);
	}
	
	private void createAndArrangeOperators(Grid grid){
		Button add = new ButtonOperator(calController, new OperatorAdd());
		Button multiply = new ButtonOperator(calController, new OperatorMultiply());
		Button divide = new ButtonOperator(calController, new OperatorDivide());
		Button subtract = new ButtonOperator(calController, new OperatorSubtract());
		
		grid.setWidget(0, 3, divide);
		grid.setWidget(1, 3, multiply);
		grid.setWidget(2, 3, subtract);
		grid.setWidget(3, 3, add);
	}
	
	private void arrangeNumberButtonsOnGrid(Grid grid, Button btns[]){
		int k=1;
		grid.setWidget(3, 0, btns[0]);
		for(int i=2; i>=0; i--)
			for(int j=0; j<3; j++){
				grid.setWidget(i, j, btns[k++]);
			}
	}
	
	/**
	 * 
	 * @return
	 */
	private Button[] createButtons() {
		Button[] btns = new Button[10];

		for (int i = 0; i < btns.length; i++) {
			btns[i] = createButton(Integer.toString(i));
		}
		return btns;
	}

	/**
	 * 
	 * @param label
	 * @return
	 */
	private Button createButton(String label) {
		Button btn = new ButtonDigit(calController, label);
		return btn;
	}

}
