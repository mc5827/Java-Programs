package my;

import java.rmi.*;
 
public interface MyRemote extends Remote
{
	public int add(int a, int b) throws RemoteException;
}