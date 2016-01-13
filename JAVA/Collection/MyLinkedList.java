class MyLinkedList
{
	static MyLinkedList front;
	static MyLinkedList rear;
	static MyLinkedList temp;
	MyLinkedList next;
	String value;
	
	MyLinkedList()
	{
		
		
	}	
	
	MyLinkedList(Object o)
	{
		next=null;
		value=(String)o;
	}
	
	public void addFirst(Object o)
	{
		temp= new MyLinkedList(o);
		
		if(front==null && rear==null)
		{
			front.next=temp;
			rear.next=temp;
		}
		
		else
		{
			temp.next=front.next;
			front.next=temp;
		}
	}
	public void addLast(Object o)
	{
		temp=new MyLinkedList(o);
		if(front.next==null && rear.next==null)
		{
			front.next=temp;
			rear.next=temp;
		}
		else
		{
			MyLinkedList temp1=rear.next;
			temp1.next=temp;
			rear.next=temp;
		}
	}
	public Object removeFirst()
	{
		temp=front.next;
		front.next=temp.next;
		temp.next=null;
		return temp.value;
	}
	public Object removeLast()
	{
		temp=rear.next;
		rear.next=temp.next;
		temp.next=null;
		return temp.value;
	}
	
	public void display()
	{
		if(front.next==null)
		{
			System.out.println("Empty List....");
			
		}
		else
		{
			for(temp=front.next;temp.next!=null;temp=temp.next)
			{
				System.out.println();
				System.out.print(temp.value+"	");
			}
		}
	}
}