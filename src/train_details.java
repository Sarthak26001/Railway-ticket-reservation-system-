
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class train_details {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","system");
		System.out.println("Successfully connected");
        Statement st=conn.createStatement();
		//st.executeUpdate("create table trains(train_no varchar2(100),train_name varchar2(100),Type varchar2(100),from_station varchar2(100),to_station varchar(100),Departure varchar2(100),Arrival varchar2(100),First_class varchar2(100),AC_1_tier varchar2(100),AC_2_tier varchar2(100),AC_3_tier varchar2(100),sleeper varchar2(100),second_class varchar2(100))");
	    //System.out.println("Table created successfully");
		
		PreparedStatement pst=conn.prepareStatement("insert into trains values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
		Scanner sc=new Scanner(System.in);
		String c;
		do {
		System.out.println("Enter Train no:");
		String no=sc.next();
		System.out.println("Enter Train name:");
		String na=sc.next();
		System.out.println("Enter Type:");
		String t=sc.next();
		System.out.println("From station:");
		String s=sc.next();
		System.out.println("To Station:");
		String ts=sc.next();
		System.out.println("Departure time:");
		String dp=sc.next();
		System.out.println("Arrival time:");
		String ar=sc.next();
		System.out.println("Cost first class:");
		String fs=sc.next();
		System.out.println("Cost AC-1-tier:");
		String a1=sc.next();
		System.out.println("Cost AC-2-tier:");
		String a2=sc.next();
		System.out.println("Cost AC-3-tier:");
		String a3=sc.next();
		System.out.println("Cost sleeper class:");
		String sl=sc.next();
		System.out.println("Cost second class:");
		String scl=sc.next();
		pst.setString(1,no);
		pst.setString(2,na);
		pst.setString(3,t);
		pst.setString(4,s);
		pst.setString(5,ts);
		pst.setString(6,dp);
		pst.setString(7,ar);
		pst.setString(8,fs);
		pst.setString(9,a1);
		pst.setString(10,a2);
		pst.setString(11,a3);
		pst.setString(12,sl);
		pst.setString(13,scl);
		pst.executeUpdate();
		System.out.println("Do you want to continue(y/n)");
		c=sc.next();
		System.out.println("Record inserted successfully");
		}while(c.equals("y"));
		
		}


}


