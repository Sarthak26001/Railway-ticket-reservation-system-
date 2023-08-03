

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class registration
 */
public class registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String mob=request.getParameter("mob");
		String age=request.getParameter("age");
		String email=request.getParameter("email");
		String password=request.getParameter("pass");
	    String gender=request.getParameter("gender");
		String selected_gender=(gender.equals("male")?"male":gender.equals("female")?"female":"male");
		
		 ProductBean p=new ProductBean();
		  String status = p.register(firstname,lastname,mob,age,email,password,selected_gender);
		  out.println("<html>");
		  //out.println("<body bgcolor='cyan'");
		     out.println("<link rel='stylesheet' type='text/css' href='back.css'>");

		  out.println("<center>");
		  out.println("<font face='engravers mt'>");
		  out.println("<marquee direction='left' behaviour='alternate' scrollamount='6'><h1><font color='yellow'>Check your Registration Details</font-color></marquee></h1><br><br>");
		  out.println("</font>");
	      out.println("<table height=400' width='600' align='center'  bgcolor='coral', border='8'>");
		  out.println("<tr align='center'><td><h2><font face='cooper'>First Name:</font></h2></td><td><h2><font face='cooper'>"+firstname+"</font></h2></td></tr>");
		  out.println("<tr align='center'><td><h2><font face='cooper'>Last Name:</font></h2></td><td><h2><font face='cooper'>"+lastname+"</font></h2></td></tr>");
		  out.println("<tr align='center'><td><h2><font face='cooper'>Mobile No:</font></h2></td><td><h2><font face='cooper'>"+mob+"</font></h2></td></tr>");
		  out.println("<tr align='center'><td><h2><font face='cooper'>Age:</font></h2></td><td><h2><font face='cooper'>"+age+"</font></h2></td></tr>");
		  out.println("<tr align='center'><td><h2><font face='cooper'>Email:</font></h2></td><td><h2><font face='cooper'>"+email+"</font></h2></td></tr>");
		  out.println("<tr align='center'><td><h2><font face='cooper'>Password:</font></h2></td><td><h2><font face='cooper'>"+password+"</font></h2></td></tr>");
		  out.println("<tr align='center'><td><h2><font face='cooper'>Gender:</font></h2></td><td><h2><font face='cooper'>"+selected_gender+"</font></h2></td></tr>");
		  out.println("<tr align='center'><td><h2><font face='cooper'>Registration:</font></h2></td><td><h2><font face='cooper'>"+status+"</font></h2></td></tr>");
		  out.println("</table>");
		  out.print("</center>");
		  out.print("</body>");
		  out.print("</html>");
		  out.print("<h2><a href='user.html'><font color='white'><b>Go to login page</b></font></h2></a>");
		
	}

}
