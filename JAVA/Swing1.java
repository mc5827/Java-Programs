import javax.swing.*;
import java.awt.event.*;
class Swing1 implements ActionListener
{
	JFrame f;
	JButton b1,b2,b3;
	JLabel l;
	
	Swing1(String s)
	{
		f=new JFrame(s);
		
		l=new JLabel();
		l.setBounds(150,50,200,200);
		f.add(l);
		
		b1=new JButton("IMAGE 1");
		b1.setBounds(50,350,100,100);
		b1.addActionListener(this);
		f.add(b1);
		
		b2=new JButton("IMAGE 2");
		b2.setBounds(200,350,100,100);
		b2.addActionListener(this);
		f.add(b2);
		
		b3=new JButton("IMAGE 3");
		b3.setBounds(350,350,100,100);
		b3.addActionListener(this);
		f.add(b3);
		
		f.setLayout(null);
		f.setSize(500,500);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			
			l.setIcon(new ImageIcon("C:\\Users\\Public\\Pictures\\Sample Pictures\\Chrysanthemum.jpg"));
		}
		
		if(e.getSource()==b2)
		{
			
			l.setIcon(new ImageIcon("C:\\Users\\Public\\Pictures\\Sample Pictures\\Desert.jpg"));
		}
		
		if(e.getSource()==b3)
		{
			
			l.setIcon(new ImageIcon("C:\\Users\\Public\\Pictures\\Sample Pictures\\Koala.jpg"));
		}
	}
	
	public static void main(String... s)
	{
		new Swing1("Assignment1");
	}
}
	