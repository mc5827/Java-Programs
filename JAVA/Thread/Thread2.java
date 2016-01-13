class Thread2 extends Thread
{
	Thread2(String s)
	{
		super(s);
	}
	public void run()
	{
		for(int i=1;i<=10;i++)
		{
			System.out.println(Thread.currentThread().getName());
			try
			{
				Thread.sleep(2000);
			}
			catch(Exception e){}
		}
		System.out.println("Thread 2 run completed.");
	}
}