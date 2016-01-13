import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface MyMarker{}

public class Marker
{
	//@MyMarker
	public static void myMethod()
	{
				
		try
		{
			Method m=Marker.class.getMethod("myMethod");
			
			MyMarker anno=m.getAnnotation(MyMarker.class);
			
			if(anno!=null)
			System.out.println("Marker Present");
			
			else
			
			System.out.println("Marker Absent");
		}
		catch(Exception e){}
	}

	public static void main(String... s)
	{
		myMethod();
	}
}

		