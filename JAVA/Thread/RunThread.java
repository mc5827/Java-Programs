class RunThread
{
	public static void main(String... s)
	{
		Thread1 t1=new Thread1("ONE");
		Thread2 t2=new Thread2("TWO");
		Thread3 t3=new Thread3("THREE");
		
		
		
		t1.start();
		t2.start();
		t3.start();
		
		try{
		t1.join();
		t2.join();
		t3.join();
		}
		catch(Exception e){}
		
		for(int i=0;i<=2;i++)
		{
			System.out.println(Thread.currentThread().getName());
			try
			{
				Thread.sleep(2000);
			}
			catch(Exception e){}
		}
		System.out.println(Thread.currentThread().getName()+" dead.");
	}
}