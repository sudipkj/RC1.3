package com.cal.limitsservice;

public class LimitsBean {
	
	private int minimum;
	private int maximum;

	public LimitsBean(int minimum, int maximum) {
		super();
		this.minimum = minimum;
		this.maximum = maximum;
	}

	public int getMinimum() {
		return minimum;
	}

	public LimitsBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}

	public int getMaximum() {
		return maximum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}

}
