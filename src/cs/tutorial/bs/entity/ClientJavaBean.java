package cs.tutorial.bs.entity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;


public class ClientJavaBean {
	

	
	private Integer clientID;
	private String strClientID;
	
	private String firstName;
	private String lastName;
	private String email;
	
	private String phoneNumber;

	private String address;
	
	private Hashtable<String, String> errors;
	
	
	
	
	public ClientJavaBean() {
		
		strClientID = "";
		firstName = "";
		lastName = "";
		email = "";		
		phoneNumber = "";		
		address="";
		errors = new Hashtable<String, String>();
	}

	public String getStrClientID() {
		return strClientID;
	}

	public void setStrClientID(String strClientID) {
		this.strClientID = strClientID;
	}

	public Integer getClientID() {
		return clientID;
	}

	public void setClientID(Integer clientID) {
		this.clientID = clientID;
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
	
	
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public boolean validate() {
		boolean ret = true;
		
		try {
			clientID = Integer.parseInt(strClientID);		
		} catch (NumberFormatException nfe) {
			ret = false;
			errors.put("clientID", "Please enter an integer number");
		}
		

		if (firstName.equals("")) {
			ret = false;
			errors.put("firstName", "Please enter a first name");
		}
		
		if (lastName.equals("")) {
			ret = false;
			errors.put("lastName", "Please enter a last name");
		}
		
		if (email.equals("")) {
			ret = false;
			errors.put("email", "Please enter an email address");
		}
		
		if (phoneNumber.equals("")) {
			ret = false;
			errors.put("phoneNumber", "Please enter a phone number");
		}
		
		if (address.equals("")) {
			ret = false;
			errors.put("address", "Please enter an address");
		}
			
		return ret;
	}
	
	public String getErrorMsg(String s) {
		String errorMsg = errors.get(s.trim());
		return (errorMsg == null) ? "" : errorMsg;
	}

	/*
	@Override
	public String toString() {
		return "The price for this Client is = " + price;
	}   */
	
}

