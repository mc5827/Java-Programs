class Anvayi
{
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
	
	public static void main(String... s)
	{
		//System.out.println(wordCount("    I   am         a           bad     boy           "));
		String s1[]=mySplit("    I   am         a           bad     boy  ");
		for(int i=0;i<s1.length;i++)
		{
			System.out.println(s1[i]);
		}
		
	}
}