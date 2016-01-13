import java.io.*;

class DataStream
{
	public static void main(String... s1) throws IOException
	{
		DataInputStream dis = new DataInputStream(System.in);
		
		FileOutputStream fout= new FileOutputStream("Ducat4.txt");
		
		//PrintStream dout = new PrintStream(fout);
		
		DataOutputStream dout=new DataOutputStream(fout);
		
		String s=" ";
		
		while(!s.equals("stop"))
		{
			s=dis.readLine();
			System.out.println(s);
			
			//dout.println(s);
			
			//dout.writeUTF(s); 
			//dout.writeBytes(s);
			dout.writeChars(s);
			dout.flush();
		}
	dis.close();
	dout.close();
	}
}