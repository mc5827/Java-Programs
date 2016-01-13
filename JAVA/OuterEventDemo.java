import java.awt.*;
import java.awt.event.*;

public class OuterEventDemo
{
	Frame f;
	Button b,b1;
	TextField tf;
	OuterEventDemo(String s)
	{
		f=new Frame(s);
		f.addWindowListener(new WindowsEventListner());
		b=new Button("OK");
		b1=new Button("CANCEL");
		b.setBounds(20,100,40,40);
		b1.setBounds(20,180,40,40);
		f.add(b);
		f.add(b1);
		
		b.addMouseListener(new MouseEventListener(this));
		b1.addMouseListener(new MouseEventListener(this));
		Outer o=new Outer(this);
		b.addActionListener(o);
		b1.addActionListener(o);
		
		
		tf=new TextField();
		tf.setBounds(20,40,100,40);
		f.add(tf);
		tf.addKeyListener(new KeyEventListener());
		f.setLayout(null);
		f.setSize(400,400);
		f.setVisible(true);
	}
	public static void main(String... s)
	{
		new OuterEventDemo("DF");
	}
}

class Outer implements ActionListener
{
OuterEventDemo oe;
	Outer(OuterEventDemo oe)
	{
		this.oe=oe;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==oe.b)
			oe.tf.setText("LALU");
		if(e.getSource()==oe.b1)
			oe.tf.setText("BHALU");
	}
}
class WindowsEventListner extends WindowAdapter
{
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}
}
class MouseEventListener extends MouseAdapter
{
	OuterEventDemo oe;
	
	MouseEventListener(OuterEventDemo oe)
	{
	this.oe=oe;
	}
	public void mouseEntered(MouseEvent me)
	{
		if(me.getSource()==oe.b)
		oe.tf.setText("India");
		if(me.getSource()==oe.b1)
		oe.tf.setText("Bharat");
	}
	public void mouseClicked(MouseEvent me)
	{
		if(me.getSource()==oe.b)
		oe.tf.setText("US");
		if(me.getSource()==oe.b1)
		oe.tf.setText("USA");
	}
	public void mouseExited(MouseEvent me)
	{
		if(me.getSource()==oe.b)
		oe.tf.setText("");
		if(me.getSource()==oe.b1)
		oe.tf.setText("");
	}
}
class KeyEventListener extends KeyAdapter
{
	
	public void keyPressed(KeyEvent ke)
	{
		char ch=ke.getKeyChar();
		if(!((ch>='a' && ch<='z')|| (ch>='A' && ch<='Z') || ch==' '))
		{
			System.out.println("Invalid");
		}
	}
}