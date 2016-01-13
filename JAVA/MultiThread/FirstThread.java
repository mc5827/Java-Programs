class A extends Thread
{
	public void run()
	{
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
	}
}
class FirstThread
{
	public static void main(String args[])
	{
	A a= new A();
	B b= new B();
	C c= new C();
	a.start();
	b.start();
	c.start();
	}
}