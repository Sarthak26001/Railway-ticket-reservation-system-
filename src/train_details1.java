

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
 * Servlet implementation class train_details1
 */
public class train_details1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public train_details1() {
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
		String station=null;
		//String st2;
		//String st3;
		String status=null;
				try {
					
		Class.forName("oracle.jdbc.driver.OracleDriver");
				
				Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","system");
				System.out.println("Successfully connected");	
				Statement st=conn.createStatement();
				String st1=request.getParameter("from");
				String st2=request.getParameter("to");
				
				//if(st1.equals(st1) && st2.equals(st2))
				//{
				ResultSet rst=st.executeQuery("select * from trains where from_station='"+st1+"' and to_station='"+st2+"'");
				out.println("<html>");
			    out.println("<body='light blue'>");
			    out.println("<center>");
			    out.println("<table bgcolor='lightgreen'>");
				out.println("******************************************************************************************************************************************************************************************************************************************************************");
				ResultSetMetaData rsmd=rst.getMetaData();
				int columncount=rsmd.getColumnCount();
				for(int i=1;i<=columncount;i++)
				{
					
					String columnname=rsmd.getColumnName(i);
					out.print(columnname);
					
				}
				out.println();
				out.println("*****************************************************************************************************************************************************************************************************************************************************************");
			    while(rst.next())
				{   
					out.println("<tr><td>"+rst.getString(1)+"  "+rst.getString(2)+"  "+rst.getString(3)+"  "+rst.getString(4)+"  "+rst.getString(5)+"  "+rst.getString(6)+"  "+ rst.getString(7)+"  "+rst.getString(8)+"  "+rst.getString(9)+"  "+rst.getString(10)+"  "+rst.getString(11)+"  "+rst.getString(12)+"  "+rst.getString(13)+"</td></tr>");
					 
				}
				out.println("</table>");	 
			    out.println("</center>");
				out.println("</html>");
			    out.println("</body>");
				
				}catch(Exception e)
				{
					out.println(e);
				}
				//out.println("yes");
				
	}
				
}


