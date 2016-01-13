class Thread3 extends Thread
{
	Thread3(String s)
	{
		super(s);
	}
	public void run()
	{
		for(int i=1;i<=15;i++)
		{
			System.out.println(Thread.currentThread().getName());
			try
			{
				Thread.sleep(2000);
			}
			catch(Exception e){}
		}
		System.out.println("Thread 3 run completed.");
	}
}