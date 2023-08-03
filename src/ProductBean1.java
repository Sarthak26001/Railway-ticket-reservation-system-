
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProductBean1 {
	public String register(String train_no,String train_name,String type,String from_station, String to_station,String departure,String arrival,String First_class,String AC_1_tier,String AC_2_tier,String AC_3_tier,String sleeper_class,String second_class,int first_class_seats,int ac_1_tier_seats,int ac_2_tier_seats,int ac_3_tier_seats,int sleeper_class_seats,int second_class_seats)
	{   Connection conn;
	Statement st;
	    ResultSet rs;
	    String status=" ";
		try {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		 conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","system");
		System.out.println("Successfully connected");	
		 st=conn.createStatement();
		 rs=st.executeQuery("select * from trains where train_no='"+train_no+"'");
		boolean b=rs.next();
		if(b==true)
		{
			status=" already existing.";
		}
		else
		{
			PreparedStatement pst=conn.prepareStatement("insert into trains values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1,train_no);
			pst.setString(2,train_name);
			pst.setString(3,type);
			pst.setString(4,from_station);
			pst.setString(5,to_station);
			pst.setString(6,departure);
			pst.setString(7,arrival);
			pst.setString(8,First_class);
			pst.setString(9,AC_1_tier);
			pst.setString(10,AC_2_tier);
			pst.setString(11,AC_3_tier);
			pst.setString(12,sleeper_class);
			pst.setString(13,second_class);
			pst.setInt(14,first_class_seats);
			pst.setInt(15,ac_1_tier_seats);
			pst.setInt(16,ac_2_tier_seats);
			pst.setInt(17,ac_3_tier_seats);
			pst.setInt(18,sleeper_class_seats);
			pst.setInt(19,second_class_seats);
			
			
			int count=pst.executeUpdate();
			if(count==1)
				status=" Successfully!!";
			else
				status=" insertion failure";
			pst.close();
			
			conn.close();
			
		}}catch(Exception e)
		{
			System.out.println(e);
		}
		return status;
			
		}

}

