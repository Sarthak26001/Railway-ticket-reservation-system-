


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class login
 */
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try{

		Class.forName("oracle.jdbc.driver.OracleDriver");
			//
		
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","system");
			response.setContentType("text/html");
			System.out.println("Successfully connected");
			Statement st=conn.createStatement();
			  
			 PrintWriter out=response.getWriter();
			 String email=request.getParameter("email");
		     String pass=request.getParameter("upass");
		     
		     HttpSession s=request.getSession();
		     s.setAttribute("email", email);
		     s.setAttribute("upass", pass);
		     ResultSet rst=st.executeQuery("select * from register where email='"+email+"'");
		     
		     if (rst.next()) {
		     
		    	 
		    	 
		    	 if(email.equals(rst.getString(5)) && pass.equals (rst.getString(6)))
		     {
		    	RequestDispatcher rsd=request.getRequestDispatcher("loginbutton.html");
		    	rsd.forward(request, response);
		    	 
		     }
		    	 
		    	 else
		    	 {

		    	out.println("<!DOCTYPE html>");
		        out.println("<body>");
		    	out.println("<br><br><br><br><br><br><br><br>");
		        out.println("<table height='300' width='1000' align='center'  bgcolor='black', border='5'>");
		    	out.println("<tr align='center'><td><h2><font color='yellow' size='100' face='cooper'> The Username or password that you entered is incorrect.<br>");
		    	out.println("Checjk your details again.</font></h2></td></tr>");
		    	out.println("<tr align='center'><td><h2><a href='user.html'>Go to login page</h2></a></td></tr>"); 
		    	out.println("<tr align='center'><td><h2><a href='register.html'>Register here</h2></a></td></tr>"); 
                out.println("</table>");
		        out.println("</body>");
		    	out.println("</html>");
				    	//RequestDispatcher rd=request.getRequestDispatcher("user.html");
				    	//rd.include(request, response);
			    	 
		    		 
		    	 }
		     }
		     else
		    {
		    	 out.println("<!DOCTYPE html>");
			        out.println("<body>");
			    	out.println("<br><br><br><br><br><br><br><br>");
			        out.println("<table height='300' width='1000' align='center'  bgcolor='black', border='5'>");
			    	out.println("<tr align='center'><td><h2><font color='yellow' size='100' face='cooper'> The Username or password that you entered is incorrect.<br>");
			    	out.println("Check your details again.</font></h2></td></tr>");
			    	out.println("<tr align='center'><td><h2><a href='user.html'>Go to login page</h2></a></td></tr>"); 
			    	out.println("<tr align='center'><td><h2><a href='register.html'>Register here</h2></a></td></tr>"); 
	                out.println("</table>");
			        out.println("</body>");
			    	out.println("</html>");
					    	//RequestDispatcher rd=request.getRequestDispatcher("user.html");
					    	//rd.include(request, response);
		     }
		     
			}catch(Exception e)
			{
				System.out.println(e);
			}
			}}
		
	


