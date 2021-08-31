package com.hw.www.bean;

public class Hz {
	private double avgmonth;
	private int cot;
	private double avgcost;

	public double getAvgmonth() {
		return avgmonth;
	}

	public void setAvgmonth(double avgmonth) {
		this.avgmonth = avgmonth;
	}

	public int getCot() {
		return cot;
	}

	public void setCot(int cot) {
		this.cot = cot;
	}

	public double getAvgcost() {
		return avgcost;
	}

	public void setAvgcost(double avgcost) {
		this.avgcost = avgcost;
	}

	@Override
	public String toString() {
		return "Hz [avgmonth=" + avgmonth + ", cot=" + cot + ", avgcost=" + avgcost + "]";
	}

}
