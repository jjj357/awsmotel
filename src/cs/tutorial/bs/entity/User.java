package cs.tutorial.bs.entity;


import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.sql.SQLException;

import javax.persistence.*;

@Entity
public class User  implements Serializable {
	@Id
	private Integer userID;
	private String username;
	private String password;
	private String userRealName;
	private String securityQuestion;
	private String securityAnswer;
	private String email;
	private String phoneNumber;

	private static final long serialVersionUID = 1L;

	public User() {
		super();

		
	}   
	
	public User(Integer userID) {
		super();
		this.userID = userID;
	}
	
	public User(String username, String password, String firstName, String lastName, String securityQuestion,
			String securityAnswer, String email, String phoneNumber) {
		super();
		this.username = username;
		LoginServlet ls = new LoginServlet();
		try {
			this.password = ls.encodePasswordUsingSHA1(password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		this.userRealName = firstName + " " + lastName;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
		this.email = email;
		this.phoneNumber = phoneNumber;

	}
	
	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
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
		//LoginServlet ls = new LoginServlet();
		try {
			this.password = LoginServlet.encodePasswordUsingSHA1(password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	public String getUserRealName() {
		return userRealName;
	}

	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getSecurityAnswer() {
		return securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
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

	


}
