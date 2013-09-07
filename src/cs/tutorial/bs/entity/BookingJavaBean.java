package cs.tutorial.bs.entity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import cs.tutorial.bs.entity.Room;


public class BookingJavaBean {
	

	
	private Integer bookingID;
	private String strBookingID;
	
	private String bookingDate;
	private String bookingStartDate;
	private String bookingEndDate;
	
	private String strClientID;
	private Integer clientID;
	
	private Integer roomNumber;
	private String strRoomNumber;
	
	private Float  bookingPrice;
	private String strBookingPrice;
	
	private String bookingNotes;
	
	private boolean isActive;
	private String strIsActive;
	
	
	//public static List<Room> availableRoomsSearchResult;
	
	

	private Hashtable<String, String> errors;
	
	
	
	public BookingJavaBean() {
		
		strBookingID = "";
		bookingDate = "";
		bookingStartDate = "";
		bookingEndDate = "";
		
		strClientID = "";
		strRoomNumber = "";
		bookingNotes = "";
		
		bookingPrice= Float.valueOf("0");
		
		isActive = true;
		
		//availableRoomsSearchResult = null;
		errors = new Hashtable<String, String>();
	}
	
	
	
	/*
	public List<Room> getAvailableRoomsSearchResult() {
		return availableRoomsSearchResult;
	}
	
	public  void setAvailableRoomsSearchResult(List<Room> availableRoomsSearchResult) {
		this.availableRoomsSearchResult = availableRoomsSearchResult;
	}   */
	
	
	

	public String getStrBookingID() {
		return strBookingID;
	}
	
	public  void setStrBookingID(String strBookingID) {
		this.strBookingID = strBookingID;
	}

	public void setStrBookingNumber(String strBookingID) {
		this.strBookingID = strBookingID;
	}

	public Integer getBookingID() {
		return bookingID;
	}

	public void setBookingNumber(Integer bookingID) {
		this.bookingID = bookingID;
	}
	
	public Integer getClientID() {
		return clientID;
	}

	public void setClientID(Integer clientID) {
		this.clientID = clientID;
	}

	public String getStrClientID() {
		return strClientID;
	}

	public void setStrClientID(String strClientID) {
		this.strClientID = strClientID;
	}
	
	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public String getStrRoomNumber() {
		return strRoomNumber;
	}

	public void setStrRoomNumber(String strRoomNumber) {
		this.strRoomNumber = strRoomNumber;
	}
	
	public Float getBookingPrice() {
		return this.bookingPrice;
	}

	public void setBookingPrice(Float bookingPrice) {
		this.bookingPrice = bookingPrice;
	}
	
	
	public String getStrBookingPrice() {
		return this.strBookingPrice;
	}

	public void setStrBookingPrice(String strBookingPrice) {
		this.strBookingPrice = strBookingPrice;
	}
	
	
	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	
	public String getBookingStartDate() {
		return bookingStartDate;
	}

	public void setBookingStartDate(String bookingStartDate) {
		this.bookingStartDate = bookingStartDate;
	}
	
	public String getBookingEndDate() {
		return bookingEndDate;
	}

	public void setBookingEndDate(String bookingEndDate) {
		this.bookingEndDate = bookingEndDate;
	}

	public String getBookingNotes() {
		return bookingNotes;
	}

	public void setBookingNotes(String bookingNotes) {
		this.bookingNotes = bookingNotes;
	}
	
	public String getIsActive() {
		if (isActive == true)
		    return "y";
		else return "n";
	}

	public void setIsActive(String strIsActive) {
		if (strIsActive.equals("y"))
		    this.isActive = true;
		else if (strIsActive.equals("n"))
			this.isActive = false;
	}
	
	public String getstrIsActive() {
		return strIsActive;
	}

	public void setstrIsActive(String strIsActive) {
		this.strIsActive = strIsActive;
	}



