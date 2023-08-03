

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class deletetrain
 */
public class deletetrain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deletetrain() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		 try {
			PrintWriter out=response.getWriter();
		    Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","system");
			System.out.println("Successfully connected");	
		    String train_no=request.getParameter("train_no");
		    Statement st=conn.createStatement();
		    ResultSet rst=st.executeQuery("select * from trains where train_no='"+train_no+"' ");
		
		    if(rst.next())
		  {
		  if(train_no.equals(rst.getString(1)))
	  		{
		    
		    int i=st.executeUpdate("delete from trains where train_no='"+train_no+"'");
		    
			 out.println("<html>");
			  out.println("<body bgcolor='black'>");
			  out.println("<center>");
			  out.println("<br><br><br><br><h1><font face='cooper' color='yellow'> Record of train number "+train_no+" deleted.</font></h1><br><br>");
			  out.println("<h2><a href='Retrieve'>View table</a></h2>");
			  out.println("<h2><a href='adminlogin.html'>Log Out</a></h2>");
			  out.println("</center>");
			  out.println("</body>");
			  out.println("</html>");
		    		}
		  }
		 else
		    {
		    	 out.println("<html>");
				  out.println("<body bgcolor='black'>");
				  out.println("<center>");
				  out.println("<br><br><br><br><h1><font face='cooper' color='yellow'>Sorry!!!! No such record available.</font></h1><br><br>");
				  out.println("<h2><a href='Retrieve'>View table</a></h2>");
				  out.println("<h2><a href='adminlogin.html'>Log Out</a></h2>");				  out.println("</center>");
				  out.println("</body>");
				  out.println("</html>");
			    		}
		 }
		 
		   catch(Exception e)
		   {
			  System.out.println(e);
		   }
		}
	}


		
		
