import java.io.*;

class Pinput implements Runnable
{
	PipedInputStream pin;
	Pinput(PipedInputStream pin)
	{
		this.pin=pin;
	}
	
	public void run()
	{
		int z=0;
		for(int i=65;i<91;i++)
		{
			try{
			z=pin.read();
			}
			catch(Exception e){}
			System.out.println((char)z);
		}
	}
}
			