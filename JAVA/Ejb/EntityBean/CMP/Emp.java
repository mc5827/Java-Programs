package employee;

import javax.ejb.*;
import java.rmi.*;

public interface Emp extends EJBObject
{
	public String getName() throws RemoteException;
	public String setName() throws RemoteException;
	
}