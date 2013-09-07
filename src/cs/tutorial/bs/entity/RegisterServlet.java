package cs.tutorial.bs.entity;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileNotFoundException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;


/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPut(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String emailaddress = request.getParameter("emailaddress");
		String phonenumber = request.getParameter("phonenumber");
		String securityquestion = request.getParameter("securityquestion");
		String securityanswer = request.getParameter("securityanswer");
		
		//create tables in database
		Configuration config = new Configuration();

		config.addAnnotatedClass(cs.tutorial.bs.entity.Room.class);
		config.configure();

		new SchemaExport(config).create(true, true);

		SessionFactory factory = config.buildSessionFactory();
		Session current = factory.getCurrentSession();

		
		
		if (firstname != null && !firstname.equals("") &&
				lastname != null && !lastname.equals("") &&
				username != null && !username.equals("") &&
				password != null && !password.equals("") &&
				emailaddress != null && !emailaddress.equals("") &&
				phonenumber != null && !phonenumber.equals("") &&
				password.length() >= 6){
			
			current.beginTransaction();
			
			User  b1 = new User();
			b1.setUserID(RoomControllerServlet.currentMaxUserNumber() + 1);
			b1.setUserRealName(firstname + " " + lastname);
			b1.setPassword(password);
			b1.setUsername(username);
			b1.setSecurityQuestion(securityquestion);
			b1.setSecurityAnswer(securityanswer);
			b1.setEmail(emailaddress);
			b1.setPhoneNumber(phonenumber);

			RoomServiceLocator sl = new RoomServiceLocator();
			if (!sl.saveUser(b1))
				b1 = null;
			

		
		current.getTransaction().commit();
		request.getSession().setAttribute("username", username);
		request.getSession().setAttribute("password", password);
		request.getSession().setAttribute("userrealname", firstname + " " + lastname);
		request.getSession().setAttribute("emailaddress", emailaddress);
		request.getSession().setAttribute("phonenumber", phonenumber);
		request.getSession().setAttribute("securityquestion", securityquestion);
		request.getSession().setAttribute("securityanswer", securityanswer);
		
		
		request.getSession().setAttribute("registerErrorMessage", "Success");
		if (current.isOpen()){
		    current.close();
		}
		request.getRequestDispatcher("main.jsp").forward(request, response);
		return;
		} else {
			request.getSession().setAttribute("registerErrorMessage", "Error");
			if (current.isOpen()){
			    current.close();
			}
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}
        
	}

}
