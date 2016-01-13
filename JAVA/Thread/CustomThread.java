class CustomThread extends Thread
{
	Shared s;
	public CustomThread(Shared s, String str)
	{
		super(str);
		this.s=s;
		start();
	}
	
	public void run()
	{
		s.show(getName(),10);
		s.show1(getName(),20);
		s.show2(getName(),30);
		s.show3(getName(),40);
		
	}
}