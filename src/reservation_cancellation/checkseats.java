package reservation_cancellation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class checkseats
 */
public class checkseats extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkseats() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
int seats=Integer.parseInt(request.getParameter("seats"));
	    

		//Integer.parseInt(request.getParameter("seats"));
HttpSession s=request.getSession();
PrintWriter out=response.getWriter();
String train_no=(String)s.getAttribute("train_no");


try{Class.forName("oracle.jdbc.driver.OracleDriver");



Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","system");
String tier=request.getParameter("menu3");



Statement st=conn.createStatement();
ResultSet rst=st.executeQuery("select * from trains where train_no='"+train_no+"' ");
if(rst.next())
if(tier.equals("first_class"))
{
if(seats<rst.getInt(14))
{
	
	RequestDispatcher rsd=request.getRequestDispatcher("reservation4");
	rsd.forward(request, response);
//PreparedStatement pst=conn.prepareStatement("update train3 set seats_remaining=(seats_remaining-?) where train_no=? ");
//pst.setInt(1,seats);
//pst.setString(2,train_no);
//int i=pst.executeUpdate();
//out.println(i+"record updated");
}
else {
	out.println("<body bgcolor='black'>");
	out.println("<br><br><br><br><br><br>");
	out.println("<center><h1><font face='cooper' color='yellow'><font color='red'>Oops!!!</font><br>WE ARE RUNNING OUT OF SEATS.<br>PLEASE LOOK FOR SOME OTHER TIER OPTION.</font></h1></center>");
}}

if(tier.equals("ac_1_tier"))
{
if(seats<rst.getInt(15))
{

RequestDispatcher rsd=request.getRequestDispatcher("reservation4");
rsd.forward(request, response);
//PreparedStatement pst=conn.prepareStatement("update train3 set seats_remaining=(seats_remaining-?) where train_no=? ");
//pst.setInt(1,seats);
//pst.setString(2,train_no);
//int i=pst.executeUpdate();
//out.println(i+"record updated");
}
else {
	out.println("<body bgcolor='black'>");
	out.println("<br><br><br><br><br><br>");
	out.println("<center><h1><font face='cooper' color='yellow'><font color='red'>Oops!!!</font><br>WE ARE RUNNING OUT OF SEATS.<br>PLEASE LOOK FOR SOME OTHER TIER OPTION.</font></h1></center>");
}}

if(tier.equals("ac_2_tier"))
{
if(seats<rst.getInt(16))
{

RequestDispatcher rsd=request.getRequestDispatcher("reservation4");
rsd.forward(request, response);
//PreparedStatement pst=conn.prepareStatement("update train3 set seats_remaining=(seats_remaining-?) where train_no=? ");
//pst.setInt(1,seats);
//pst.setString(2,train_no);
//int i=pst.executeUpdate();
//out.println(i+"record updated");
}
else {
	out.println("<body bgcolor='black'>");
	out.println("<br><br><br><br><br><br>");
	out.println("<center><h1><font face='cooper' color='yellow'><font color='red'>Oops!!!</font><br>WE ARE RUNNING OUT OF SEATS.<br>PLEASE LOOK FOR SOME OTHER TIER OPTION.</font></h1></center>");
}}

if(tier.equals("ac_3_tier"))
{
if(seats<rst.getInt(17))
{

RequestDispatcher rsd=request.getRequestDispatcher("reservation4");
rsd.forward(request, response);
//PreparedStatement pst=conn.prepareStatement("update train3 set seats_remaining=(seats_remaining-?) where train_no=? ");
//pst.setInt(1,seats);
//pst.setString(2,train_no);
//int i=pst.executeUpdate();
//out.println(i+"record updated");
}
else {
	out.println("<body bgcolor='black'>");
	out.println("<br><br><br><br><br><br>");
	out.println("<center><h1><font face='cooper' color='yellow'><font color='red'>Oops!!!</font><br>WE ARE RUNNING OUT OF SEATS.<br>PLEASE LOOK FOR SOME OTHER TIER OPTION.</font></h1></center>");
}}

if(tier.equals("sleeper_class"))
{
if(seats<rst.getInt(18))
{

RequestDispatcher rsd=request.getRequestDispatcher("reservation4");
rsd.forward(request, response);
//PreparedStatement pst=conn.prepareStatement("update train3 set seats_remaining=(seats_remaining-?) where train_no=? ");
//pst.setInt(1,seats);
//pst.setString(2,train_no);
//int i=pst.executeUpdate();
//out.println(i+"record updated");
}
else {
	out.println("<body bgcolor='black'>");
	out.println("<br><br><br><br><br><br>");
	out.println("<center><h1><font face='cooper' color='yellow'><font color='red'>Oops!!!</font><br>WE ARE RUNNING OUT OF SEATS.<br>PLEASE LOOK FOR SOME OTHER TIER OPTION.</font></h1></center>");
}}
if(tier.equals("second_class"))
{
if(seats<rst.getInt(19))
{

RequestDispatcher rsd=request.getRequestDispatcher("reservation4");
rsd.forward(request, response);
//PreparedStatement pst=conn.prepareStatement("update train3 set seats_remaining=(seats_remaining-?) where train_no=? ");
//pst.setInt(1,seats);
//pst.setString(2,train_no);
//int i=pst.executeUpdate();
//out.println(i+"record updated");
}
else 
	out.println("<body bgcolor='black'>");
out.println("<br><br><br><br><br><br>");
out.println("<center><h1><font face='cooper' color='yellow'><font color='red'>Oops!!!</font><br>WE ARE RUNNING OUT OF SEATS.<br>PLEASE LOOK FOR SOME OTHER TIER OPTION.</font></h1></center>");
}
	/*out.println("<body style='background-image:url(abc.jpg); width:1000px; height:500px;'>"); 
	//out.println("<body>");
	//out.println("<img src='abc.jpg' style='width:2000px;height:1000px;>");
	
	out.println("<br><br><br><br><br><br>");
	out.println("<center><h1><font face='cooper' color='yellow'><font color='red'>Oops!!!</font><br>WE ARE RUNNING OUT OF SEATS.<br>PLEASE LOOK FOR SOME OTHER TIER OPTION.</font></h1></center>");
	out.println("</body>");
}}*/




}catch(Exception e)
{
out.println(e);
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
