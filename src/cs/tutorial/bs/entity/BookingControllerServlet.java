package cs.tutorial.bs.entity;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import cs.tutorial.bs.entity.BookingJavaBean;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import servlet.pkg.String;

//import servlet.pkg.String;

import cs.tutorial.bs.entity.Booking;

/**
 * Servlet implementation class ActionServlet
 */
//@WebServlet("/BookingControllerServlet")
public class BookingControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String datepicker1,datepicker2;

	Integer bookingNumber = null;
	Booking booking = null;
	List<Booking> listBookings = null;
	boolean result = false;

	public BookingControllerServlet() {
		super();  
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		dispatch(request, response);  
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		dispatch(request, response);
	}

	protected void dispatch(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		// take the request params
		String process = req.getParameter("process");
		String bookingId = req.getParameter("bookingId");
		//System.out.println("BookingServlet START ---  process is " + process);
		System.out.println("BookingServlet START ---  bookingId is " + bookingId);
/*		if (process == null)
			process = (String) req.getAttribute("process");
		if (bookingId == null)
			bookingId = (String) req.getAttribute("bookingId");*/
		
		if (process == null) {
			process = (String) req.getSession().getAttribute("process");
		} else {
			req.getSession().setAttribute("process",process);			
		}
		
		if (bookingId == null) {
			bookingId = (String) req.getSession().getAttribute("bookingId");
		} else {
			req.getSession().setAttribute("bookingId",bookingId);	
		}
		
		System.out.println("In booking servlet, after getAttribute --- bookingId is " + bookingId);
		System.out.println("In booking servlet, after getAttribute --- process is " + (process==null?"":process));
		 //public static String addbooking1 = req.getParameter("button_addbooking1");
		 //public static String addbooking2 = req.getParameter("button_addbooking2");
		
		datepicker1 = req.getParameter("datepicker1");
		datepicker2 = req.getParameter("datepicker2");
		
		if (datepicker1 == null)
			datepicker1 = (String) req.getAttribute("datepicker1");
		if (datepicker2 == null)
			datepicker2 = (String) req.getAttribute("datepicker2");
		System.out.println("in booking servlet, datepicker1 is " + datepicker1);
		System.out.println("in booking servlet, datepicker2 is " + datepicker2);
		/*
		//check if a button in index page was clicked
		String indexpage_button_bookabooking = req.getParameter("bookabooking");
		String indexpage_button_cancelabooking = req.getParameter("cancelabooking");
		String indexpage_button_editabooking = req.getParameter("editabooking");
		String indexpage_button_editbooking = req.getParameter("editbooking");
		String indexpage_button_editbookingtype = req.getParameter("editbookingtype");
		String indexpage_button_editpenalty = req.getParameter("editpenalty");
		String indexpage_button_editclient = req.getParameter("editclient");
		String indexpage_button_getallbookingsandstatus = req.getParameter("getallbookingsandstatus");
		String indexpage_button_getfreebookingsforaperiod = req.getParameter("getfreebookingsforaperiod");
		String indexpage_button_getbookingsmeetingacriteria = req.getParameter("getbookingsmeetingacriteria");
		
		
		String bookingId = req.getParameter("textfield_editbooking");
		String editbooking = req.getParameter("button_editbooking");
		//String addbooking1 = req.getParameter("button_addbooking1");
		String addbooking2 = req.getParameter("button_addbooking2");
		
		String getAllAvailableBookings = req.getParameter("buttonName_getAllAvailableBookings");
		String fromDate = req.getParameter("datepicker1");
		String toDate = req.getParameter("datepicker2");
		
		System.out.println("START EDITING ROOM --- " + bookingId);
		
		//if (process == null)
		//	process = (String) req.getAttribute("process");
		//if (bookingId == null)
		//	bookingId = (String) req.getAttribute("bookingId");
		

		//checkBookingNumber(process, bookingId, req, res);

        */
   
		// in EditBooking.jsp, when user click "add booking" button,forward to AddBooking.jsp
		if (process != null && process.equals("add")) {
			System.out.println("in if (process.equals(\"add\")), fromDate is "+ datepicker1);
			System.out.println("in if (process.equals(\"add\")), toDate is " + datepicker2);
			//req.setAttribute("datepicker1",datepicker1);
			//req.setAttribute("datepicker2",datepicker2);
			
			/*
			if (datepicker1 == null && datepicker2 == null){
				req.getRequestDispatcher("BookRoom.jsp").forward(req, res);
				return;
			}   */

			  if (addBooking(req, res) == null)
			    return;
			  else {
				req.removeAttribute("bookingId");
				req.removeAttribute("process");
				req.removeAttribute("datepicker1");
				req.removeAttribute("datepicker2");
				bookingNumber = 0;
				req.setAttribute("CurrentMaxClientNumber",RoomControllerServlet.currentMaxClientNumber());
				//after add booking,add the client
				req.getRequestDispatcher("AddClient.jsp").forward(req, res);
				//req.getRequestDispatcher("xsuccessfully.jsp").forward(req, res);
				return;
			  }

		  }
		
		/*
		// in AddBooking.jsp, when user click "add booking" button
		if (addbooking2 != null) {
			
			if (addBooking(req, res) != null) {
				//req.removeAttribute("bookingId");
				//req.removeAttribute("process");
				//bookingNumber = 0;
				req.getRequestDispatcher("xsuccessfully.jsp").forward(req, res);
			}
		}   */
		
		
		// get booking
		if (process != null && process.equals("get") && bookingId != null) {
			System.out.println("In if (process.equals(\"get\") --- " + bookingId);
			displayBooking(Integer.parseInt(bookingId), req, res);
			return;
		}

		// get all bookings
		if (process != null && process.equals("getAll")) {
			req.setAttribute("doitagain", true); 
			displayBookings(req,res);
			return;
			//req.getRequestDispatcher("DisplayBookings.jsp").forward(req, res);
		}    
		
		// inactivate a booking
		if (process != null && process.equals("inactivate") && bookingId != null) {
			System.out.println("In if (process.equals(\"inactivate\") --- " + bookingId);
			BookingServiceLocator sl = new BookingServiceLocator();		
			if (sl.setBookingInactive(Integer.parseInt(bookingId)) != null) {
				req.removeAttribute("bookingId");
				req.removeAttribute("process");
				req.removeAttribute("datepicker1");
				req.removeAttribute("datepicker2");
				req.getRequestDispatcher("xsuccessfully.jsp").forward(req, res);
				return;
			}
			//displayBooking(Integer.parseInt(bookingId), req, res);
			return;
			//req.getRequestDispatcher("DisplayBookings.jsp").forward(req, res);
		}    
		
		
		/*
		// get all available bookings for a period
		if (getAllAvailableBookings != null) { //.equals("buttonValue_getAllAvailableBookings")) {
			displayAllAvailableBookings(req,res);
			req.setAttribute("doitagain", true); 
			req.getRequestDispatcher("BookBooking.jsp").forward(req, res);
		}   */
		 
		

		// remove booking
		if (process != null && process.equals("remove") ) { //&& bookingNumber != 0) {
			if (removeBooking(Integer.parseInt(bookingId))) {
				req.removeAttribute("bookingId");
				req.removeAttribute("process");
				bookingNumber = 0;
				req.getRequestDispatcher("xsuccessfully.jsp").forward(req, res);
				return;
			}			
		}

		if (process != null && process.equals("update") && booking == null) {
			booking = updateBooking(Integer.parseInt(bookingId),req,res);  
			System.out.println("customer click update, no bookingID --- the booking is " + booking);
		    return;
		}
		
		if (process != null && process.equals("update") && booking != null && bookingId != null) {
			booking = null;
			//booking = updateBooking(Integer.parseInt(bookingId),req,res);  
			System.out.println("customer click update, has bookingID --- the booking is " + booking);
			//if (booking  != null) {
			   req.getRequestDispatcher("xsuccessfully.jsp").forward(req, res);
			   return;
			//}
		}
		
		//get all free rooms for a period
		if (datepicker1 != null && datepicker2 != null && process.equals("bookroom")) {
			    System.out.println("in if (datepicker1 != null && datepicker2 != null), datepicker1 is " + datepicker1);
			    BookingServiceLocator sl = new BookingServiceLocator();	
				List<Room> AvailableRoomsSearchResult = sl.getAllAvailableRooms(datepicker1,datepicker2);
				if (AvailableRoomsSearchResult != null) {	
				   req.setAttribute("AvailableRoomsSearchResult",AvailableRoomsSearchResult);
				   //BookingJavaBean.availableRoomsSearchResult = AvailableRoomsSearchResult;
				   System.out.println("in booking servlet, with datepicker1 and 2, AvailableRoomsSearchResultis " + AvailableRoomsSearchResult);
				   req.setAttribute("CurrentMaxBookingNumber",RoomControllerServlet.currentMaxBookingNumber());
				   req.setAttribute("datepicker1",datepicker1);
				   req.setAttribute("datepicker2",datepicker2);
				   System.out.println("after set datepicker1 attribute, datepicker1 attribute is " + (String)req.getAttribute("datepicker1"));
			       req.getRequestDispatcher("BookRoomSearchResult.jsp").forward(req, res);
			       return;
				}
		}

	}  

	public Booking addBooking(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		Booking r = null;
		BookingJavaBean rb = (BookingJavaBean) req.getAttribute("javabeanbooking");
		if (rb == null) {
			BookingServiceLocator sl = new BookingServiceLocator();	
		    List<Room> AvailableRoomsSearchResult = sl.getAllAvailableRooms(datepicker1,datepicker2);
		    if (AvailableRoomsSearchResult != null) {	
			   req.setAttribute("AvailableRoomsSearchResult",AvailableRoomsSearchResult);			
			   //BookingJavaBean.availableRoomsSearchResult = AvailableRoomsSearchResult;
			   req.setAttribute("datepicker1",datepicker1);
			   req.setAttribute("datepicker2",datepicker2);
			   req.setAttribute("roomNumber1",req.getParameter("roomNumber1"));
			   req.setAttribute("CurrentMaxBookingNumber",RoomControllerServlet.currentMaxBookingNumber());
			   req.setAttribute("CurrentMaxClientNumber",RoomControllerServlet.currentMaxClientNumber());
			   req.getRequestDispatcher("AddBooking.jsp").forward(req, res);
			   return null;
		    }
			//return null;
		} else {

			r = new Booking();
			r.setBookingID(rb.getBookingID());
			r.setBookingDate(rb.getBookingDate());
			r.setBookingStartDate(rb.getBookingStartDate());
			r.setBookingEndDate(rb.getBookingEndDate());
			//if (rb.getClientID() != null)
			   r.setClientID(rb.getClientID());
			r.setRoomNumber(rb.getRoomNumber());	
			r.setBookingPrice(rb.getBookingPrice());
			//if (rb.getBookingNotes() != null)
			r.setBookingNotes(rb.getBookingNotes());	
			
			if (rb.getIsActive().equals("y")) {
			    r.setIsActive("TRUE");
			} else if (rb.getIsActive().equals("n")) {
				r.setIsActive("FALSE");
			}
			
			
			System.out.println("in bookingservlet's addbooking,booking id is "+rb.getBookingID());
			System.out.println("in addbooking,booking date is "+r.getBookingDate());
			System.out.println("in addbooking,booking from date is "+r.getBookingStartDate());
			System.out.println("in addbooking,booking to date is "+r.getBookingEndDate());
			System.out.println("in addbooking,booking client id is "+r.getClientID());
			System.out.println("in addbooking,booking room number is "+r.getRoomNumber());
			System.out.println("in addbooking,booking booking notes is "+r.getBookingNotes());
			System.out.println("in addbooking,booking is active is "+r.getIsActive());
			
			
			//r.setFileName(rb.getFileName());
			//File f = new File(r.getFileName());
			//byte[] image = Booking.ImageToByte(f);
			//r.setImage(image);
			BookingServiceLocator sl = new BookingServiceLocator();
			if (!sl.saveBooking(r))
				r = null;
		}
		return r;
	}
	
	public void  displayBooking(int bookingNumber, HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("In displayBooking() --- " + bookingNumber);
		booking = getBooking(bookingNumber);
		if (booking != null) {
			req.setAttribute("ThisBooking", booking);
			req.removeAttribute("bookingId");
			req.removeAttribute("process");
			//req.removeAttribute("ThisBooking");
			bookingNumber = 0;
			req.getRequestDispatcher("DisplayOneBooking.jsp").forward(req, res);
			return;

		}
		
	}
	
	public void  displayBookings(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("In displayBookings() ==== ");
		listBookings = null;
		BookingServiceLocator sl = new BookingServiceLocator();		
		listBookings = sl.listAllBookings();
		if (listBookings != null) {
			req.setAttribute("ThisBooking", listBookings);
			req.removeAttribute("bookingId");
			req.removeAttribute("process");
			//req.removeAttribute("ThisBooking");
			bookingNumber = 0;
			listBookings = null;
			req.getRequestDispatcher("DisplayBookings.jsp").forward(req, res);
			return;

		}
		
	}
	
	/*
	//display all non-booked available rooms in a period for new clients to choose
		public static List<Room>  displayAllAvailableRooms(String fromDate,String toDate,HttpServletRequest req, HttpServletResponse res)
				throws ServletException, IOException {
			RoomServiceLocator sl = new RoomServiceLocator();
			List<Room> results = null;
			int first = 0;
			int max = 1;
			//String fromDate = datepicker1;
			//String toDate = datepicker2;
			
			if (sl != null) {
		
				//do {
					results = sl.getAllAvailableRooms(fromDate, toDate);
				//	req.setAttribute("AllAvailableRooms", results);
				//	req.getRequestDispatcher("BookRoomSearchResult.jsp").forward(req, res);
				//	req.removeAttribute("ThisRoom");
				//	Iterator<Room> it = results.iterator();
				//	while (it.hasNext()) {
				//		Room r = (Room)it.next();
				//		displayRoom(r.getRoomNumber(), req, res);
				//	}
				////	first = first + max;
				//} while (results.size() > 0);
			}
			return results;
			
		}  */


	public Booking getBooking(int bookingNumber) {
		Booking r = null;
		BookingServiceLocator sl = new BookingServiceLocator();
		r = sl.getBooking(bookingNumber);

		return r;
	}

	

	private boolean removeBooking(Integer bookingNumber) {
		BookingServiceLocator sl = new BookingServiceLocator();
		return sl.removeBooking(bookingNumber);
	}

	private Booking updateBooking(Integer bookingNumber, HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		Booking r = null;
		BookingJavaBean rb = (BookingJavaBean) req.getAttribute("javabeanbooking");
		if (rb == null) {
			booking = getBooking(bookingNumber);
			if (booking != null) {
		    req.setAttribute("ThisBooking", booking);
			req.removeAttribute("bookingId");
			req.removeAttribute("process");
			//req.removeAttribute("ThisBooking");
			bookingNumber = 0;
			req.getRequestDispatcher("DisplayBookingForEdit.jsp").forward(req, res);
			return null;

			}
		} else {

			//r = new Booking(rb.getBookingNumber());
			
			r = new Booking();
			r.setBookingID(rb.getBookingID());
			r.setBookingDate(rb.getBookingDate());
			r.setBookingStartDate(rb.getBookingStartDate());
			r.setBookingEndDate(rb.getBookingEndDate());
			r.setClientID(rb.getClientID());
			r.setRoomNumber(rb.getRoomNumber());	
			r.setBookingPrice(rb.getBookingPrice());
			r.setBookingNotes(rb.getBookingNotes());			
			//r.setIsActive(rb.getIsActive());
			
			if (rb.getIsActive().equals("y")) {
			    r.setIsActive("TRUE");
			} else if (rb.getIsActive().equals("n")) {
				r.setIsActive("FALSE");
			}

			BookingServiceLocator sl = new BookingServiceLocator();
			if (!sl.updateBooking(r))
				r = null;
		}
		return r;
	}

	private void checkBookingNumber(String process, String bookingId,
			HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		    //if (process == null || bookingId == null)
			if (bookingId == null) {
			   req.getRequestDispatcher("Fail.jsp").forward(req, res);
			   return;
			}
		
		if (process.equals("get") || process.equals("update")
				|| process.equals("remove")) {

			if (!bookingId.isEmpty()) {
				try {
					bookingNumber = Integer.valueOf(bookingId);
					System.out.println(">>>>>>>>----->> check booking number: "
							+ bookingNumber);
					BookingServiceLocator sl = new BookingServiceLocator();
					if (!sl.isBookingNumberValid(bookingNumber))
						throw new NumberFormatException();
				} catch (java.lang.NumberFormatException nfe) {
					req.setAttribute("bookingNumber", bookingNumber);
					req.getRequestDispatcher("Fail.jsp").forward(req, res);
					return;
				}
			} else {
				req.getRequestDispatcher("Fail.jsp").forward(req, res);
				return;
			}
			
		}

	}

}
