import java.io.*;
import java.net.*;

public class FTPServer
{
	ServerSocket ss;
	Socket s;
	DataInputStream dis;
	DataOutputStream dos;
	PrintStream ps;
	String fileData="";
	String fileName="";
	
	
	FTPServer()
	{
		try
		{		
			ss=new ServerSocket(100);
			System.out.println(ss);
			s=ss.accept();
			System.out.println(s);
			dis=new DataInputStream(s.getInputStream());
			dos=new DataOutputStream(s.getOutputStream());
			
			fileName="D:\\SERVER_FILE\\"+dis.readUTF();
				
			System.out.println(fileName);
			ps=new PrintStream(new FileOutputStream(new File(fileName)));
			if(ps!=null)
			{
				System.out.println("File created");
			}
			else
			{
				System.out.println("File not created");
			}
			dos.writeUTF("begin");
			while(fileData!=null)
			{
				fileData=dis.readUTF();
				if(fileData!=null)
				{
					System.out.println(fileData);
					ps.println(fileData);
				}
				else
				{
					dos.writeUTF("end");
					break;
				}
			}
			System.out.println("Done");
			
			
			
			
		}
		catch(Exception e){}
	}
	public static void main(String... s)
	{
		new FTPServer();
	}
}
