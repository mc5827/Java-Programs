class Calculate
{
	Calculate(int a ,int b)
	{
	System.out.println(a+b);
	}
	Calculate(int a ,int b,int c)
	{
	System.out.println(a+b+c);
	}
	Calculate(int a ,double b)
	{
	
	System.out.println((int)(a+b));
	}
	Calculate(String a ,int b)
	{
	System.out.println(a+b);
	}
}
class UseCalculate
{
	public static void main(String args[])
	{
	Calculate c1= new Calculate(1,2);
	Calculate c2= new Calculate(1,2,3);
	Calculate c3= new Calculate(1,2.1);
	Calculate c4= new Calculate("M",2);
	}
}
	