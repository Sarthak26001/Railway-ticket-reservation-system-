package reservation_cancellation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 * Servlet implementation class validation
 */
public class validation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public validation() {
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
	    String uname=request.getParameter("uname");
	    HttpSession s=request.getSession();
	    s.setAttribute("uname", uname);
	     String upass=request.getParameter("upass");
		
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","system");
		
		System.out.println("Successfully connected");
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//response.setContentType("text/html");
		
	     
	     Statement st=conn.createStatement();
	     
	     
	 
	     ResultSet rst=st.executeQuery("select * from register where email='"+uname+"'");
	     if (rst.next())
	     {
	     if(uname.equals(rst.getString(5)) && upass.equals(rst.getString(6)))
	     {
	    	 RequestDispatcher rd=request.getRequestDispatcher("td.html");
		    	rd.include(request, response);
	    	 out.println("welcome");
	    	 
	     }
	     else
	     {
	    	 out.println("<html>");
		    	out.println("<body bgcolor='red'>");
		    	out.println("<center><h1>User name:"+uname +"and Password:"+upass +"is not valid OR Your account is not registered </h1></center><br><br>" );
		    	out.println("<a href='register.html'>create new account</a><br><br>");
		    	out.println("</body>");
		    	out.println("</html>");
		    	RequestDispatcher rd=request.getRequestDispatcher("user.html");
		    	rd.include(request, response);
	    	 
	     }
	     }
	     else
	     {
	    	 out.println("<html>");
		    	out.println("<body bgcolor='red'>");
		    	out.println("<center><h1>User name:"+uname +"and Password:"+upass +"is not valid OR Your account is not registered </h1></center><br><br>" );
		    	out.println("<a href='register.html'>create new account</a><br><br>");
		    	out.println("</body>");
		    	out.println("</html>");
		    	RequestDispatcher rd=request.getRequestDispatcher("user.html");
		    	rd.include(request, response);
	     }
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
