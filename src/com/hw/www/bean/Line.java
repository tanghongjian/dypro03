package com.hw.www.bean;

public class Line {
	private int xid;
	private String xname;

	public int getXid() {
		return xid;
	}

	public void setXid(int xid) {
		this.xid = xid;
	}

	public String getXname() {
		return xname;
	}

	public void setXname(String xname) {
		this.xname = xname;
	}

	@Override
	public String toString() {
		return "Line [xid=" + xid + ", xname=" + xname + "]";
	}

}
