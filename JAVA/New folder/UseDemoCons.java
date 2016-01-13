class Ab
{
	Ab()
	{
	System.out.println("DefaultSuper");
	}
	Ab(int a)
	{
	this();
	System.out.println("Param Supper");
	}
}
class Ba extends Ab
{
	Ba()
	{
	
	System.out.println("Sub");
	}
}
class UseDemoCons
{
	public static void main(String args[])
	{
	Ba a = new Ba();
	}
}