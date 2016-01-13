import java.io.*;

class MyFileReader 
{
	public static void main(String... s1) throws IOException
	{
		FileInputStream fr= new FileInputStream(new File("H:\\JAVA\\IO\\abc.txt"));
		int i=0;
		while((i=fr.read())!=-1)
		{
			System.out.print((char)i);
		}
		fr.close();
	}
}
		