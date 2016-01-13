class OwnException extends Exception
{
	OwnException(String str)
	{
	super(str);
	}
}
class DemoOwn
{
	public static void main(String args[])
	{
	int a=(int)(Math.random()*10);
	System.out.println(a);
	if(a<6)
	{
		try
		{
		OwnException e=new OwnException("MOHIT");
		throw(e);
		}
		catch(OwnException e1)
		{
		System.out.println(e1);
		System.out.println("s");
		}
	}
	System.out.println("End");
	}
}
	