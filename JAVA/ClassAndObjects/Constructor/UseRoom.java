class Room
{
	int l;
	int b;
	Room()
	{
	System.out.println("Area" + l*b);
	}
	Room(int a,int b)
	{
	l=a;
	this.b=b;
	System.out.println("Area" + l*b);
	}
	Room(Room r)
	{
	l=r.l;
	b=r.b;
	System.out.println("Area" + l*b);
	}
}
class UseRoom
{
	public static void main(String args[])
	{
	Room r1=new Room();
	Room r2=new Room(12,20);
	Room r3=new Room(r1);
	}
}