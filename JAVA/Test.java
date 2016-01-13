import javax.swing.*;
import java.awt.*;

class Test
{
	JFrame f;
	JPanel p1,p2,p3,p4,p5;
	
	Test(String s)
	{
		f=new JFrame(s);
		
		p1=new JPanel();
		p1.setSize(100,100);
		p1.setBorder(BorderFactory.createTitledBorder("NORTH"));
		f.add(p1,BorderLayout.NORTH);
		
		p2=new JPanel();
		p2.setSize(100,100);
		p2.setBorder(BorderFactory.createTitledBorder("SOUTH"));
	    f.add(p2, BorderLayout.SOUTH);
		
		p3=new JPanel();
		p3.setSize(100,100);
		p3.setBorder(BorderFactory.createTitledBorder("EAST"));
		f.add(p3, BorderLayout.EAST);
		
		p4=new JPanel();
		p4.setSize(100,100);
		p4.setBorder(BorderFactory.createTitledBorder("WEST"));
		f.add(p4, BorderLayout.WEST);
		
		p5=new JPanel();
		p5.setSize(100,100);
		p5.setBorder(BorderFactory.createTitledBorder("CENTER"));
		f.add(p5, BorderLayout.CENTER);
		
		f.pack();
		f.setVisible(true);
	
	}
	
	public static void main(String... s)
	{
		new Test("FARZI");
	}
}
		
		