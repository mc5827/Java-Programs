package pack1;

import javax.ejb.*;

public interface DemoHome extends EJBHome
{
	public Demo create(int a, int b) throws CreateException, java.rmi.RemoteException;
}
