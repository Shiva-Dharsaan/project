package com.example.project.ord;

public class Redemption {
	
	private String loginid;
	private int mfid;
	private double units;
	
	
	public Redemption(String loginid, int mfid, double units) {
		super();
		this.loginid = loginid;
		this.mfid = mfid;
		this.units = units;
	}


	public String getLoginid() {
		return loginid;
	}


	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

    

	public int getMfid() {
		return mfid;
	}


	public void setMfid(int mfid) {
		this.mfid = mfid;
	}


	public double getUnits() {
		return units;
	}


	public void setUnits(double units) {
		this.units = units;
	}
	
	
	
	

}