	public boolean validate() {
		boolean ret = true;
		
		try {
			bookingID = Integer.parseInt(strBookingID);		
		} catch (NumberFormatException nfe) {
			ret = false;
			errors.put("bookingID", "Please enter an integer number");
		}
		
		/*
		try {
			clientID = Integer.parseInt(strClientID);		
		} catch (NumberFormatException nfe) {
			ret = false;
			errors.put("clientID", "Please enter a client ID");
		}    */
		
		/*
		if (strClientID.equals("")) {
			//ret = false;
			//clientID = 0;
			errors.put("bookingDate", "");
		} else {  */
		
		if (strClientID != "" && strClientID != null) {
			try {		
			   clientID = Integer.parseInt(strClientID);		
		    } catch (NumberFormatException nfe) {
			   //ret = false;
			   //errors.put("clientID", "Please enter a client ID");
		    }
	    
	    }
		
		
		  try {
		    	roomNumber = new Integer(Integer.parseInt(strRoomNumber));		
		  } catch (NumberFormatException nfe) {
			ret = false;
			errors.put("roomNumber", "Please enter a room number");
			
			System.out.println("strBookingID is "+strBookingID);
			System.out.println("bookingDate is "+bookingDate);
			System.out.println("bookingStartDate is "+bookingStartDate);
			System.out.println("bookingEndDate is "+bookingEndDate);
			System.out.println("strClientID is "+strClientID);
			System.out.println("strroomNumber is "+strRoomNumber);
			System.out.println("bookingNotes is "+bookingNotes);
			System.out.println("strIsActive is "+strIsActive);
			
		  }
		
		
		
		if (roomNumber != null && !isRoomExist(roomNumber.intValue()))	{	
		
			ret = false;
			errors.put("roomNumber", "This room number does not exist!");
		}
		
		if (strIsActive == null ) 
		{
			ret = false;
			errors.put("isActive", "Please enter y/n");
		}
		else if (strIsActive.equals("y")) {
			isActive = true;		
		} else if (strIsActive.equals("n")) {
			isActive = false;
		}
			
		

		if (bookingDate.equals("")) {
			ret = false;
			errors.put("bookingDate", "Please enter a booking date");
		}
		
		if (bookingStartDate.equals("")) {
			ret = false;
			errors.put("bookingStartDate", "Please enter a booking date");
		}
		
		if (bookingEndDate.equals("")) {
			ret = false;
			errors.put("bookingEndDate", "Please enter a booking date");
		}
		
		BookingServiceLocator sl = new BookingServiceLocator();	
		System.out.println("in bookingjavabean.java validate(),BookingControllerServlet.datepicker1 is "+BookingControllerServlet.datepicker1);
		List<Room> AvailableRoomsSearchResult = sl.getAllAvailableRooms(BookingControllerServlet.datepicker1,BookingControllerServlet.datepicker2);
			
		if (AvailableRoomsSearchResult == null && strRoomNumber != null) {
			System.out.println("in bookingjavabean.java validate(),AvailableRoomsSearchResult is "+AvailableRoomsSearchResult);
			System.out.println("in bookingjavabean.java validate(),strRoomNumber is "+strRoomNumber);
			
			ret = false;
			errors.put("roomNumber", "No room available for this booking!");
		}
		
		if (AvailableRoomsSearchResult != null && strRoomNumber != null) {
			if (!isRoomNumberInAvailableRoomsSearchResult(AvailableRoomsSearchResult,strRoomNumber)) {
				System.out.println("in bookingjavabean.java validate(),availableRoomsSearchResult is "+AvailableRoomsSearchResult);
				System.out.println("in bookingjavabean.java validate(),strRoomNumber is "+strRoomNumber);
				ret = false;
			    errors.put("roomNumber", "This room can't be booked for this period!");
			}
		}
		
		
		
		try {
			bookingPrice = Float.valueOf(strBookingPrice);		
		} catch (NumberFormatException nfe) {
			ret = false;
			System.out.println("Booking price is wrong.");
			//errors.put("bookingID", "Please enter an integer number");
		}
		
		
		
		return ret;
	}
	
	
	//only for Booking update,so no need to check if a room is in a list of available rooms
	public boolean validateForUpdateBooking() {
		
        boolean ret = true;
		
		try {
			bookingID = Integer.parseInt(strBookingID);		
		} catch (NumberFormatException nfe) {
			ret = false;
			errors.put("bookingID", "Please enter an integer number");
		}
		
		/*
		try {
			clientID = Integer.parseInt(strClientID);		
		} catch (NumberFormatException nfe) {
			ret = false;
			errors.put("clientID", "Please enter a client ID");
		}    */
		
		/*
		if (strClientID.equals("")) {
			//ret = false;
			//clientID = 0;
			errors.put("bookingDate", "");
		} else {  */
		
		if (strClientID != "" && strClientID != null) {
			try {		
			   clientID = Integer.parseInt(strClientID);		
		    } catch (NumberFormatException nfe) {
			   //ret = false;
			   //errors.put("clientID", "Please enter a client ID");
		    }
	    
	    }
		
		
		  try {
		    	roomNumber = new Integer(Integer.parseInt(strRoomNumber));		
		  } catch (NumberFormatException nfe) {
			ret = false;
			errors.put("roomNumber", "Please enter a room number");
			
			System.out.println("strBookingID is "+strBookingID);
			System.out.println("bookingDate is "+bookingDate);
			System.out.println("bookingStartDate is "+bookingStartDate);
			System.out.println("bookingEndDate is "+bookingEndDate);
			System.out.println("strClientID is "+strClientID);
			System.out.println("strroomNumber is "+strRoomNumber);
			System.out.println("bookingNotes is "+bookingNotes);
			System.out.println("strIsActive is "+strIsActive);
			
		  }
		
		
		
		if (roomNumber != null && !isRoomExist(roomNumber.intValue()))	{	
		
			ret = false;
			errors.put("roomNumber", "This room number does not exist!");
		}
		
		if (strIsActive == null ) 
		{
			ret = false;
			errors.put("isActive", "Please enter y/n");
		}
		else if (strIsActive.equals("y")) {
			isActive = true;		
		} else if (strIsActive.equals("n")) {
			isActive = false;
		}
			
		

		if (bookingDate.equals("")) {
			ret = false;
			errors.put("bookingDate", "Please enter a booking date");
		}
		
		if (bookingStartDate.equals("")) {
			ret = false;
			errors.put("bookingStartDate", "Please enter a booking date");
		}
		
		if (bookingEndDate.equals("")) {
			ret = false;
			errors.put("bookingEndDate", "Please enter a booking date");
		}
		
		try {
			bookingPrice = Float.valueOf(strBookingPrice);		
		} catch (NumberFormatException nfe) {
			ret = false;
			System.out.println("Booking price is wrong.");
			//errors.put("bookingID", "Please enter an integer number");
		}

		
		return ret;
		
	}
	
