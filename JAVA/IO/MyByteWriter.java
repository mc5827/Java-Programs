import java.io.*;

class MyByteWriter
{
	public static void main(String... s1) throws IOException
	{
		ByteArrayOutputStream bout=new ByteArrayOutputStream();
		
		String s="I am a good boy. ";
		byte b[]=s.getBytes();
		
		bout.write(b);
		
		bout.writeTo(new FileOutputStream(new File("H:\\JAVA\\IO\\abc.txt"),true));
		
		System.out.println(bout.toString());
		
		byte b1[]= bout.toByteArray();
		
		ByteArrayInputStream bin=new ByteArrayInputStream(b1);
		
		int i=0;
		while((i=bin.read())!=-1)
		{
			System.out.print((char)i);
		}
	}
}