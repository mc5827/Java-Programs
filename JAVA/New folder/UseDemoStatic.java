class DemoStatic
{
	int a=10;
	
	static class InnerStatic
	{
	void show()
	{
	System.out.println("Static Inner class");
	DemoStatic d=new DemoStatic();
	System.out.println(d.a);
	}
	}
}
class UseDemoStatic
{
	public static void main(String args[])
	{
	DemoStatic.InnerStatic o= new DemoStatic.InnerStatic();
	o.show();
	}
}