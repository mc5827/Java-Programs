class DemoContinue
{
	public static void main(String args[])
	{
	for(int i=1;i<=5;i++)
	{
		int a=(int)(Math.random()*10);
		if(a==1)
		{
		System.out.println(a + "  Continue executed");
		continue;
		}
		System.out.println(a + "  Normal Execution");
	}
	}
}