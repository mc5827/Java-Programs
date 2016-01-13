import java.io.*;
import java.net.*;
import java.util.*;

class PublicChatServer
{
	ArrayList alSocket=new ArrayList();
	ArrayList alName=new ArrayList();
	ServerSocket ss;
	Socket s;

	PublicChatServer()
	{
		try
		{
			ss=new ServerSocket(10);
			while(true)
			{
				s=ss.accept();
				alSocket.add(s);
				
				Runnable r=new MyThread(s,alSocket,alName);
				Thread t=new Thread(r);
				t.start();
			}
		}
		catch(Exception e)
		{
		}
	}
	public static void main(String... args)
	{
		new PublicChatServer();
	}
}

class MyThread implements Runnable
{
	Socket s;
	ArrayList alSocket;
	ArrayList alName;
	
	MyThread(Socket s, ArrayList alSocket, ArrayList alName)
	{
		this.s=s;
		this.alSocket=alSocket;
		this.alName=alName;
	}
	
	public void run()
	{
	while(true)
	{
		try
		{
			DataInputStream dis=new DataInputStream(s.getInputStream());
			String recvText=dis.readLine();
			System.out.println(recvText);
		
			String extractText=recvText.substring(0,7);
			if(extractText.equals("*%add%*"))
			{
				String extractName=recvText.substring(8);
				alName.add(extractName);
				Iterator ir=alSocket.iterator();
				while(ir.hasNext())
				{
					Socket sc=(Socket)ir.next();
					PrintStream ps=new PrintStream(sc.getOutputStream());
					ps.println("*%appendList%*");
					ObjectOutputStream oos=new ObjectOutputStream(sc.getOutputStream());
					oos.writeObject(alName);
				}
			}
			else if(extractText.equals("*%del%*"))
			{
				String extractName=recvText.substring(8);
				System.out.println(extractName);
				
				if(alName.remove(extractName))
				{
					Iterator ir=alSocket.iterator();
					while(ir.hasNext())
					{
						Socket sc=(Socket)ir.next();
						PrintStream ps=new PrintStream(sc.getOutputStream());
						ps.println("*%appendList%*");
						ObjectOutputStream oos=new ObjectOutputStream(sc.getOutputStream());
						oos.writeObject(alName);
					}
				}
			}
			else
			{
				Iterator i=alSocket.iterator();
				while(i.hasNext())
				{
					Socket sc=(Socket) i.next();
					PrintStream ps=new PrintStream(sc.getOutputStream());
					
					if(sc!=s)
					{
						ps.println(recvText);
					}
				}
			}
		}
		catch(Exception e)
		{
		}
	}
	}
}
	