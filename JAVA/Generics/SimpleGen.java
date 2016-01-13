class TwoGen<T,V>
{
	T ob1;
	V ob2;
	
	TwoGen(T ob1,V ob2)
	{
		this.ob1=ob1;
		this.ob2=ob2;
	}
	
	void showTypes()
	{
		System.out.println("Type of T is: "+ob1.getClass().getName());
		
		System.out.println("Type of V is: "+ob2.getClass().getName());
	}
	
	T getob1()
	{
		return ob1;
	}
	V getob2()
	{
		return ob2;
	}
}

public class SimpleGen
{
	public static void main(String... s)
	{
		TwoGen<Integer, String> tobj=new TwoGen<Integer,String>(100,"Mohit");
		tobj.showTypes();
		int v=tobj.getob1();
		System.out.println("Value: "+v);
		String str=tobj.getob2();
		System.out.println("String: "+str);
	}
}