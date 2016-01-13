class ArrayDemo
{
	static int max(int x[])
	{
		int max=x[0];
		for(int i=1;i<x.length;i++)
		{
			if(x[i]>max)
			{
				max=x[i];
			}
		}
		return max;
	}
	
	static int max1(int x[][])
	{
		int max=x[0][0];
		for(int i=0;i<x.length;i++)
		{
			for(int j=0;j<x[i].length;j++)
			{
				if(x[i][j]>max)
				{
				max=x[i][j];
				}
			}
		}
	return max;
	}
	
	static int min(int x[])
	{
		int min=x[0];
		for(int i=1;i<x.length;i++)
		{
			if(x[i]<min)
			{
				min=x[i];
			}
		}
		return min;
	}
	
	static int min1(int x[][])
	{
		int min=x[0][0];
		for(int i=0;i<x.length;i++)
		{
			for(int j=0;j<x[i].length;j++)
			{
				if(x[i][j]<min)
				{
				min=x[i][j];
				}
			}
		}
	return min;
	}
	
	static void sort(int x[])
	{
		int temp;
		for(int i=0;i<x.length;i++)
		{
			for(int j=0;j<(x.length-1);j++)
			{
				if(x[j]>x[j+1])
				{
						temp=x[j];
						x[j]=x[j+1];
						x[j+1]=temp;
				}
			}
		}
		System.out.print("5a.	");
		for(int i=0;i<x.length;i++)
		{
			System.out.print(x[i]+" ");
		}
		
		System.out.println("");
		System.out.print("5b.	");
		for(int i=x.length-1;i>=0;i--)
		{
			System.out.print(x[i]+" ");
		}
	}
	
	static void mergeSort(int x[],int y[])
	{
		int z[]=new int[x.length+y.length];
		int i,j=0;
		for(i=0;i<x.length;i++)
		{
			z[j++]=x[i];
		}
		for(i=0;i<y.length;i++)
		{
			z[j++]=y[i];
		}
		System.out.println();
		System.out.println("7.	");
		sort(z);
	}
	
	static void sort1(int x[][])
	{
		System.out.println();
		System.out.print("6.	");
		int i,j,len=0,k=0;
		for(i=0;i<x.length;i++)
		{
			len=len+x[i].length;
		}
		int temp[]=new int[len];
		for(i=0;i<x.length;i++)
		{
			for(j=0;j<x[i].length;j++)
			{
				temp[k++]=x[i][j];
			}
		}
		int temp1;
		for(i=0;i<temp.length;i++)
		{
			for(j=0;j<(temp.length-1);j++)
			{
				if(temp[j]>temp[j+1])
				{
						temp1=temp[j];
						temp[j]=temp[j+1];
						temp[j+1]=temp1;
				}
			}
		}
		k=0;
		for(i=0;i<x.length;i++)
		{
			System.out.println("	");
			for(j=0;j<x[i].length;j++)
			{
				x[i][j]=temp[k++];
				System.out.print(x[i][j]+" ");
			}
		}
	}
	static void union(int x[],int y[])
	{
		int i,j,k,count=0,flag1;
		int temp[]=new int[(x.length+y.length)];
		for(i=0;i<x.length;i++)
		{
			for(j=0;j<y.length;j++)
			{
				if(x[i]==y[j])
				{
					flag1=0;
					for(k=count-1;k>=0;k--)
					{
						if(x[i]==temp[k])
						{
							flag1=1;
							break;
						}
					}
					if(flag1==0)
					{
						temp[count++]=x[i];
					}
				}
			}
		}
		System.out.println();
		System.out.print("8.	");
		for(i=0;i<x.length;i++)
		{
			int flag=0;
			for(j=0;j<count;j++)
			{
				if(x[i]==temp[j])
				
				{
				flag=1;
				break;
				}
			}
			if(flag==0)
			System.out.print(x[i]+" ");
		}
		for(i=0;i<y.length;i++)
		{
			int flag=0;
			for(j=0;j<count;j++)
			{
				if(y[i]==temp[j])
				{
				flag=1;
				break;
				}
			}
			if(flag==0)
			System.out.print(y[i]+" ");
		}
		for(i=0;i<count;i++)
		{
		System.out.print(temp[i]+" ");
		}
	}
	
	static void intersection(int x[],int y[])
	{
		int i,j,count=0,flag1,k;
		int temp[]=new int[(x.length+y.length)];
		for(i=0;i<x.length;i++)
		{
			for(j=0;j<y.length;j++)
			{
				if(x[i]==y[j])
				{
				flag1=0;
					for(k=count-1;k>=0;k--)
					{
						if(x[i]==temp[k])
						{
							flag1=1;
							break;
						}
					}
					if(flag1==0)
					{
						temp[count++]=x[i];
					}
				}
			}
		}
		System.out.println();
		System.out.print("9.	");
		for(i=0;i<count;i++)
		{
		System.out.print(temp[i]+" ");
		}
	}
	
	static void matrixAdd(int x[][],int y[][])
	{
		int i,j;
		System.out.println();
		System.out.print("10.	");	
		for(i=0;i<x.length;i++)
		{
			System.out.println();
			for(j=0;j<x[i].length;j++)
			{
			System.out.print("	"+x[i][j]+" ");
			}
		}
		System.out.println();
		for(i=0;i<y.length;i++)
		{
			System.out.println();
			for(j=0;j<y[i].length;j++)
			{
				System.out.print("	"+y[i][j]+" ");
			}
		}		
		System.out.println();
		for(i=0;i<y.length;i++)
		{
			System.out.println();
			for(j=0;j<y[i].length;j++)
			{
				System.out.print("	"+(x[i][j]+y[i][j])+" ");
			}
		}	
	}
	
	static void matrixMultiply(int x[][],int y[][])
	{
		int i=0,j,k;
		int z[][]=new int[x.length][x[i].length];
		System.out.println();
		System.out.print("11.	");	
		for(i=0;i<x.length;i++)
		{
			System.out.println();
			for(j=0;j<x[i].length;j++)
			{
			System.out.print("	"+x[i][j]+" ");
			}
		}
		System.out.println();
		for(i=0;i<y.length;i++)
		{
			System.out.println();
			for(j=0;j<y[i].length;j++)
			{
				System.out.print("	"+y[i][j]+" ");
			}
		}		
		System.out.println();
		for(i=0;i<x.length;i++)
		{	
			for(j=0;j<x.length;j++)
			{	
				int sum=0;
				for(k=0;k<x.length;k++)
				{
				sum=sum+(x[i][k]*y[k][j]);
				}
			z[i][j]=sum;
			}
		}
		System.out.println();
		for(i=0;i<z.length;i++)
		{
			System.out.println();
			for(j=0;j<z[i].length;j++)
			{
				System.out.print("	"+z[i][j]+" ");
			}
		}
	}
	
	static void matrixSum(int x[][])
	{
		System.out.println();
		System.out.print("12.	");
		int i,j,d1=0,d2=0;
		int temp[]=new int[x.length+2];
		for(i=0;i<x.length;i++)
		{
			System.out.println();
			System.out.print("   ");
			int sum1=0,sum2=0;
			for(j=0;j<x[i].length;j++)
			{
				sum1=sum1+x[i][j];
				sum2=sum2+x[j][i];
				System.out.print(x[i][j]+" ");
				if(i==j)
				d1=d1+x[i][j];
				if(i+j==(x.length-1))
				d2=d2+x[i][j];
			}
			System.out.print(sum1);
			temp[i+1]=sum2;
		}
		temp[0]=d2;
		temp[x.length+1]=d1;
		System.out.println();
		System.out.print(temp[0]);
		for(i=1;i<temp.length;i++)
		System.out.print(" "+temp[i]);
	}
	
	static int triangleASum(int x[][])
	{
		int i,j,sum=0;
		for (i=0;i<x.length;i++)
		{
			for(j=0;j<x[i].length;j++)
			{
				if(i<=j)
				sum=sum+x[i][j];
			}
		}
	return sum;
	}
	
	static int triangleAMax(int x[][])
	{
		int i,j,max=x[0][0];
		for(i=0;i<x.length;i++)
		{
			for(j=0;j<x[i].length;j++)
			{
				if(i<=j)
				{
					if(max<x[i][j])
					{
						max=x[i][j];
					}
				}
			}
		}
		return max;
	}
	
	static int triangleAMin(int x[][])
	{
		int i,j,min=x[0][0];
		for(i=0;i<x.length;i++)
		{
			for(j=0;j<x[i].length;j++)
			{
				if(i<=j)
				{
					if(min>x[i][j])
					{
						min=x[i][j];
					}
				}
			}
		}
		return min;
	}
	
	static int triangleBSum(int x[][])
	{
		int i,j,sum=0;
		for(i=0;i<x.length;i++)
		{
			for(j=0;j<x[i].length;j++)
			{
				if(i>=j)
				sum=sum+x[i][j];
			}
		}
		return sum;
	}
	
	static int triangleBMax(int x[][])
	{
		int i=x.length-1,j,max=x[i][(x[i].length-1)];
		for(i=0;i<x.length;i++)
		{
			for(j=0;j<x[i].length;j++)
			{
				if(i>=j)
				{
					if(max<x[i][j])
					max=x[i][j];
				}
			}
		}
		return max;
	}
	
	static int triangleBMin(int x[][])
	{
		int i=x.length-1,j,min=x[i][(x[i].length-1)];
		for(i=0;i<x.length;i++)
		{
			for(j=0;j<x[i].length;j++)
			{
				if(i>=j)
				{
					if(min>x[i][j])
					min=x[i][j];
				}
			}
		}
		return min;
	}
	
	static void shift(int x[])
	{
		int temp,i,j;
		for(i=0;i<x.length;i++)
		{
			for(j=0;j<(x.length-1);j++)
			{
				if(x[j]>x[j+1])
				{
						temp=x[j];
						x[j]=x[j+1];
						x[j+1]=temp;
				}
			}
		}
		int count=0;
		i=0;
		while(x[i]<0)
		{
			count++;
			i++;
		}
		for(i=0,j=count-1;i<j;i++,j--)
		{
			temp=x[i];
			x[i]=x[j];
			x[j]=temp;
		}
		System.out.println();
		System.out.print("19.	");
		for(i=0;i<x.length;i++)
		{
			System.out.print(x[i]+" ");
		}
	}
	
	static void spiral(int x[][])
	{
		System.out.println();
		int i,j,k,l,m,n,row;
		row=x.length;
		for(i=0,j=row-1;i<=j;i++,j--)
		{
			for(k=i;k<row-i;k++)
			{
				System.out.print(x[i][k]+",");
			}
			for(l=i+1;l<row-i;l++)
			{
				System.out.print(x[l][j]+",");
			}
			for(m=j-1;m-i>=0;m--)
			{
				System.out.print(x[j][m]+",");
			}
			for(n=j-1;n>=i+1;n--)
			{
				System.out.print(x[n][i]+",");
			}
		}
	}
			
		
	static void frequencyCount(int x[])
	{
		System.out.println();
		int i,j,count=1;
		int temp[]=new int[x.length];
		temp[0]=x[0];
		for(i=1;i<x.length;i++)
		{
			int flag=0;
			for(j=i-1;j>=0;j--)
			{
				if(x[i]==temp[j])
				{
				flag=1;
				break;
				}
			}
			if(flag==0)
			{
				temp[count]=x[i];
				count++;
			}
		}
		System.out.println();
		System.out.println("20.	"+"element		"+"frequency");
		for(i=0;i<count;i++)
		{
			int count1=0;
			for(j=0;j<x.length;j++)
			{
				if(temp[i]==x[j])
				{
					count1++;
				}
			}
			System.out.println("	"+temp[i]+"		"+count1);
		}
	}
				
		public static void main(String... s)
	{
		/*System.out.println("1.	"+max(new int[] {1,4,6,8,65,9,1}));
		System.out.println("2.	"+max1(new int[][] {{1,2,88},{4,66,77,123},{100,345,33},}));
		System.out.println("3.	"+min(new int[] {1,4,6,8,65,9,1}));
		System.out.println("4.	"+min1(new int[][] {{-1,2,88},{4,66,77,123},{100,345,33},}));
		sort(new int[] {112,41,45,1,32,200});
		sort1(new int[][] {{9,8,7,10},{6,5,4},{3,2,1},});
*/		spiral(new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16},});
/*
		mergeSort(new int[] {1,3,5,7,9}, new int[] {2,4,6,8});
		union(new int[] {112,411,451,11,321,411,200,200,411,1234},new int[] {112,411,411,41,45,1,32,200});
		intersection(new int[] {112,411,451,11,321,411,200,200,411,1234},new int[] {112,411,411,41,45,1,32,200,200,112,411,41,45,1,32,32});
		matrixAdd(new int[][] {{1,2},{3,4},},new int[][] {{1,2},{3,4},});
		matrixMultiply(new int[][] {{1,2},{3,4},},new int[][] {{1,2},{3,4},});
		matrixSum(new int[][] {{1,2},{3,4},});
		System.out.println();
		System.out.println("13.	"+triangleASum(new int[][] {{1,2,3},{4,5,6},{7,8,9},}));
		System.out.println();
		System.out.println("14.	"+triangleAMax(new int[][] {{1,2,3},{4,5,6},{7,8,9},}));
		System.out.println();
		System.out.println("15.	"+triangleAMin(new int[][] {{1,2,3},{4,5,6},{7,8,9},}));
		System.out.println();
		System.out.println("16.	"+triangleBSum(new int[][] {{1,2,3},{4,5,6},{7,8,9},}));
		System.out.println();
		System.out.println("17.	"+triangleBMax(new int[][] {{1,2,3},{4,5,6},{7,8,9},}));
		System.out.println();
		System.out.println("18.	"+triangleBMin(new int[][] {{1,2,3},{4,5,6},{7,8,9},}));
		shift(new int[] {-9,4,3,-3,2,-2,1,-8,});
		frequencyCount(new int[] {1,2,3,1,2,1});*/
	}
}
		