package pack;

import javax.ejb.*;

public interface DemoHome extends EJBHome
{
	public Demo create() throws CreateException, java.rmi.RemoteException;
}