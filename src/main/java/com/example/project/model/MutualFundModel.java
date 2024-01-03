package com.example.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity
@Table(name="mutualfund")


//@NamedStoredProcedureQueries({
@NamedStoredProcedureQuery(
  name = MutualFundModel.updateWeightage,
  procedureName = "UPDATEWIGHTAGE",
  resultClasses = MutualFundModel.class,
  parameters = {
          @StoredProcedureParameter(type = Integer.class, mode = ParameterMode.IN),
          @StoredProcedureParameter(type = Integer.class, mode = ParameterMode.IN),
  })

public class MutualFundModel {
	
	public static final String updateWeightage = "updateWeightage";
	
	  @Id
   //   @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int mf_id; // represents the unique identifier for a mutual fund.
		
		private String name_of_mf; //stores the name or title of the mutual fund.
		private int  entry_load;   // represent the entry load, which is a fee that investors pay when purchasing mutual fund units.
		private int  exit_load;    // represent the exit load, which is a fee incurred when selling or redeeming mutual fund units within a specified period.
		private int  expense_ratio;// represent the expense ratio of the mutual fund, which is the percentage of assets deducted annually to cover operating expenses.
		private double balance_cash; // available cash balance within the mutual fund
		private double nav; // represent per-unit market value of the fund's assets.
		private double total_corpus;  // represent the total corpus or the total assets under management for the mutual fund
		private String created_on;
		private String created_by;
		private String modified_on;
		private String modified_by;
		private int available_weightage;
      
		// Default constructor, typically used by JPA when retrieving entities from the database.

		public MutualFundModel() {
			super();
		}

		
		// Parameterized Constructor to initialize the entity with values for all fields.

		public MutualFundModel(int mf_id,String name_of_mf, int entry_load, int exit_load, int expense_ratio, double balance_cash,
				double nav, double total_corpus) {
			super();
			this.mf_id=mf_id;
			this.name_of_mf = name_of_mf;
			this.entry_load = entry_load;
			this.exit_load = exit_load;
			this.expense_ratio = expense_ratio;
			this.balance_cash = balance_cash;
			this.nav = nav;
			this.total_corpus = total_corpus;
		}

		/* These getter and setter methods provide access to the private fields of the Login class.
		   allowing other parts of the program to read and modify the attributes in a controlled manner. */
		
		// This is a getter method for retrieving the mf_id attribute. It returns a Integer representing the mutual_fund ID.
		public Integer getMf_id() {
			return mf_id;
		}

		// This is a setter method for setting the mf_id attribute. It sets the value of the mf_id field to the provided value. This method allows external code to update the mf_id attribute.
		public void setMf_id(Integer mf_id) {
			this.mf_id = mf_id;
		}


		// This is a getter method for retrieving the name_of_mf attribute. It returns a String representing the name of the mutual fund
		public String getName_of_mf() {
			return name_of_mf;
		}


		// This is a setter method for setting the name_of_mf attribute. It sets the value of the name_of_mf field to the provided value. This method allows external code to update the name_of_mf attribute.
		public void setName_of_mf(String name_of_mf) {
			this.name_of_mf = name_of_mf;
		}

		// This is a getter method for retrieving the entry_load attribute. It returns a integer representing the entry_load.
		public int getEntry_load() {
			return entry_load;
		}
		// This is a setter method for setting the entry_load attribute. It sets the value of the entry_load field to the provided value. This method allows external code to update the entry_load attribute.
		public void setEntry_load(int entry_load) {
			this.entry_load = entry_load;
		}

		// This is a getter method for retrieving the exit_load attribute. It returns a integer representing the exit_load.
		public int getExit_load() {
			return exit_load;
		}

		
		// This is a setter method for setting the exit_load attribute. It sets the value of the exit_load field to the provided value. This method allows external code to update the exit_load attribute.
		public void setExit_load(int exit_load) {
			this.exit_load = exit_load;
		}

		// This is a getter method for retrieving the expense_ratio attribute. It returns a float representing the expense_ratio.
		public int getExpense_ratio() {
			return expense_ratio;
		}

		// This is a setter method for setting the expense_ratio attribute. It sets the value of the expense_ratio field to the provided value. This method allows external code to update the expense_ratio attribute.
		public void setExpense_ratio(int expense_ratio) {
			this.expense_ratio = expense_ratio;
		}

		// This is a getter method for retrieving the balance_cash attribute. It returns a double representing the balance_cash.
		public double getBalance_cash() {
			return balance_cash;
		}

		// This is a setter method for setting the balance_cash attribute. It sets the value of the balance_cash field to the provided value. This method allows external code to update the balance_cash attribute.
		public void setBalance_cash(double balance_cash) {
			this.balance_cash = balance_cash;
		}

		// This is a getter method for retrieving the nav attribute. It returns a double representing the nav.
		public double getNav() {
			return nav;
		}

		// This is a setter method for setting the nav attribute. It sets the value of the nav field to the provided value. This method allows external code to update the nav attribute.
		public void setNav(double nav) {
			this.nav = nav;
		}

		// This is a getter method for retrieving the total_corpus attribute. It returns a double representing the total_corpus.
		public double getTotal_corpus() {
			return total_corpus;
		}

		// This is a setter method for setting the total_corpus attribute. It sets the value of the total_corpus field to the provided value. This method allows external code to update the total_corpus attribute
		public void setTotal_corpus(double total_corpus) {
			this.total_corpus = total_corpus;
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


		/**
		 * @return the available_weightage
		 */
		public int getAvailable_weightage() {
			return available_weightage;
		}


		/**
		 * @param available_weightage the available_weightage to set
		 */
		public void setAvailable_weightage(int available_weightage) {
			this.available_weightage = available_weightage;
		}
        

			
		

    }
