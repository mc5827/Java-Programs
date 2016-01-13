class String_Demo
{
	static int wordCount(String s)
	{
		System.out.println();
		System.out.println();
		int count=0,k=0,i;
		char ch;
		for(i=0;i<s.length();)
		{
			ch=s.charAt(i);
			while(ch==' ')
			{
				if(i<s.length())
				{
					ch=s.charAt(i++);
				}
				else
				break;
			}
			while(ch>='A' && ch<='Z' || ch>='a' && ch<='z')
			{
				if(i<s.length())
				{
					ch=s.charAt(i++);
				}
				else
				break;
			}
			count++;
		}
		return count;
	}
	
	static int spaceCount(String s)
	{
		System.out.println();
		System.out.println();
		int count=0,i;
		char ch;
		for(i=0;i<s.length();i++)
		{
			ch=s.charAt(i);
			if(ch==' ')
			{
				count++;
			}
		}
		return count;
	}
	
	static int charCount(String s)
	{
		System.out.println();
		System.out.println();
		int count=0,i;
		char ch;
		for(i=0;i<s.length();i++)
		{
			ch=s.charAt(i);
			if((ch>='A' && ch<='Z')|| (ch>='a' && ch<='z'))
			{
				count++;
			}
		}
		return count;
	}
	
	static String reverse(String s)
	{
		System.out.println();
		System.out.println();
		int i,j;
		char ch[]=new char[s.length()];
		for(i=s.length()-1,j=0;i>=0;i--,j++)
		{
			ch[j]=s.charAt(i);
		}
		String s1=new String(ch);
		return s1;
	}
	
	static boolean palindrome(String s)
	{
		System.out.println();
		System.out.println();
		String s1=reverse(s);
		if(s1.equalsIgnoreCase(s))
		{
			return true;
		}
		else
			return false;
	}
	
	static String lTrim(String s)
	{
		System.out.println();
		System.out.println();
		char ch;
		int i;
		for(i=0;i<s.length();i++)
		{
			ch=s.charAt(i);
			if(!(ch==' '))
			{
				break;
			}
		}
		return (s.substring(i,(s.length())));
	}
	
	static String rTrim(String s)
	{
		System.out.println();
		System.out.println();
		char ch;
		int i;
		for(i=s.length()-1;i>=0;i--)
		{
			ch=s.charAt(i);
			if(!(ch==' '))
			{
				break;
			}
		}
		return (s.substring(0,i+1));
	}
	
	static String allTrim(String s)
	{
		System.out.println();
		System.out.println();
		return (rTrim(lTrim(s)));
	}
	
	static String squeeze(String s)
	{
		System.out.println();
		int i,k=0;
		int res=wordCount(s);
		char ch;
		String s1[]=new String[res];
		for(i=0;i<s.length();)
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
			int i_index=i;
			while(ch>='A' && ch<='Z' || ch>='a' && ch<='z')
			{
				if(++i<s.length())
				{
					ch=s.charAt(i);
				}
				else
				break;
			}
			int f_index=i;
			if(!s.substring(i_index,f_index).equals(" "))
			{
			s1[k]=s.substring(i_index,f_index);
			k++;
			}
		}
		String s2;
		s2=s1[0];
		for(i=1;i<s1.length;i++)
		{
			s2=s2+s1[i];
		}
		return s2;
	}
	
	static int vowelCount(String s)
	{
		System.out.println();
		System.out.println();
		s=s.toLowerCase();
		int i,count=0;
		char ch;
		for(i=0;i<s.length();i++)
		{
			ch=s.charAt(i);
			switch(ch)
			{
				case 'a': count++;break;
				case 'e': count++;break;
				case 'i': count++;break;
				case 'o': count++;break;
				case 'u': count++;break;
				default : break;
			}
		}
		return count;
	}
		
	static int length(String s)
	{
		System.out.println();
		System.out.println();
		char ch[]=s.toCharArray();
		return ch.length;
	}
	
	static String changeCase(String s)
	{
		System.out.println();
		System.out.println();
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++)
		{
			char c = chars[i];
			if (Character.isUpperCase(c))
			{
				chars[i] = Character.toLowerCase(c);
			}
			else if (Character.isLowerCase(c))
			{
				chars[i] = Character.toUpperCase(c);
			}
		}
		return new String(chars);
	}
	
	static boolean equals(String s1, String s2)
	{
		System.out.println();
		System.out.println();
		s1=s1.toLowerCase();
		s2=s2.toLowerCase();
		if(compare(s1,s2)!=0)
			return false;
		else
			return true;
	}
	
	static String singleOccurance(String s)
	{
		System.out.println();
		System.out.println();
		int i,j,k;
		char ch;
		char ch1[]=new char[s.length()];
		for(i=0,k=0;i<s.length();k++)
		{
			ch=s.charAt(i);
			ch1[k]=ch;
			for(j=i+1;j<s.length();j++)
			{
				if(ch!=s.charAt(j))
				{
					i=j;
					break;
				}
			}
			if(j>=s.length())
				break;
			
		}
		return (new String(ch1,0,k+1));					
	}
	
	static boolean find(String s1, String s2)
	{
		System.out.println();
		System.out.println();
		int i,j,k,flag;
		for(i=0;i<=(s1.length()-s2.length());)
		{
			flag=0;
			for(k=0,j=i;k<s2.length();k++,j++)
			{
				if(s1.charAt(j)!=s2.charAt(k))
				{
					flag=1;
					i=j+1;
					break;
				}
			}
			if(flag==0)
			{
				return true;
			}
		}
		return false;
	}
	
	static String replace(String s1,String s2,String s3)
	{
		System.out.println();
		System.out.println();
		int index=s1.indexOf(s2);
		String temp1,temp2;
		while(index!=-1)
		{
			temp1=s1.substring(0,index);
			temp2=s1.substring(index+s2.length());
			s1=temp1+s3+temp2;
			index=s1.indexOf(s2);
		}
			
		return s1;
	}
	
	static String sortedWord(String s)
	{	
		System.out.println();
		int i,k=0,j;
		int res=wordCount(s);
		char ch;
		String s1[]=new String[res];
		for(i=0;i<s.length();)
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
			int i_index=i;
			while(ch>='A' && ch<='Z' || ch>='a' && ch<='z')
			{
				if(++i<s.length())
				{
					ch=s.charAt(i);
				}
				else
				break;
			}
			int f_index=i;
			if(!s.substring(i_index,f_index).equals(" "))
			{
			s1[k]=s.substring(i_index,f_index);
			k++;
			}
		}
		String temp;
		for(i=0;i<s1.length;i++)
		{
			for(j=0;j<(s1.length-1);j++)
			{
				if(compare(s1[j],s1[j+1])>0)
				{
						temp=s1[j];
						s1[j]=s1[j+1];
						s1[j+1]=temp;
				}
			}
		}
		s=s1[0];
		
		for(i=0;i<s1.length;i++)
		{
			s=s+" "+s1[i];
		}
		return s;
	}
	
	static void triangle1(String s)
	{
		System.out.println();
		System.out.print("21.	");
		for(int i=0;i<s.length();i++)
		{
			System.out.println();
			System.out.print("	");
			for(int j=0;j<i+1;j++)
			{
				System.out.print(s.charAt(j));
			}
		}
	}
	
	static void triangle2(String s)
	{
		System.out.println();
		System.out.print("22.	");
		for(int i=0;i<s.length();i++)
		{
			System.out.println();
			System.out.print("	");
			for(int j=0;j<(s.length()-i);j++)
			{
				System.out.print(s.charAt(j));
			}
		}
	}
			
	static void triangle3(String s)
	{
		System.out.println();
		System.out.print("23.	");
		for(int i=0;i<s.length();i++)
		{
			System.out.println();
			System.out.print("	");
			for(int j=0;j<(i*2);j++)
			{
				System.out.print(" ");
			}
			for(int k=i;k<s.length();k++)
			{
				System.out.print(s.charAt(k));
			}
		}
	}			
			
	static void triangle4(String s)
	{
		System.out.println();
		System.out.print("24.	");
		for(int i=0;i<s.length();i++)
		{
			System.out.println();
			System.out.print("	");
			for(int j=0;j<(s.length()-i);j++)
			{
				System.out.print(s.charAt(j));
			}
			for(int k=0;k<(i*4);k++)
			{
				System.out.print(" ");
			}
			for(int l=i;l<s.length();l++)
			{
				System.out.print(s.charAt(l));
			}
		}
	}
				
	static int compare(String s1, String s2)
	{
		System.out.println();
		System.out.println();

		byte b1[]=s1.getBytes();
		byte b2[]=s2.getBytes();
		int len,flag=0,i;
		if(b1.length>=b2.length)
		{
			len=b2.length;
		}
		else
			len=b1.length;
		for(i=0;i<len;i++)
		{
			if(b1[i]!=b2[i])
			{
				flag=1;
				break;
			}
		}
		if(flag==1)
		{
			return (b1[i]-b2[i]);
		}
		else
		{
			if(i<b1.length)
			{
				return (b1.length-i);
			}
			else if(i<b2.length)
			{
				return (-(b2.length-i));
			}
			else
				return 0;
		}
	}
	
	static void wordFrequencyCount(String s)
	{
		System.out.println();
		int i,k=0;
		int res=wordCount(s);
		char ch;
		String s1[]=new String[res];
		for(i=0;i<s.length();)
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
			int i_index=i;
			while(ch>='A' && ch<='Z' || ch>='a' && ch<='z')
			{
				if(++i<s.length())
				{
					ch=s.charAt(i);
				}
				else
				break;
			}
			int f_index=i;
			if(!s.substring(i_index,f_index).equals(" "))
			{
			s1[k]=s.substring(i_index,f_index);
			k++;
			}
		}
		String s2[]=new String[res];
		int count=1,j;
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
		
		System.out.println("25.	"+"STRING   		"+"FREQUENCY");
		System.out.println();
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
			System.out.println("	"+s2[i]+"		   "+count1);
		}
}
	
	public static void main(String... s)
	{	
		System.out.print("1.	"+wordCount("   mohit     chandak is    great great is mohit    chandak    is   great  "));
		System.out.print("2.	"+spaceCount("  mohit   chandak     is   great  "));
		System.out.print("3.	"+charCount("  mohit   chandak     is   great  "));
		System.out.print("4.	"+reverse("mohit"));
		System.out.print("5.	"+palindrome("NiTIn"));
		System.out.print("6.	"+lTrim("     mohit chandak  mohit"));	
		System.out.print("7.	"+rTrim("     mohit chandak  mohit   "));
		System.out.print("8.	"+allTrim("     mohit chandak  mohit   "));
		System.out.print("9.	"+squeeze("     mohit chandak  mohit   "));
		System.out.print("10.	"+vowelCount("     mohit chandak  mohit aieou  "));
		System.out.print("11.	"+length("mohit  "));
		System.out.print("14.	"+changeCase("MoHiT"));
		System.out.print("15.	"+singleOccurance("mmooohhhhiiiiitttttt"));
		System.out.print("17.	"+sortedWord("cde bcd abc bcde"));
		System.out.print("18.	"+find("cde bcd abc bcde","bcdf"));
		System.out.print("19.	"+replace("India is a great country. India is best. India is awesome.","India","Bharat"));
		System.out.print("20.	"+equals("mohit","mohitt"));
		triangle1("*****");
		triangle2("*****");
		triangle3("*****");
		triangle4("*****");
		System.out.print("24.	"+compare("Hello","Helloooo"));
		wordFrequencyCount("   mohit     chandak is    great great is mohit    chandak    is   great      ");
	}
}
			
			