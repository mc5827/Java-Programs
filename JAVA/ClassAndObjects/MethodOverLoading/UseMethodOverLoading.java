class MethodOverLoading
{
	void calculate(int a ,int b)
	{
	System.out.println(a+b);
	}
	void calculate(int a ,float b)
	{
	System.out.println(a+b);
	}
	/*int calculate(int a ,int b)
	{
	return a+b;
	
	}
*/}
class UseMethodOverLoading
{
	public static void main(String args[])
	{
	MethodOverLoading m= new MethodOverLoading();
	m.calculate(1,2);
	m.calculate(1,2.2f);
	//int result=m.calculate(1,3);
	//System.out.println(result);
	}
}