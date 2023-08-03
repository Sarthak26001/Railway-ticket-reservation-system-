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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 * Servlet implementation class tier_verification1
 */
public class tier_verification1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tier_verification1() {
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
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","system");
		System.out.println("Successfully connected");			
		Statement st=conn.createStatement();
		
		
		//if(st1.equals(st1) && st2.equals(st2))
		//{
		
		
	
		PrintWriter out=response.getWriter();
		HttpSession s=request.getSession();
		String date=(String)s.getAttribute("date");
		String username=(String)s.getAttribute("email");
		String train_no=(String)s.getAttribute("train_no");
		ResultSet rs=st.executeQuery("select * from trains where train_no='"+train_no+"' ");
		String tier=(String)s.getAttribute("menu3");
		int seats=(int)s.getAttribute("seats");
		

		String name[]=request.getParameterValues("name");
		String gender[]=request.getParameterValues("gender");
		String age[]=request.getParameterValues("age");
		int cr=0;

		
	    out.println("<link rel='stylesheet' type='text/css' href='NewFile6.css'>");
		if(rs.next())
		if(tier.equals("first_class"))
		{  int total_cost= seats*Integer.parseInt(rs.getString(8));
			int cost_first_class=Integer.parseInt(rs.getString(8));
			String train_name=rs.getString(2);
			String type=rs.getString(3);
			String from=rs.getString(4);
			String to=rs.getString(5);
		    out.println("<h1><center><font face='elephant' color='black'>Your ticket fare is : " +seats*Integer.parseInt(rs.getString(8))+"</font></center></h1>");

			out.println("<html>");
			out.println("<body bgcolor='black'>"); 
			out.println("<div class='title'>");
			out.println("<a href='loginbutton.html' class='btn btn-log' >Login Page</a><br><br><br><br>");
			out.println("</div>");
			//out.println("<video autoplay loop width='' height='' class='video-background' muted plays-inline>");
			//out.println("<source src='train.mp4' type='video/mp4'></video>");
			  
			
			out.println("<center>"); 
			   out.println("<table bgcolor='lightblue'>");
			    out.println("<table bgcolor='yellow' border='5'>");
				
				out.println("<tr><td><h2><font face='cooper' color='black'>Train no:</font></h2></td><td align='center'><h2><font face='cooper' color='dark brown'>"+rs.getString(1)+"</font></h2></td></tr>");  
				out.println("<tr><td><h2><font face='cooper' color='black'>Train name:</font></h2></td><td align='center'><h2><font face='cooper' color='dark brown'>"+rs.getString(2)+"</font></h2></td></tr>");  
				out.println("<tr><td><h2><font face='cooper' color='black'>Train type:</font></h2></td><td align='center'><h2><font face='cooper' color='dark brown'>"+rs.getString(3)+"</font></h2></td></tr>");  
				out.println("<tr><td><h2><font face='cooper' color='black'>From:</font></h2></td><td align='center'><h2><font face='cooper' color='dark brown'>"+rs.getString(4)+"</font></h2></td></tr>");  
				out.println("<tr><td><h2><font face='cooper' color='black'>To:</font></h2></td><td align='center'><h2><font face='cooper' color='dark brown'>"+rs.getString(5)+"</font></h2></td></tr><br><br><br><br>");  
				out.println("</table>");
				out.println("<table border='5' bgcolor='cyan'>");

				
				PreparedStatement pst=conn.prepareStatement("update trains set first_class_seats=(first_class_seats-?) where train_no=? ");
				pst.setInt(1,seats);
				pst.setString(2,train_no);
				pst.executeUpdate();
			    out.println("</center");
				out.println("</table>");
				
				out.println("<br><br>");
				out.println("<td bgcolor='black' border='5' height='50' align='center'><font face='cooper' color='yellow'>NAME</font></td><td bgcolor='black' height='50' align='center'><font face='cooper' color='yellow'>GENDER</font></td><td bgcolor='black' height='50' align='center'><font face='cooper' color='yellow'>AGE</font></td><td bgcolor='black' height='50' align='center'><font face='cooper' color='yellow'>TIER</font></td><td bgcolor='black' height='50' align='center'><font face='cooper' color='yellow'>COST PER TICKET</font></td><td bgcolor='black' height='50' align='center'><font face='cooper' color='yellow'>RESERVATION DATE</font></td>");
				
				
			for(int i=0;i<=name.length;i++)
			{
				
				
			
				out.println("<tr><td align='center' width='100' height='50'><font face='cooper'>"+name[i]+"</font></td><td align='center' width='100'><font face='cooper'>"+gender[i]+"</font></td><td align='center' width='100'><font face='cooper'>"+age[i]+"</font></td><td align='center' width='100'><font face='cooper'>"+tier+"</font></td><td align='center' width='100'><font face='cooper'>"+cost_first_class+"</font></td><td align='center' width='100'><font face='cooper'>"+date+"</font></td></tr><br>");


			//out.println("<h2><a href='loginbutton.html' align='right'=>Login page</a></h2>");

				st.executeUpdate("insert into user4 values('"+username+"','"+train_no+"','"+name[i]+"','"+gender[i]+"','"+age[i]+"','"+tier+"','"+cost_first_class+"','"+total_cost+"','"+date+"','"+train_name+"','"+type+"','"+from+"','"+to+"','"+cr+"')");
					
			}


				out.println("</table><br><br>");
				out.println("</body>");
				out.println("</html>");
			
				
				
	
		
		
		}
		if(tier.equals("ac_1_tier"))
		{
			int total_cost=seats*Integer.parseInt(rs.getString(9));
			int cost_ac1=Integer.parseInt(rs.getString(9));
			String train_name=rs.getString(2);
			String type=rs.getString(3);
			String from=rs.getString(4);
			String to=rs.getString(5);
			
			    out.println("<h1><center><font face='elephant' color='black'>Your ticket fare is : " +seats*Integer.parseInt(rs.getString(9))+"</font></center></h1>");
			    //out.println("<h1><font face='cooper' color='red'>"+seats*Integer.parseInt(rs.getString(9))+"</font></h1>");
			    out.println("<body bgcolor='black'>"); 
				out.println("<center>"); 
				   out.println("<table bgcolor='lightblue'>");
				   out.println("<div class='title'>");
					out.println("<a href='loginbutton.html' class='btn btn-log' >Login Page</a><br><br><br><br>");
					out.println("</div>");
				    out.println("<table bgcolor='yellow' border='5'>");
					
					out.println("<tr><td><h2><font face='cooper' color='black'>Train no:</font></h2></td><td align='center'><h2><font face='cooper' color='dark brown'>"+rs.getString(1)+"</font></h2></td></tr>");  
					out.println("<tr><td><h2><font face='cooper' color='black'>Train name:</font></h2></td><td align='center'><h2><font face='cooper' color='dark brown'>"+rs.getString(2)+"</font></h2></td></tr>");  
					out.println("<tr><td><h2><font face='cooper' color='black'>Train type:</font></h2></td><td align='center'><h2><font face='cooper' color='dark brown'>"+rs.getString(3)+"</font></h2></td></tr>");  
					out.println("<tr><td><h2><font face='cooper' color='black'>From:</font></h2></td><td align='center'><h2><font face='cooper' color='dark brown'>"+rs.getString(4)+"</font></h2></td></tr>");  
					out.println("<tr><td><h2><font face='cooper' color='black'>To:</font></h2></td><td align='center'><h2><font face='cooper' color='dark brown'>"+rs.getString(5)+"</font></h2></td></tr><br><br><br><br>");  
					out.println("</table>");
					out.println("<table border='5' bgcolor='cyan'>");
					

				
				PreparedStatement pst=conn.prepareStatement("update trains set ac_1_tier_seats=(ac_1_tier_seats-?) where train_no=? ");
				pst.setInt(1,seats);
				pst.setString(2,train_no);
				pst.executeUpdate();
			    out.println("</center");
				out.println("</table>");
				out.println("</body>");
				
				out.println("<td bgcolor='black' border='5' height='50' align='center'><font face='cooper' color='yellow'>NAME</font></td><td bgcolor='black' height='50' align='center'><font face='cooper' color='yellow'>GENDER</font></td><td bgcolor='black' height='50' align='center'><font face='cooper' color='yellow'>AGE</font></td><td bgcolor='black' height='50' align='center'><font face='cooper' color='yellow'>TIER</font></td><td bgcolor='black' height='50' align='center'><font face='cooper' color='yellow'>COST PER TICKET</font></td><td bgcolor='black' height='50' align='center'><font face='cooper' color='yellow'>RESERVATION DATE</font></td>");
				
				
				for(int i=0;i<=name.length;i++)
				{
					
					
				
					out.println("<tr><td align='center' width='100' height='50'><font face='cooper'>"+name[i]+"</font></td><td align='center' width='100'><font face='cooper'>"+gender[i]+"</font></td><td align='center' width='100'><font face='cooper'>"+age[i]+"</font></td><td align='center' width='100'><font face='cooper'>"+tier+"</font></td><td align='center' width='100'><font face='cooper'>"+cost_ac1+"</font></td><td align='center' width='100'><font face='cooper'>"+date+"</font></td></tr><br>");
	              
						
					st.executeUpdate("insert into user4 values('"+username+"','"+train_no+"','"+name[i]+"','"+gender[i]+"','"+age[i]+"','"+tier+"','"+cost_ac1+"','"+total_cost+"','"+date+"','"+train_name+"','"+type+"','"+from+"','"+to+"','"+cr+"')");
						
				}				
				out.println("</table><br><br>");
			
				
				//out.println("Tier"+rs.getString(1)+"<br><br>");  
				//out.println("Cost per ticket"+rs.getString(1)+"<br><br>");  
			
			
			


		}

