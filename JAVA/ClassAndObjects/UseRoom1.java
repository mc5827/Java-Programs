class Room1
{
int l;
int b;
	void get(int len,int br)
	{
	l=len;
	b=br;
	}
	int area()
	{
	int area;
	area=l*b;
	
	return area;
	}
}
class UseRoom1
{
	public static void main(String args[])
	{
	Room1 r= new Room1();
	r.get(10,10);
	int area=r.area();
	System.out.println("Area is: "+ area);
	}
}
