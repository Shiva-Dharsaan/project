package com.example.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


//Annotates the class as a JPA entity, indicating it's mapped to a database table.

@Entity

//Specifies the name of the database table called transac to which this entity is mapped.

@Table(name="transac")
public class THistory {



	// Annotates the field as the primary key for the entity.

		@Id
		// Fields to store information about the transaction history.

		private int tranid;
		private String type;
		private double noofunits;
		private double price;
		private String currdate;
		private String investorid;
		private String nameofmuf;
		
		
		// Default constructor, typically used by JPA when retrieving entities from the database.	
		public THistory() {
			super();
		}



		// Parameterized Constructor to initialize the entity with values for all fields.
		public THistory(int tranid, String type,double noofunits,double price, String currdate,
				String investorid, String nameofmuf) {
			super();
			this.tranid = tranid;
			this.type = type;
			this.noofunits = noofunits;
			this.price = price;
			this.currdate = currdate;
			this.investorid = investorid;
			this.nameofmuf = nameofmuf;
		}
		/* Getter and setter methods for all fields.
		   These methods allow you to access and modify the values of the entity's attributes.
		   They follow standard Java bean naming conventions. */


		// Getter method for 'getTranid' field

		public int getTranid() {
			return tranid;
		}



		// Setter method for 'setTranid' field

		public void setTranid(int tranid) {
			this.tranid = tranid;
		}



		// Getter method for 'getType' field

		public String getType() {
			return type;
		}



		// Setter method for 'setType' field

		public void setType(String type) {
			this.type = type;
		}



		// Getter method for 'getNoofunits' field

		public double getNoofunits() {
			return noofunits;
		}



		// Setter method for 'setNoofunits' field

		public void setNoofunits(double noofunits) {
			this.noofunits = noofunits;
		}



		// Getter method for 'getPrice' field

		public double getPrice() {
			return price;
		}



		// Setter method for 'setPrice' field

		public void setPrice(double price) {
			this.price = price;
		}



		// Getter method for 'getCurrdate' field

		public String getCurrdate() {
			return currdate;
		}



		// Setter method for 'setCurrdate' field

		public void setCurrdate(String currdate) {
			this.currdate = currdate;
		}



		// Getter method for 'getInvestorid' field

		public String getInvestorid() {
			return investorid;
		}



		// Setter method for 'setInvestorid' field

		public void setInvestorid(String investorid) {
			this.investorid = investorid;
		}



		// Setter method for 'setInvestorid' field

		public String getNameofmuf() {
			return nameofmuf;
		}



		// Setter method for 'setInvestorid' field

		public void setNameofmuf(String nameofmuf) {
			this.nameofmuf = nameofmuf;
		}

		
	   
	}



