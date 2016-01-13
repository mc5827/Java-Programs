import javax.swing.*;
import java.awt.event.*;

class Swing3 implements ActionListener
{
    int count=1;
	JFrame f1;
	JButton b1,b2;
	JLabel l1,l2,l3,l4;
	
	Swing3(String s)
	{
		f1=new JFrame(s);
		
		l1=new JLabel("First",JLabel.LEFT);
		l1.setBounds(100,50,100,100);
		f1.add(l1);
		
		l2=new JLabel("Second",JLabel.RIGHT);
		l2.setBounds(100,200,100,100);
		f1.add(l2);
	
		l3=new JLabel("Third",JLabel.LEFT);
		l3.setBounds(100,350,100,100);
		f1.add(l3);
		
		l4=new JLabel("Fourth",JLabel.RIGHT);
		l4.setBounds(100,500,100,100);
		f1.add(l4);
		
		b1=new JButton("CHANGE");
		b1.setBounds(300,200,100,100);
		b1.addActionListener(this);
		f1.add(b1);
		
		b2=new JButton("ChangeAll");
		b2.setBounds(300,350,100,100);
		b2.addActionListener(this);
		f1.add(b2);
		
		f1.setLayout(null);
		f1.setSize(500,650);
		f1.setVisible(true);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		}
		
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==b1)
			{
				if(count%4==1)
				{
					count=2;
					if(l1.getHorizontalAlignment()==JLabel.LEFT)
					{
						l1.setHorizontalAlignment(JLabel.RIGHT);
					}
					else
					{
						l1.setHorizontalAlignment(JLabel.LEFT);
					}
				}
				
				else if(count%4==2)
				{
					count=3;
					if(l2.getHorizontalAlignment()==JLabel.LEFT)
					{
						l2.setHorizontalAlignment(JLabel.RIGHT);
					}
					else
					{
						l2.setHorizontalAlignment(JLabel.LEFT);
					}
				}
				
				else if(count%4==3)
				{
					count=4;
					if(l3.getHorizontalAlignment()==JLabel.LEFT)
					{
						l3.setHorizontalAlignment(JLabel.RIGHT);
					}
					else
					{
						l3.setHorizontalAlignment(JLabel.LEFT);
					}
				}
				else 
				{
					count=1;
					if(l4.getHorizontalAlignment()==JLabel.LEFT)
					{
						l4.setHorizontalAlignment(JLabel.RIGHT);
					}
					else
					{
						l4.setHorizontalAlignment(JLabel.LEFT);
					}
				}
			}
			
			if(e.getSource()==b2)
			{
				if(l1.getHorizontalAlignment()==JLabel.LEFT)
				{
					l1.setHorizontalAlignment(JLabel.RIGHT);
				}
				else
				{
					l1.setHorizontalAlignment(JLabel.LEFT);
				}
				if(l2.getHorizontalAlignment()==JLabel.LEFT)
				{
					l2.setHorizontalAlignment(JLabel.RIGHT);
				}
				else
				{
					l2.setHorizontalAlignment(JLabel.LEFT);
				}
				if(l3.getHorizontalAlignment()==JLabel.LEFT)
				{
					l3.setHorizontalAlignment(JLabel.RIGHT);
				}
				else
				{
					l3.setHorizontalAlignment(JLabel.LEFT);
				}
				if(l4.getHorizontalAlignment()==JLabel.LEFT)
				{
					l4.setHorizontalAlignment(JLabel.RIGHT);
				}
				else
				{
					l4.setHorizontalAlignment(JLabel.LEFT);
				}
			}
		}
	
	public static void main(String... s)
	{
	new Swing3("Assignment3");
	}
}