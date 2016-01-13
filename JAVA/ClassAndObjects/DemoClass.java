class DemoClass
{
int a=10;
static int b;
	void show()
	{
	b=10;
	System.out.println(a);
	}
	
}	
class UseDemoClass
{
public static void main(String args[])
	{
		System.out.println(DemoClass.b);
		DemoClass d= new DemoClass();
		d.show();
		System.out.println(++DemoClass.b);
	}
}
