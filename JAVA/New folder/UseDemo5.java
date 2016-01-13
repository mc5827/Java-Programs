class Demo5
{
	static int a;
	static void demo(int a)
	{
	a=a;
	System.out.println(a);
	}
	void demo1(int a)
	{
	
	demo(this.a);
	
	}
}
class UseDemo5
{
	public static void main(String a[])
	{
	Demo5 d=new Demo5();
	d.demo1(12);
	System.out.println(Demo5.a);
	}
}
