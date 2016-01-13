import java.io.IOException;
class Temp
{
	public static void main(String... s) throws IOException
	{
			try
			{
			int x=10/s.length;
			System.out.println(x);
			}
			catch( ArithmeticException ae)
			{
				System.out.println(ae);
			}
			finally
			{
			}
			try
			{
			int z[]=new int[s.length];
			z[12]=111;
			}
			catch(ArithmeticException e)
			{
			System.out.println(e);
			}
			finally
			{
			}
		
	}
	
}
		