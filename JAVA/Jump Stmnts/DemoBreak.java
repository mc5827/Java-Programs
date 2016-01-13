public class DemoBreak
{
	public static void main(String ar[])
	{
	for(int i=0;i<5;i++)
	{
		int a=(int)(Math.random()*10);
		if(a==1)
		{
		System.out.println(a+" Forced Out of loop");
		break;
		}
		else
		{
		System.out.println(a);
		}
	}
	System.out.println("Geniune Out of loop");
	}
}