		if(tier.equals("ac_2_tier"))
		{
			int total_cost=seats*Integer.parseInt(rs.getString(10));
			int cost_ac2=Integer.parseInt(rs.getString(10));
			String train_name=rs.getString(2);
			String type=rs.getString(3);
			String from=rs.getString(4);
			String to=rs.getString(5);
		    out.println("<h1><center><font face='elephant' color='black'>Your ticket fare is : " +seats*Integer.parseInt(rs.getString(10))+"</font></center></h1>");

			out.println("<body bgcolor='black'>"); 
			out.println("<div class='title'>");
			out.println("<a href='loginbutton.html' class='btn btn-log' >Login Page</a><br><br><br><br>");
			out.println("</div>");
			out.println("<center>"); 
			   out.println("<table bgcolor='lightblue'>");
			    out.println("<table bgcolor='yellow' border='5'>");
				
				out.println("<tr><td><h2><font face='cooper' color='black'>Train no:</font></h2></td><td align='center'><h2><font face='cooper' color='dark brown'>"+rs.getString(1)+"</font></h2></td></tr>");  
				out.println("<tr><td><h2><font face='cooper' color='black'>Train name:</font></h2></td><td align='center'><h2><font face='cooper' color='dark brown'>"+rs.getString(2)+"</font></h2></td></tr>");  
				out.println("<tr><td><h2><font face='cooper' color='black'>Train type:</font></h2></td><td align='center'><h2><font face='cooper' color='dark brown'>"+rs.getString(3)+"</font></h2></td></tr>");  
				out.println("<tr><td><h2><font face='cooper' color='black'>From:</font></h2></td><td align='center'><h2><font face='cooper' color='dark brown'>"+rs.getString(4)+"</font></h2></td></tr>");  
				out.println("<tr><td><h2><font face='cooper' color='black'>To:</font></h2></td><td align='center'><h2><font face='cooper' color='dark brown'>"+rs.getString(5)+"</font></h2></td></tr><br><br><br><br>");  
				out.println("</table>");
				out.println("<table border='5' bgcolor='cyan'>");
				

			
				
				PreparedStatement pst=conn.prepareStatement("update trains set ac_2_tier_seats=(ac_2_tier_seats-?) where train_no=? ");
				pst.setInt(1,seats);
				pst.setString(2,train_no);
				pst.executeUpdate();
			    out.println("</center");
				out.println("</table>");
				out.println("</body>");

				
				
				out.println("<td bgcolor='black' border='5' height='50' align='center'><font face='cooper' color='yellow'>NAME</font></td><td bgcolor='black' height='50' align='center'><font face='cooper' color='yellow'>GENDER</font></td><td bgcolor='black' height='50' align='center'><font face='cooper' color='yellow'>AGE</font></td><td bgcolor='black' height='50' align='center'><font face='cooper' color='yellow'>TIER</font></td><td bgcolor='black' height='50' align='center'><font face='cooper' color='yellow'>COST PER TICKET</font></td><td bgcolor='black' height='50' align='center'><font face='cooper' color='yellow'>RESERVATION DATE</font></td>");
				
				
				for(int i=0;i<=name.length;i++)
				{
					
					
				
					out.println("<tr><td align='center' width='100' height='50'><font face='cooper'>"+name[i]+"</font></td><td align='center' width='100'><font face='cooper'>"+gender[i]+"</font></td><td align='center' width='100'><font face='cooper'>"+age[i]+"</font></td><td align='center' width='100'><font face='cooper'>"+tier+"</font></td><td align='center' width='100'><font face='cooper'>"+cost_ac2+"</font></td><td align='center' width='100'><font face='cooper'>"+date+"</font></td></tr><br>");
	              
						
					st.executeUpdate("insert into user4 values('"+username+"','"+train_no+"','"+name[i]+"','"+gender[i]+"','"+age[i]+"','"+tier+"','"+cost_ac2+"','"+total_cost+"','"+date+"','"+train_name+"','"+type+"','"+from+"','"+to+"','"+cr+"')");
						
				}
			
				out.println("</table><br><br>");		

		}
		
