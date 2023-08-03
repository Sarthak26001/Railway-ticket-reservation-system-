package reservation_cancellation;

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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class cancel
 */
public class cancel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cancel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		//String st2;
		//String st3;
		
				try {
					
		Class.forName("oracle.jdbc.driver.OracleDriver");
				
				Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","system");
				System.out.println("Successfully connected");	
				Statement st=conn.createStatement();
				HttpSession s=request.getSession();
				String uname=(String)s.getAttribute("email");
				String tn=(String)s.getAttribute("tn");
				String da=(String)s.getAttribute("da");
				
				//if(st1.equals(st1) && st2.equals(st2))
				//{
				
				
				ResultSet rst=st.executeQuery("select * from user4 where email='"+uname+"' and train_no='"+tn+"' and reservation_date='"+da+"'");
				
				out.println("<html>");
			    out.println("<body bgcolor=''>");
			    
			    out.println("<form action='cancel2'>");
			    out.println("<h2><a href='user.html'><font color='white'>Sign out</font></a></h2>");
			    out.println("<link rel='stylesheet' type='text/css' href='NewFile7.css'>");

			    out.println("<br><br><br><br><br><br><br>");
			    out.println("<center>");
			    out.println("<table border='5'>");
			
				//ResultSetMetaData rsmd=rst.getMetaData();
				//int columncount=rsmd.getColumnCount();
				//for(int i=1;i<=columncount;i++)
				//{
				//	String columnname=rsmd.getColumnName(i);
					//out.println("<tr><th>train_no train_name type from_station to_station First_class AC_1_tier var AC_2_tier AC_3_tier sleeper second_class </tr></th><br>");
				//	out.print("<td bgcolor='yellow'>"+columnname+"</td>");
			//	}
				out.println("<td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>NAME</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>TRAIN NO</font></td><td bgcolor='black' height='70' width='120' align='center'><font face='cooper' color='yellow'>GENDER</font></td><td bgcolor='black' height='70' width='120' align='center'><font face='cooper' color='yellow'>AGE</font></td><td bgcolor='black' height='70' width='120' align='center'><font face='cooper' color='yellow'>TIER</font></td>");

			    
				//out.print("<td bgcolor='yellow'>NAME</td><td bgcolor='yellow'>TRAIN NO.</td><td bgcolor='yellow'>GENDER</td><td bgcolor='yellow'>AGE</td><td bgcolor='yellow'>TIER</td>");
			    while(rst.next())
				{   
			    	
					out.println("<b><tr><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'><input type='radio' name='name' value="+rst.getString(3)+">  <font face='cooper'>"+rst.getString(3)+"</font></td><td bgcolor='coral' align='center'><font face='cooper'>"+rst.getString(2)+"</font></td><td bgcolor='coral' align='center'><font face='cooper'>"+rst.getString(4)+"</font></td><td bgcolor='coral' align='center'><font face='cooper'>"+rst.getString(5)+"</font></td><td bgcolor='coral' align='center'><font face='cooper'>"+rst.getString(6)+"</font></td></tr></b>");

					//out.println("<tr><td><input type='radio' name='name' value="+rst.getString(3)+">"+rst.getString(3)+"</td><td>"+rst.getString(2)+"</td><td>"+rst.getString(4)+"</td><td>"+rst.getString(5)+"</td><td>"+rst.getString(6)+"</td></tr>");
				}
				out.println("</table>");
				out.println("<input type='submit' value='Cancel' id='can'>");
					 
			    out.println("</center>");
			    
				out.println("</body>");
				out.println("</html>");
				
				}catch(Exception e)
				{
					out.println(e);
				}

	}

}
