

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
 * Servlet implementation class password
 */
public class password extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public password() {
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
		String pass=request.getParameter("pass");
		HttpSession s=request.getSession();	
		s.setAttribute("pass",pass);
		String uname=(String)s.getAttribute("email");
	              
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
		     if(  pass.equals(rst.getString(6)))
		     {
		    	 RequestDispatcher rd=request.getRequestDispatcher("password2.html");
			    	rd.include(request, response);
		    	 //out.println("welcome");
		    	 
		     }
		     else
		     {
		    	 out.println("<html>");
			    	out.println("<body bgcolor='red'>");
			    	out.println("Please enter correct password!! ");
			        out.println("</body>");
			    	out.println("</html>");
			    	RequestDispatcher rd=request.getRequestDispatcher("password.html");
			    	rd.include(request, response);
		    	 
		     }
		     }
		    
		}catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}


