class Shared 
{
	static int x;
	
	synchronized void show(String s, int a)
	{
		x=a;
		System.out.println("Starting in method show "+s+" "+x);
		try
		{
			Thread.sleep(2000);
		}
		catch(Exception e){}
		
		System.out.println("Exit from method show "+s+" "+x);
		
	}
	
	synchronized void show1(String s, int a)
	{
		x=a;
		System.out.println("Starting in method show1 "+s+" "+x);
		try
		{
			Thread.sleep(2000);
		}
		catch(Exception e){}
		
		System.out.println("Exit from method show1 "+s+" "+x);
		
	}
	void show2(String s, int a)
	{
		System.out.println("Starting in method show1 "+s);
		synchronized(this)
		{
			x=a;
			System.out.println("Starting in method show1 in shychronized block "+s+" "+x);
			try
			{
				Thread.sleep(2000);
			}
			catch(Exception e){
			}
			System.out.println("Exit from sychronized block "+s+" "+x);
		}
	}

	Temp t=new Temp();
	void show3(String s, int a)
	{
		System.out.println("Starting in method show3 "+s);
		synchronized(t)
		{
			t.dilTohPagalHai(s);
		}
	}
}