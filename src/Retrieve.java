

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Retrieve
 */
public class Retrieve extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Retrieve() {
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
		try {
			   Class.forName("oracle.jdbc.driver.OracleDriver");
				
				Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","system");
				System.out.println("Successfully connected");	
				Statement st=conn.createStatement();
				
				
				
				ResultSet rst=st.executeQuery("select * from trains");
				out.println("<html>");
			    out.println("<body bgcolor='white'>");
				  out.println("<h2><a href='adminlogin.html'>Log Out</a></h2>");
			    out.println("<center>");
			    out.println("<table border='3'>");
				
				ResultSetMetaData rsmd=rst.getMetaData();
				int columncount=rsmd.getColumnCount();
				for(int i=1;i<=columncount;i++)
				{
					String columnname=rsmd.getColumnName(i);
					//out.println("<tr><th>train_no train_name type from_station to_station First_class AC_1_tier var AC_2_tier AC_3_tier sleeper second_class </tr></th><br>");
					out.print("<td bgcolor='black' height='50' align='center'><font face='cooper' color='yellow'>"+columnname+"</font></td>");
				}
				
				
			    while(rst.next())
				{   
			    	
					out.println("<tr><td bgcolor='coral' align='center'><font face='cooper' color='black'>"+rst.getString(1)+"</font></td><td bgcolor='coral' align='center'><font face='cooper' color='black'>"+rst.getString(2)+"</font></td><td bgcolor='coral' align='center'><font face='cooper' color='black'>"+rst.getString(3)+"</font></td><td bgcolor='coral' align='center'><font face='cooper' color='black'>"+rst.getString(4)+"</font></td><td bgcolor='coral' align='center'><font face='cooper' color='black'>"+rst.getString(5)+"</font></td><td bgcolor='coral' align='center'><font face='cooper' color='black'>"+rst.getString(6)+"</font></td><td bgcolor='coral' align='center'><font face='cooper' color='black'>"+ rst.getString(7)+"</font></td><td bgcolor='coral' align='center'><font face='cooper' color='black'>"+rst.getString(8)+"</font></td><td bgcolor='coral' align='center'><font face='cooper' color='black'>"+rst.getString(9)+"</font></td><td bgcolor='coral' align='center'><font face='cooper' color='black'>"+rst.getString(10)+"</font></td><td bgcolor='coral' align='center'><font face='cooper' color='black'>"+rst.getString(11)+"</font></td><td bgcolor='coral' align='center'><font face='cooper' color='black'>"+rst.getString(12)+"</font></td><td bgcolor='coral' align='center'><font face='cooper' color='black'>"+rst.getString(13)+"</font></td><td bgcolor='coral' align='center'><font face='cooper' color='black'>"+rst.getInt(14)+"</font></td><td bgcolor='coral' align='center'><font face='cooper' color='black'>"+rst.getInt(15)+"</font></td><td bgcolor='coral' align='center'><font face='cooper' color='black'>"+rst.getInt(16)+"</font></td><td bgcolor='coral' align='center'><font face='cooper' color='black'>"+rst.getInt(17)+"</font></td><td bgcolor='coral' align='center'><font face='cooper' color='black'>"+rst.getInt(18)+"</font></td><td bgcolor='coral' align='center'><font face='cooper' color='black'>"+rst.getInt(19)+"</font></td></tr>");

					 
				}

				
		   }catch(Exception e) 
			   {
			   System.out.println(e);
			   }
		  out.println("</table><br><br>");
		   
		    out.println("</center>");
			out.println("</html>");
		    out.println("</body>");
	}

	}


