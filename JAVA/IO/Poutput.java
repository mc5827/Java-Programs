import java.io.*;

class Poutput implements Runnable
{
	PipedOutputStream pout;
	Poutput(PipedOutputStream pout)
	{
		this.pout=pout;
	}
	
	public void run()
	{
		for(int i=65;i<91;i++)
		{
			try{
			pout.write(i);
			Thread.sleep(1000);
			}
			catch(Exception e){}
		}
	}
}
			