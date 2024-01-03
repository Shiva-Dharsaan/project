package com.example.project.ord;

public class Subscription {
	
	private String logind;
    private	int mfid;
    private double amount;
	
    
    public Subscription(String logind, int mfid, double amount) {
		super();
		this.logind = logind;
		this.mfid = mfid;
		this.amount = amount;
	}


	public String getLogind() {
		return logind;
	}


	public void setLogind(String logind) {
		this.logind = logind;
	}

    


	public int getMfid() {
		return mfid;
	}


	public void setMfid(int mfid) {
		this.mfid = mfid;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}
    
    
    
    
}
