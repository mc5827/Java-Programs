package my;

import java.rmi.*;
import java.rmi.server.*;

public class Register
{
	public static void main(String... a)
	{
		try{
		
		my.MyServer m=new my.MyServer();
		Naming.rebind("ducat",m);
		}
		catch(Exception e){}
	
	}
}	