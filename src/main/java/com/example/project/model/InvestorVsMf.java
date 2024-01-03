package com.example.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.ParameterMode;


//Annotates the class as a JPA entity, indicating it's mapped to a database table.
@Entity

//Specifies the name of the database table called investorvsmf to which this entity is mapped.
@Table(name="investorvsmf")

//@NamedStoredProcedureQueries({
@NamedStoredProcedureQuery(
    name = InvestorVsMf.namedQuery_selectInvestorMf,
    procedureName = "SELECTCURRENTHOLDING",
    resultClasses = InvestorVsMf.class,
    parameters = {
            @StoredProcedureParameter(type = String.class, mode = ParameterMode.IN),
            @StoredProcedureParameter(type = void.class, mode = ParameterMode.REF_CURSOR),
    })

 @NamedStoredProcedureQuery(
		name=InvestorVsMf.namedQuery_insertIVsMf,
		procedureName="INSERTINVESTORVSMF",
		resultClasses=InvestorVsMf.class,
		parameters = {
				@StoredProcedureParameter(type = Integer.class, mode = ParameterMode.IN),
	            @StoredProcedureParameter(type = String.class, mode = ParameterMode.IN),
	            @StoredProcedureParameter(type = String.class, mode = ParameterMode.IN),
	            @StoredProcedureParameter(type = Double.class, mode = ParameterMode.IN),
	            @StoredProcedureParameter(type = Double.class, mode = ParameterMode.IN),
	            @StoredProcedureParameter(type = String.class, mode = ParameterMode.IN),
	            @StoredProcedureParameter(type = String.class, mode = ParameterMode.OUT),
	
	})
//})


public class InvestorVsMf {
	
	public static final String namedQuery_selectInvestorMf = "selectInvestorMF";
    public static final String namedQuery_insertIVsMf="insertInvestorVsMf";





	// Annotates the field as the primary key for the entity.

	@Id
	int investor_id;
	
	// Fields to store information about the investor vs mutual fund relationship.

	private String nameofinvestor; //name of the investor
	private String nameofmf;       //name of the mutualfund
	private double noofunits;      //number of units owned
	private double amount;         //amount invested
	private String created_on;
	private String created_by;
	private String modified_on;
	private String modified_by;
	// Default constructor, typically used by JPA when retrieving entities from the database.

	public InvestorVsMf() {
		super();
	}

	// Parameterized Constructor to initialize the entity with values for all fields.

	public InvestorVsMf(int investor_id, String nameofinvestor, String nameofmf, double noofunits, double amount) {
		super();
		this.investor_id = investor_id;
		this.nameofinvestor = nameofinvestor;
		this.nameofmf = nameofmf;
		this.noofunits = noofunits;
		this.amount = amount;
	}

	/* Getter and setter methods for all fields.
  These methods allow you to access and modify the values of the entity's attributes.
  They follow standard Java bean naming conventions. */
	
	public int getInvestor_id()  // Getter method for 'getInvestor_id' field
	{
		return investor_id;
	}


	public void setInvestor_id(int investor_id) // Setter method for 'setInvestor_id' field
	{
		this.investor_id = investor_id;
	}


	public String getNameofinvestor() // Getter method for 'getNameofinvestor' field
	{
		return nameofinvestor;
	}


	public void setNameofinvestor(String nameofinvestor)// Setter method for 'setNameofinvestor' field
	{
		this.nameofinvestor = nameofinvestor;
	}


	public String getNameofmf() // Getter method for 'getNameofmf' field
	{
		return nameofmf;
	}


	public void setNameofmf(String nameofmf) // Setter method for 'setNameofmf' field
	{
		this.nameofmf = nameofmf;
	}


	public double getNoofunits() // Getter method for 'getNoofunits' field
	{
		return noofunits;
	}


	public void setNoofunits(double noofunits) // Setter method for 'setNoofunits' field
	{
		this.noofunits = noofunits;
	}


	public double getAmount() // Getter method for 'getAmount' field
	{
		return amount;
	}


	public void setAmount(double amount)// Setter method for 'setAmount' field
	{
		this.amount = amount;
	}
	
	
	
	

}
