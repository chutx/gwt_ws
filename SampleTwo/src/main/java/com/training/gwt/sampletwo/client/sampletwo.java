package com.training.gwt.sampletwo.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class sampletwo implements EntryPoint {

	private Boolean playerToogle = true;
	private ClickHandler clickHandler = new TicTacClickHandler();
	
	public void onModuleLoad() {
		Grid grid = new Grid(3, 3);
		fillGrid(grid);
		
		RootPanel.get().add(grid);
	}

	private void fillGrid(Grid grid){
		Widget wgt = null;
		for(int row =0; row < 3; row++)
			for(int col=0; col < 3; col++){
				wgt = createButton(30, 30);
				grid.setWidget(row, col, wgt);
			}
	}
	
	private Button createButton(int height, int width){
		Button btn = new Button();
		btn.addClickHandler(clickHandler);
		btn.setPixelSize(width, height);
		return btn;
	}
	
	private class TicTacClickHandler implements ClickHandler{

		public void onClick(ClickEvent event) {
			Object obj = event.getSource();
			if(obj instanceof Button){
				Button btn = (Button) obj;
				
				if(btn.getText().equals("")){
					btn.setText(getText());
					playerToogle = !playerToogle;
				}else{
					Window.alert("Fail !!");
				}
			}
		}
		
		private String getText(){
			return playerToogle ? "X" : "O";
		}
		
	}
}
