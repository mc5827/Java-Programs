import java.io.*;

public class ExternExample
{
	public static void main(String... s) throws IOException, ClassNotFoundException
	{
		Car car= new Car("BMW",12);
		Car newCar;
		
		ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("Ducat2"));
		
		out.writeObject(car);
		out.flush();
		
		ObjectInputStream oin=new ObjectInputStream(new FileInputStream("Ducat2"));
		newCar=(Car)oin.readObject();
		
		System.out.println("Original Car is:");
		System.out.println(car);
		
		System.out.println("New Car is:");
		System.out.println(newCar);
	}
}