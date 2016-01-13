import java.io.*;

public class MyServer
{
	ObjectInputStream dis;
	public MyServer()
	{
		try{
		dis=new ObjectInputStream(new FileInputStream("Ducat3"));
		emp z=(emp)dis.readObject();
		
		System.out.println("name:" +z.name);
		System.out.println("age:" +z.age);
		System.out.println("a:" +z.a);
		System.out.println("b:" +z.b);
		System.out.println("z:" +z.z);
		
		emp z1=(emp)dis.readObject();
		System.out.println("name:" +z1.name);
		System.out.println("age:" +z1.age);
		System.out.println("a:" +z1.a);
		System.out.println("b:" +z1.b);
		System.out.println("z:" +z1.z);
		}
		catch(Exception e){}
	}
	public static void main(String... s)
	{
		new MyServer();
	}
}