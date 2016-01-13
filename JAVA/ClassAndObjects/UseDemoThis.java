class DemoThis
{
	int a,b,c;
	DemoThis(int a,int b, int c)
	{
	this.a=a;
	this.b=b;
	this.c=c;
	System.out.println("a="+a);
	System.out.println("b="+b);
	System.out.println("c="+c);
	}

	DemoThis(int a,int b)
	{
	this(a,b,0);
	}
	
	DemoThis(int a)
	{
	this(a,0,0);
	}
	DemoThis()
	{
	this(0,0,0);
	}
	
}

class UseDemoThis
{
public static void main(String a[])
{

DemoThis d= new DemoThis(1,2,3);
DemoThis d1= new DemoThis(1,2);
DemoThis d2= new DemoThis(1);
DemoThis d3= new DemoThis();
}
}