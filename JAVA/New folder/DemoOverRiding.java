class A
{
	void show()
	{
	System.out.println("Super");
	}
}
class B extends A
{
	void show()
	{
	System.out.println("sub");
	super.show();
	}
}
class DemoOverRiding
{
	public static void main(String args[])
	{
	B b=new B();
	b.show();
	
	}
}