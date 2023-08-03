

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class validreg
 */
public class validreg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public validreg() {
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
		int sage=Integer.parseInt(request.getParameter("age"));
		String pass=request.getParameter("pass");
		String pass1=request.getParameter("pass1");
		int pwd=pass1.length();
		if(sage>18 && pwd>=8 && pass.equals(pass1))
		{
			RequestDispatcher rd=request.getRequestDispatcher("registration");
			rd.forward(request, response);
		}else
		{
			
			
			out.println("<body bgcolor='black'>");
			out.println("<center><br><br><br><br><br><br><br><br><br><h1><font face='cooper' color='yellow' size='50'>Either you are Underage to register an account or Your password credentials does not match.<br>Re-enter your details as per validations.</font></h1></center>");
			out.println("<center><h2><a href='register.html' align='right'><font color='white'>Register Here</font></a></h2></center>");

		}
		

	}

}
