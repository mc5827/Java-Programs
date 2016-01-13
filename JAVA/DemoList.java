import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class DemoList implements ActionListener
{
	JFrame f;
	JList l;
	JTextField tf;
	JButton b;
	DefaultListModel dlm=new DefaultListModel();
	
	DemoList()
	{
		f=new JFrame("DEMO LIST");
		
		l=new JList(dlm);
		l.setEnabled(false);
		f.add(l);
		
		tf=new JTextField();
		f.add(tf,BorderLayout.WEST);
		
		b=new JButton("add");
		b.addActionListener(this);
		f.add(b,BorderLayout.SOUTH);
	
		f.setSize(400,400);
		f.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		dlm.addElement(tf.getText());
	}
	public static void main(String... s)
	{
		new DemoList();
	}
}