

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
 * Servlet implementation class adminverification
 */
public class adminverification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminverification() {
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
		   String aid=request.getParameter("aid");
		   String apass=request.getParameter("apass");
		   if(aid.equals("1111") && apass.equals("1111"))
		   {
			  
			  try {
			   Class.forName("oracle.jdbc.driver.OracleDriver");
				
				Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","system");
				System.out.println("Successfully connected");	
				Statement st=conn.createStatement();
				
				
				
				/*ResultSet rst=st.executeQuery("select * from trains");
				out.println("<html>");
			    out.println("<body='light blue'>");
			    out.println("<center>");
			    out.println("<table border='1'>");
				
				ResultSetMetaData rsmd=rst.getMetaData();
				int columncount=rsmd.getColumnCount();
				for(int i=1;i<=columncount;i++)
				{
					String columnname=rsmd.getColumnName(i);
					//out.println("<tr><th>train_no train_name type from_station to_station First_class AC_1_tier var AC_2_tier AC_3_tier sleeper second_class </tr></th><br>");
					out.print("<td bgcolor='yellow'>"+columnname+"</td>");
				}
				
				
			    while(rst.next())
				{   
			    	
					out.println("<tr><td>"+rst.getString(1)+"</td><td>"+rst.getString(2)+"</td><td>"+rst.getString(3)+"</td><td>"+rst.getString(4)+"</td><td>"+rst.getString(5)+"</td><td>"+rst.getString(6)+"</td><td>"+ rst.getString(7)+"</td><td>"+rst.getString(8)+"</td><td>"+rst.getString(9)+"</td><td>"+rst.getString(10)+"</td><td>"+rst.getString(11)+"</td><td>"+rst.getString(12)+"</td><td>"+rst.getString(13)+"</td><td>"+rst.getInt(14)+"</td><td>"+rst.getInt(15)+"</td><td>"+rst.getInt(16)+"</td><td>"+rst.getInt(17)+"</td><td>"+rst.getInt(18)+"</td><td>"+rst.getInt(19)+"</td></tr>");
					 
				}

			    out.println("</table>");*/
				
		   }catch(Exception e) 
			   {
			   System.out.println(e);
			   }
			 
			 // out.println("</table><br><br>");
			  out.println("<body bgcolor='black'>");
			  out.println("<link rel='stylesheet' type='text/css' href='adlogin.css'>");
			  out.println("<h1><font face='cooper' color='yellow'>Welcome Admin!!</font></h1>");
			  out.println("<div class='title'>");
			  out.println("<a href='insert_train.html' class='btn btn-insert' >Insert train details</a><br><br><br><br>");
			  out.println("<a href='updatetrain.html' class='btn btn-update' >Update train details</a><br><br><br><br>");
			  out.println("<a href='deletetrain.html' class='btn btn-delete' >Delete train details</a><br><br><br><br>");
			  out.println("<a href='adminlogin.html' class='btn btn-log'>Log Out</a><br><br><br><br>");
			  out.println("</div>");
			  
			  
			   /*out.println("<a href='insert_train.html'>Insert Train details</a><br>");
			   out.println("<a href='updatetrain.html'>Update Train details</a><br>");
			   out.println("<a href='deletetrain.html'>Delete Train details</a><br>");
			    out.println("</center>");
				out.println("</html>");
			    out.println("</body>");*/
			   }
		   else
		   {
			   out.println("<body bgcolor='black'>");
				out.println("<center><br><br><br><br><br><br><br><br><br><h1><font face='cooper' color='yellow' size='50'>THIS LOGIN PAGE IS ACCESSED ONLY BY THE ADMINS !!</font></h1></center>");
				out.println("<center><h2><a href='homepage.html' align='right'><font color='white'>Home Page</font></a></h2></center>");

			   
			   
			   
		   }
		}
	
}

