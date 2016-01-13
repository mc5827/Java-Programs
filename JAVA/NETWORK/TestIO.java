import java.io.*;

class TestIO
{
	public static void main(String... s) throws IOException
	{
		String fileName="abc.txt";
		fileName="D:\\SERVER_FILE\\"+fileName;
		
		PrintStream ps=new PrintStream(new FileOutputStream(new File(fileName)));
		if(ps!=null)
		{
			System.out.println("File Created");
		}
		else
		System.out.println("File Not Created");
	}
}