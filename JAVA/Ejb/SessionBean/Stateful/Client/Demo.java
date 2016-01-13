package pack1;

import javax.ejb.*;
import java.rmi.*;

public interface Demo extends EJBObject
{
	public int add() throws RemoteException;
}