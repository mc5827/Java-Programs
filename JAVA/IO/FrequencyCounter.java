import java.io.*;
import java.util.*;

class FrequencyCounter
{
	public static void main(String... s1) throws IOException
	{
		DataInputStream dis=new DataInputStream(new FileInputStream("Country.txt"));
		
		String s="";
		String s2="";
		
		while(s!=null)
		{
			s=dis.readLine();
			if(s!=null)
			{
				s2=s2+" "+s;
			}
		}
		String as[]=mySplit(s2);
		frequencyCount(as);
	}
	public static void frequencyCount(String [] s1)
	{
		String s2[]=new String[s1.length];
		int count=1,j,i;
		s2[0]=s1[0];
		for(i=1;i<s1.length;i++)
		{
			int flag=0;
			for(j=i-1;j>=0;j--)
			{
				if(s1[i].equals(s2[j]))
				{
				flag=1;
				break;
				}
			}
			if(flag==0)
			{
				s2[count]=s1[i];
				count++;
			}	
		}
		int wordNumber[]=new int[count];
		for(i=0;i<count;i++)
		{
			int count1=0;
			for(j=0;j<s1.length;j++)
			{
				if(s2[i].equals(s1[j]))
				{
					count1++;
				}
			}
			wordNumber[i]=count1;
		}
		for(i=0;i<count-1;i++)
		{
			for(j=i+1;j<count;j++)
			{
				if(wordNumber[i]>wordNumber[j])
				{
					int tempInt=wordNumber[i];
					wordNumber[i]=wordNumber[j];
					wordNumber[j]=tempInt;
					
					String tempString=s2[i];
					s2[i]=s2[j];
					s2[j]=tempString;
				}
				else if(wordNumber[i]==wordNumber[j])
				{
					if((s2[i].compareTo(s2[j]))>0)
					{
						String tempString=s2[i];
						s2[i]=s2[j];
						s2[j]=tempString;
					}
				}
			}
		}
		System.out.println("Word"+"		"+"Frequency");
		for(i=0;i<count;i++)
		{
			System.out.println(s2[i]+"		"+wordNumber[i]);
		}
	}
	public static int wordCount(String s)
	{
		int i=0,count=0,flag=0;
		char ch;
		for(;i<s.length();)
		{
			ch=s.charAt(i);
			while(ch==' ')
			{
				if(++i<s.length())
				{
					ch=s.charAt(i);
				}
				else
				break;
			}
			flag=0;
			while(ch>='A' && ch<='Z' || ch>='a' && ch<='z')
			{
				flag=1;
				if(++i<s.length())
				{
					ch=s.charAt(i);
				}
				else
				break;
			}
			if(flag==1)
			count++;
		}
	return count;
	}

	public static String[] mySplit(String s)
	{
		
		int res=wordCount(s);
		s=s+" ";
		String s1[]=new String[res];
		int i=0,k=0,i_index,f_index,flag=0;
		char ch;
		
		for(;i<s.length();)
		{
			ch=s.charAt(i);
			while(ch==' ')
			{	
				if(i+1<s.length())
				{
					ch=s.charAt(++i);
				}
				else
				{
					flag=1;
					break;
				}
			}
			if(flag==1)
			break;
			i_index=i;
			while(ch>='A' && ch<='Z' || ch>='a' && ch<='z')
			{
				if(i+1<s.length())
				{
					ch=s.charAt(++i);
				}
				else
				break;
			}
			f_index=i;
			if(!s.substring(i_index,f_index).equals(" "))
			{
			s1[k]=s.substring(i_index,f_index);
			k++;
			}
			
		}
		return s1;
	}
	
	
}
		