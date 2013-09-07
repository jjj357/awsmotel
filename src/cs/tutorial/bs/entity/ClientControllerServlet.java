package cs.tutorial.bs.entity;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import cs.tutorial.bs.entity.ClientJavaBean;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import servlet.pkg.String;

//import servlet.pkg.String;

import cs.tutorial.bs.entity.Client;

/**
 * Servlet implementation class ActionServlet
 */
//@WebServlet("/ClientControllerServlet")
public class ClientControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Integer clientNumber = null;
	Client client = null;
	List<Client> listClients = null;
	boolean result = false;

	public ClientControllerServlet() {
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
		String clientId = req.getParameter("clientId");
		System.out.println("START ---  clientId is " + clientId);
/*		if (process == null)
			process = (String) req.getAttribute("process");
		if (clientId == null)
			clientId = (String) req.getAttribute("clientId");*/
		
		if (process == null) {
			process = (String) req.getSession().getAttribute("process");
		} else {
			req.getSession().setAttribute("process",process);			
		}
		
		if (clientId == null) {
			clientId = (String) req.getSession().getAttribute("clientId");
		} else {
			req.getSession().setAttribute("clientId",clientId);	
		}
		
		
		System.out.println("After getAttribute --- clientId is " + clientId);
		/*
		//check if a button in index page was clicked
		String indexpage_button_bookaclient = req.getParameter("bookaclient");
		String indexpage_button_cancelaclient = req.getParameter("cancelaclient");
		String indexpage_button_editaclient = req.getParameter("editaclient");
		String indexpage_button_editclient = req.getParameter("editclient");
		String indexpage_button_editclienttype = req.getParameter("editclienttype");
		String indexpage_button_editpenalty = req.getParameter("editpenalty");
		String indexpage_button_editclient = req.getParameter("editclient");
		String indexpage_button_getallclientsandstatus = req.getParameter("getallclientsandstatus");
		String indexpage_button_getfreeclientsforaperiod = req.getParameter("getfreeclientsforaperiod");
		String indexpage_button_getclientsmeetingacriteria = req.getParameter("getclientsmeetingacriteria");
		
		
		String clientId = req.getParameter("textfield_editclient");
		String editclient = req.getParameter("button_editclient");
		//String addclient1 = req.getParameter("button_addclient1");
		String addclient2 = req.getParameter("button_addclient2");
		
		String getAllAvailableClients = req.getParameter("buttonName_getAllAvailableClients");
		String fromDate = req.getParameter("datapicker1");
		String toDate = req.getParameter("datapicker2");
		
		System.out.println("START EDITING ROOM --- " + clientId);
		
		//if (process == null)
		//	process = (String) req.getAttribute("process");
		//if (clientId == null)
		//	clientId = (String) req.getAttribute("clientId");
		

		//checkClientNumber(process, clientId, req, res);

        */
   
		// in EditClient.jsp, when user click "add client" button,forward to AddClient.jsp
		if (process != null && process.equals("add")) {
			if (addClient(req, res) != null) {
				req.removeAttribute("clientId");
				req.removeAttribute("process");
				clientNumber = 0;
				req.getRequestDispatcher("xsuccessfully.jsp").forward(req, res);
				return;
			}

		}
		
		/*
		// in AddClient.jsp, when user click "add client" button
		if (addclient2 != null) {
			
			if (addClient(req, res) != null) {
				//req.removeAttribute("clientId");
				//req.removeAttribute("process");
				//clientNumber = 0;
				req.getRequestDispatcher("xsuccessfully.jsp").forward(req, res);
			}
		}   */
		
		
		// get client
		if (process != null && process.equals("get") ){  //&& clientNumber != null ) {   // && clientId != null) {
			System.out.println("In if (process.equals(\"get\") --- " + clientId);
			displayClient(Integer.parseInt(clientId), req, res);
		}

		// get all clients
		if (process != null && process.equals("getAll")) {
			req.setAttribute("doitagain", true); 
			displayClients(req,res);
			//req.getRequestDispatcher("DisplayClients.jsp").forward(req, res);
		}    
		
		/*
		// get all available clients for a period
		if (getAllAvailableClients != null) { //.equals("buttonValue_getAllAvailableClients")) {
			displayAllAvailableClients(req,res);
			req.setAttribute("doitagain", true); 
			req.getRequestDispatcher("BookClient.jsp").forward(req, res);
		}   */
		 
		

		// remove client
		if (process != null && process.equals("remove") && clientId != null) {
			if (removeClient(Integer.parseInt(clientId))) {
				req.removeAttribute("clientId");
				req.removeAttribute("process");
				clientNumber = 0;
				req.getRequestDispatcher("xsuccessfully.jsp").forward(req, res);
				return;
			}			
		}

		if (process != null && process.equals("update")  && client == null)  //&& clientNumber != null)
			client = updateClient(Integer.parseInt(clientId),req,res);  
		
		if (process != null && process.equals("update") && client != null && clientId != null) {
			client = null;
			req.getRequestDispatcher("xsuccessfully.jsp").forward(req, res);
			return;
		}
	}  

	public Client addClient(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		Client r = null;
		ClientJavaBean rb = (ClientJavaBean) req.getAttribute("javabeanclient");
		if (rb == null) {
			req.setAttribute("CurrentMaxBookingNumber",RoomControllerServlet.currentMaxBookingNumber());
			req.setAttribute("CurrentMaxClientNumber",RoomControllerServlet.currentMaxClientNumber());
			req.getRequestDispatcher("AddClient.jsp").forward(req, res);
			return null;
		} else {

			r = new Client();
			r.setClientID(rb.getClientID());
			r.setFirstName(rb.getFirstName());
			r.setLastName(rb.getLastName());
			r.setEmail(rb.getEmail());
			r.setPhoneNumber(rb.getPhoneNumber());
			r.setAddress(rb.getAddress());

			ClientServiceLocator sl = new ClientServiceLocator();
			if (!sl.saveClient(r))
				r = null;
		}
		return r;
	}
	
	public void  displayClient(int clientNumber, HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("In displayClient() --- " + clientNumber);
		client = getClient(clientNumber);
		if (client != null) {
			req.setAttribute("ThisClient", client);
			req.removeAttribute("clientId");
			req.removeAttribute("process");
			//req.removeAttribute("ThisClient");
			clientNumber = 0;
			req.getRequestDispatcher("DisplayOneClient.jsp").forward(req, res);
			return;

		}
		
	}
	
	public void  displayClients(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("In displayClients() ==== ");
		listClients = null;
		ClientServiceLocator sl = new ClientServiceLocator();		
		listClients = sl.listClients();
		if (listClients != null) {
			req.setAttribute("ThisClient", listClients);
			req.removeAttribute("clientId");
			req.removeAttribute("process");
			//req.removeAttribute("ThisClient");
			clientNumber = 0;
			listClients = null;
			req.getRequestDispatcher("DisplayClients.jsp").forward(req, res);
			return;

		}
		
		
	}
	
	/*
	//display all non-booked available clients in a period for new clients to choose
	public void  displayAllAvailableClients(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		ClientServiceLocator sl = new ClientServiceLocator();
		List<Client> results = null;
		int first = 0;
		int max = 1;
		String fromDate = req.getParameter("datapicker1");
		String toDate = req.getParameter("datapicker2");
		
		if (sl != null) {
	
			do {
				results = sl.getAllAvailableClients(fromDate, toDate);
				req.setAttribute("AllAvailableClients", results);
				req.getRequestDispatcher("BookClientSearchResult.jsp").forward(req, res);
				req.removeAttribute("ThisClient");
				Iterator<Client> it = results.iterator();
				while (it.hasNext()) {
					Client r = (Client)it.next();
					displayClient(r.getClientID(), req, res);
				}
				first = first + max;
			} while (results.size() > 0);
		}
		
	} */

	public Client getClient(int clientNumber) {
		Client r = null;
		ClientServiceLocator sl = new ClientServiceLocator();
		r = sl.getClient(clientNumber);

		return r;
	}

	

	private boolean removeClient(int clientNumber) {
		ClientServiceLocator sl = new ClientServiceLocator();
		return sl.removeClient(clientNumber);
	}

	private Client updateClient(Integer clientNumber, HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		Client r = null;
		ClientJavaBean rb = (ClientJavaBean) req.getAttribute("javabeanclient");
		if (rb == null) {
			client = getClient(clientNumber);
			if (client != null) {
		    req.setAttribute("ThisClient", client);
			req.removeAttribute("clientId");
			req.removeAttribute("process");
			//req.removeAttribute("ThisClient");
			clientNumber = 0;
			req.getRequestDispatcher("DisplayClientForEdit.jsp").forward(req, res);
			return null;

			}
		} else {

			//r = new Client(rb.getClientNumber());
			
			r = new Client();
			r.setClientID(rb.getClientID());
			r.setFirstName(rb.getFirstName());
			r.setLastName(rb.getLastName());
			r.setEmail(rb.getEmail());
			r.setPhoneNumber(rb.getPhoneNumber());
			r.setAddress(rb.getAddress());
			
			ClientServiceLocator sl = new ClientServiceLocator();
			if (!sl.updateClient(r))
				r = null;
		}
		return r;
	}

	private void checkClientNumber(String process, String clientId,
			HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		    //if (process == null || clientId == null)
			if (clientId == null){
			   req.getRequestDispatcher("Fail.jsp").forward(req, res);
			   return;
	        }
		
		if (process.equals("get") || process.equals("update")
				|| process.equals("remove")) {

			if (!clientId.isEmpty()) {
				try {
					clientNumber = Integer.valueOf(clientId);
					System.out.println(">>>>>>>>----->> check client number: "
							+ clientNumber);
					ClientServiceLocator sl = new ClientServiceLocator();
					if (!sl.isClientNumberValid(clientNumber))
						throw new NumberFormatException();
				} catch (java.lang.NumberFormatException nfe) {
					req.setAttribute("clientNumber", clientNumber);
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
