

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class inserttrain
 */
public class inserttrain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inserttrain() {
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
	        
	        String train_no=request.getParameter("train_no");
		    String train_name=request.getParameter("train_name");
		    String type=request.getParameter("type");
		    String from_station=request.getParameter("from_station");
	        String to_station=request.getParameter("to_station");
	        String departure=request.getParameter("departure");
	        String arrival=request.getParameter("arrival");
	        String First_class=request.getParameter("first_class");
	        String AC_1_tier=request.getParameter("ac_1_tier");
	        String AC_2_tier=request.getParameter("ac_2_tier");
	        String AC_3_tier=request.getParameter("ac_3_tier");
	        String sleeper_class=request.getParameter("sleeper_class");
	        String second_class=request.getParameter("second_class");
	        int first_class_seats=Integer.parseInt(request.getParameter("first_class_seats"));
	        int ac_1_tier_seats=Integer.parseInt(request.getParameter("ac_1_tier_seats"));
	        int ac_2_tier_seats=Integer.parseInt(request.getParameter("ac_2_tier_seats"));
	        int ac_3_tier_seats=Integer.parseInt(request.getParameter("ac_3_tier_seats"));
	        int sleeper_class_seats=Integer.parseInt(request.getParameter("sleeper_class_seats"));
	        int second_class_seats=Integer.parseInt(request.getParameter("second_class_seats"));
	        
	  ProductBean1 p=new ProductBean1();
	  String status = p.register(train_no,train_name,type,from_station, to_station,departure,arrival,First_class,AC_1_tier,AC_2_tier, AC_3_tier,sleeper_class,second_class,first_class_seats,ac_1_tier_seats,ac_2_tier_seats,ac_3_tier_seats,sleeper_class_seats,second_class_seats);
	  out.println("<html>");
	  out.println("<body bgcolor='black'>");
	  out.println("<center>");
	  out.println("<br><br><br><br><br><br><h1><font face='cooper' color='yellow'>Train details inserted "+status +" </font></h1><br><br>");
	  out.println("<h2><a href='Retrieve'><font color='white'>View table</font></a></h2>");
	  out.println("<h2><a href='adminlogin.html'><font color='white'>Admin Login</font></a></h2>");

	  out.println("</center>");
	  out.println("</body>");
	  out.println("</html>");
		}

	}


