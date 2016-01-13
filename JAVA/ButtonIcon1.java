import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;

class ButtonIcon1 implements ActionListener
{
	JButton jb;
	JFrame jf;
	//Icon cross = new ImageIcon("C:\\Users\\Public\\Pictures\\Sample Pictures\\Desert.jpg");
	ButtonIcon1()
	{
		jf=new JFrame("AAA");
		jb=new JButton();
		jb.addActionListener(this);
		jf.add(jb);
		
		jf.setVisible(true);
		jf.setSize(400,400);
	}
	public void actionPerformed(ActionEvent e)
	{
	
	jb.setBackground(Color.GRAY);
	}
	public static void main(String... s)
	{
		new ButtonIcon1();
	}
}