package cs.tutorial.bs.entity;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;
import cs.tutorial.bs.entity.Room;

/**
 * Entity implementation class for Entity: Booking
 *
 */
@Entity
public class Booking implements Serializable {
	@Id
	private Integer bookingID;
	
	private String bookingDate;
	private String bookingStartDate;
	private String bookingEndDate;
	
	private Integer clientID;
	
	private Integer roomNumber;
	
	private Float  bookingPrice;
	
	private String bookingNotes;
	
	private String isActive;
	
	private static final long serialVersionUID = 1L;

	public Booking() {
		super();
		this.bookingID = null;
		this.bookingDate = null;
		this.bookingStartDate = null;
		this.bookingEndDate = null;
		this.clientID = null;
		this.roomNumber = null;
		this.bookingNotes = null;
		this.isActive = null;	
		
	}   
	
	public Booking(Integer bookingNumber,String bookingDate, String bookingStartDate,String bookingEndDate,
			Integer clientID,Integer roomNumber,String bookingNotes,String isActive ) {
		super();
		this.bookingID = bookingNumber;
		this.bookingDate = bookingDate;
		this.bookingStartDate = bookingStartDate;
		this.bookingEndDate = bookingEndDate;
		this.clientID = clientID;
		this.roomNumber = roomNumber;
		this.bookingNotes = bookingNotes;
		this.isActive = isActive;		
	}
	
	public Integer getBookingID() {
		return this.bookingID;
	}
	
	
	public void setBookingID(Integer bookingID) {
		this.bookingID = bookingID;
	}

	
	public String getBookingDate() {
		return this.bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	
	public String getBookingStartDate() {
		return this.bookingStartDate;
	}

	public void setBookingStartDate(String bookingStartDate) {
		this.bookingStartDate = bookingStartDate;
	}
	
	public String getBookingEndDate() {
		return this.bookingEndDate;
	}

	public void setBookingEndDate(String bookingEndDate) {
		this.bookingEndDate = bookingEndDate;
	}
	
	
	public Integer getClientID() {
		return this.clientID;
	}
	
	public void setClientID(Integer clientID) {
		this.clientID = clientID;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public Float getBookingPrice() {
		return this.bookingPrice;
	}

	public void setBookingPrice(Float bookingPrice) {
		this.bookingPrice = bookingPrice;
	}
	
	public String getBookingNotes() {
		return this.bookingNotes;
	}

	public void setBookingNotes(String bookingNotes) {
		this.bookingNotes = bookingNotes;
	}
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String strIsActive) {
		if (strIsActive.equals("TRUE") || strIsActive.equals("FALSE"))  {
		    this.isActive = strIsActive;
	    }
		
	}
		
	public Integer getBookingNumberByRoomStartDate (String bookingStartDate) {
		Integer getBookingNumber = new Integer(0);
		if (this.bookingStartDate.equals(bookingStartDate)) {
			getBookingNumber = this.bookingID;
		}
		return getBookingNumber;
	}
	
	public Integer getBookingNumberByFirstName (String firstName) {
		Integer getBookingNumber = new Integer(0);
		if ((new Client(this.clientID)).getFirstName().equals(firstName)) {
			getBookingNumber = this.bookingID;
		}
		return getBookingNumber;
	}
	
	public Integer getBookingNumberByLastName (String lastName) {
		Integer getBookingNumber = new Integer(0);
		if ((new Client(this.clientID)).getLastName().equals(lastName)) {
			getBookingNumber = this.bookingID;
		}
		return getBookingNumber;
	}
	

}
