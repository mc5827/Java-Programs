import java.io.*;

class DataRead
{
	public static void main(String... s1) throws IOException
	{
		DataInputStream dis =new DataInputStream(new FileInputStream("abc.txt"));
		
		String s=" ";
		
		while(s!=null)
		{
			s=dis.readLine();
			if(s!=null)
			{
				System.out.println(s);
			}
		}
		dis.close();
	}
}