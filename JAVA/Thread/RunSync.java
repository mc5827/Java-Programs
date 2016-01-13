class RunSync
{
	public static void main(String... s)
	{
		Shared st=new Shared();
		CustomThread t1=new CustomThread(st,"ONE");
		CustomThread1 t2=new CustomThread1(st,"TWO");
		
	}
}