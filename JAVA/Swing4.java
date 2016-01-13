import javax.swing.*;
import java.awt.event.*;

class Swing4 implements ActionListener
{
	JFrame f;
	JTextArea ta;
	JTextField tf;
	JTextField tf1;
	JButton b;
	JButton b1;
	JButton b2;
	String temp;
	String[] temp1;
	int index=0;
	
	
	Swing4(String s)
	{
		f=new JFrame(s);
		
		ta=new JTextArea();
		ta.setBounds(50,50,400,200);
		f.add(ta);
		
		tf=new JTextField();
		tf.setBounds(50,300,100,50);
		f.add(tf);
		
		b=new JButton("FIND");
		b.setBounds(200,300,100,50);
		b.addActionListener(this);
		f.add(b);
		
		b1=new JButton("NEXT");
		b1.setBounds(350,300,100,50);
		b1.addActionListener(this);
		b1.setVisible(false);
		f.add(b1);
		
		tf1=new JTextField();
		tf1.setBounds(50,400,100,50);
		f.add(tf1);
		
		b2=new JButton("REPLACE");
		b2.setBounds(200,400,100,50);
		b2.addActionListener(this);
		f.add(b2);
		
		f.setLayout(null);
		f.setSize(500,500);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b)
		{
			temp=tf.getText();
			temp1[]=ta.getText().split();
			index=0;
			index=temp1[].indexOf(temp,index);
			ta.select(index, index+temp.length());
			b.setVisible(false);
			b1.setVisible(true);
		}
		if(e.getSource()==b1)
		{
			index=temp1.indexOf(temp,index+temp.length());
			if(index!=-1)
			{
				ta.requestFocusInWindow();
				ta.select(index, index+temp.length());
			}
			else
			{
				b.setVisible(true);
				b1.setVisible(false);
				index=0;
			}
		}
	}	
	public static void main(String... s)
	{
		new Swing4("Assignment 4");
	}
}