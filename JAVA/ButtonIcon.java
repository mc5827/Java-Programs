import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class ButtonIcon implements ActionLisener
{
	JButton jb;
	JFrame jf;
	Icon cross = new ImageIcon("C:\\Users\\MOHIT\\Desktop\\cross");
	ButtonIcon()
	{
		jf=new JFrame("AAA");
		jb=new JButton();
		jb.addActionListener(this);
		jf.add(jb);
		
		jf.setVisible(true);
		jf.pack();
	}
	public void actionPerformed(ActionEvent e)
	{
		jb.setIcon(cross);
	}
	public static void main(String... s)
	{
		new ButtonIcon();
	}
}