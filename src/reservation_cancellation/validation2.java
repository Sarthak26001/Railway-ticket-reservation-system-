package reservation_cancellation;

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
 * Servlet implementation class validation2
 */
public class validation2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public validation2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out=response.getWriter();

	    HttpSession s=request.getSession();
	    String uname=(String)s.getAttribute("email");
	     String tn=request.getParameter("tn");
	     String da=request.getParameter("da");
	     s.setAttribute("tn",tn);
	     s.setAttribute("da",da);
	     
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","system");
		
		System.out.println("Successfully connected");
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//response.setContentType("text/html");
		
	     
	     Statement st=conn.createStatement();
	     
	     
	 
	     ResultSet rst=st.executeQuery("select * from user4 where train_no='"+tn+"' and reservation_date='"+da+"'and email='"+uname+"'");
	     if (rst.next())
	     {
	     if( tn.equals(rst.getString(2)) && da.equals(rst.getString(9)))
	     {
	    	 RequestDispatcher rd=request.getRequestDispatcher("cancel");
		    	rd.include(request, response);
	    	// out.println("welcome");
	    	 
	     }
	   
	    	 else {
	    			out.println("<body bgcolor='black'>");
	    			out.println("<br><br><br><br><br><br>");
	    			out.println("<center><h1><font face='cooper' color='yellow'><font color='red'>Sorry!!!</font><br>YOU HAVE NOT BOOKED THIS TICKET.<br>PLEASE GO THROUGH THE FILLED-UP DETAILS AGAIN.</font></h1></center>");
	    	
		    	//RequestDispatcher rd=request.getRequestDispatcher("td.html");
		    	//rd.include(request, response);
	    	 
	     }
	     }
	     
	    	 else {
	    			out.println("<body bgcolor='black'>");
	    			out.println("<br><br><br><br><br><br>");
	    			out.println("<center><h1><font face='cooper' color='yellow'><font color='red'>Sorry!!!</font><br>YOU HAVE NOT BOOKED THIS TICKET.<br>PLEASE GO THROUGH THE FILLED-UP DETAILS AGAIN.</font></h1></center>");
	    		
		    	//RequestDispatcher rd=request.getRequestDispatcher("td.html");
		    	//rd.include(request, response);
	     }
		}
		catch(Exception e)
		{
			System.out.println(e);
		}


		
		
	}

}
