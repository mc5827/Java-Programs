class ThreadRunnable1 implements Runnable
{
	int x=10;
	public void run()
	{
		for(int i=0;i<10;i++)
		{
			System.out.println(Thread.currentThread().getName());
			try
			{
				Thread.sleep(1000);
			}
			catch(Exception e){}
		}
		System.out.println(Thread.currentThread().getName()+" dead");
	}
}

public class RunThreadRunnable
{
	public static void main(String... s)
	{
		ThreadRunnable1 tr1=new ThreadRunnable1();
		Thread t1=new Thread(tr1,"Thread 1");
		t1.start();
		
		Thread t2=new Thread(tr1, "Thread 2");
		t2.start();
	}
}