import java.io.*;

class CountInFile
{
	public static void main(String... s) throws IOException
	{
		FileInputStream fis=new FileInputStream(new File("D:\\Abstract.docx"));
		int charCount=0;
		
		while(fis.read()!=-1)
		{
			charCount++;
		}
		fis.close();
		DataInputStream dis=new DataInputStream(new FileInputStream(new File("D:\\Abstract.docx")));
		int lineCount=0;
		String s1="";
		while(s1!=null)
		{
			s1=dis.readLine();
			if(s1!=null)
			{
				lineCount++;
			}
		}
		dis.close();
		
		InputStreamReader isr=new InputStreamReader(new FileInputStream(new File("D:\\Abstract.docx")));
		StreamTokenizer st=new StreamTokenizer(isr);
		
		st.eolIsSignificant(true);
		st.wordChars(33,255);
		st.whitespaceChars(32,32);
		int token=0,wordCount=0;
		
		while(true)
		{
			token=st.nextToken();
			if(token==StreamTokenizer.TT_EOF)
			break;
			if(token==StreamTokenizer.TT_NUMBER)
			{}
			if(token==StreamTokenizer.TT_WORD)
			wordCount++;
		}
		
		isr.close();
		
		System.out.println("Number of Alpahbets: "+charCount);
		System.out.println("Number of Words:       "+wordCount);
		System.out.println("Number of Lines:          "+lineCount);
	}
}