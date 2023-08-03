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
 * Servlet implementation class cancel2
 */
public class cancel2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cancel2() {
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
		try{
			String name=request.getParameter("name");
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","system");
			System.out.println("Successfully connected");	
			Statement st=conn.createStatement();
			HttpSession s=request.getSession();
			String uname=(String)s.getAttribute("uname");
			
			ResultSet rst=st.executeQuery("select * from user4 where name='"+name+"'");
			if(rst.next())
			
			{
				  int orignal_cost=rst.getInt(7);
				  String train_no=rst.getString(2);
				  String date=rst.getString(9);
				  int total_cost=rst.getInt(8);
				  int cost_returned=orignal_cost/2;
				  int new_cost=total_cost-cost_returned;
				 String train_name= rst.getString(10);
				  String type=rst.getString(11);
				  String from=rst.getString(12);
				  String to=rst.getString(13);
				  
				  int cost_r1=rst.getInt(14);
				  int cost_r2=cost_r1+cost_returned;
				 
				    out.println("<link rel='stylesheet' type='text/css' href='NewFile8.css'>");

				 
				  
					  if(rst.getString(6).equals("first_class"))
			{
			//	String train_no=rst.getString(2);
				int i=st.executeUpdate("update trains set first_class_seats=(first_class_seats+1) where train_no='"+train_no+"' ");
			    
				int j= st.executeUpdate("delete from user4 where name='"+name+"' and train_no='"+train_no+"'");
			
				st.executeUpdate("Update user4 set total_cost=(total_cost-'"+cost_returned+"')where train_no='"+train_no+"' and reservation_date='"+date+"'");
		   

			
			st.executeUpdate("Update user4 set cost_returned=(cost_returned+'"+cost_returned+"')where train_no='"+train_no+"' and reservation_date='"+date+"'");
			out.println("<h1><font face='cooper' color='yellow'>Ticket of passenger named " +name+ " has been cancelled</font></h1>");
			   // int orignal_cost=rst.getInt(7);
			 
			    out.println("<h1><font face='cooper' color='yellow'>Total cost returned:Rs."+cost_r2+"</font></h1>");
				out.println("<h1><font face='cooper' color='yellow'>Rs."+new_cost+"</font></h1>");

			   // int total_cost=rst.getInt(8);
			    //float new_cost=total_cost-cost_returned;
				
				//out.println("<body bgcolor='lightblue'>"); 

				out.println("<center>"); 
				   out.println("<table bgcolor='lightblue'>");
				    //out.println("<table bgcolor='lightblue'>");
				/*	out.println("<td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Name:</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+name+"</font></td>"); 

					out.println("<td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Train no:</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+train_no+"</font></td>"); 
					out.println("<td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Train name:</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+train_name+"</font></td>");
					out.println("<td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Type:</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+type+"</font></td>");  
					out.println("<td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>From:</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+from+"</font></td>");  
					out.println("<td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>To:</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+to+"</font></td><br><br><br><br><br><br>");  
				  */
					//out.println("<br><br><br><br><br><br>");
					out.println("<table border='5' bgcolor='white'>");
					
			
				
					out.println("<br><br><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Name</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Train no.</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Gender</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Age</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Tier</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Cost per ticket</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Reservation date</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Train Name</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>From</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>To</font></td>");
			
					ResultSet rst2=st.executeQuery("select * from user4 where train_no='"+train_no+"' and reservation_date='"+date+"'");
					while(rst2.next())
					{
						
						out.println("<tr><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(3)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(2)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(4)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(5)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(6)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(7)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(9)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(10)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(12)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(13)+"</font></td></tr>");
					}
				
				  
				
					
					out.println("</table><br>");
			
				
			    out.println("<h2><a href='cancel'><font color='white'>Cancel more tickets</font></a></h2>");
				out.println("<h2><a href='user.html' align='right'><font color='white'>Sign out</font></a></h2>");
               }
			
					  if(rst.getString(6).equals("ac_1_tier"))
						{
						//	String train_no=rst.getString(2);
							int i=st.executeUpdate("update trains set ac_1_tier_seats=(ac_1_tier_seats+1) where train_no='"+train_no+"' ");
						    
							int j= st.executeUpdate("delete from user4 where name='"+name+"' and train_no='"+train_no+"'");
						
							st.executeUpdate("Update user4 set total_cost=(total_cost-'"+cost_returned+"')where train_no='"+train_no+"' and reservation_date='"+date+"'");
					   

						
						st.executeUpdate("Update user4 set cost_returned=(cost_returned+'"+cost_returned+"')where train_no='"+train_no+"' and reservation_date='"+date+"'");
						out.println("<h1><font face='cooper' color='yellow'>Ticket of passenger named " +name+ " has been cancelled</font></h1>");
						   // int orignal_cost=rst.getInt(7);
						 
						    out.println("<h1><font face='cooper' color='yellow'>Total cost returned:Rs."+cost_r2+"</font></h1>");
							out.println("<h1><font face='cooper' color='yellow'>Rs."+new_cost+"</font></h1>");

						   // int total_cost=rst.getInt(8);
						    //float new_cost=total_cost-cost_returned;
							
							//out.println("<body bgcolor='lightblue'>"); 

							out.println("<center>"); 
							   out.println("<table bgcolor='lightblue'>");
							    //out.println("<table bgcolor='lightblue'>");
							/*	out.println("<td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Name:</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+name+"</font></td>"); 

								out.println("<td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Train no:</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+train_no+"</font></td>"); 
								out.println("<td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Train name:</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+train_name+"</font></td>");
								out.println("<td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Type:</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+type+"</font></td>");  
								out.println("<td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>From:</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+from+"</font></td>");  
								out.println("<td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>To:</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+to+"</font></td><br><br><br><br><br><br>");  
							  */
								//out.println("<br><br><br><br><br><br>");
								out.println("<table border='5' bgcolor='white'>");
								
						
							
								out.println("<br><br><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Name</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Train no.</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Gender</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Age</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Tier</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Cost per ticket</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Reservation date</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Train Name</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>From</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>To</font></td>");
						
								ResultSet rst2=st.executeQuery("select * from user4 where train_no='"+train_no+"' and reservation_date='"+date+"'");
								while(rst2.next())
								{
									
									out.println("<tr><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(3)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(2)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(4)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(5)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(6)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(7)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(9)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(10)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(12)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(13)+"</font></td></tr>");
								}
							
							  
							
								
								out.println("</table><br>");
						
							
						    out.println("<h2><a href='cancel'><font color='white'>Cancel more tickets</font></a></h2>");
							out.println("<h2><a href='user.html' align='right'><font color='white'>Sign out</font></a></h2>");
			}

					  
					  if(rst.getString(6).equals("ac_2_tier"))
						{
						//	String train_no=rst.getString(2);
							int i=st.executeUpdate("update trains set ac_2_tier_seats=(ac_2_tier_seats+1) where train_no='"+train_no+"' ");
						    
							int j= st.executeUpdate("delete from user4 where name='"+name+"' and train_no='"+train_no+"'");
						
							st.executeUpdate("Update user4 set total_cost=(total_cost-'"+cost_returned+"')where train_no='"+train_no+"' and reservation_date='"+date+"'");
					   

						
						st.executeUpdate("Update user4 set cost_returned=(cost_returned+'"+cost_returned+"')where train_no='"+train_no+"' and reservation_date='"+date+"'");
						out.println("<h1><font face='cooper' color='yellow'>Ticket of passenger named " +name+ " has been cancelled</font></h1>");
						   // int orignal_cost=rst.getInt(7);
						 
						    out.println("<h1><font face='cooper' color='yellow'>Total cost returned:Rs."+cost_r2+"</font></h1>");
							out.println("<h1><font face='cooper' color='yellow'>Rs."+new_cost+"</font></h1>");

						   // int total_cost=rst.getInt(8);
						    //float new_cost=total_cost-cost_returned;
							
							//out.println("<body bgcolor='lightblue'>"); 

							out.println("<center>"); 
							   out.println("<table bgcolor='lightblue'>");
							    //out.println("<table bgcolor='lightblue'>");
							/*	out.println("<td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Name:</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+name+"</font></td>"); 

								out.println("<td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Train no:</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+train_no+"</font></td>"); 
								out.println("<td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Train name:</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+train_name+"</font></td>");
								out.println("<td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Type:</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+type+"</font></td>");  
								out.println("<td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>From:</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+from+"</font></td>");  
								out.println("<td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>To:</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+to+"</font></td><br><br><br><br><br><br>");  
							  */
								//out.println("<br><br><br><br><br><br>");
								out.println("<table border='5' bgcolor='white'>");
								
						
							
								out.println("<br><br><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Name</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Train no.</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Gender</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Age</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Tier</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Cost per ticket</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Reservation date</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Train Name</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>From</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>To</font></td>");
						
								ResultSet rst2=st.executeQuery("select * from user4 where train_no='"+train_no+"' and reservation_date='"+date+"'");
								while(rst2.next())
								{
									
									out.println("<tr><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(3)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(2)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(4)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(5)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(6)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(7)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(9)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(10)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(12)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(13)+"</font></td></tr>");
								}
							
							  
							
								
								out.println("</table><br>");
						
							
						    out.println("<h2><a href='cancel'><font color='white'>Cancel more tickets</font></a></h2>");
							out.println("<h2><a href='user.html' align='right'><font color='white'>Sign out</font></a></h2>");
			}

		
	
					  if(rst.getString(6).equals("ac_3_tier"))
						{
						//	String train_no=rst.getString(2);
							int i=st.executeUpdate("update trains set ac_3_tier_seats=(ac_3_tier_seats+1) where train_no='"+train_no+"' ");
						    
							int j= st.executeUpdate("delete from user4 where name='"+name+"' and train_no='"+train_no+"'");
						
							st.executeUpdate("Update user4 set total_cost=(total_cost-'"+cost_returned+"')where train_no='"+train_no+"' and reservation_date='"+date+"'");
					   

						
						st.executeUpdate("Update user4 set cost_returned=(cost_returned+'"+cost_returned+"')where train_no='"+train_no+"' and reservation_date='"+date+"'");
						out.println("<h1><font face='cooper' color='yellow'>Ticket of passenger named " +name+ " has been cancelled</font></h1>");
						   // int orignal_cost=rst.getInt(7);
						 
						    out.println("<h1><font face='cooper' color='yellow'>Total cost returned:Rs."+cost_r2+"</font></h1>");
							out.println("<h1><font face='cooper' color='yellow'>Rs."+new_cost+"</font></h1>");

						   // int total_cost=rst.getInt(8);
						    //float new_cost=total_cost-cost_returned;
							
							//out.println("<body bgcolor='lightblue'>"); 

							out.println("<center>"); 
							   out.println("<table bgcolor='lightblue'>");
							    //out.println("<table bgcolor='lightblue'>");
							/*	out.println("<td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Name:</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+name+"</font></td>"); 

								out.println("<td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Train no:</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+train_no+"</font></td>"); 
								out.println("<td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Train name:</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+train_name+"</font></td>");
								out.println("<td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Type:</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+type+"</font></td>");  
								out.println("<td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>From:</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+from+"</font></td>");  
								out.println("<td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>To:</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+to+"</font></td><br><br><br><br><br><br>");  
							  */
								//out.println("<br><br><br><br><br><br>");
								out.println("<table border='5' bgcolor='white'>");
								
						
							
								out.println("<br><br><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Name</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Train no.</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Gender</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Age</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Tier</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Cost per ticket</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Reservation date</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Train Name</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>From</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>To</font></td>");
						
								ResultSet rst2=st.executeQuery("select * from user4 where train_no='"+train_no+"' and reservation_date='"+date+"'");
								while(rst2.next())
								{
									
									out.println("<tr><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(3)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(2)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(4)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(5)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(6)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(7)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(9)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(10)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(12)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(13)+"</font></td></tr>");
								}
							
							  
							
								
								out.println("</table><br>");
						
							
						    out.println("<h2><a href='cancel'><font color='white'>Cancel more tickets</font></a></h2>");
							out.println("<h2><a href='user.html' align='right'><font color='white'>Sign out</font></a></h2>");
			}

					  if(rst.getString(6).equals("sleeper_class"))
						{
						//	String train_no=rst.getString(2);
							int i=st.executeUpdate("update trains set sleeper_class_seats=(sleeper_class_seats+1) where train_no='"+train_no+"' ");
						    
							int j= st.executeUpdate("delete from user4 where name='"+name+"' and train_no='"+train_no+"'");
						
							st.executeUpdate("Update user4 set total_cost=(total_cost-'"+cost_returned+"')where train_no='"+train_no+"' and reservation_date='"+date+"'");
					   

						
						st.executeUpdate("Update user4 set cost_returned=(cost_returned+'"+cost_returned+"')where train_no='"+train_no+"' and reservation_date='"+date+"'");
						out.println("<h1><font face='cooper' color='yellow'>Ticket of passenger named " +name+ " has been cancelled</font></h1>");
						   // int orignal_cost=rst.getInt(7);
						 
						    out.println("<h1><font face='cooper' color='yellow'>Total cost returned:Rs."+cost_r2+"</font></h1>");
							out.println("<h1><font face='cooper' color='yellow'>Rs."+new_cost+"</font></h1>");

						   // int total_cost=rst.getInt(8);
						    //float new_cost=total_cost-cost_returned;
							
							//out.println("<body bgcolor='lightblue'>"); 

							out.println("<center>"); 
							   out.println("<table bgcolor='lightblue'>");
							    //out.println("<table bgcolor='lightblue'>");
							/*	out.println("<td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Name:</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+name+"</font></td>"); 

								out.println("<td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Train no:</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+train_no+"</font></td>"); 
								out.println("<td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Train name:</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+train_name+"</font></td>");
								out.println("<td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Type:</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+type+"</font></td>");  
								out.println("<td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>From:</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+from+"</font></td>");  
								out.println("<td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>To:</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+to+"</font></td><br><br><br><br><br><br>");  
							  */
								//out.println("<br><br><br><br><br><br>");
								out.println("<table border='5' bgcolor='white'>");
								
						
							
								out.println("<br><br><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Name</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Train no.</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Gender</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Age</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Tier</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Cost per ticket</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Reservation date</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Train Name</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>From</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>To</font></td>");
						
								ResultSet rst2=st.executeQuery("select * from user4 where train_no='"+train_no+"' and reservation_date='"+date+"'");
								while(rst2.next())
								{
									
									out.println("<tr><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(3)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(2)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(4)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(5)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(6)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(7)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(9)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(10)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(12)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(13)+"</font></td></tr>");
								}
							
							  
							
								
								out.println("</table><br>");
						
							
						    out.println("<h2><a href='cancel'><font color='white'>Cancel more tickets</font></a></h2>");
							out.println("<h2><a href='user.html' align='right'><font color='white'>Sign out</font></a></h2>");
			               }

					  if(rst.getString(6).equals("second_class"))
						{
						//	String train_no=rst.getString(2);
							int i=st.executeUpdate("update trains set second_class_seats=(second_class_seats+1) where train_no='"+train_no+"' ");
						    
							int j= st.executeUpdate("delete from user4 where name='"+name+"' and train_no='"+train_no+"'");
						
							st.executeUpdate("Update user4 set total_cost=(total_cost-'"+cost_returned+"')where train_no='"+train_no+"' and reservation_date='"+date+"'");
					   

						
						st.executeUpdate("Update user4 set cost_returned=(cost_returned+'"+cost_returned+"')where train_no='"+train_no+"' and reservation_date='"+date+"'");
						out.println("<h1><font face='cooper' color='yellow'>Ticket of passenger named " +name+ " has been cancelled</font></h1>");
						   // int orignal_cost=rst.getInt(7);
						 
						    out.println("<h1><font face='cooper' color='yellow'>Total cost returned:Rs."+cost_r2+"</font></h1>");
							out.println("<h1><font face='cooper' color='yellow'>New Cost is: "+new_cost+"</font></h1>");

						   // int total_cost=rst.getInt(8);
						    //float new_cost=total_cost-cost_returned;
							
							//out.println("<body bgcolor='lightblue'>"); 

							out.println("<center>"); 
							   out.println("<table bgcolor='lightblue'>");
							    //out.println("<table bgcolor='lightblue'>");
							/*	out.println("<td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Name:</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+name+"</font></td>"); 

								out.println("<td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Train no:</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+train_no+"</font></td>"); 
								out.println("<td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Train name:</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+train_name+"</font></td>");
								out.println("<td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Type:</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+type+"</font></td>");  
								out.println("<td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>From:</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+from+"</font></td>");  
								out.println("<td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>To:</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+to+"</font></td><br><br><br><br><br><br>");  
							  */
								//out.println("<br><br><br><br><br><br>");
								out.println("<table border='5' bgcolor='white'>");
								
						
							
								out.println("<br><br><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Name</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Train no.</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Gender</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Age</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Tier</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Cost per ticket</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Reservation date</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>Train Name</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>From</font></td><td bgcolor='black' border='5' height='70' width='120' align='center'><font face='cooper' color='yellow'>To</font></td>");
						
								ResultSet rst2=st.executeQuery("select * from user4 where train_no='"+train_no+"' and reservation_date='"+date+"'");
								while(rst2.next())
								{
									
									out.println("<tr><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(3)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(2)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(4)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(5)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(6)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(7)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(9)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(10)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(12)+"</font></td><td bgcolor='coral' height='50' width='70' align='center'><font face='cooper'>"+rst2.getString(13)+"</font></td></tr>");
								}
							
							  
							
								
								out.println("</table><br>");
						
							
						    out.println("<h2><a href='cancel'><font color='white'>Cancel more tickets</font></a></h2>");
							out.println("<h2><a href='user.html' align='right'><font color='white'>Sign out</font></a></h2>");
						}		
			}
		}
		catch(Exception e)
			{
		      System.out.println(e);		
			}
	}}
		

