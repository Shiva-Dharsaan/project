package com.example.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mfvsstocks")

public class MutualFundsVsStocks {
	
	@Id
	private int pid;
	private String currdate;
	private int mfid;
	private String nameofstock;
	private float noofunits;
	private int weightage;
    private String created_on;
    private String created_by;
	private String modified_by;
    private String modified_on;
	
	
	
	// Default constructor, typically used by JPA when retrieving entities from the database.
	public MutualFundsVsStocks() {
		super();
	}

	// Parameterized Constructor to initialize the entity with values for all fields

	public MutualFundsVsStocks(int pid,String currdate, int mfid, String nameofstock,float noofunits,int weightage,String created_by )
			{
		super();
		this.pid = pid;
		this.currdate = currdate;
		this.mfid = mfid;
		this.nameofstock = nameofstock;
		this.noofunits = noofunits;
		this.weightage = weightage;
		this.created_by=created_by;
	
		
		
		
	}
	/* These getter and setter methods provide access to the private fields of the Login class.
	   allowing other parts of the program to read and modify the attributes in a controlled manner. */

	// This is a getter method for retrieving the pid attribute. It returns a Integer representing the price id.
	public int getPid() {
		return pid;
	}


	// This is a setter method for setting the pid attribute. It sets the value of the pid field to the provided value. This method allows external code to update the pid attribute.
	public void setPid(int pid) {
		this.pid = pid;
	}


	// This is a getter method for retrieving the mf_id attribute. It returns a Integer representing the mfid .

	public int getMfid() {
		return mfid;
	}


	// This is a setter method for setting the mf_id attribute. It sets the value of the mf_id field to the provided value. This method allows external code to update the mf_id attribute.
	public void setMfid(int mfid) {
		this.mfid = mfid;
	}


	// This is a getter method for retrieving the nameofstock attribute. It returns a String representing the nameofstock.
	public String getNameofstock() {
		return nameofstock;
	}

	 // This is a setter method for setting the nameofstock attribute. It sets the value of the nameofstock field to the provided value. This method allows external code to update the nameofstock attribute.
	public void setNameofstock(String nameofstock) {
		this.nameofstock = nameofstock;
	}


	// This is a getter method for retrieving the weightage attribute. It returns a Integer representing the weightage
	public int getWeightage() {
		return weightage;
	}


	// This is a setter method for setting the weightage attribute. It sets the value of the weightage field to the provided value. This method allows external code to update the weightage attribute.
	public void setWeightage(int weightage) {
		this.weightage = weightage;
	}

	// This is a getter method for retrieving the currdate attribute. It returns a String representing the currdate.
	public String getCurrdate() {
		return currdate;
	}


	// This is a setter method for setting the currdate attribute. It sets the value of the currdate field to the provided value. This method allows external code to update the currdate attribute.
	public void setCurrdate(String currdate) {
		this.currdate = currdate;
	}


	// This is a getter method for retrieving the noofunits attribute. It returns a float representing the noofunits.
	public float getNoofunits() {
		return noofunits;
	}


	// This is a setter method for setting the noofunits attribute. It sets the value of the noofunits field to the provided value. This method allows external code to update the noofunits attribute.
	public void setNoofunits(float noofunits) {
		this.noofunits = noofunits;
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
