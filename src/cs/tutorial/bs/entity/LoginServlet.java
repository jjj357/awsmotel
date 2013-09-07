package cs.tutorial.bs.entity;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			if (processInput(username,password,request)) {

				request.getSession().setAttribute("username", username);
				request.getSession().setAttribute("password", password);
				System.out.println("at login servlet line 47, username and password are correct. Going to main.jsp...");
				request.getRequestDispatcher("main.jsp").forward(request, response);
				return;
			} else {
				request.getSession().setAttribute("errormessage","Username/Password is wrong.");
				request.getRequestDispatcher("index.jsp").forward(request, response);
				return;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

protected boolean processInput(String user, String pass,HttpServletRequest request) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

    

    Connection conn = null;
    Connection conn1 = null;
    String userName = "mingtl2010";   //"root";    //
    String password = "19760108";   //"0108";   //
    String url = "jdbc:mysql://aa17y9fu77blehb.ceexy9bsxwn2.us-west-2.rds.amazonaws.com:3306/ebdb";  //"jdbc:mysql://localhost:3306/test";  //
    ResultSet rs = null;
    try {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection(url, userName, password);
        System.out.println("Database connection established");

        PreparedStatement stmt = null;

        stmt = conn.prepareStatement("SELECT * FROM User WHERE username = ?");
        stmt.setString(1, user);
        rs = stmt.executeQuery();
        //System.out.println("Database connection established");
        if(!rs.next()){
            return false;                
        }

        request.getSession().setAttribute("username", rs.getString("username"));
        
        String encodedpassword = rs.getString("password");
           
        
        conn.close();
        
        conn1 = DriverManager.getConnection(url, userName, password);
        Statement stmt1 = null;
        String query = " SELECT SHA1('" 
                        + pass + "') AS MYPASSWORD";
        String sha1password = "";
        
            stmt1 = conn1.createStatement();
            ResultSet rs1 = stmt1.executeQuery(query);
            while (rs1.next()) {
            	sha1password = rs1.getString("MYPASSWORD");
            }
            conn1.close();
            
            System.out.println("at login servlet line 114, encodedpassword in mySQL is: " + encodedpassword);
            System.out.println("at login servlet line 115, sha1password is: " + sha1password);
            
            if (encodedpassword.equals(sha1password))
            return true;
    } catch (Exception e) {
    	if (conn != null && !conn.isClosed()) {conn.close();}
    	if (conn1 != null && !conn1.isClosed()) {conn1.close();}
    	e.printStackTrace();
    }
    return false;
}


public static String encodePasswordUsingSHA1(String pass) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

    
	String sha1password = "";
    Connection conn1 = null;
    String userName = "mingtl2010";   //"root";  //
    String password = "19760108";   //"0108";  //
    String url = "jdbc:mysql://aa17y9fu77blehb.ceexy9bsxwn2.us-west-2.rds.amazonaws.com:3306/ebdb";   // "jdbc:mysql://localhost:3306/test";   
    ResultSet rs = null;
    try {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        conn1 = DriverManager.getConnection(url, userName, password);
        System.out.println("Database connection established");

        Statement stmt1 = null;
        String query = " SELECT SHA1('" 
                        + pass + "') AS MYPASSWORD";
        
        
            stmt1 = conn1.createStatement();
            rs = stmt1.executeQuery(query);
            while (rs.next()) {
            	sha1password = rs.getString("MYPASSWORD");
            }
            conn1.close();
            
            return sha1password;
            
    } catch (Exception e) {
    	e.printStackTrace();
    	if (conn1 != null && !conn1.isClosed()) {conn1.close();}
    	return "";
    }
    
}


}