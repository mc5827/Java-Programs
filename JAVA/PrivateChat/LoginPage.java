import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class LoginPage implements ActionListener
{
	JFrame f;
	JLabel l;
	JTextField tf;
	JButton b;
	
	LoginPage()
	{
		f=new JFrame("LOGIN");
		
		l=new JLabel("Enter the name: ");
		f.add(l,BorderLayout.WEST);
		
		tf=new JTextField();
		f.add(tf);
		
		b=new JButton("Login");
		b.addActionListener(this);
		f.add(b,BorderLayout.SOUTH);
		
		f.setVisible(true);
		f.setSize(300,300);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		new PrivateChatClient(tf.getText());
		f.setVisible(false);
	}
	public static void main(String... s)
	{
		new LoginPage();
	}
}
	
		
