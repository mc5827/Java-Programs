class DemoThrow
{
	public static void main(String args[])
	{
	ArithmeticException e= new ArithmeticException("MOHIT");
	
	try{
	
	throw(e);
	
	   }
	catch(ArithmeticException e1){
	System.out.println(e1);
}	}
}