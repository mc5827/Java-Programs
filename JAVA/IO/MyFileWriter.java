import java.io.*;
class MyFileWriter
{
	public static void main(String... s1) throws IOException
	{
		FileOutputStream fw= new FileOutputStream(new File("H:\\Java\\IO\\abc.txt"), true);
		String s="My name is Mohit Chandak. ";
		byte b[]=s.getBytes();
		
		fw.write(b);
		
		fw.close();
		
		System.out.println("File Created Successfully.");
	}
}