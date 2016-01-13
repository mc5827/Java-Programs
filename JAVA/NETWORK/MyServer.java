import java.io.*;
import java.net.*;

public class MyServer
{
	DataInputStream dis;
	DataOutputStream dos;
	ServerSocket ss;
	Socket s;
	
	public MyServer()
	{
		try
		{
			System.out.println("Server Started");
			ss=new ServerSocket(10);
			s=ss.accept();
			System.out.println(s);
			
			System.out.println("Client Connected");
			
			dis=new DataInputStream(s.getInputStream());
			dos=new DataOutputStream(s.getOutputStream());
			
			serverChat();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void serverChat() throws IOException
	{
		String str;
		do
		{
			str=dis.readUTF();
			System.out.println("Client Message: "+str);
			dos.writeUTF("Hello "+str);
			dos.flush();
		}while(!str.equals("stop"));
	}
	public static void main(String... s)
	{
		new MyServer();
	}
}
