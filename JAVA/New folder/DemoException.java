class DemoException
{
	public static void main(String args[])
	{
	int a=0;
		try 
		{
		int b=100/a;
		System.out.println("1");
		}
		
		finally
		{
		System.out.println("Finish");
		}
		System.out.println("Finished");
	}
}