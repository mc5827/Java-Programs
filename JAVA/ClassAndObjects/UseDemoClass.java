class DemoClass
{
int a=10;
protected static int b;
	void show()
	{
	int c;

	System.out.println("A=" +a);
	System.out.println("c=" +c);
	}
	
}	
class UseDemoClass
{
public static void main(String args[])
	{
		//int c;
		System.out.println(DemoClass.b);
		DemoClass.b=10;
		DemoClass d= new DemoClass();
		d.show();
		System.out.println(++DemoClass.b);
	}
}
