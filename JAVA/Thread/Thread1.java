class Thread1 extends Thread
{
	Thread1(String s)
	{
		super(s);
	}
	public void run()
	{
		for(int i=1;i<=5;i++)
		{
			System.out.println(Thread.currentThread().getName());
			try
			{
				Thread.sleep(2000);
			}
			catch(Exception e){}
		}
		System.out.println("Thread 1 run completed.");
	}
}
	