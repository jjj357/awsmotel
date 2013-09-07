package cs.tutorial.bs.entity;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;


/**
 * Entity implementation class for Entity: Client
 *
 */
@Entity
public class Client implements Serializable {
	@Id
	private Integer clientID;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String address;
	//private Integer creditCardNumber;
	//private Integer addressID;
	private static final long serialVersionUID = 1L;

	public Client() {
		super();

		
	}   
	
	public Client(Integer clientID) {
		super();
		this.clientID = clientID;
	}
	
	public Client(String firstName, String lastName,
			String email, String phoneNumber, Integer creditCardNumber,Integer addressID) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		//this.creditCardNumber = creditCardNumber;
		//this.addressID = addressID;
	}
	
	public Integer getClientID() {
		return this.clientID;
	}
	
	public  void setClientID(Integer clientID) {
		this.clientID = clientID;
	}
		
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	/*
	public Integer getCreditCardNumber() {
		return this.creditCardNumber;
	}

	public void setCreditCardNumber(Integer creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	
	public Integer getAddressID() {
		return this.addressID;
	}

	public void setAddressID(Integer addressID) {
		this.addressID = addressID;
	}  */
	
}
