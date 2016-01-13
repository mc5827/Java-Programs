import java.io.*;
class TempFile
{
	public static void main(String... s)
	{
		File file=new File("Temp1");
		System.out.println(file.getAbsolutePath());
	}
}