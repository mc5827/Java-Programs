import java.io.*;

class Ps
{
	public static void main(String... s) throws IOException
	{
		PrintStream ps1= new PrintStream(new FileOutputStream(new File("H:\\JAVA\\IO\\chachi.txt")));
		
		PrintStream ps2= new PrintStream(new FileOutputStream(new File("H:\\JAVA\\IO\\chacha.txt")));
		
		System.out.println("Before connecting to our printstream object(which is connected to fileoutput stream to out variable which at present has the object of printstream class(which has monitor's buffer) in system class.");
		
		System.setOut(ps1);
		System.setErr(ps2);
		
		System.out.println("chachi 420");
		System.out.println("chachi 840");
		
		System.err.println("chacha 420");
		System.err.println("chacha 840");
	}
}