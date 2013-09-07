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

@Entity
public class RoomType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer roomTypeID;
	private String roomTypeName;
	private String roomTypeDescription;



	public RoomType() {
		super();
	}

	public RoomType(Integer roomTypeID) {
		super();
		this.roomTypeID = roomTypeID;

	}
	
	public RoomType(Integer roomTypeID, String roomTypeName, String roomTypeDescription) {
		super();
		this.roomTypeID = roomTypeID;
		this.roomTypeName = roomTypeName;
		this.roomTypeDescription = roomTypeDescription;
	}

	public Integer getRoomTypeID() {
		return this.roomTypeID;
	}

	public void setRoomTypeID(Integer roomTypeID) {
		this.roomTypeID = roomTypeID;
	}
	
	public String getRoomTypeName() {
		return this.roomTypeName;
	}

	public void setRoomTypeName(String roomTypeName) {
		this.roomTypeName = roomTypeName;
	}
	
	public String getRoomTypeDescription() {
		return this.roomTypeDescription;
	}

	public void setRoomTypeDescription(String roomTypeDescription) {
		this.roomTypeDescription = roomTypeDescription;
	}
	
	
}
