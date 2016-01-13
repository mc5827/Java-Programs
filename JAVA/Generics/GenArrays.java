class Gen1<T extends Number>
{
	T ab;
	T vals[];
	
	Gen1(T o, T[]nums)
	{
		ab=o;
		vals=nums;
	}
}
public class GenArrays
{
	public static void main(String... s)
	{
		Gen1<?> gens[]=new Gen1<?>[10];
		Integer num[]={1,2,3,4};
		
		gens[0]=new Gen1<Integer>(10, num);
		
		for(int i=0;i<gens[0].vals.length;i++)
		System.out.println(gens[0].vals[i]);
	}
}