import java.util.*;
import javax.naming.*;
import javax.sql.*;
import java.sql.*;


public class DataPoolEx
{
	public static void main(String... s1)
	{
		try{
			Properties p=new Properties();
			p.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
			p.put(Context.PROVIDER_URL,"t3://localhost:7001");
			
			InitialContext ctx=new InitialContext(p);
			
			DataSource ds=(DataSource)ctx.lookup("mysqlpool");
			
			Connection con=ds.getConnection();
			Statement s=con.createStatement();
			ResultSet rs=s.executeQuery("select * from login");
			
			while(rs.next())
			{
				System.out.println("name: "+rs.getString(1));
			}
		}
		catch(Exception exp){System.out.println(exp);}
	}
}