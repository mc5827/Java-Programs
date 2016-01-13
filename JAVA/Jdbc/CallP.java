
import java.sql.*;
import java.io.*;

class CallP
{
	public static void main(String... s)
	{
		try{
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost/ducat", "root", "mohit");
		CallableStatement cs=c.prepareCall("{CALL proc_demo2(?,?)}");
		
		cs.setString(1,"Mohit");
		cs.setInt(2,10);
		cs.execute();
		ResultSet result1=cs.executeQuery("select * from emp");
		
		while(result1.next())
		{
			System.out.println(result1.getString(1)+"	"+result1.getString(2));
		}
		}
		catch(Exception e){System.out.println(e);}
		
	}
}