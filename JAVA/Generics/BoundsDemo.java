class Stats<T extends Number>
{
	T nums[];
	
	Stats(T[] o)
	{
		nums=o;
	}
	double average()
	{
		double sum=0.0;
		for(int i=0;i<nums.length;i++)
			sum+=nums[i].doubleValue();
		return (sum/nums.length);
	}
}

public class BoundsDemo
{
	public static void main(String... s)
	{
		Integer inums[]={1,2,3,4,5};
		Stats<Integer> iob=new Stats<Integer>(inums);
		double v=iob.average();
		System.out.println("Average: "+v);
		
		Float fnums[]={1.2F, 2.3F, 3.3F};
		Stats<Float> fob=new Stats<Float>(fnums);
		double v1=fob.average();
		System.out.println("Average: "+v1);
		
	}
}
