class A extends Thread
{
	A(String name)
	{
	super(name);
	start();
	}	
	public void run()
	{
		try{sleep(1000);}
		catch(Exception e){}
		for(int i=0;i<5;i++)
		{
		System.out.println(getName()+  "\t"+ i);
		}
	}
}
class ThirdThread
{
	public static void main(String args[])
	{
	
	new A("one");
	new A("two");
	new A("three");
	for(int i=0;i<5;i++)
	{
		try{Thread.sleep(1000);}
		catch(Exception e){}
		if(i<3)
		System.out.println((Thread.currentThread()).getName()+"\t"+i);
		else{
		Thread t=Thread.currentThread();
	t.setName("MAIN THREADDDDDDDD");
	System.out.println((Thread.currentThread()).getName()+"\t"+i);}	
	}
	}
}
	