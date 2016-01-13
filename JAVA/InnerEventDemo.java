import java.awt.*;
import java.awt.event.*;

public class InnerEventDemo
{
	Frame f;
	Button b,b1;
	TextField tf;
	InnerEventDemo(String s)
	{
		f=new Frame(s);
		b=new Button("OK");
		b1=new Button("CANCEL");
		b.setBounds(20,100,40,40);
		b1.setBounds(20,180,40,40);
		f.add(b);
		f.add(b1);
		b.addActionListener(new 
		ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				tf.setText("SHYAM");
			}
		}
		);
		b1.addActionListener(new 
		ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				tf.setText("RAM");
			}
		}
		);
		
		tf=new TextField();
		tf.setBounds(20,40,100,40);
		f.add(tf);
		
		f.setLayout(null);
		f.setSize(400,400);
		f.setVisible(true);
	}
	public static void main(String... s)
	{
		new InnerEventDemo("DF");
	}
}
