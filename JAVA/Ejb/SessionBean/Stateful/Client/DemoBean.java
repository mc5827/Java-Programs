package pack1;
import javax.ejb.*;
import java.rmi.*;

public class DemoBean implements SessionBean
{
	int a,b;
	public void setSessionContext(SessionContext ctx)
	{
	}
	
	public void ejbCreate(int a, int b)
	{
		this.a=a;
		this.b=b;
		System.out.println("EJB Created");
	}
	
	public void ejbActivate()
	{
		System.out.println("EJB Activated");
	}
	
	public void ejbPassivate()
	{
		System.out.println("EJB Passivated");
	}
	
	public void ejbRemove()
	{
		System.out.println("EJB Removed");
	}
	
	public int add() throws RemoteException
	{
		return (a+b);
	}
}	
