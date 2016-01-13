class OrderInitialization
{
	static
	{
	System.out.println("Super Static Block");
	static int a=100;
	System.out.println(a);
	int b=10;
	System.out.println(b);
	}
	
	{
	System.out.println("Super Initialization Block");
	static int a=200;
	System.out.println(a);
	int b=20;
	System.out.println(b);
	}
	OrderInitialization()
	{
	System.out.println("Super Constructor Block");
	static int a=300;
	System.out.println(a);
	int b=30;
	System.out.println(b);
	}
}
class OrderInitializationSub extends OrderInitialization
{
	static
	{
	System.out.println("Sub Static Block");
	static int a=400;
	System.out.println(a);
	int b=40;
	System.out.println(b);
	}
	
	{
	System.out.println("Sub Initialization Block");
	static int a=500;
	System.out.println(a);
	int b=50;
	System.out.println(b);
	}
	OrderInitializationSub()
	{
	super();
	System.out.println("Sub Constructor Block");
	static int a=600;
	System.out.println(a);
	int b=60;
	System.out.println(b);
	}
}
class UseOrderInitialization
{
	public static void main(String a[])
	{
	new OrderInitializationSub();
	}
}