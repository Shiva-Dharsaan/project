package com.example.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login")

public class Login {
	// Annotates the field as the primary key for the entity.
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
     private String login_id;
// Fields to store user login information.

	
	private String password;// Password for login authentication.
	private String type;// Type of user (e.g., Investor, Manager)
	private String created_by;// Name of the person associated with the login.
	private String created_on;
	private String modified_by;
	private String modified_on;
	
	// Default constructor, typically used by JPA when retrieving entities from the database.

	public Login() {
		// Default constructor with no arguments.

	}

	// Parameterized Constructor to initialize the entity with values for all fields.

	public Login(String login_id,String password, String type,String created_by) {
		super();
		this.login_id = login_id;
		this.password = password;
		this.type = type;
		this.created_by=created_by;
		
	
	}


	/* These getter and setter methods provide access to the private fields of the Login class.
	allowing other parts of the program to read and modify the attributes in a controlled manner. */
	
	// This is a getter method for retrieving the login_id attribute. It returns a String representing the login ID

	public String getLogin_id() {
		return login_id;
	}

	// This is a setter method for setting the login_id attribute. It sets the value of the login_id field to the provided value. This method allows external code to update the login_id attribute.

	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}
	// a getter method for retrieving the name_of_p attribute. It returns a String representing the name of the person associated with the login.


    // a getter method for retrieving the password attribute. It returns a String representing the password for login authentication. This method allows external code to access the value of the password field.

	public String getPassword() {
		return password;
	}

    // Setter method for setting the password attribute. It sets the value of the password field to the provided value. This method allows external code to update the password attribute.

	public void setPassword(String password) {
		this.password = password;
	}

	// This is a getter method for retrieving the type attribute. It returns a String representing the type of user (e.g., Manager, Investor).

	public String getType() {
		return type;
	}

    // This is a setter method for setting the type attribute. It sets the value of the type field to the provided value.

	public void setType(String type) {
		this.type = type;
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
