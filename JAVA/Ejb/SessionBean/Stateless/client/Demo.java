package pack;
 
import javax.ejb.*;
import java.rmi.*;

public interface Demo extends EJBObject
{
	public int add(int a, int b) throws RemoteException;
}