package cs.tutorial.bs.entity;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import cs.tutorial.bs.entity.RoomJavaBean;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import servlet.pkg.String;

//import servlet.pkg.String;

import cs.tutorial.bs.entity.Room;

/**
 * Servlet implementation class ActionServlet
 */
//@WebServlet("/RoomControllerServlet")
public class RoomControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String datepicker1,datepicker2;

	Integer roomNumber = null;
	Room room = null;
	List<Room> listRooms = null;
	boolean result = false;

	public RoomControllerServlet() {
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
		//req.setAttribute("process","process");
		//req.setAttribute("roomId","roomId");
		//req.setAttribute("datepicer1","datepicker1_default");
		//req.setAttribute("datepicer2","datepicker2_default");

		// take the request params
		String process = req.getParameter("process");
		String roomId = req.getParameter("roomId");
		System.out.println("room servlet line 59, START ---  roomId is " + roomId);
		

		
		if (process == null) {
			process = (String) req.getSession().getAttribute("process");
		} else {
			req.getSession().setAttribute("process",process);			
		}
		
		if (roomId == null) {
			roomId = (String) req.getSession().getAttribute("roomId");
		} else {
			req.getSession().setAttribute("roomId",roomId);	
		}
		
		System.out.println("room servlet line 65, After getAttribute --- process is " + process);
		System.out.println("room servlet line 66, After getAttribute --- roomId is " + roomId);
		
		datepicker1 = req.getParameter("datepicker1");
		datepicker2 = req.getParameter("datepicker2");
		
		System.out.println("datepicker1 is " + datepicker1);
		System.out.println("datepicker2 is " + datepicker2);
		
		/*
		//check if a button in index page was clicked
		String indexpage_button_bookaroom = req.getParameter("bookaroom");
		String indexpage_button_cancelabooking = req.getParameter("cancelabooking");
		String indexpage_button_editabooking = req.getParameter("editabooking");
		String indexpage_button_editroom = req.getParameter("editroom");
		String indexpage_button_editroomtype = req.getParameter("editroomtype");
		String indexpage_button_editpenalty = req.getParameter("editpenalty");
		String indexpage_button_editclient = req.getParameter("editclient");
		String indexpage_button_getallroomsandstatus = req.getParameter("getallroomsandstatus");
		String indexpage_button_getfreeroomsforaperiod = req.getParameter("getfreeroomsforaperiod");
		String indexpage_button_getroomsmeetingacriteria = req.getParameter("getroomsmeetingacriteria");
		
		
		String roomId = req.getParameter("textfield_editroom");
		String editroom = req.getParameter("button_editroom");
		//String addroom1 = req.getParameter("button_addroom1");
		String addroom2 = req.getParameter("button_addroom2");
		
		String getAllAvailableRooms = req.getParameter("buttonName_getAllAvailableRooms");
		String fromDate = req.getParameter("datapicker1");
		String toDate = req.getParameter("datapicker2");
		
		System.out.println("START EDITING ROOM --- " + roomId);
		
		//if (process == null)
		//	process = (String) req.getAttribute("process");
		//if (roomId == null)
		//	roomId = (String) req.getAttribute("roomId");
		

		//checkRoomNumber(process, roomId, req, res);

        */
   
		// in EditRoom.jsp, when user click "add room" button,forward to AddRoom.jsp
		if (process != null && process.equals("add")) {
			if (addRoom(req, res) != null) {
				req.removeAttribute("roomId");
				req.removeAttribute("process");

				
				roomNumber = 0;
				
				//req.getRequestDispatcher("AddClient.jsp").forward(req, res);
				req.getRequestDispatcher("xsuccessfully.jsp").forward(req, res);
				return;
			}

		}
		
		/*
		// in AddRoom.jsp, when user click "add room" button
		if (addroom2 != null) {
			
			if (addRoom(req, res) != null) {
				//req.removeAttribute("roomId");
				//req.removeAttribute("process");
				//roomNumber = 0;
				req.getRequestDispatcher("xsuccessfully.jsp").forward(req, res);
			}
		}   */
		
		
		// get room
		if (process != null && process.equals("get") && roomId != null) {
			System.out.println("In if (process.equals(\"get\") --- " + roomId);
			displayRoom(Integer.parseInt(roomId), req, res);
		}

		// get all rooms
		if (process != null && process.equals("getAll")) {
			req.setAttribute("doitagain", true); 
			displayRooms(req,res);
			//req.getRequestDispatcher("DisplayRoom.jsp").forward(req, res);
			//req.getRequestDispatcher("ShowAllRooms.jsp").forward(req, res);
		}    
		
		
		// get all occupied rooms
		if (process != null && process.equals("choosecriteria")) {
			//req.setAttribute("doitagain", true); 
			
			RoomServiceLocator rsl = new RoomServiceLocator();
			
			listRooms = rsl.getOccupiedRooms();
			
			System.out.println("in room servlet line 160, listRooms is " + listRooms);
			
		//	if (listRooms != null) {
				req.setAttribute("ThisRoom", listRooms);
			    //req.getRequestDispatcher("DisplayRooms.jsp").forward(req, res);
			    //req.getRequestDispatcher("ShowAllRooms.jsp").forward(req, res);
				req.removeAttribute("roomId");
				req.removeAttribute("process");
				//req.removeAttribute("ThisRoom");
				roomNumber = 0;
				listRooms = null;
				req.getRequestDispatcher("DisplayRooms.jsp").forward(req, res);
				return;

				
		/*	}
			else {
				req.setAttribute("ThisRoom", listRooms);
			    //req.getRequestDispatcher("DisplayRooms.jsp").forward(req, res);
			    //req.getRequestDispatcher("ShowAllRooms.jsp").forward(req, res);
				req.getRequestDispatcher("DisplayRooms.jsp").forward(req, res);
				req.removeAttribute("roomId");
				req.removeAttribute("process");
				req.removeAttribute("ThisRoom");
				roomNumber = 0;
				listRooms = null;
				return;
			}  */
		} //end of if (process != null && process.equals("choosecriteria")) { 
		
		// get all ordered active rooms
		if (process != null && process.equals("choosecriteria1")) {
			
			RoomServiceLocator rsl = new RoomServiceLocator();
			
			listRooms = rsl.getOrderedRooms();
			
			System.out.println("in room servlet line 195, listRooms is " + listRooms);

				req.setAttribute("ThisRoom", listRooms);
				req.removeAttribute("roomId");
				req.removeAttribute("process");
				//req.removeAttribute("ThisRoom");
				roomNumber = 0;
				listRooms = null;
			    //req.getRequestDispatcher("DisplayRooms.jsp").forward(req, res);
			    //req.getRequestDispatcher("ShowAllRooms.jsp").forward(req, res);
				req.getRequestDispatcher("DisplayRooms.jsp").forward(req, res);

				return;
		}
		
		/*
		// get all available rooms for a period
		if (datepicker1 != null && datepicker2 != null) { 
			displayAllAvailableRooms(req,res);
			//req.setAttribute("doitagain", true); 
			req.getRequestDispatcher("BookRoom.jsp").forward(req, res);
		}     */
		 
		

		// remove room
		if (process != null && process.equals("remove") ) { //&& roomNumber != 0) {
			if (removeRoom(Integer.parseInt(roomId))) {
				req.removeAttribute("roomId");
				req.removeAttribute("process");
				roomNumber = 0;
				req.getRequestDispatcher("xsuccessfully.jsp").forward(req, res);
				return;
			}			
		}

		if (process != null && process.equals("update") && room == null) { //&& roomNumber != null)
			room = updateRoom(Integer.parseInt(roomId),req,res);  
			System.out.println("at line 241 inside room servlet,room is null");
		}
			
		
		if (process != null && process.equals("update") && roomId != null && room != null) {
			room = null;
			System.out.println("at line 247 inside room servlet, room is not null");
			req.getRequestDispatcher("xsuccessfully.jsp").forward(req, res);
			return;

		}
		
		//get all free rooms for a period
		if (datepicker1 != null && datepicker2 != null) {	
			    System.out.println("in if (datepicker1 != null && datepicker2 != null), datepicker1 is " + datepicker1);
			    BookingServiceLocator sl = new BookingServiceLocator();	
				List<Room> AvailableRoomsSearchResult = sl.getAllAvailableRooms(datepicker1,datepicker2);
				if (AvailableRoomsSearchResult != null) {	
				   //BookingJavaBean.availableRoomsSearchResult = AvailableRoomsSearchResult;
				   req.setAttribute("AvailableRoomsSearchResult",AvailableRoomsSearchResult);
				   req.setAttribute("CurrentMaxBookingNumber",currentMaxBookingNumber());
			       req.getRequestDispatcher("BookRoomSearchResult.jsp").forward(req, res);
			       return;
				}
		}
	}  

	public Room addRoom(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		Room r = null;
		RoomJavaBean rb = (RoomJavaBean) req.getAttribute("javabeanroom");
		if (rb == null) {
			System.out.println("In addRoom() line 278, going to addroom.jsp");
			req.getRequestDispatcher("AddRoom.jsp").forward(req, res);
			return null;
		} else {

			r = new Room();
			r.setRoomNumber(rb.getRoomNumber());
			r.setRoomName(rb.getRoomName());
			r.setDescription(rb.getDescription());
			r.setPrice(rb.getPrice());
			r.setRoomTypeID(rb.getRoomTypeID());
			
			System.out.println("In addRoom() line 289, room number is --- " + rb.getRoomNumber());
			RoomServiceLocator sl = new RoomServiceLocator();
			if (!sl.saveRoom(r))
				r = null;
		}
		return r;
	}
	
	public void displayRoom(int roomNumber, HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("In displayRoom() --- " + roomNumber);
		//listRooms = null;
		//listRooms.add(getRoom(roomNumber));
		
		room = getRoom(roomNumber);
		System.out.println("In displayRoom(), listRoom are--- " + room);
		if (room != null) {
			req.setAttribute("ThisRoom", room);
			req.removeAttribute("roomId");
			req.removeAttribute("process");
			//req.removeAttribute("ThisRoom");
			roomNumber = 0;
			req.getRequestDispatcher("DisplayOneRoom.jsp").forward(req, res);
			return;

		}
		
	}
	
	public void  displayRooms(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("In displayRooms() ==== ");
		listRooms = null;
		//RoomServiceLocator sl = new RoomServiceLocator();		
		listRooms = RoomServiceLocator.listRooms();
		if (listRooms != null) {
			System.out.println("in room servlet at line 326, listRooms value is: " + listRooms);
			req.setAttribute("ThisRoom", listRooms);
			req.removeAttribute("roomId");
			req.removeAttribute("process");
			//req.removeAttribute("ThisRoom");
			roomNumber = 0;
			listRooms = null;
			req.getRequestDispatcher("DisplayRooms.jsp").forward(req, res);
			return;

		}
		/*
		RoomServiceLocator sl = new RoomServiceLocator();
		List<Room> results = null;
		int first = 0;
		int max = 1;
		if (sl != null) {
	
			do {
				results = sl.getRooms(max, first);
				Iterator<Room> it = results.iterator();
				while (it.hasNext()) {
					Room r = (Room)it.next();
					displayRoom(r.getRoomNumber(), req, res);
				}
				first = first + max;
			} while (results.size() > 0);
		}  */
		
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

	public Room getRoom(int roomNumber) {
		Room r = null;
		RoomServiceLocator sl = new RoomServiceLocator();
		r = sl.getRoom(roomNumber);

		return r;
	}

	

	private boolean removeRoom(Integer roomNumber) {
		RoomServiceLocator sl = new RoomServiceLocator();
		return sl.removeRoom(roomNumber);
	}

	private Room updateRoom(Integer roomNumber, HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		Room r = null;
		RoomJavaBean rb = (RoomJavaBean) req.getSession().getAttribute("javabeanroom");
		if (rb == null) {
			room = getRoom(roomNumber);
			if (room != null) {
				System.out
						.println("in room servlet line 388, room is not null, roomjavabean is null. room is " + room);

				req.setAttribute("ThisRoom", room);
				req.removeAttribute("roomId");
				req.removeAttribute("process");
				//req.removeAttribute("ThisRoom");
				roomNumber = 0;
				req.getRequestDispatcher("DisplayRoomForEdit.jsp").forward(req,
						res);
				return null;

			}
		} else {
			System.out.println("in room servlet line 399, roomjavabean is NOT null. roomjavabean is " + rb);
			//r = new Room(rb.getRoomNumber());
			
			r = new Room();
			r.setRoomNumber(rb.getRoomNumber());
			r.setRoomName(rb.getRoomName());
			r.setDescription(rb.getDescription());
			r.setPrice(rb.getPrice());
			r.setRoomTypeID(rb.getRoomTypeID());
			//r.setFileName(rb.getFileName());
			//File f = new File(r.getFileName());
			//byte[] image = Room.ImageToByte(f);
			//r.setImage(image);
			RoomServiceLocator sl = new RoomServiceLocator();
			if (!sl.updateRoom(r))
				r = null;
		}
		return r;
	}

	private void checkRoomNumber(String process, String roomId,
			HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		    //if (process == null || roomId == null)
			if (roomId == null) {
			   req.getRequestDispatcher("Fail.jsp").forward(req, res);
			   return;
			}
		
		if (process.equals("get") || process.equals("update")
				|| process.equals("remove")) {

			if (!roomId.isEmpty()) {
				try {
					roomNumber = Integer.valueOf(roomId);
					System.out.println(">>>>>>>>----->> check room number: "
							+ roomNumber);
					RoomServiceLocator sl = new RoomServiceLocator();
					if (!sl.isRoomNumberValid(roomNumber))
						throw new NumberFormatException();
				} catch (java.lang.NumberFormatException nfe) {
					req.setAttribute("roomNumber", roomNumber);
					req.getRequestDispatcher("Fail.jsp").forward(req, res);
					return;
				}
			} else {
				req.getRequestDispatcher("Fail.jsp").forward(req, res);
				return;
			}
			
		}

	}
	
	public static int currentMaxBookingNumber() {
		int max = 0;
		RoomServiceLocator sl = new RoomServiceLocator();
		List<Booking> bookingList = sl.listAllBookings();
		for (Booking b : bookingList) {
			int temp = b.getBookingID();
			if (temp > max) {
				max = temp;
			}
		}
		return max;
		
	}
	
	
		public static int currentMaxClientNumber() {
		int max = 0;
		RoomServiceLocator sl = new RoomServiceLocator();
		List<Client> clientList = sl.listAllClients();
		for (Client b : clientList) {
			int temp = b.getClientID();
			if (temp > max) {
				max = temp;
			}
		}
		return max;
		
	}
		
		public static int currentMaxUserNumber() {
		int max = 0;
		RoomServiceLocator sl = new RoomServiceLocator();
		List<User> userList = sl.listAllUsers();
		if (userList != null) {
			for (User b : userList) {
				int temp = b.getUserID();
				if (temp > max) {
					max = temp;
				}
			}
		}
		return max;
		
	}
	

}
