import java.util.*;
import javax.naming.*;
import javax.rmi.*;
 
import pack.*;

public class DemoClient
{
	public static void main(String... s)
	{
		try{
			
			Properties p=new Properties();
			p.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
			p.put(Context.PROVIDER_URL,"t3://localhost:7001");
			
			InitialContext ctx=new InitialContext(p);
			Object home=ctx.lookup("DemoHome6");
			
			pack.DemoHome h=(pack.DemoHome)PortableRemoteObject.narrow(home,pack.DemoHome.class);
			pack.Demo rstub=h.create();
			
			System.out.println(rstub.add(100,200));
			
		}
		catch(Exception e){}
	}
}