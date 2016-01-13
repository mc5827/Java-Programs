import javax.swing.*;
import java.awt.event.*;

class Swing2 implements ActionListener
{
	int count=1;
	JFrame f1;
	JButton b1,b2,b3,b4,b5;
	JLabel l;
	
	Swing2(String s)
	{
		f1=new JFrame(s);
		
		l=new JLabel();
		l.setBounds(150,50,200,200);
		f1.add(l);
	
		b1=new JButton("Image 1");
		b1.setBounds(50,350,100,100);
		b1.addActionListener(this);
		f1.add(b1);
		
		b2=new JButton("Image 2");
		b2.setBounds(200,350,100,100);
		b2.addActionListener(this);
		f1.add(b2);
		
		b3=new JButton("Image 3");
		b3.setBounds(350,350,100,100);
		b3.addActionListener(this);
		f1.add(b3);
		
		b4=new JButton("NEXT");
		b4.setBounds(200,500,100,50);
		b4.addActionListener(this);
		f1.add(b4);
		
		b5=new JButton("PREVIOUS");
		b5.setBounds(350,500,100,50);
		b5.addActionListener(this);
		b5.setVisible(false);
		f1.add(b5);
		
		f1.setLayout(null);
		f1.setSize(500,600);
		f1.setVisible(true);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		}
		
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==b4)
			{
				if(count==1)
				{
					count=2;
					b1.setText("Image 4");
					b2.setText("Image 5");
					b3.setText("Image 6");
					
					b5.setVisible(true);
				}
			
				else if(count==2)
				{
					count=3;
					b1.setText("Image 7");
					b2.setText("Image 8");
					b3.setText("Image 9");
					
					b4.setVisible(false);
				}
			}
			
			if(e.getSource()==b5)
			{
				if(count==2)
				{
					count=1;
					b1.setText("Image 1");
					b2.setText("Image 2");
					b3.setText("Image 3");
					
					b5.setVisible(false);
				}
				
				else if(count==3)
				{
					count=2;
					b1.setText("Image 4");
					b2.setText("Image 5");
					b3.setText("Image 6");
					
					b4.setVisible(true);
					
				}
			}
			
			if(e.getActionCommand().equals("Image 1"))
			{	
				System.out.println("1");
				l.setIcon(new ImageIcon("C:\\Users\\Public\\Pictures\\Sample Pictures\\Chrysanthemum.jpg"));
			}
			
			if(e.getActionCommand().equals("Image 2"))
			{
				System.out.println("2");
				l.setIcon(new ImageIcon("C:\\Users\\Public\\Pictures\\Sample Pictures\\Desert.jpg"));
			}
			
			if(e.getActionCommand().equals("Image 3"))
			{
				System.out.println("3");
				l.setIcon(new ImageIcon("C:\\Users\\Public\\Pictures\\Sample Pictures\\Hydrangeas.jpg"));
			}
			
			if(e.getActionCommand().equals("Image 4"))
			{
				System.out.println("4");
				l.setIcon(new ImageIcon("C:\\Users\\Public\\Pictures\\Sample Pictures\\Koala.jpg"));
			}
			
			if(e.getActionCommand().equals("Image 5"))
			{
				System.out.println("5");
				l.setIcon(new ImageIcon("C:\\Users\\Public\\Pictures\\Sample Pictures\\Jellyfish.jpg"));
			}
			
			if(e.getActionCommand().equals("Image 6"))
			{
				System.out.println("6");
				l.setIcon(new ImageIcon("C:\\Users\\Public\\Pictures\\Sample Pictures\\Lighthouse.jpg"));
			}
			
			if(e.getActionCommand().equals("Image 7"))
			{
				System.out.println("7");
				l.setIcon(new ImageIcon("C:\\Users\\Public\\Pictures\\Sample Pictures\\Penguins.jpg"));
			}
			
			if(e.getActionCommand().equals("Image 8"))
			{
				System.out.println("8");
				l.setIcon(new ImageIcon("C:\\Users\\Public\\Pictures\\Sample Pictures\\Tulips.jpg"));
			}
			
			if(e.getActionCommand().equals("Image 9"))
			{
				System.out.println("9");
				l.setIcon(new ImageIcon("C:\\Users\\Public\\Pictures\\Sample Pictures\\Bhavya.jpg"));
			}
		}
	
	public static void main(String... s)
	{
	new Swing2("Assignment2");
	}
}