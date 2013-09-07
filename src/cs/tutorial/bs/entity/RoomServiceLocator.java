package cs.tutorial.bs.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import cs.tutorial.bs.entity.Room;
import cs.tutorial.bs.entity.Booking;
import cs.tutorial.bs.entity.Client;



public class RoomServiceLocator {


	public Boolean saveRoom(Room r) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Boolean b = false;
		try {
			transaction = session.beginTransaction();
			session.save(r);  
			transaction.commit();
			b = true;
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			if (session.isOpen())	
			session.close();
		}
		return b;
	}
	
	public Boolean updateRoom(Room r) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Boolean b = false;
		try {
			transaction = session.beginTransaction();
			session.update(r);  
			transaction.commit();
			b = true;
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			if (session.isOpen())	
			session.close();
		}
		return b;
	}

	public static List<Room> listRooms() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Room> rooms = 
					(List<Room>) session.createQuery("from Room").list();
			transaction.commit();
			session.close();
			return rooms;
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			session.close();
			return null;
		} finally {
			if (session.isOpen())		
		        session.close();
		}
	}
	
	//only list active bookings
	public List<Booking> listActiveBookings() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			List<Booking> bookings = 
					(List<Booking>) session.createQuery("from Booking b where b.isActive = 'TRUE'").list();
			transaction.commit();
			session.close();
			return bookings;
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			session.close();
			return null;
		} finally {
			if (session.isOpen())	
			session.close();
		}
	}
	
	//list all active and inactive(cancelled) bookings
	public List<Booking> listAllBookings() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			List<Booking> bookings = 
					(List<Booking>) session.createQuery("from Booking").list();
			transaction.commit();
			session.close();
			return bookings;
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			session.close();
			return null;
		} finally {
			if (session.isOpen())	
			session.close();
		}
	}
	
	
		//list all clients
	public List<Client> listAllClients() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			List<Client> clients = 
					(List<Client>) session.createQuery("from Client").list();
			transaction.commit();
			session.close();
			return clients;
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			session.close();
			return null;
		} finally {
			if (session.isOpen())	
			session.close();
		}
	}
	
	//list all users
public List<User> listAllUsers() {
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction transaction = null;
	try {
		transaction = session.beginTransaction();
		List<User> users = 
				(List<User>) session.createQuery("from User").list();
		transaction.commit();
		session.close();
		return users;
	} catch (HibernateException e) {
		transaction.rollback();
		e.printStackTrace();
		session.close();
		return null;
	} finally {
		if (session.isOpen())	
		session.close();
	}
}

