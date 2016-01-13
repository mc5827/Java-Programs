import java.io.*;
class Run
{
	public static void main(String... s) throws IOException
	{
		PipedOutputStream pout=new PipedOutputStream();
		
		PipedInputStream pin=new PipedInputStream();
		
		pout.connect(pin);
		
		Poutput po=new Poutput(pout);
		Pinput pi=new Pinput(pin);
		
		Thread t1= new Thread(po);
		Thread t2=new Thread(pi);
		
		t1.start();
		t2.start();
	}
}