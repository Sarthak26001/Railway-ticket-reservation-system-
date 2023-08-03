

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class password2
 */
public class password2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public password2() {
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
		String pass=request.getParameter("passn");
		HttpSession s=request.getSession();
		String uname=(String)s.getAttribute("email");
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
					
					Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","system");
					System.out.println("Successfully connected");	
					Statement st=conn.createStatement();
					st.executeUpdate("update register set passwrd='"+pass+"'where email='"+uname+"'");
					 out.println("<body bgcolor='black'>");
					out.println("<center><br><br><br><br><br><br><br><br><br><h1><font face='cooper' color='yellow' size='50'>Your Password has been changed!!!</font></h1></center>");
					out.println("<center><h2><a href='user.html' align='right'><font color='white'>Sign out</font></a></h2></center>");

	}
		catch(Exception e)
		{
		e.printStackTrace();	
		}
		}
	}


