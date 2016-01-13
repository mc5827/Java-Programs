class Gen<T>
{
	T ob;
	Gen(T ob)
	{
		this.ob=ob;
	}
	
	T getob()
	{
		return ob;
	}
	
	void showType()
	{
		System.out.println("Type of T is: "+ob.getClass().getName());
	}
}

public class GenDemo
{
	public static void main(String... s)
	{
		Gen<Integer> iob=new Gen<Integer>(80);
		iob.showType();
		int v=iob.getob();
		System.out.println("Value: "+v);
		Gen<String> sob=new Gen<String>("Mohit");
		sob.showType();
		String str=sob.getob();
		System.out.println("Value: "+str);
	}
}