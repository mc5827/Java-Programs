import java.io.*;

class CopyItself
{
	public static void main(String... s) throws IOException
	{
		DataInputStream dis=new DataInputStream(new FileInputStream("CopyItself.java"));
		
		PrintStream ps=new PrintStream(new FileOutputStream("CopyItself1.java"));
		
		String s1=" ";
		
		while(s1!=null)
		{
			s1=dis.readLine();
			if(s1!=null)
			{
				ps.println(s1);
				ps.flush();
			}
		}
		dis.close();
		ps.close();
	
	}
}
