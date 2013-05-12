package com.training.gwt.calculator.controller;

import com.training.gwt.calculator.listeners.CalculatorChangeListener;
import com.training.gwt.calculator.notifiers.CalculatorChangeNotifier;

public class CalculatorData implements CalculatorChangeNotifier {

	private String display;
	private double buffer;
	private boolean initDisplay;
	private boolean lastOpEquals;
	private CalculatorChangeListener changeListener;
	
	public CalculatorData(){
		this.clear();
	}
	
	public void addChangeListener(CalculatorChangeListener listener) {
		changeListener = listener;
	}
	
	public void clear(){
		this.display = "0";
		this.buffer = 0;
		this.initDisplay = true;
		this.lastOpEquals = false;
		if(this.changeListener != null) this.changeListener.onChange(this);
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
		changeListener.onChange(this);
	}

	public double getBuffer() {
		return buffer;
	}

	public void setBuffer(double buffer) {
		this.buffer = buffer;
		changeListener.onChange(this);
	}

	public boolean isInitDisplay() {
		return initDisplay;
	}

	public void setInitDisplay(boolean initDisplay) {
		this.initDisplay = initDisplay;
	}

	public boolean isLastOpEquals() {
		return lastOpEquals;
	}

	public void setLastOpEquals(boolean lastOpEquals) {
		this.lastOpEquals = lastOpEquals;
	}
	
}
