package com.example.project.ord;

public class StockSelection {
	private int mfid;
	private String stockname;
	private int weightage;
	private String created_by;
	
	
	public StockSelection(int mfid, String stockname, int weightage,String created_by) {
		super();
		this.mfid =mfid;
		this.stockname = stockname;
		this.weightage = weightage;
		this.created_by=created_by;
	}



	public int getMfid() {
		return mfid;
	}

	public void setMfid(int mfid) {
		this.mfid = mfid;
	}


	public String getStockname() {
		return stockname;
	}


	public void setStockname(String stockname) {
		this.stockname = stockname;
	}


	public int getWeightage() {
		return weightage;
	}


	public void setWeightage(int weightage) {
		this.weightage = weightage;
	}



	/**
	 * @return the created_by
	 */
	public String getCreated_by() {
		return created_by;
	}



	/**
	 * @param created_by the created_by to set
	 */
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	
	
	
	
	

}