		if(tier.equals("ac_3_tier"))
		{
			int total_cost=seats*Integer.parseInt(rs.getString(11));
			int cost_ac3=Integer.parseInt(rs.getString(11));
			String train_name=rs.getString(2);
			String type=rs.getString(3);
			String from=rs.getString(4);
			String to=rs.getString(5);
		    out.println("<h1><center><font face='elephant' color='black'>Your ticket fare is : " +seats*Integer.parseInt(rs.getString(11))+"</font></center></h1>");

			   // out.println("Rs."+seats*Integer.parseInt(rs.getString(9)));
			    out.println("<body bgcolor='black'>"); 
			    out.println("<div class='title'>");
				out.println("<a href='loginbutton.html' class='btn btn-log' >Login Page</a><br><br><br><br>");
				out.println("</div>");
				out.println("<center>"); 
				   out.println("<table bgcolor='lightblue'>");
				    out.println("<table bgcolor='yellow' border='5'>");
					
					out.println("<tr><td><h2><font face='cooper' color='black'>Train no:</font></h2></td><td align='center'><h2><font face='cooper' color='dark brown'>"+rs.getString(1)+"</font></h2></td></tr>");  
					out.println("<tr><td><h2><font face='cooper' color='black'>Train name:</font></h2></td><td align='center'><h2><font face='cooper' color='dark brown'>"+rs.getString(2)+"</font></h2></td></tr>");  
					out.println("<tr><td><h2><font face='cooper' color='black'>Train type:</font></h2></td><td align='center'><h2><font face='cooper' color='dark brown'>"+rs.getString(3)+"</font></h2></td></tr>");  
					out.println("<tr><td><h2><font face='cooper' color='black'>From:</font></h2></td><td align='center'><h2><font face='cooper' color='dark brown'>"+rs.getString(4)+"</font></h2></td></tr>");  
					out.println("<tr><td><h2><font face='cooper' color='black'>To:</font></h2></td><td align='center'><h2><font face='cooper' color='dark brown'>"+rs.getString(5)+"</font></h2></td></tr><br><br><br><br>");  
					out.println("</table>");
					out.println("<table border='5' bgcolor='cyan'>");
					

				
				PreparedStatement pst=conn.prepareStatement("update trains set ac_3_tier_seats=(ac_3_tier_seats-?) where train_no=? ");
				pst.setInt(1,seats);
				pst.setString(2,train_no);
				pst.executeUpdate();
			    out.println("</center");
				out.println("</table>");
				out.println("</body>");
				
				out.println("<td bgcolor='black' border='5' height='50' align='center'><font face='cooper' color='yellow'>NAME</font></td><td bgcolor='black' height='50' align='center'><font face='cooper' color='yellow'>GENDER</font></td><td bgcolor='black' height='50' align='center'><font face='cooper' color='yellow'>AGE</font></td><td bgcolor='black' height='50' align='center'><font face='cooper' color='yellow'>TIER</font></td><td bgcolor='black' height='50' align='center'><font face='cooper' color='yellow'>COST PER TICKET</font></td><td bgcolor='black' height='50' align='center'><font face='cooper' color='yellow'>RESERVATION DATE</font></td>");
				
				
				for(int i=0;i<=name.length;i++)
				{
					
					
				
					out.println("<tr><td align='center' width='100' height='50'><font face='cooper'>"+name[i]+"</font></td><td align='center' width='100'><font face='cooper'>"+gender[i]+"</font></td><td align='center' width='100'><font face='cooper'>"+age[i]+"</font></td><td align='center' width='100'><font face='cooper'>"+tier+"</font></td><td align='center' width='100'><font face='cooper'>"+cost_ac3+"</font></td><td align='center' width='100'><font face='cooper'>"+date+"</font></td></tr><br>");
	              
						
					st.executeUpdate("insert into user4 values('"+username+"','"+train_no+"','"+name[i]+"','"+gender[i]+"','"+age[i]+"','"+tier+"','"+cost_ac3+"','"+total_cost+"','"+date+"','"+train_name+"','"+type+"','"+from+"','"+to+"','"+cr+"')");
						
				}				
				out.println("</table><br><br>");
			
				
				//out.println("Tier"+rs.getString(1)+"<br><br>");  
				//out.println("Cost per ticket"+rs.getString(1)+"<br><br>");  
			
			
			


		}
		if(tier.equals("sleeper_class"))
		{int cost_sleeper_class=Integer.parseInt(rs.getString(12));
		  int total_cost=seats*Integer.parseInt(rs.getString(12));
		  String train_name=rs.getString(2);
			String type=rs.getString(3);
			String from=rs.getString(4);
			String to=rs.getString(5);
		    out.println("<h1><center><font face='elephant' color='black'>Your ticket fare is : " +seats*Integer.parseInt(rs.getString(12))+"</font></center></h1>");

			out.println("<body bgcolor='black'>"); 
			out.println("<div class='title'>");
			out.println("<a href='loginbutton.html' class='btn btn-log' >Login Page</a><br><br><br><br>");
			out.println("</div>");
			out.println("<center>"); 
			   out.println("<table bgcolor='lightblue'>");
			    out.println("<table bgcolor='yellow' border='5'>");
				
				out.println("<tr><td><h2><font face='cooper' color='black'>Train no:</font></h2></td><td align='center'><h2><font face='cooper' color='dark brown'>"+rs.getString(1)+"</font></h2></td></tr>");  
				out.println("<tr><td><h2><font face='cooper' color='black'>Train name:</font></h2></td><td align='center'><h2><font face='cooper' color='dark brown'>"+rs.getString(2)+"</font></h2></td></tr>");  
				out.println("<tr><td><h2><font face='cooper' color='black'>Train type:</font></h2></td><td align='center'><h2><font face='cooper' color='dark brown'>"+rs.getString(3)+"</font></h2></td></tr>");  
				out.println("<tr><td><h2><font face='cooper' color='black'>From:</font></h2></td><td align='center'><h2><font face='cooper' color='dark brown'>"+rs.getString(4)+"</font></h2></td></tr>");  
				out.println("<tr><td><h2><font face='cooper' color='black'>To:</font></h2></td><td align='center'><h2><font face='cooper' color='dark brown'>"+rs.getString(5)+"</font></h2></td></tr><br><br><br><br>");  
				out.println("</table>");
				out.println("<table border='5' bgcolor='cyan'>");
				

				PreparedStatement pst=conn.prepareStatement("update trains set sleeper_class_seats=(sleeper_class_seats-?) where train_no=? ");
				pst.setInt(1,seats);
				pst.setString(2,train_no);
				pst.executeUpdate();
			    out.println("</center");
				out.println("</table>");
				out.println("</body>");
				
				out.println("<td bgcolor='black' border='5' height='50' align='center'><font face='cooper' color='yellow'>NAME</font></td><td bgcolor='black' height='50' align='center'><font face='cooper' color='yellow'>GENDER</font></td><td bgcolor='black' height='50' align='center'><font face='cooper' color='yellow'>AGE</font></td><td bgcolor='black' height='50' align='center'><font face='cooper' color='yellow'>TIER</font></td><td bgcolor='black' height='50' align='center'><font face='cooper' color='yellow'>COST PER TICKET</font></td><td bgcolor='black' height='50' align='center'><font face='cooper' color='yellow'>RESERVATION DATE</font></td>");
				
				
				for(int i=0;i<=name.length;i++)
				{
					
					
				
					out.println("<tr><td align='center' width='100' height='50'><font face='cooper'>"+name[i]+"</font></td><td align='center' width='100'><font face='cooper'>"+gender[i]+"</font></td><td align='center' width='100'><font face='cooper'>"+age[i]+"</font></td><td align='center' width='100'><font face='cooper'>"+tier+"</font></td><td align='center' width='100'><font face='cooper'>"+cost_sleeper_class+"</font></td><td align='center' width='100'><font face='cooper'>"+date+"</font></td></tr><br>");
	              
						
					st.executeUpdate("insert into user4 values('"+username+"','"+train_no+"','"+name[i]+"','"+gender[i]+"','"+age[i]+"','"+tier+"','"+cost_sleeper_class+"','"+total_cost+"','"+date+"','"+train_name+"','"+type+"','"+from+"','"+to+"','"+cr+"')");
						
				}				
				
				out.println("</table><br><br>");

		
				
				//out.println("Tier"+rs.getString(1)+"<br><br>");  
				//out.println("Cost per ticket"+rs.getString(1)+"<br><br>");  
			
			
		
			
	

		}
		if(tier.equals("second_class"))
		{
			int total_cost=seats*Integer.parseInt(rs.getString(13));
			int cost_second_class=Integer.parseInt(rs.getString(13));
			String train_name=rs.getString(2);
			String type=rs.getString(3);
			String from=rs.getString(4);
			String to=rs.getString(5);
		    out.println("<h1><center><font face='elephant' color='black'>Your ticket fare is : " +seats*Integer.parseInt(rs.getString(13))+"</font></center></h1>");

			out.println("<body bgcolor='black'>"); 
			out.println("<div class='title'>");
			out.println("<a href='loginbutton.html' class='btn btn-log' >Login Page</a><br><br><br><br>");
			out.println("</div>");
			out.println("<center>"); 
			   out.println("<table bgcolor='lightblue'>");
			    out.println("<table bgcolor='yellow' border='5'>");
				
				out.println("<tr><td><h2><font face='cooper' color='black'>Train no:</font></h2></td><td align='center'><h2><font face='cooper' color='dark brown'>"+rs.getString(1)+"</font></h2></td></tr>");  
				out.println("<tr><td><h2><font face='cooper' color='black'>Train name:</font></h2></td><td align='center'><h2><font face='cooper' color='dark brown'>"+rs.getString(2)+"</font></h2></td></tr>");  
				out.println("<tr><td><h2><font face='cooper' color='black'>Train type:</font></h2></td><td align='center'><h2><font face='cooper' color='dark brown'>"+rs.getString(3)+"</font></h2></td></tr>");  
				out.println("<tr><td><h2><font face='cooper' color='black'>From:</font></h2></td><td align='center'><h2><font face='cooper' color='dark brown'>"+rs.getString(4)+"</font></h2></td></tr>");  
				out.println("<tr><td><h2><font face='cooper' color='black'>To:</font></h2></td><td align='center'><h2><font face='cooper' color='dark brown'>"+rs.getString(5)+"</font></h2></td></tr><br><br><br><br>");  
				out.println("</table>");
				out.println("<table border='5' bgcolor='cyan'>");
				

				PreparedStatement pst=conn.prepareStatement("update trains set second_class_seats=(second_class_seats-?) where train_no=? ");
				pst.setInt(1,seats);
				pst.setString(2,train_no);
				pst.executeUpdate();
			    out.println("</center");
				out.println("</table>");
				out.println("</body>");
				
				
				
				out.println("<td bgcolor='black' border='5' height='50' align='center'><font face='cooper' color='yellow'>NAME</font></td><td bgcolor='black' height='50' align='center'><font face='cooper' color='yellow'>GENDER</font></td><td bgcolor='black' height='50' align='center'><font face='cooper' color='yellow'>AGE</font></td><td bgcolor='black' height='50' align='center'><font face='cooper' color='yellow'>TIER</font></td><td bgcolor='black' height='50' align='center'><font face='cooper' color='yellow'>COST PER TICKET</font></td><td bgcolor='black' height='50' align='center'><font face='cooper' color='yellow'>RESERVATION DATE</font></td>");
				
				
				for(int i=0;i<=name.length;i++)
				{
					
					
				
					out.println("<tr><td align='center' width='100' height='50'><font face='cooper'>"+name[i]+"</font></td><td align='center' width='100'><font face='cooper'>"+gender[i]+"</font></td><td align='center' width='100'><font face='cooper'>"+age[i]+"</font></td><td align='center' width='100'><font face='cooper'>"+tier+"</font></td><td align='center' width='100'><font face='cooper'>"+cost_second_class+"</font></td><td align='center' width='100'><font face='cooper'>"+date+"</font></td></tr><br>");
	              
						
					st.executeUpdate("insert into user4 values('"+username+"','"+train_no+"','"+name[i]+"','"+gender[i]+"','"+age[i]+"','"+tier+"','"+cost_second_class+"','"+total_cost+"','"+date+"','"+train_name+"','"+type+"','"+from+"','"+to+"','"+cr+"')");	
				}				
				
				out.println("</table><br><br>");


			
				
				//out.println("Tier"+rs.getString(1)+"<br><br>");  
				//out.println("Cost per ticket"+rs.getString(1)+"<br><br>");  
			
		
			

		}
		
		
		}catch(Exception e)
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
