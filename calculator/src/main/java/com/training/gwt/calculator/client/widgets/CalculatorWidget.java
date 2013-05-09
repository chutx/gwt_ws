package com.training.gwt.calculator.client.widgets;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.training.gwt.calculator.constants.CalculatorConstants;
import com.training.gwt.calculator.controller.CalculatorController;
import com.training.gwt.calculator.controller.CalculatorData;

public class CalculatorWidget extends VerticalPanel {

	private CalculatorController calController;
	private CalculatorData data;

	public CalculatorWidget(final String title) {
		super();

		data = new CalculatorData();
		calController = new CalculatorController(data);

		VerticalPanel vp = createVerticalPanel();
		Grid grid = createGrid();

		Button[] btns = createButtons();
		arrangeButtonsOnGrid(grid, btns);

	}

	public void onModuleLoad() {

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

	private void arrangeButtonsOnGrid(Grid grid, Button btns[]){
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
