import java.lang.annotation.*;

class TestDeprecated
{
	@Deprecated
	static void display()
	{
		System.out.println("Display");
	}
}

class TestAnnotations
{
	public static void main(String... s)
	{
		new TestAnnotations().doSomeWork();
	}
	@SuppressWarnings({"checked","deprecation"})
	public void doSomeWork()
	{
		TestDeprecated.display();
	}
}