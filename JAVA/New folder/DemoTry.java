class DemoTry
{
public static void main(String ab[])
	{
	int a=(int)(Math.random()*10);
	//int ar[]={1,2,3,4,5};
	System.out.println("a="+a);
	try
	{
	int b=10/a;
	System.out.println(b);
		
		
	}
	catch(NullPointerException e1)
	{
	System.out.println(e1.toString());
	}
	}
}
