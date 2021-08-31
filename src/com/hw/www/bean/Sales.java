package com.hw.www.bean;

public class Sales {
	private int sid;
	private String saledate;
	private double price;
	private int num;
	private int pid;
	private double cost;
	private int countnum;
	private double avgprice;
	private double msr;
	private double zcost;
	private double lr;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSaledate() {
		return saledate;
	}

	public void setSaledate(String saledate) {
		this.saledate = saledate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getCountnum() {
		return countnum;
	}

	public void setCountnum(int countnum) {
		this.countnum = countnum;
	}

	public double getAvgprice() {
		return avgprice;
	}

	public void setAvgprice(double avgprice) {
		this.avgprice = avgprice;
	}

	public double getMsr() {
		return msr;
	}

	public void setMsr(double msr) {
		this.msr = msr;
	}

	public double getZcost() {
		return zcost;
	}

	public void setZcost(double zcost) {
		this.zcost = zcost;
	}

	public double getLr() {
		return lr;
	}

	public void setLr(double lr) {
		this.lr = lr;
	}

	@Override
	public String toString() {
		return "Sales [sid=" + sid + ", saledate=" + saledate + ", price=" + price + ", num=" + num + ", pid=" + pid
				+ ", cost=" + cost + ", countnum=" + countnum + ", avgprice=" + avgprice + ", msr=" + msr + ", zcost="
				+ zcost + ", lr=" + lr + "]";
	}

}
