

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class update_ac3tierseats
 */
public class update_ac3tierseats extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update_ac3tierseats() {
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
		  String train_no=request.getParameter("train_no");
		   
		  int ac_3_tier_seats=Integer.parseInt(request.getParameter("ac_3_tier_seats"));
	       
		    Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","system");
			System.out.println("Successfully connected");	
		    
		    Statement st=conn.createStatement();
		    
		        //st.executeQuery("select * from train3 where train_no=");
		  //  int i=	st.executeUpdate("update train3 set train_name='"+train_name+"',type='"+type+"',from_station='"+from_station+"', to_station='"+to_station+"',first_class='"+First_class+"', AC_1_tier='"+AC_1_tier+"',AC_2_tier='"+AC_2_tier+"',AC_3_tier='"+AC_3_tier+"',sleeper='"+sleeper_class+"',second class='"+second_class+"' where train_no='"+train_no+"' ");
				  

					  st.executeUpdate("update trains set ac_3_tier_seats='"+ac_3_tier_seats+"' where train_no='"+train_no+"' ");
			
					 
					 

					  out.println("<html>");
					  out.println("<body bgcolor='black'>");
					  out.println("<center>");
					  out.println("<br><br><br><h1><font face='cooper' color='yellow'>AC-3-Tier Seats numbered : "+train_no+" updated successfully!!!</font></h1><br><br>");
					  out.println("<h2><a href='Retrieve'>View table</a></h2>");
					  out.println("<h2><a href='adminlogin.html'>Log Out</a></h2>");
		    	
		
		    
		 }
		   catch(Exception e)
		   {
			  System.out.println(e);
		   }

	}

}
