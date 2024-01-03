package com.example.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//Annotates the class as a JPA entity, indicating it's mapped to a database table.
@Entity

//Specifies the name of the database table to which this entity is mapped
@Table(name="nav")
public class NavModel {
	
	// Annotates the field as the primary key for the entity.

	@Id
	private int nav;  // NAV is a per-unit market value of the fund's assets
	private String mutualfund; // stores the name or title of a mutual fund. This field could be used to identify or describe the mutual fund associated with the other data.
	private double previous_day_nav;  //represents the NAV of the mutual fund from the previous day
	private String created_on;
	private String created_by;
	private String modified_on;
	private String modified_by;
	private int mfid;
	
	// Default constructor, typically used by JPA when retrieving entities from the database.
	public NavModel() {
		super();
	}


	// Parameterized Constructor to initialize the entity with values for all fields.
	public NavModel(int nav,String mutualfund, double previous_day_nav,String created_by) {
		super();
		this.nav=nav;
		this.mutualfund= mutualfund;
		this.previous_day_nav = previous_day_nav;
		this.created_by=created_by;
	}
	/* These getter and setter methods provide access to the private fields of the Login class.
	allowing other parts of the program to read and modify the attributes in a controlled manner. */
	
	// This is a getter method for retrieving the nav attribute. It returns a integer representing the nav.

	public int getNav() {
		return nav;
	}

	// This is a setter method for setting the nav attribute. It sets the value of the nav field to the provided value. This method allows external code to update the nav attribute
	public void setNav(int nav) {
		this.nav = nav;
	}

	// This is a getter method for retrieving the mutualfund attribute. It returns a String representing the mutualfund.
	public String getMutualfund() {
		return mutualfund;
	}

	// This is a setter method for setting the mutualfund attribute. It sets the value of the mutualfund field to the provided value. This method allows external code to update the mutualfund attribute.
	public void setMutualfund(String mutualfund) {
		this.mutualfund = mutualfund;
	}


	// This is a getter method for retrieving the previous_day_nav attribute. It returns a double representing the previous_day_nav.
	public double getPrevious_day_nav() {
		return previous_day_nav;
	}


	// This is a setter method for setting the previous_day_nav attribute. It sets the value of the previous_day_nav field to the provided value. This method allows external code to update the previous_day_nav attribute.
	public void setPrevious_day_nav(double previous_day_nav) {
		this.previous_day_nav = previous_day_nav;
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
