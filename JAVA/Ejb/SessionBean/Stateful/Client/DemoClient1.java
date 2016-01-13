import java.util.*;
import javax.naming.*;
import javax.rmi.*;

import pack1.*;

public class DemoClient1
{
	public static void main(String... s)
	{
		try{
			Properties p=new Properties();
			p.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
			p.put(Context.PROVIDER_URL,"t3://localhost:7001");
			
			InitialContext ctx=new InitialContext(p);
			
			pack1.Demo r[]=new pack1.Demo[15];
			
			Object home=ctx.lookup("DemoHome12");
			
			pack1.DemoHome h=(pack1.DemoHome)PortableRemoteObject.narrow(home, pack1.DemoHome.class);
			
			for(int i=0;i<r.length;i++)
			{
				r[i]=h.create(100,i);
				System.out.println(r[i].add());
				try{
					Thread.sleep(2000);
				}
				catch(Exception e1){}
			}
		
		}
		catch(Exception e){}
	}
}