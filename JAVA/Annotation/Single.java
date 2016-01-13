import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface MySingle
{
	int value();
}

public class Single
{
	@MySingle(value=100)
	public static void myMethod()
	{
				
		try
		{
			Method m=Single.class.getMethod("myMethod");
			
			MySingle anno=m.getAnnotation(MySingle.class);
			
			System.out.println(anno.value());
		}
		catch(Exception e){}
	}

	public static void main(String... s)
	{
		myMethod();
	}
}

		