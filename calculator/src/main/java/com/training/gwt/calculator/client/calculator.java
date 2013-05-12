package com.training.gwt.calculator.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.training.gwt.calculator.client.widgets.CalculatorWidget;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class calculator implements EntryPoint {

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
    RootPanel.get().add(new CalculatorWidget("Calculator"));
	  
  }
}
