package reservation_cancellation;

import java.io.IOException;
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
 * Servlet implementation class reservation2
 */
public class reservation2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reservation2() {
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
		 String train_no=request.getParameter("train_no");
		 HttpSession s=request.getSession();
		 s.setAttribute("train_no", train_no);
		
	
		 Statement st=conn.createStatement();
		  ResultSet rs=st.executeQuery("select * from trains where train_no='"+train_no+"'");
		  if(rs.next())
		  {
		  
			out.println("<form action='checkseats'>");
			 out.println("<body bgcolor='red'>");
		    out.println("<link rel='stylesheet' type='text/css' href='NewFile3.css'>");

			//out.println("<br><br><h1><center><font face='engravers mt' color='black'>Check your train details!!!</font></center></h1>");
			out.println("<center><table height='200' width='500' bgcolor='black'></center>");
			out.println("<tr><td>");
			 out.println("<tr align='center'><td><h2><font face='cooper' color='cyan'>Train no:</font></h2></td><td><h2><font face='cooper' color='cyan'>"+rs.getString(1)+"</font></h2></td></tr>");
			//out.println("<h2>Train no:</h2>"+"<h2>"+rs.getString(1)+"</h2>"); 
			 out.println("<tr align='center'><td><h2><font face='cooper' color='cyan'>Train name:</font></h2></td><td><h2><font face='cooper' color='cyan'>"+rs.getString(2)+"</font></h2></td></tr>");

			//out.println("<h2>Train name:</h2>"+rs.getString(2)+"<br>");  
			 out.println("<tr align='center'><td><h2><font face='cooper' color='cyan'>Train type:</font></h2></td><td><h2><font face='cooper' color='cyan'>"+rs.getString(3)+"</font></h2></td></tr>");

			//out.println("<h2>Train type:</h2>"+rs.getString(3)+"<br>"); 
			 out.println("<tr align='center'><td><h2><font face='cooper' color='cyan'>From:</font></h2></td><td><h2><font face='cooper' color='cyan'>"+rs.getString(4)+"</font></h2></td></tr>");

			//out.println("<h2>From:</h2>"+rs.getString(4)+"<br>"); 
			 out.println("<tr align='center'><td><h2><font face='cooper' color='cyan'>To:</font></h2></td><td><h2><font face='cooper' color='cyan'>"+rs.getString(5)+"</font></h2></td></tr>");

			//out.println("<h2>To:</h2>"+rs.getString(5)+"<br>");  
			out.println("<tr align='center'><td><h2><font face='cooper' color='cyan'>Enter seats to reserve:</font></h2></td><td><input type='text' name='seats'></td></tr><br>");
			
			out.println("<tr align='center'><td><h2><font face='cooper' color='cyan'>Enter reservation date:</font></h2></td><td><input type='text' name='date'></td></tr><br>");

			//out.println("<h2>Enter reservation date:</h2><input type='text' name='date'><br>");
			//out.println("<tr align='center'><td><h2><font face='cooper' color='red'><option value='0' selected>Tier:</option></font></h2><select name='menu3'>");
			//out.println("<tr align='center'><td><h2><font face='cooper'><option value='0' selected>Tier:</option></font></td></tr>");
			out.println("<tr align='center'><td><h2><font face='cooper' color='cyan'><option value='0'>Tier:</option></font></h2><select name='menu3'>");
			out.println("<option value='first_class'>First class</option>");
			out.println("<option value='ac_1_tier'>AC-1-tier</option>");
			out.println("<option value='ac_2_tier'>AC-2-tier</option>");
			out.println("<option value='ac_3_tier'>AC-3-tier</option>");
			out.println("<option value='sleeper_class'>Sleeper class</option>");
		    out.println("<option value='second_class'>Second class</option>");
			out.println("</select></td></tr><br><br><br>");
			//out.println("<br><br>");
			//out.println("<&nbsp<&nbsp<&nbsp<&nbsp<&nbsp<&nbsp<&nbsp<&nbsp<&nbsp>");
			out.println("<br><br><tr align='center'><td align='center'><center><input type='submit' value='Submit' id='sub'></center></td></tr><br>");
			out.println("</form>");
			out.println("</table><br><br></body></html>");
			//out.println("Tier"+rs.getString(1)+"<br><br>");  
			//out.println("Cost per ticket"+rs.getString(1)+"<br><br>");  
		}}
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
