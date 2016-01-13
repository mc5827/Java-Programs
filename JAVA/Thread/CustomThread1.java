class CustomThread1 extends Thread
{
	Shared s;
	public CustomThread1(Shared s, String str)
	{
		super(str);
		this.s=s;
		start();
	}
	
	public void run()
	{
		s.show(getName(),100);
		s.show1(getName(),200);
		s.show2(getName(),300);
		s.show3(getName(),400);
	}
}