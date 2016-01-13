import java.io.*;

public class MyClient1
{
	ObjectOutputStream dout;
	
	MyClient1()
	{
		try{
		emp e1=new emp("mohit",10,20,30,40);
		emp e2=new emp("sonu",100,200,300,400);
		dout=new ObjectOutputStream(new FileOutputStream("Ducat3"));
		dout.writeObject(e1);
		dout.writeObject(e2);
		
		dout.flush();
		}
		catch(Exception e){}
	}
	public static void main(String... s)
	{
		new MyClient1();
	}
}