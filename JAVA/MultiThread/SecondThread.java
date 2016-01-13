class A extends Thread 
{
	public void run()
	{
		try{
		sleep(1000);}
		catch(Exception e){}
		for(int i=0;i<2;i++)
		{	
		System.out.println("A" + i);
		}
	}
}
class B extends Thread 
{
	public void run()
	{
		for(int i=0;i<3;i++)
		{
		try{
		sleep(1000);}
		catch(Exception e){}		
		System.out.println("B" + i);
		}
	}
}
class C extends Thread 
{
	public void run()
	{
		for(int i=0;i<4;i++)
		{	
		System.out.println("C" + i);
		}
		try{
		sleep(1000);}
		catch(Exception e){}
	}
}
class SecondThread 
{
	public static void main(String args[])
	{
	A a= new A();a.start();
	B b= new B();b.start();
	C c= new C();c.start();

	
	
	
	}
}