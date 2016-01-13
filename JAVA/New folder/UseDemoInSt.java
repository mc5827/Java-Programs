class DemoInSt
{
int a;
static int b;
	
	{
	System.out.println("Initialization Block");
	a=10;
	b=20;
	System.out.println(a);
	System.out.println(b);
	}
	static
	{
	System.out.println("Static Block");
	
	System.out.println(b);
	}
	DemoInSt()
	{
	System.out.println("Constructor");
	a=100;
	b=200;
	System.out.println(a);
	System.out.println(b);
	}
	void show()
	{
	System.out.println("Method");
	System.out.println(a);
	System.out.println(b);
	}
}
class UseDemoInSt
{
	public static void main(String args[])
	{
	DemoInSt s1= new DemoInSt();
	s1.show();
	DemoInSt s2=new DemoInSt();
	s2.show();
	}
}
	
	