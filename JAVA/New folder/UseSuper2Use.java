class Super2Use
{
	public int a=10;
}
class B extends Super2Use
{
	public int a=100;
}
class UseSuper2Use
{
	public static void main(String args[])
	{
	B b=new B();
	System.out.println(b.super.a);
	}
}