	public boolean isRoomExist(int roomNumber) {
		List<Room> roomList = RoomServiceLocator.listRooms();
		boolean isRoomExist = false;
		for (Room b : roomList) {
			if (b.getRoomNumber().equals(roomNumber)){
				isRoomExist = true;
			}
		}
		return isRoomExist;
	}
	
	public String getErrorMsg(String s) {
		String errorMsg = errors.get(s.trim());
		return (errorMsg == null) ? "" : errorMsg;
	}
	
	public boolean isRoomNumberInAvailableRoomsSearchResult(List<Room> availableRoomsSearchResult,String strRoomNumber) {
		RoomServiceLocator sl = new RoomServiceLocator();	
		Room r = sl.getRoom(Integer.parseInt(strRoomNumber));
		boolean found= false;
		for (Room temp : availableRoomsSearchResult) {
			if (temp.getRoomNumber().intValue() == r.getRoomNumber().intValue()) {
				found = true;
			}
		}
		return found;
		
	}
	
	/*
	public boolean isClientNumberInCurrentClientTable(List<Room> availableRoomsSearchResult,String strRoomNumber) {
		RoomServiceLocator sl = new RoomServiceLocator();	
		Room r = sl.getRoom(Integer.parseInt(strRoomNumber));
		boolean found= false;
		for (Room temp : availableRoomsSearchResult) {
			if (temp.getRoomNumber().intValue() == r.getRoomNumber().intValue()) {
				found = true;
			}
		}
		return found;
		
	}  */

	/*
	@Override
	public String toString() {
		return "The price for this Booking is = " + price;
	}   */
	
}

