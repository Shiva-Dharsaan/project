package com.example.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


//Annotates the class as a JPA entity, indicating it's mapped to a database table.
@Entity

//Specifies the name of the database table to which this entity is mapped.

@Table(name="pricedata1")
public class Pricedata1 {
	@Id
	private int p_id;
	private String nameofshare;
  private  String closingdate;
  private double closing_price;
	
  
  /*Default constructor, typically used by JPA when retrieving entities from the database.*/   
	public Pricedata1() {
		super();
	}

	// Parameterized Constructor to initialize the entity with values for all fields.
	public Pricedata1(int p_id, String nameofshare, String closingdate, double closing_price) {
		super();
		this.p_id = p_id;
		this.nameofshare = nameofshare;
		this.closingdate = closingdate;
		this.closing_price = closing_price;
	}
	
	/* Getter and setter methods for all fields.
	   These methods allow you to access and modify the values of the entity's attributes.
	   They follow standard Java bean naming conventions. */	
	
	// Getter method for 'p_id' field
	public int getP_id() {
		return p_id;
	}

	//Setter method for 'p_id' field

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	// Getter method for 'nameofshare' field

	public String getNameofshare() {
		return nameofshare;
	}
	
	//Setter method for 'nameofshare' field

	public void setName_of_share(String nameofshare) {
		this.nameofshare = nameofshare;
	}
	
	// Getter method for 'closing_date' field

	public String getClosingdate() {
		return closingdate;
	}
	
	// Setter method for 'closing_date' field

	public void setClosing_date(String closingdate) {
		this.closingdate = closingdate;
	}
	
	// Getter method for 'closing_price' field

	public double getClosing_price() {
		return closing_price;
	}
	
	//Setter method for 'closing_price' field

	public void setClosing_price(double closing_price) {
		this.closing_price = closing_price;
	}

}
