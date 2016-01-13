import javax.swing.*;
import java.awt.*;

class Test1
{
	JFrame f;
	JButton b1,b2,b3,b4,b5,b6;
	
	Test1(String s)
	{
		f=new JFrame(s);
		
		b5=new JButton("5");
		b5.setBounds(0,0,50,50);
		f.add(b5);
		
		b1=new JButton("1");
		b1.setBounds(50,50,50,50);
		f.add(b1);
		
		b2=new JButton("2");
		b2.setBounds(100,100,50,50);
		f.add(b2);
		
		b3=new JButton("3");
		b3.setBounds(150,150,50,50);
		f.add(b3);
		
		b4=new JButton("4");
		b4.setBounds(200,200,50,50);
		f.add(b4);
		
		b6=new JButton("6");
		b1.setBounds(250,250,50,50);
		f.add(b1);
		
		f.setSize(800,800);
		f.setVisible(true);
	}
	
	public static void main(String... s)
	{
		new Test1("Test1");
	}
}