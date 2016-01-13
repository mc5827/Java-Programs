import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface MySingle1
{
	int value();
	String name();
}

public class Single1
{
	@MySingle1(value=100, name="Mohit")
	public static void myMethod()
	{
				
		try
		{
			Method m=Single1.class.getMethod("myMethod");
			
			MySingle1 anno=m.getAnnotation(MySingle1.class);
			
			System.out.println(anno.value()+anno.name());
		}
		catch(Exception e){}
	}

	public static void main(String... s)
	{
		myMethod();
	}
}

		