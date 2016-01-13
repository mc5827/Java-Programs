import java.io.*;
import java.util.*;

class ScannerTest
{
	public static void main(String... s) throws IOException
	{
		Scanner sc=new Scanner(new FileInputStream("Country.txt"));
		
		while(sc.hasNext())
		{
			System.out.println(sc.nextLine());
		}
	}
}