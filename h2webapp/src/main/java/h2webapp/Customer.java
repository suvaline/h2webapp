package h2webapp;

import java.sql.Date;
public class Customer {
	  private Integer id;
	  private String firstName;
	  private String lastName;
	  private Date dateOfBirth;
	  private String username;
	  private String password;
	  
	  public Customer() {

		}
	  

	public Customer(String firstName, String lastName, Date dateOfBirth, String username, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.username = username;
		this.password = password;
	}
	public Customer(int id,String firstName, String lastName, Date dateOfBirth, String username, String password) {
		super();
		this.id=id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.username = username;
		this.password = password;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String ToString() 
	{
		return "Person{"+
				"Firstame"+firstName+'\''+
				"Lastname"+lastName+'\''+
				"DateofBirth"+dateOfBirth+'\''+
				"username"+username+'\''+
				"password"+password+'\''+'}';
	}
}