class DemoParam
{
	DemoParam(String a[])
	{
	
	for(int i=0;i<a.length;i++)
	System.out.println(a[i]);
	
	}
}
class UseDemoParam
{
	public static void main(String args[])
	{
	String s[]={"Mohit","Chandak"};
	DemoParam d= new DemoParam(s);
	}
}
	