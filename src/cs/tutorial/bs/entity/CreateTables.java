package cs.tutorial.bs.entity;

import java.io.File;
import java.io.FileNotFoundException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class CreateTables {

	public static void main(String[] args) throws FileNotFoundException {

		
		//create tables in database
		Configuration config = new Configuration();

		config.addAnnotatedClass(cs.tutorial.bs.entity.Room.class);
		config.configure();

		new SchemaExport(config).create(true, true);

		SessionFactory factory = config.buildSessionFactory();
		Session current = factory.getCurrentSession();

		current.beginTransaction();
		Room r = new Room();
		r.setRoomNumber(101);
		r.setRoomName("test");
		r.setPrice(20.00f);
		r.setDescription("This is the nicest room: It has ...");
		r.setRoomTypeID(1);
		current.save(r);
		///////////////////////////////////
		Client  c = new Client();
		c.setClientID(1);
		c.setFirstName("jack");
		c.setLastName("layton");
		c.setEmail("jack.layton@yahoo.com");
		c.setPhoneNumber("4167654567");
		c.setAddress("123 Yonge Street,Toronto,Canada,M2J3T4");
		current.save(c);
		////////////////////////////////////
		Booking  b = new Booking();
		b.setBookingID(1);
		b.setBookingDate("20121101");
		b.setBookingStartDate("20121201");
		b.setBookingEndDate("20121221");
		b.setRoomNumber(101);
		b.setClientID(1);
		b.setBookingPrice(400.00f);
		b.setBookingNotes("This customer is looking for a job");
		b.setIsActive("TRUE");
		current.save(b);
		////////////////////////////////////
		User  b1 = new User();
		b1.setUserID(1);
		b1.setUsername("Jack");
		b1.setUserRealName("Jack Tom");
		b1.setPassword("999999999");
		b1.setSecurityQuestion("which country were you born in?");
		b1.setSecurityAnswer("canada");
		b1.setEmail("jacktom@gmail.com");
		b1.setPhoneNumber("4167898909");
		current.save(b1);
		//////////////////////////////////////////
		RoomType  t1 = new RoomType();
		t1.setRoomTypeID(1);
		t1.setRoomTypeName("1 bed");
		t1.setRoomTypeDescription("1 bed in the room,1 washroom,free tv and wifi");
		current.save(t1);
		
		RoomType  t2 = new RoomType();
		t2.setRoomTypeID(2);
		t2.setRoomTypeName("2 beds");
		t2.setRoomTypeDescription("2 beds in the room,1 washroom,free tv and wifi");
		current.save(t2);
		
		RoomType  t3 = new RoomType();
		t3.setRoomTypeID(3);
		t3.setRoomTypeName("3 beds");
		t3.setRoomTypeDescription("3 beds in the room,1 washroom,free tv and wifi");
		current.save(t3);
		
		RoomType  t4 = new RoomType();
		t4.setRoomTypeID(4);
		t4.setRoomTypeName("4 beds");
		t4.setRoomTypeDescription("4 beds in the room,2 washroom,free tv and wifi");
		current.save(t4);
		
		
		//////////////////////////////////////////
		
		current.getTransaction().commit();
        current.close();
 


	}

}