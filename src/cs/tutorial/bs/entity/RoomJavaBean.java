package cs.tutorial.bs.entity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;


public class RoomJavaBean {
	
	private Float price;
	private String strPrice;
	
	private Integer roomNumber;
	private String strRoomNumber;
	
	private String roomName;
	private String description;
	private Integer roomTypeID;
	private String strRoomTypeID;
	//private String fileName;
	
	private Hashtable<String, String> errors;
	
	public RoomJavaBean() {
		strPrice = "";
		strRoomNumber = "";
		roomName = "";
		description = "";
		//fileName ="";
		errors = new Hashtable<String, String>();
	}

	public String getStrRoomNumber() {
		return strRoomNumber;
	}

	public void setStrRoomNumber(String strRoomNumber) {
		this.strRoomNumber = strRoomNumber;
	}

	public String getStrPrice() {
		return strPrice;
	}

	public void setStrPrice(String strPrice) {
		this.strPrice = strPrice;
	}
	
	public Float getPrice() {
		return price;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getRoomTypeID() {
		return roomTypeID;
	}

	public void setRoomTypeID(Integer  roomTypeID) {
		this.roomTypeID = roomTypeID;
	}
	
	public String getStrRoomTypeID() {
		return strRoomTypeID;
	}

	public void setStrRoomTypeID(String  strRoomTypeID) {
		this.strRoomTypeID = strRoomTypeID;
	}

	
	/*
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}   */

	public void setPrice(Float price) {
		this.price = price;
	}

	public boolean validate() {
		boolean ret = true;
		
		try {
			roomNumber = Integer.parseInt(strRoomNumber);		
		} catch (NumberFormatException nfe) {
			ret = false;
			errors.put("roomNumber", "Please enter an integer number");
		}
		
		if (roomName.equals("")) {
			ret = false;
			errors.put("roomName", "Please enter a room name");
		}
		
		if (description.equals("")) {
			ret = false;
			errors.put("description", "Please enter a description");
		}

		
		try {
			roomTypeID = Integer.parseInt(strRoomTypeID);		
		} catch (NumberFormatException nfe) {
			ret = false;
			errors.put("roomTypeID", "Please choose a room type");
		}
		
		try {
			price = Float.parseFloat(strPrice);			
		} catch (NumberFormatException nfe) {
			ret = false;
			errors.put("price", "Please enter a decimal number (xx.yy)");
		}
		
		/*
		File f = new File("",fileName);
		if (!f.exists()) {
			ret = false;
			errors.put("fileName", "Please enter a valid file name");
		}    */
			
		return ret;
	}
	
	public String getErrorMsg(String s) {
		String errorMsg = errors.get(s.trim());
		return (errorMsg == null) ? "" : errorMsg;
	}

	@Override
	public String toString() {
		return "The price for this room is = " + price;
	}
	
}
