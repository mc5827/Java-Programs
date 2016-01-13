import java.io.*;

class Temp
{
	public static void main(String... s1) throws IOException
	{
		FileOutputStream fos=new FileOutputStream("abc.txt",true);
		
		PrintStream ps=new PrintStream(fos);
		System.setOut(ps);
		
		System.out.println("I am an Engineer");
	}
}