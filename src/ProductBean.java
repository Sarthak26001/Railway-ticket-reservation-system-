import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProductBean 

{
	public String register(String firstname, String lastname, String mob, String age,String email,String password,String selected_gender)
	{   Connection conn;
	    Statement st;
	    ResultSet rs;
	    String status=" ";
		try {
		
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","system");
			System.out.println("Successfully connected");
	        st=conn.createStatement();
		    rs=st.executeQuery("select * from register where email='"+email+"'");
		boolean b=rs.next();
		if(b==true)
		{
			status="Account already exists";
		}
		else
		{
			PreparedStatement pst=conn.prepareStatement("insert into register values (?,?,?,?,?,?,?)");
			pst.setString(1,firstname);
			pst.setString(2,lastname);
			pst.setString(3,mob);
			pst.setString(4,age);
			pst.setString(5,email);
			pst.setString(6,password);
		    pst.setString(7,selected_gender);
			
			int count=pst.executeUpdate();
			if(count==1)
				status="successfull";
			else
				status="failed";
			pst.close();
			
			conn.close();
			
		}}catch(Exception e)
		{
			System.out.println(e);
		}
		return status;
			
		}

}
