import java.lang.reflect.*;
import java.io.*;
import java.util.*;

public class MyJavaP
{
	public static void main(String... fn) throws IOException
	{
		String param=fn[0];
		String param1=param+".";
		String fileName="D:\\SERVER_FILE\\"+param+".txt";
		Class className=void.class;
		
		try
		{
			className=Class.forName(param);
		}
		catch(Exception e)
		{
			System.out.println(e);
			System.exit(0);
		}
		
		PrintStream ps=new PrintStream(new FileOutputStream(new File(fileName)));
		System.setOut(ps);
		
		StringTokenizer st=new StringTokenizer(param,".");
		String name="";
		while(st.hasMoreTokens())
		{
			name=st.nextToken();
		}
		
		System.out.println("Complied from "+"'"+name+".java'");
		
		int modifier=className.getModifiers();
		
		if(Modifier.isPublic(modifier))
		{
			System.out.print("public ");
		}
		if(Modifier.isFinal(modifier))
		{
			System.out.print("final ");
		}
		if(Modifier.isAbstract(modifier))
		{
			System.out.print("abstract ");
		}
		
		if(className.isInterface())
		{
			System.out.print("interface ");
		}
		else
		{
			System.out.print("class ");
		}
		
		System.out.print(param+" ");
		
		Class superClass=className.getSuperclass();
		if(superClass!=null)
		{
			System.out.print("extends "+superClass.getName()+" ");
		}
		
		Class inter[]=className.getInterfaces();
		if(inter.length>0)
		{
			if(!(className.isInterface()))
			System.out.print("implements ");
			
			else
			System.out.print("extends ");
			for(int i=0;i<inter.length;i++)
			{
				System.out.print(inter[i].getName()+" ");
			}
		}
		System.out.println("{");
		
		Field fields[]=className.getDeclaredFields();
		if(fields.length>0)
		{
			for(int i=0;i<fields.length;i++)
			{
				int modifierField=fields[i].getModifiers();
				if(!(Modifier.isPrivate(modifierField)))
				{
				String replace1=replace(fields[i].toString(),param1,"");
				System.out.println(replace1+";");
				}
			}
		}
		Constructor constructors[]=className.getDeclaredConstructors();
		if(constructors.length>0)
		{
			for(int i=0;i<constructors.length;i++)
			{
				System.out.println(constructors[i].toString()+";");
			}
		}
		Method methods[]=className.getDeclaredMethods();
		if(methods.length>0)
		{
			for(int i=0;i<methods.length;i++)
			{
				int modifierMethod=methods[i].getModifiers();
				if(!(Modifier.isPrivate(modifierMethod)))
				{
					String replace1=replace(methods[i].toString(),param1,"");
					System.out.println(replace1+";");
				}	
			}
		}
		System.out.print("}");
	}
	static String replace(String s1,String s2,String s3)
	{
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
	
}
		
		