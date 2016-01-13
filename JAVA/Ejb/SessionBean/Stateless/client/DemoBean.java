package pack;

import javax.ejb.*;
import java.rmi.*;

public class DemoBean implements SessionBean
{
	public void setSessionContext(SessionContext ctx)
	{
	}
	
	public void ejbCreate()
	{
		System.out.println("Ejb Created");
	}
	
	public void ejbActivate()
	{
	}
	
	public void ejbPassivate()
	{
	}
	
	public void ejbRemove()
	{
	}
	
	public int add(int a, int b) throws RemoteException
	{
		return (a+b);
	}
}