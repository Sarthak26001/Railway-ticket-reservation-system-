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
 * Servlet implementation class reservation4
 */
public class reservation4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reservation4() {
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
		
		int seats=Integer.parseInt(request.getParameter("seats"));
		String date =request.getParameter("date");

				//Integer.parseInt(request.getParameter("seats"));
					
					
		HttpSession s=request.getSession();
		s.setAttribute("seats", seats);
		s.setAttribute("date", date);
		String tier=request.getParameter("menu3");
		s.setAttribute("menu3", tier);	    
		String train_no=(String)s.getAttribute("train_no");
		out.println("<form action='tier_verification1'>");
		out.println("<body bgcolor='black'>");
	     out.println("<link rel='stylesheet' type='text/css' href='NewFile4.css'>");
	     out.println("<br><br><br><br><br>");
		//out.println("<br><br><br><b><h2><center><font face='Engravers mt' color='red'>Enter your username first:</font><br><br><border='3'><input type='text' name='username' id='name'></border></b></h2><br>");
		out.println("<b><h2><font face='Engravers mt' color='red'><center>Fill up the following details!!</center></font></center></h2></b><br>");
		out.println("<center><table border='5' width='100' height='100'></center>");
		out.println("<td bgcolor='black' height='50' align='center'><font face='cooper' color='yellow'>NAME</font></td><td bgcolor='black' align='center'><font face='cooper' color='yellow'>GENDER</font></td><td bgcolor='black' align='center'><font face='cooper' color='yellow'>AGE</font></td>");
		for(int i=1;i<=seats;i++)
		{
				out.println("<tr><td align='center' bgcolor='cyan'><font face='comic sans ms' color='red'><input type='text' name='name' id='name1'></font></td><td align='center' bgcolor='cyan'><font face='comic sans ms' color='red'><input type='text'name='gender' id='name1'></font></td><td align='center' bgcolor='cyan'><font face='comic sans ms' color='red'><input type='text' name='age' id='name1'></font></td></tr>");
		}
		out.println("</table><br><br>");
		out.println("<input type='submit' value='Book' id='submit'>");
		out.println("</form>");
		
	
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
