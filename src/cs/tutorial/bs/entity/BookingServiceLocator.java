package cs.tutorial.bs.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import cs.tutorial.bs.entity.Booking;
import cs.tutorial.bs.entity.Booking;
import cs.tutorial.bs.entity.Client;



public class BookingServiceLocator {

	public Boolean saveBooking(Booking r) {
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
			session.close();
		}
		return b;
	}
	
	public Boolean updateBooking(Booking r) {
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
			session.close();
		}
		return b;
	}

	public static List<Room> listRooms() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
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

	public Booking getBooking(int bookingID) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query q =  session
					.createQuery("SELECT r FROM Booking r WHERE r.bookingID = :bookingID");
			q.setParameter("bookingID", bookingID);
			List<Booking> lr = (List<Booking>) q.list();
			transaction.commit();
			session.close();
			if (lr.isEmpty()) 
				return null;
			else
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
	
	public boolean isBookingNumberValid(int bookingID) {
		boolean found = false;
		
		List<Booking> listBookings = listAllBookings();
		for (Booking r : listBookings) {
			if (r.getBookingID() == bookingID) {
				found = true;
				break;
			}
		}
		return found;
	}
	
	public List<Integer> getBookingNumbers() {
		int index = 0;
		List<Integer> li = new ArrayList<Integer>(10);
		List<Booking> listBookings = listAllBookings();
		for (Booking r : listBookings) {
			li.add(index, r.getBookingID());
			index++;
		}
		
		return li;
	}
	
	public boolean removeBooking(int bookingID) {
		boolean remove = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query q =  session
					.createQuery("DELETE Booking r WHERE r.bookingID = :bookingID");
			q.setParameter("bookingID", bookingID);
			int val = q.executeUpdate();
			System.out.println("_______REMOVE_______________" + val);
			transaction.commit();
			session.close();
			if (val != 0) 
				remove = true;
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
	
	public Booking setBookingInactive(int bookingID) {
		//Booking r = null;
		Booking b = getBooking(bookingID);
		b.setIsActive("n");
		
		/*
		r = new Booking();
		r.setBookingID(b.getBookingID());
		r.setBookingDate(b.getBookingDate());
		r.setBookingStartDate(b.getBookingStartDate());
		r.setBookingEndDate(b.getBookingEndDate());
		r.setClientID(b.getClientID());
		r.setRoomNumber(b.getRoomNumber());			
		r.setBookingNotes(b.getBookingNotes());			
		r.setIsActive("n");  */

		BookingServiceLocator sl = new BookingServiceLocator();
		if (!sl.updateBooking(b))
			b = null;
		
		return b;
	}
	
	public List<Booking> getBookings(int max, int index) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query q = session.createQuery("from Booking");

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
	
	public List<Room> getAllAvailableRooms(String fromDate, String toDate) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			
			List<Room> roomList = listRooms();
			List<Booking> bookingList = listActiveBookings();
			System.out.println("In RoomServiceLocator.getAllavailablerooms(), all rooms list are--- " + roomList);
			System.out.println("In RoomServiceLocator.getAllavailablerooms(), line 232, fromDate is--- " + fromDate);
			
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
			
			session.close();
			return roomList;
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			session.close();
			return null;
		} finally {
			if (session.isOpen())	
			session.close();
		}
	}//end of getAllAvailableRooms()
}