public Boolean saveUser(User r) {
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction transaction = null;
	Boolean b = false;
	try {
		transaction = session.beginTransaction();
		session.save(r);  
		transaction.commit();
		b = true;
	} catch (HibernateException e) {
		transaction.rollback();
		e.printStackTrace();
	} finally {
		if (session.isOpen())	
		session.close();
	}
	return b;
}

	public Room getRoom(int roomNumber) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query q =  session
					.createQuery("SELECT r FROM Room r WHERE r.roomNumber = :roomNumber");
			q.setParameter("roomNumber", roomNumber);
			List<Room> lr = (List<Room>) q.list();
			transaction.commit();
			if (lr.isEmpty()) {
				session.close();
				return null;
		    } else
				return lr.get(0);
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			session.close();
			return null;
		} finally {
			if (session.isOpen())	
			session.close();
		}
	}
	
	public boolean isRoomNumberValid(int roomNumber) {
		boolean found = false;
		
		List<Room> listRooms = listRooms();
		for (Room r : listRooms) {
			if (r.getRoomNumber() == roomNumber) {
				found = true;
				break;
			}
		}
		return found;
	}
	
	public List<Integer> getRoomNumbers() {
		int index = 0;
		List<Integer> li = new ArrayList<Integer>(10);
		List<Room> listRooms = listRooms();
		for (Room r : listRooms) {
			li.add(index, r.getRoomNumber());
			index++;
		}
		
		return li;
	}
	
	public boolean removeRoom(int roomNumber) {
		boolean remove = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query q =  session
					.createQuery("DELETE Room r WHERE r.roomNumber = :roomNumber");
			q.setParameter("roomNumber", roomNumber);
			int val = q.executeUpdate();
			System.out.println("_______REMOVE_______________" + val);
			transaction.commit();
			if (val != 0) 
				remove = true;
			session.close();
			return remove;
		} catch (HibernateException e) {
			transaction.rollback();
			session.close();
			return false;
		} finally {
			if (session.isOpen())	
			session.close();
		}
	}
	
	public List<Room> getRooms(int max, int index) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query q = session.createQuery("from Room");

			transaction.commit();
			
			session.close();
			return q.setMaxResults(max).setFirstResult(index).list();			
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			session.close();
			return null;
		} finally {
			if (session.isOpen())	
			session.close();
		}
	}
	
	//Get all rooms that are occupied now
	public List<Room> getOccupiedRooms() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query q = session.createQuery("from Booking b where b.isActive = 'TRUE'");

			transaction.commit();
			
			List<Booking> occupiedBookingList = (List<Booking>) q.list();
			
			System.out.println("in room locator class,occupiedBookingList " + occupiedBookingList);
			
			List<Room> roomList = new ArrayList<Room>();
			
			//get today's date in string format "yyyyMMdd"
			//Date now = new Date();
			//String dateString = now.toString();
			//SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			//Date parsed = format.parse(dateString);
			//String todayDateString = parsed.toString();
			/*
			   Date today = new Date();
			   int dd = Integer.parseInt(today.getDate());
			   int mm = Integer.parseInt(today.getMonth())+1; //January is 0!

			   String yyyy = today.getYear().toString();
			   if(dd<10){dd =Integer.parseInt('0'+(new Integer(dd)).toString());
			   if(mm<10){mm=Integer.parseInt('0'+(new Integer(mm)).toString());
			   String todayDateString = yyyy + (new Integer(mm)).toString() + (new Integer(dd)).toString();
			   */
			   
			   Calendar cal = Calendar.getInstance();
			   String DATE_FORMAT_NOW = "yyyyMMdd";
			   SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
			   String todayDateString = sdf.format(cal.getTime());
			   
			   System.out.println("in room locator class,todayDateString is " + todayDateString);
			   
			for (Booking r : occupiedBookingList){
				System.out.println("in booking loop");
				System.out.println("r.getBookingStartDate() is " + r.getBookingStartDate());
				
				System.out.println("r.getBookingEndDate() is " + r.getBookingEndDate());
				System.out.println("Integer.parseInt(r.getBookingStartDate()) is " + Integer.parseInt(r.getBookingStartDate()));
				System.out.println("Integer.parseInt(todayDateString) is " + Integer.parseInt(todayDateString));
			   
				if (Integer.parseInt(r.getBookingStartDate().trim()) <= Integer.parseInt(todayDateString.trim())  && Integer.parseInt(r.getBookingEndDate().trim()) >= Integer.parseInt(todayDateString.trim())) {
				   System.out.println("inside the if statemen");
				   roomList.add(getRoom(r.getRoomNumber().intValue()));
				   System.out.println("room locator class line 282, add room statement,getRoom(r.getRoomNumber()) is " + getRoom(r.getRoomNumber()));
			   }
			   System.out.println("in room locator class line 282,roomList is " + roomList);
			}
			   
			
			if (roomList.isEmpty()) 
				return null;
			else
				return roomList;
			
				
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			return null;
		} finally {
			if (session.isOpen())	
			session.close();
		}
	}
	
	    //Get all rooms that are ordered now
		public List<Room> getOrderedRooms() {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = null;
			try {
				transaction = session.beginTransaction();
				Query q = session.createQuery("from Booking b where b.isActive = 'TRUE'");

				transaction.commit();
				
				List<Booking> occupiedBookingList = (List<Booking>) q.list();
				
				System.out.println("in room locator class,occupiedBookingList " + occupiedBookingList);
				
				List<Room> roomList = new ArrayList<Room>();				
				   
				   Calendar cal = Calendar.getInstance();
				   String DATE_FORMAT_NOW = "yyyyMMdd";
				   SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
				   String todayDateString = sdf.format(cal.getTime());
				   
				   System.out.println("in room locator class,todayDateString is " + todayDateString);
				   
				for (Booking r : occupiedBookingList){
					System.out.println("in booking loop");
					System.out.println("r.getBookingStartDate() is " + r.getBookingStartDate());
					
					System.out.println("r.getBookingEndDate() is " + r.getBookingEndDate());
					System.out.println("Integer.parseInt(r.getBookingStartDate()) is " + Integer.parseInt(r.getBookingStartDate()));
					System.out.println("Integer.parseInt(todayDateString) is " + Integer.parseInt(todayDateString));
				   
					//if (Integer.parseInt(r.getBookingStartDate().trim()) <= Integer.parseInt(todayDateString.trim())  && Integer.parseInt(r.getBookingEndDate().trim()) >= Integer.parseInt(todayDateString.trim())) {
					   System.out.println("inside the if statemen");
					   roomList.add(getRoom(r.getRoomNumber().intValue()));
					   System.out.println("room locator class line 335, add room statement,getRoom(r.getRoomNumber()) is " + getRoom(r.getRoomNumber()));
				   //}
				   System.out.println("in room locator class line 337,roomList is " + roomList);
				}
				   
				
				if (roomList.isEmpty()) 
					return null;
				else
					return roomList;
				
					
			} catch (HibernateException e) {
				transaction.rollback();
				e.printStackTrace();
				return null;
			} finally {
				if (session.isOpen())	
				session.close();
			}
		}//end of getOrderedRooms()
	
	public List<Room> getAllAvailableRooms(String fromDate, String toDate) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			
			List<Room> roomList = listRooms();
			List<Booking> bookingList = listActiveBookings();
			System.out.println("In RoomServiceLocator.getAllavailablerooms(), all rooms list are--- " + roomList);
			System.out.println("In RoomServiceLocator.getAllavailablerooms(), fromDate is--- " + fromDate);
			
			String delims = "/";
			String[] data1 = fromDate.split(delims);       
			String year1 = data1[2];
			String month1 = data1[0];  
			String day1 = data1[1];  
			String newFromDate = year1.concat(month1).concat(day1);
						
			String[] data2 = toDate.split(delims); 
			String year2 = data2[2];    
			String month2 = data2[0];   
			String day2 = data2[1];     
			String newToDate = year2.concat(month2).concat(day2);
			
			System.out.println("before query commit, all rooms list are--- " + roomList);
			
			if (bookingList != null) {
			   for (Booking b : bookingList) {
				   System.out.println("in RoomServiceLocator, booking start date is --- " + b.getBookingStartDate());
				   System.out.println("in RoomServiceLocator, booking end date is --- " + b.getBookingEndDate());
				   System.out.println("in RoomServiceLocator, new from date is --- " + newFromDate);
				   System.out.println("in RoomServiceLocator, new to date is --- " + newToDate);
				   
				   if (Integer.parseInt(b.getBookingStartDate())>=  Integer.parseInt(newFromDate)  && Integer.parseInt(b.getBookingStartDate())<Integer.parseInt(newToDate)) {
					   for (int i = 0;i<roomList.size();i++){
						   if (roomList.get(i).getRoomNumber().equals(b.getRoomNumber())) {
							   roomList.remove(i);						   
					           //roomList.remove(getRoom(b.getRoomNumber()));
					           System.out.println("inside 1st if");
						   }
					   }
				   }				 
				   else if (Integer.parseInt(b.getBookingStartDate())<=  Integer.parseInt(newFromDate)  && Integer.parseInt(b.getBookingEndDate()) >= Integer.parseInt(newToDate)) {
					   for (int i = 0;i<roomList.size();i++){
						   if (roomList.get(i).getRoomNumber().equals(b.getRoomNumber())) {
							   roomList.remove(i);						   
					           //roomList.remove(getRoom(b.getRoomNumber()));
					           System.out.println("inside 2nd if");
						   }
					   }
				   }
				   else if (Integer.parseInt(b.getBookingStartDate())>=  Integer.parseInt(newFromDate)  && Integer.parseInt(b.getBookingEndDate()) <= Integer.parseInt(newToDate)) {
					   for (int i = 0;i<roomList.size();i++){
						   if (roomList.get(i).getRoomNumber().equals(b.getRoomNumber())) {
							   roomList.remove(i);						   
					           //roomList.remove(getRoom(b.getRoomNumber()));
					           System.out.println("inside 3rd if");
						   }
					   }
				   }
				   else if (Integer.parseInt(b.getBookingEndDate()) > Integer.parseInt(newFromDate)  && Integer.parseInt(b.getBookingEndDate())<=Integer.parseInt(newToDate)) {
					   System.out.println("in 4th if, before remove,all rooms list size is--- " + roomList.size());
					   
					   for (int i = 0;i<roomList.size();i++){
						   if (roomList.get(i).getRoomNumber().equals(b.getRoomNumber())) {
						   System.out.println("roomList.get(i).getRoomNumber() is " + roomList.get(i).getRoomNumber());
						   System.out.println("b.getRoomNumber() is " + b.getRoomNumber());
							   roomList.remove(i);
							   System.out.println("inside 4th if-for-loop,room number is " + b.getRoomNumber());
							   System.out.println("i is " + i);
						   }
					   }
					   
					   //roomList.remove(getRoom(b.getRoomNumber()));
					   System.out.println("in 4th if,after remove, all rooms list are--- " + roomList);
					   System.out.println("inside 4th if");
				   }
			   }
			}
			
			   /*
			Query q1 = session.createSQLQuery("SELECT * FROM Booking b WHERE cast(b.bookingStartDate as int)>= cast(:newFromDate as int)  AND cast(b.bookingStartDate as int) <= cast(:newToDate as int)");
			transaction.commit();
			System.out.println("after query q1 commit, all rooms list are--- " + roomList);
			System.out.println("after query q1 commit, q1 list are--- " + (List<Booking>)q1.list());
			
			Query q2 = session.createQuery("SELECT b FROM Booking b WHERE ( STRCMP(b.bookingEndDate,:newFromDate ) >= 0 AND STRCMP(b.bookingEndDate,:newToDate) <= 0)");
			transaction.commit();			
			System.out.println("after query q2 commit, q2 list are--- " + (List<Booking>)q2.list());
			
			if ((List<Booking>)q1.list() != null) {
			for (Booking b : (List<Booking>)q1.list()) {
				roomList.remove(getRoom(b.getRoomNumber()));
			}
			}
			System.out.println("after remove q1, all rooms list are--- " + roomList);
			
			if ((List<Booking>)q2.list() != null) {
			for (Booking b : (List<Booking>)q2.list()) {
				roomList.remove(getRoom(b.getRoomNumber()));
			}
			}   */
			   
			System.out.println("after for loop, all rooms list are--- " + roomList);
			
			
			return roomList;
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			return null;
		} finally {
			if (session.isOpen())	
			session.close();
		}
	}//end of getAllAvailableRooms()
	
	public int daysBetween (Date d1,Date d2){
	    return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
	}
	
}
