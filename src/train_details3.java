

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
 * Servlet implementation class train_details3
 */
public class train_details3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public train_details3() {
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
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
					
					Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","system");
					System.out.println("Successfully connected");	
					Statement st=conn.createStatement();
					String st1=request.getParameter("menu");
					String st2=request.getParameter("menu2");
					
					//if(st1.equals(st1) && st2.equals(st2))
					//{
					
					
					ResultSet rst=st.executeQuery("select * from trains where from_station='"+st1+"' and to_station='"+st2+"'");
					out.println("<html>");
				    out.println("<body background='' height='500' width='1000'>");
				    out.println("<link rel='stylesheet' type='text/css' href='NewFile2.css'>");
				    out.println("<form action='reservation2'>");
				    out.println("<b><h1><font face='cooper' color='black'><center>HERE ARE THE AVAILABLE TRAINS!!!</center></font></h1></b>");
				    out.println("<br><br><br><br><br><br><center>");
				    out.println("<table border='3' color='yellow'>");
				
					ResultSetMetaData rsmd=rst.getMetaData();
					int columncount=rsmd.getColumnCount();
					for(int i=1;i<=columncount;i++)
					{
						String columnname=rsmd.getColumnName(i);
						//out.println("<tr><th>train_no train_name type from_station to_station First_class AC_1_tier var AC_2_tier AC_3_tier sleeper second_class </tr></th><br>");
						out.print("<b><td bgcolor='black' align='center' height='70' width='100'><font face='Elephant' color='yellow'>"+columnname+"</font></b></td>");
					}
					
				    while(rst.next())
					{   
				    	
						out.println("<b><tr><td bgcolor='cyan' height='50' width='70' align='center'><font face='cooper'><input type='radio' name='train_no'value="+rst.getString(1)+"><font face='cooper'>"+rst.getString(1)+"</font></td><td bgcolor='cyan' align='center'><font face='cooper'>"+rst.getString(2)+"</font></td><td bgcolor='cyan' align='center'><font face='cooper'>"+rst.getString(3)+"</font></td><td bgcolor='cyan' align='center'><font face='cooper'>"+rst.getString(4)+"</font></td><td bgcolor='cyan' align='center'><font face='cooper'>"+rst.getString(5)+"</font></td><td bgcolor='cyan' align='center'><font face='cooper'>"+rst.getString(6)+"</font></td><td bgcolor='cyan' align='center'><font face='cooper'>"+rst.getString(7)+"</font></td><td bgcolor='cyan' align='center'><font face='cooper'>"+rst.getString(8)+"</font></td><td bgcolor='cyan' align='center'><font face='cooper'>"+rst.getString(9)+"</font></td><td bgcolor='cyan' align='center'><font face='cooper'>"+rst.getString(10)+"</font></td><td bgcolor='cyan' align='center'><font face='cooper'>"+rst.getString(11)+"</font></td><td bgcolor='cyan' align='center'><font face='cooper'>"+rst.getString(12)+"</font></td><td bgcolor='cyan' align='center'><font face='cooper'>"+rst.getString(13)+"</font></td><td bgcolor='cyan' align='center'><font face='cooper'>"+rst.getInt(14)+"</font></td><td bgcolor='cyan' align='center'><font face='cooper'>"+rst.getInt(15)+"</font></td><td bgcolor='cyan' align='center'><font face='cooper'>"+rst.getInt(16)+"</font></td><td bgcolor='cyan' align='center'><font face='cooper'>"+rst.getInt(17)+"</font></td><td bgcolor='cyan' align='center'><font face='cooper'>"+rst.getInt(18)+"</font></td><td bgcolor='cyan' align='center'><font face='cooper'>"+rst.getInt(19)+"</font></td></tr></b>");
						
					}
					out.println("</table><br><br>");
					out.println("<font size='100'><input type='submit' value='Book ticket' id='book'></font>");
						 
				    out.println("</center>");
				    out.println("</form>");
					out.println("</body>");
					out.println("</html>");
					
					}catch(Exception e)
					{
						out.println(e);
					}
					//out.println("yes");
					
		
	}

}
