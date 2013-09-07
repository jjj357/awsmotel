package cs.tutorial.bs.entity;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.lang.Float;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Room
 * 
 */


@Entity
public class Room implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer roomNumber;
	private String roomName;
	private Float price;
	private String description;
	private Integer roomTypeID;


	public Room() {
		super();
	}

	public Room(Integer roomNumber) {
		super();
		this.roomNumber = roomNumber;

	}
	
	public Room(Integer roomNumber, String roomName, Float price) {
		super();
		this.roomNumber = roomNumber;
		this.roomName = roomName;
		this.price = price;
	}

	public Integer getRoomNumber() {
		return this.roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getRoomName() {
		return this.roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
	
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getRoomTypeID() {
		return this.roomTypeID;
	}

	public void setRoomTypeID(Integer roomTypeID) {
		this.roomTypeID = roomTypeID;
	}

	/*
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}  

	public static byte[] ImageToByte(File file) throws FileNotFoundException {
		FileInputStream fis = new FileInputStream(file);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] buf = new byte[1024];
		try {
			for (int readNum; (readNum = fis.read(buf)) != -1;) {
				bos.write(buf, 0, readNum);
				System.out.println("read " + readNum + " bytes,");
			}
		} catch (IOException ex) {
		}
		byte[] bytes = bos.toByteArray();

		return bytes;
	}   */

}


