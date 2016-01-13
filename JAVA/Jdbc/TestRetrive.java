import java.sql.*;

class TestRetrive
{
	public static void main(String... s1)
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection c=DriverManager.getConnection("jdbc:odbc:mydsn");
			Statement s=c.createStatement();
		
			ResultSet result1=s.executeQuery("select * from Employee");
			while(result1.next())
			{
				System.out.println(result1.getString(2));
				System.out.println(result1.getString(3));
			}
		}
		catch(SQLException e){System.err.println(e);}
		catch(Exception i){System.err.println(i);}
	}
}