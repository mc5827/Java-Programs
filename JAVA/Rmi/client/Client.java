import my.*;

import java.rmi.*;
import java.rmi.server.*;

public class Client
{
	public static void main(String... a)
	{
		try{
		my.MyRemote m=(my.MyRemote)Naming.lookup("rmi://localhost:1099/ducat");
		System.out.println(m.add(10,19));
		
		}
		catch(Exception e){}
	}
}
