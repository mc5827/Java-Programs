class GenerateRandom
{
	public static void main(String... s)
	{
	int min=1, max=9;
	int random=min + (int)(Math.random() * ((max - min) + 1));
	System.out.println("initial random"+random);
	int array_occupied[]={1,4,5,7,8,6,2};
	boolean occupied_check=true;
	
	int flag=0;
				while(occupied_check)
				{
					flag=0;
					for(int q=0;q<7;q++)
					{
						if(random==array_occupied[q])
						{
							flag=1;
							System.out.println("common random"+random);
							random=min + (int)(Math.random() * ((max - min) + 1));
							System.out.println("again intial random"+random);
							break;
						}
					}
					if(flag==0)
					{
						occupied_check=false;
					}
				}
	System.out.println(random);
	}
}
	