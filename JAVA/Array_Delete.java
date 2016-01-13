class Array_Delete
{
	int array_remaining[]={1,2,3,4,5,6,7,8};
	int remaining_counter=8;
	public int[] remainingPosition(int new_occupied)
	{
		int n=0,position=0;
		for(n=0;n<remaining_counter;n++)
		{
			if(array_remaining[n]==new_occupied)
			{
				position=n;
			}
		}
		System.out.println(position);
		for(n=position;n<remaining_counter-1;n++)
		{
			array_remaining[n]=array_remaining[n+1];
		}
		remaining_counter--;
		System.out.println("vhvg "+remaining_counter);
		return array_remaining;
	}
	
	void print()
	{
		array_remaining=remainingPosition(8);
		for(int i=0;i<remaining_counter;i++)
		{
			System.out.println(array_remaining[i]);
		}
	}
	
	public static void main(String... s)
	{
		new Array_Delete().print(); 
		
	}
}