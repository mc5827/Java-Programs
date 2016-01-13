class Demo
{
	Demo()
	{
	System.out.println("Cons called");
	}
	Demo show()
	{
	System.out.println("show() called");
	return this;
	}
	void call()
	{
	System.out.println("call() called");
	}
}
class UseDemo
{
	public static void main(String args[])
	{
	Demo d=new Demo();
	d.show().call();
	}
}